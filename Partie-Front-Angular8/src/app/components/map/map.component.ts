import { Component, OnInit, ViewChild, ElementRef, NgZone } from '@angular/core';
import { MapsAPILoader, MouseEvent } from '@agm/core';
import { StationService } from 'src/app/services/station.service';
import { Station } from 'src/app/models/station';

// just an interface for type safety.
// tslint:disable-next-line:class-name
interface marker {
  lat: number;
  lng: number;
  label?: string;
   draggable: boolean;
   content?: string;
   isShown: boolean;
   icon: string;
 }
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
  stations: Station[] = [];
  resultStations: Station[] = [];
  title = 'AGM project';
  latitude: number;
  longitude: number;
  lat: number;
  longe: number;
  positions: Station[] = [];
  zoom: number;
  address: string;
  private geoCoder;


   // Radius
   radius = 500;
   radiusLat = 0;
   radiusLong = 0;
   markers: marker[] = [];
  @ViewChild('search')
  public searchElementRef: ElementRef;



  constructor( private stationService: StationService,
               private mapsAPILoader: MapsAPILoader,
               private ngZone: NgZone) { }

  ngOnInit()  {

    this.mapsAPILoader.load().then(() => {
      this.setCurrentLocation();
      // tslint:disable-next-line:new-parens
      this.geoCoder = new google.maps.Geocoder;

      const autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement, {
        types: ['address']
      });
      autocomplete.addListener('place_changed', () => {
        this.ngZone.run(() => {
          // get the place result
          const place: google.maps.places.PlaceResult = autocomplete.getPlace();

          // verify result
          if (place.geometry === undefined || place.geometry === null) {
            return;
          }

          // set latitude, longitude and zoom
          this.latitude = place.geometry.location.lat();
          this.longitude = place.geometry.location.lng();
          this.zoom = 18;
        });
      });
    });
    this.getStations();

  }
   getStations() {
     this.stationService.findAll().subscribe(stations => {
     this.resultStations = this.stations = stations;
    });

  }

   private setCurrentLocation() {
    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.radiusLat = position.coords.latitude;
        this.radiusLong = position.coords.longitude;
        this.zoom = 18;

        for (let i = 1; i < 50; i++) {
          this.markers.push(
            {
              lat: this.latitude + Math.random(),
              lng: this.longitude + Math.random(),
              label: `${i}`,
              draggable: true,
              content: `Content no ${i}`,
              isShown: false,
              icon: './assets/marker-red.png'
            }
          );
        }

      });
    }
  }



  markerDragEnd($event: MouseEvent) {
    console.log($event);

    this.latitude = $event.coords.lat;
    this.longitude = $event.coords.lng;
    this.getAddress(this.latitude, this.longitude);
  }

  getAddress(latitude, longitude) {
    this.geoCoder.geocode({ location: { lat: latitude, lng: longitude } }, (results, status) => {
      console.log(results);
      console.log(status);
      if (status === 'OK') {
        if (results[0]) {
          this.zoom = 18;
          this.address = results[0].formatted_address;
        } else {
          window.alert('No results found');
        }
      } else {
        window.alert('Geocoder failed due to: ' + status);
      }

    });
  }

clickedMarker(label: string, index: number) {
  console.log(`clicked the marker: ${label || index}`);
}

radiusDragEnd($event: any) {
  console.log($event);
  this.radiusLat = $event.coords.lat;
  this.radiusLong = $event.coords.lng;
  this.showHideMarkers();
}

event(type, $event) {
  console.log(type, $event);
  this.radius = $event;
  this.showHideMarkers();
}

showHideMarkers() {
  Object.values(this.markers).forEach(value => {
    value.isShown = this.getDistanceBetween(value.lat, value.lng, this.radiusLat, this.radiusLong);
  });
}

getDistanceBetween(lat1, long1, lat2, long2) {
  const from = new google.maps.LatLng(lat1, long1);
  const to = new google.maps.LatLng(lat2, long2);

  if (google.maps.geometry.spherical.computeDistanceBetween(from, to) <= this.radius) {
    console.log('Radius', this.radius);
    console.log('Distance Between', google.maps.geometry.spherical.computeDistanceBetween(
      from, to
    ));
    return true;
  } else {
    return false;
  }
}

}

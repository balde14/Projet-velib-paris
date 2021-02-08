
import { Component, OnInit } from '@angular/core';
import { StationService } from 'src/app/services/station.service';
import { Station } from 'src/app/models/station';

@Component({
  selector: 'app-stations',
  templateUrl: './stations.component.html',
  styleUrls: ['./stations.component.css']
})
export class StationsComponent implements OnInit {
  stations: Station[]=[];
  resultStations: Station[]=[];

  searchText='';
  
  

  constructor( private stationService: StationService) { }

  ngOnInit()  {
      this.getStations();
  }
   getStations(){
     this.stationService.findAll().subscribe(stations =>{
     this.resultStations= this.stations= stations 
    })
      
  }
  searchStation(){
    this.resultStations=this.stations.filter((Station)=>Station.nom_station.toLocaleLowerCase().includes(this.searchText.toLocaleLowerCase()));
   }
  
}

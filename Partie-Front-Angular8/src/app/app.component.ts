import { Component } from '@angular/core';
import { Station } from './models/station';
import { StationService } from './services/station.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  
  constructor( private stationService: StationService){}
  ngOnInit()  {
  }
  
}

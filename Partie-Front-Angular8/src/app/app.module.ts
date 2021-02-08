import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import{ HttpClientModule} from '@angular/common/http'
import {FormsModule}from '@angular/forms';
import { StationsComponent } from './components/stations/stations.component';
import { MapComponent } from './components/map/map.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';

// import { MapComponent } from './components/map/map.component';
//import { StationFilterPape } from './components/stations/stations-filter.pipe';
const appRoutes: Routes = [
  { path: 'stations', component: StationsComponent },
   { path: 'carte',      component: MapComponent },
   { path: '',      component: HomeComponent },

];
@NgModule({
  declarations: [
    AppComponent,
    StationsComponent,
    MapComponent,
    HomeComponent,
    //MapComponent,
   // StationFilterPape
    
    
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyC-udXizbYpqTV8961TLzmstwQriXL9ezE',
      libraries: ['places']
    }),
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]

})
export class AppModule { }

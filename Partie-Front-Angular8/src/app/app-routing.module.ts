import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';


import { Routes, RouterModule } from '@angular/router';
import { StationsComponent } from './components/stations/stations.component';


const routes: Routes = [
  // {path: 'stations',component :StationsComponent},
  // {}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
// export const routingComponents = [StationsComponent]  

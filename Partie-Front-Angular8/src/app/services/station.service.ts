import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import {map, catchError} from 'rxjs/operators';
import { Station } from '../models/station';

@Injectable({
  providedIn: 'root'
})
export class StationService {
  constructor(private http: HttpClient) { }
  findAll(): Observable<any> {

    return this.http.get<any>('http://localhost:8080/projetsVelib/rest/velib/temp-reel');
  }

  // public getStation(): Observable<fields> {
  //   return this.http.get<fields>("http://localhost:4000/records").pipe(
  //     map(data => new fields().deserialize(data)),
  //     catchError(() => throwError('Station not found'))
  //   );
  // }

  // public getAllStations(): Observable<fields[]> {
  //   return this.http.get<fields[]>("http://localhost:4000/records").pipe(
  //     map(data => data.map(data => new fields().deserialize(data)))
  //   );
  // }
}


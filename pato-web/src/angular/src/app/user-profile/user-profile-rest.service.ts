import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserDto} from "./user-profile.component";

@Injectable({
  providedIn: 'root'
})

export class UserProfileRestService {

  constructor( private http: HttpClient ) {
  }

  getUserProfile() : Observable<UserDto> {
    return this.http.get<UserDto>('/rest/model/user');
  }
}

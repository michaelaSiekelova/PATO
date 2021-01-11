import { Injectable } from '@angular/core';
import {ProjectDto} from "../../dtos";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProjectDetailRestService {

  constructor(private http : HttpClient) { }

  getProjectDtoById(id: number) : Observable<ProjectDto>{
    return this.http.get<ProjectDto>('/pato-api/model/project//projectDetail/' + id.toString());
  }
}

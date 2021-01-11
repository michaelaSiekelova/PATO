import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProjectDto} from "../../dtos";

@Injectable({
  providedIn: 'root'
})
export class ProjectOverviewTableRestService {

  constructor(private http : HttpClient) { }

  getAllProjectsForUser(userId: number) : Observable<Array<ProjectDto>> {
    return this.http.get<Array<ProjectDto>>('/pato-api/model/project/allProjects');
  }
}

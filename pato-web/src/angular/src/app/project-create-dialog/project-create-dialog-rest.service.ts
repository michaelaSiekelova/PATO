import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ProjectDto} from "../../dtos";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProjectCreateDialogRestService {

  constructor(private http : HttpClient) { }

  createProject(newProject: ProjectDto) : Observable<ProjectDto> {
    console.info(this.http);
    console.info('/pato-api/model/project/create/' + newProject.name + '/' + newProject.key);
    return this.http.get<ProjectDto>('/pato-api/model/project/create/' + newProject.name + '/' + newProject.key);
  }
}

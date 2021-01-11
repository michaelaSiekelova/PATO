import { Component, OnInit } from '@angular/core';
import {ProjectDto} from "../../dtos";
import {ActivatedRoute, Route} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {ProjectDetailRestService} from "./project-detail-rest.service";
import {Observable} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {

  project: ProjectDto;
  private selectedId: number;

  constructor(private route: ActivatedRoute, private service: ProjectDetailRestService) {
    this.selectedId = Number(route.snapshot.params['id']);
  }

  ngOnInit(): void {
    this.service.getProjectDtoById(this.selectedId).subscribe(project =>
    {
      this.project = project;
    });
  }

}

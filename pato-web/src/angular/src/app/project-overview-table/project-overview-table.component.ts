import {Component, NgModule, OnInit, ViewChild} from '@angular/core';
import {Router, RouterModule} from "@angular/router";
import {ProjectOverviewTableRestService} from "./project-overview-table-rest.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatTableDataSource} from "@angular/material/table";
import {MatDialog} from "@angular/material/dialog";
import {ProjectCreateDialogComponent} from "../project-create-dialog/project-create-dialog.component";
import {ProjectDto} from "../../dtos";
export {ProjectDto} from  "..//..//dtos"

@Component({
  selector: 'app-project-overview-table',
  templateUrl: './project-overview-table.component.html',
  styleUrls: ['./project-overview-table.component.css']
})
export class ProjectOverviewTableComponent implements OnInit {


  colums: string[] = ['control', 'key', 'name', 'createDate', 'deadline']
  projects: MatTableDataSource<ProjectDto>

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private router: Router, public dialog: MatDialog, private service: ProjectOverviewTableRestService ) { }

  ngOnInit(): void {
    this.service.getAllProjectsForUser(1).subscribe(projects => {
      this.projects = new MatTableDataSource(projects)});
    this.projects.paginator = this.paginator;
    this.projects.sort = this.sort;
  }

  openCreateDialog(){
    this.dialog.open(ProjectCreateDialogComponent)
  }


}





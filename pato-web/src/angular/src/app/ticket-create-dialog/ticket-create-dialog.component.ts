import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TicketCreateDialogRestService} from "./ticket-create-dialog-rest.service";
import {ProjectOverviewTableRestService} from "../project-overview-table/project-overview-table-rest.service";
import {ProjectDto} from "../../dtos";

@Component({
  selector: 'app-ticket-create-dialog',
  templateUrl: './ticket-create-dialog.component.html',
  styleUrls: ['./ticket-create-dialog.component.css']
})
export class TicketCreateDialogComponent implements OnInit {

  formGroup : FormGroup;
  projects: Array<ProjectDto>;

  constructor(fb: FormBuilder, private service: TicketCreateDialogRestService, private projectService: ProjectOverviewTableRestService) {
    this.projectService.getAllProjectsForUser(1).subscribe(projects => {
      this.projects = projects});
    this.formGroup = fb.group({
      name: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      projectId: new FormControl('', [Validators.required])
    });
  }

  ngOnInit(): void {
  }

  saveDialog(){
    console.info(this.formGroup.value);
    let tc;
    tc = this.formGroup.value;
    this.service.createTicket(tc).subscribe(x=> console.log(x))
  }

}

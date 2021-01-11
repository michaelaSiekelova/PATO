import { Component, OnInit } from '@angular/core';
import {ProjectDto} from "../../dtos";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ProjectCreateDialogRestService} from "./project-create-dialog-rest.service";


@Component({
  selector: 'app-project-create-dialog',
  templateUrl: './project-create-dialog.component.html',
  styleUrls: ['./project-create-dialog.component.css']
})
export class ProjectCreateDialogComponent implements OnInit {

  formGroup : FormGroup;

  constructor(fb: FormBuilder, private service: ProjectCreateDialogRestService) {
    this.formGroup = fb.group({
      name: new FormControl('', [Validators.required]),
      key: new FormControl('', [Validators.required])
  });
  }

  ngOnInit(): void {
  }

  saveDialog(){
    console.info(this.formGroup.value);
    let pr;
    pr = this.formGroup.value;
    this.service.createProject(pr).subscribe(x=> console.log(x))
  }

}

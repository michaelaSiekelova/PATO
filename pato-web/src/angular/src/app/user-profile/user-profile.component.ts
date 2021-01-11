
import { Component, OnInit, OnDestroy } from '@angular/core';
import {Router, ParamMap } from '@angular/router';
import { Observable,of } from 'rxjs';
import {UserProfileRestService} from "./user-profile-rest.service";
import {UserDto} from "../../dtos";
export {UserDto} from "../../dtos";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user: UserDto;

  constructor(private router: Router, private service: UserProfileRestService ) {}

  ngOnInit(): void {
    this.service.getUserProfile().subscribe(user => {
      this.user = user});
  }

}



import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserProfileComponent} from "./user-profile/user-profile.component";
import {ProjectOverviewTableComponent} from "./project-overview-table/project-overview-table.component";
import {ProjectDetailComponent} from "./project-detail/project-detail.component";
import {TicketOverviewTableComponent} from "./ticket-overview-table/ticket-overview-table.component";

const routes: Routes = [
  {path: 'userProfile', component: UserProfileComponent},
  {path: 'projectsOverview', component: ProjectOverviewTableComponent},
  {path: 'ticketsOverview', component: TicketOverviewTableComponent},
  {path: 'projectDetail/:id', component: ProjectDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

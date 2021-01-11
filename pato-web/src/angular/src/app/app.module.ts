import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {ContentComponent} from "./template/content/content.component";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatListModule} from "@angular/material/list";
import {MatButtonModule} from '@angular/material/button';
import {MatGridListModule} from "@angular/material/grid-list";
import {MatTableModule} from "@angular/material/table";
import { UserProfileComponent } from './user-profile/user-profile.component';
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import { ProjectOverviewTableComponent } from './project-overview-table/project-overview-table.component';
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatTooltipModule} from "@angular/material/tooltip";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ProjectCreateDialogComponent } from './project-create-dialog/project-create-dialog.component';
import {MatDialogModule} from "@angular/material/dialog";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ProjectDto} from "../dtos";
import {MatInputModule} from "@angular/material/input";
import { ProjectDetailComponent } from './project-detail/project-detail.component';
import { TicketOverviewTableComponent } from './ticket-overview-table/ticket-overview-table.component';
import { TicketDetailComponent } from './ticket-detail/ticket-detail.component';
import { TicketCreateDialogComponent } from './ticket-create-dialog/ticket-create-dialog.component';
import {MatSelectModule} from "@angular/material/select";

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    UserProfileComponent,
    ProjectOverviewTableComponent,
    ProjectCreateDialogComponent,
    ProjectDetailComponent,
    TicketOverviewTableComponent,
    TicketDetailComponent,
    TicketCreateDialogComponent
  ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        MatSidenavModule,
        MatToolbarModule,
        MatIconModule,
        MatListModule,
        MatButtonModule,
        MatGridListModule,
        MatTableModule,
        AppRoutingModule,
        HttpClientModule,
        MatPaginatorModule,
        MatFormFieldModule,
        MatTooltipModule,
        FontAwesomeModule,
        MatDialogModule,
        ReactiveFormsModule,
        FormsModule,
        MatInputModule,
        MatSelectModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

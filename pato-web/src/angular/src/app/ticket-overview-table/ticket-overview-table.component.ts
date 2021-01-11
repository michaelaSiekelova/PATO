import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {TicketOverviewTableRestService} from "./ticket-overview-table-rest.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatTableDataSource} from "@angular/material/table";
import {TicketDto} from "../../dtos";
import {TicketCreateDialogComponent} from "../ticket-create-dialog/ticket-create-dialog.component";
export {TicketDto} from "../../dtos";

@Component({
  selector: 'app-ticket-overview-table',
  templateUrl: './ticket-overview-table.component.html',
  styleUrls: ['./ticket-overview-table.component.css']
})
export class TicketOverviewTableComponent implements OnInit {

  colums: string[] = ['control', 'key', 'name','type', 'createDate', 'deadline', 'createUser', 'assignee', 'project']
  tickets: MatTableDataSource<TicketDto>

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private router: Router, public dialog: MatDialog, private service: TicketOverviewTableRestService) { }

  ngOnInit(): void {
    this.service.getAllTicketsForCurrentUser().subscribe(tickets => {
      this.tickets = new MatTableDataSource(tickets)});
    this.tickets.paginator = this.paginator;
    this.tickets.sort = this.sort;
  }

  openCreateDialog(){
    this.dialog.open(TicketCreateDialogComponent)
  }

}

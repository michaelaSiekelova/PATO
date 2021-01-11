import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProjectDto, TicketDto} from "../../dtos";

@Injectable({
  providedIn: 'root'
})
export class TicketOverviewTableRestService {

  constructor(private http : HttpClient) { }

  getAllTicketsForCurrentUser(): Observable<Array<TicketDto>>{
    return this.http.get<Array<TicketDto>>('/pato-api/model/ticket/allTicketsForCurrentUser');
  }
}

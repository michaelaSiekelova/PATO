import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TicketDto} from "../../dtos";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TicketCreateDialogRestService {

  constructor(private http : HttpClient) { }

  createTicket(newTicket: TicketDto) : Observable<TicketDto> {
    return this.http.get<TicketDto>('/pato-api/model/ticket/create/' + newTicket.name + '/' + newTicket.description + '/' + newTicket.projectId);
  }
}

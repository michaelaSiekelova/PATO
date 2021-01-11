import { TestBed } from '@angular/core/testing';

import { TicketOverviewTableRestService } from './ticket-overview-table-rest.service';

describe('TicketOverviewTableRestService', () => {
  let service: TicketOverviewTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TicketOverviewTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

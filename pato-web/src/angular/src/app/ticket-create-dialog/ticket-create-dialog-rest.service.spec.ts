import { TestBed } from '@angular/core/testing';

import { TicketCreateDialogRestService } from './ticket-create-dialog-rest.service';

describe('TicketCreateDialogRestService', () => {
  let service: TicketCreateDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TicketCreateDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

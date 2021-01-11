import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketOverviewTableComponent } from './ticket-overview-table.component';

describe('TicketOverviewTableComponent', () => {
  let component: TicketOverviewTableComponent;
  let fixture: ComponentFixture<TicketOverviewTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketOverviewTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketOverviewTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketCreateDialogComponent } from './ticket-create-dialog.component';

describe('TicketCreateDialogComponent', () => {
  let component: TicketCreateDialogComponent;
  let fixture: ComponentFixture<TicketCreateDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketCreateDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketCreateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

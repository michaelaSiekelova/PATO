import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectOverviewTableComponent } from './project-overview-table.component';

describe('ProjectOverviewTableComponent', () => {
  let component: ProjectOverviewTableComponent;
  let fixture: ComponentFixture<ProjectOverviewTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectOverviewTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectOverviewTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

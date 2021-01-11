import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectCreateDialogComponent } from './project-create-dialog.component';

describe('ProjectCreateDialogComponent', () => {
  let component: ProjectCreateDialogComponent;
  let fixture: ComponentFixture<ProjectCreateDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectCreateDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectCreateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

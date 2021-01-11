import { TestBed } from '@angular/core/testing';

import { ProjectCreateDialogRestService } from './project-create-dialog-rest.service';

describe('ProjectCreateDialogRestService', () => {
  let service: ProjectCreateDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectCreateDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

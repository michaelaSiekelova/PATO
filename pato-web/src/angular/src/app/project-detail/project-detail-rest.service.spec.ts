import { TestBed } from '@angular/core/testing';

import { ProjectDetailRestService } from './project-detail-rest.service';

describe('ProjectDetailRestService', () => {
  let service: ProjectDetailRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectDetailRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

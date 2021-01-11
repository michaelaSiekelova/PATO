import { TestBed } from '@angular/core/testing';

import { ProjectOverviewTableRestService } from './project-overview-table-rest.service';

describe('ProjectOverviewTableRestService', () => {
  let service: ProjectOverviewTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectOverviewTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

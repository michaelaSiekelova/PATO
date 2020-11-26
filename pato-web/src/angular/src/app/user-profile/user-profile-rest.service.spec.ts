import { TestBed } from '@angular/core/testing';

import { UserProfileRestService } from './user-profile-rest.service';

describe('UserProfileRestService', () => {
  let service: UserProfileRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserProfileRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

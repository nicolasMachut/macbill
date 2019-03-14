import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Profile} from '../shared/models/profile.model';
import {Observable} from 'rxjs';

@Injectable()
export class ProfileService {

  constructor(private httpClient: HttpClient) { }

  updateProfile(profile: Profile): Observable<Profile> {
    return this.httpClient.put<Profile>('/api/profile', profile);
  }

  getProfile(): Observable<Profile> {
    return this.httpClient.get<Profile>('/api/profile');
  }
}

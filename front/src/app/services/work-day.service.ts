import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {WorkDay} from '../shared/interfaces/WorkDay';

@Injectable()
export class WorkDayService {

  @Output() newWorkDay: EventEmitter<object> = new EventEmitter();

  constructor(private httpClient: HttpClient) { }

  create(newDay) {
    this.httpClient.post<WorkDay>('/api/workDay', newDay).subscribe(data => {
      data.customer = newDay.customer;
      this.newWorkDay.emit(data);
    });
  }
  delete(workDay: WorkDay) {
    return this.httpClient.delete('/api/workDay/' + workDay.id);
  }
  findAll(): Observable<WorkDay[]> {
    return this.httpClient.get<WorkDay[]>('/api/workDays');
  }
  findLastForCustomer(customerId: string): Observable<WorkDay> {
    return this.httpClient.get<WorkDay>('/api/workDay/last?customerId=' + customerId);
  }
}

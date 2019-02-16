import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class WorkDayService {

  @Output() newWorkDay: EventEmitter<object> = new EventEmitter();

  constructor(private httpClient: HttpClient) { }

  create(newDay) {
    console.log(newDay);
    this.httpClient.post<object>('http://localhost:8585/work-day-service/workDay', newDay).subscribe(data => {
      console.log(data);
    });
  }
}

import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class CustomersService {

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<any> {
    return this.httpClient.get<any[]>('http://localhost:8080/customers');
  }

  create(nameParam: string) {
    const customer = {
      name: nameParam
    };
    return this.httpClient.post<object>('http://localhost:8080/customer', customer);
  }
}

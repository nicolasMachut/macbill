import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../shared/models/customer.model';

@Injectable()
export class CustomersService {

  @Output() newCustomer: EventEmitter<object> = new EventEmitter();

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>('http://localhost:8081/customer-service/customers');
  }

  create(customer: Customer) {
    this.httpClient.post<Customer>('http://localhost:8081/customer-service/customer', customer).subscribe(newCustomer => {
      this.newCustomer.emit(newCustomer);
    });
  }

  delete(customer: Customer) {
    return this.httpClient.delete('http://localhost:8081/customer-service/customer/' + customer.id);
  }
}

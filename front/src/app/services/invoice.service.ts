import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../shared/models/customer.model';

@Injectable()
export class InvoiceService {

  constructor(private httpClient: HttpClient) { }

  generateInvoice(start: Date, end: Date, customer: Customer) {
    return this.httpClient.get('/api/invoice?customerId=' + customer.id + '&start=' + start + '&end=' + end, {responseType: 'text'});
  }
}

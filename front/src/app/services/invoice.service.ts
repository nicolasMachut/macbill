import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class InvoiceService {

  constructor(private httpClient: HttpClient) { }

  generateInvoice(customerId: string) {
    console.log('coucou');
    return this.httpClient.get('/api/invoice?customerId=' + customerId, {responseType: 'text'});
  }
}

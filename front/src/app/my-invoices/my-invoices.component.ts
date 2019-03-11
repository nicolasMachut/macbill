import { Component, OnInit } from '@angular/core';
import {InvoiceService} from '../services/invoice.service';
import {CustomersService} from '../services/customers.service';
import {Customer} from '../shared/models/customer.model';

@Component({
  selector: 'app-my-invoices',
  templateUrl: './my-invoices.component.html',
  styleUrls: ['./my-invoices.component.scss']
})
export class MyInvoicesComponent implements OnInit {

  invoiceHtml: string;
  public customers: Array<Customer> = [];
  start: Date;
  end: Date;

  constructor(private invoiceService: InvoiceService, private customerService: CustomersService) { }

  ngOnInit() {
    this.start = new Date();
    this.end = new Date();
    this.customerService.findAll().subscribe((data)  => {
      this.customers = data;
    });
    this.invoiceService.generateInvoice('5c82fcaaf3d10e2f7b0c9d3f').subscribe((data) => {
      this.invoiceHtml = data;
    });
  }

  save() {
    console.log('test');
    console.log(this.start);
  }
}

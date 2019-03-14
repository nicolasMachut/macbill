import { Component, OnInit } from '@angular/core';
import {InvoiceService} from '../services/invoice.service';
import {CustomersService} from '../services/customers.service';
import {Customer} from '../shared/models/customer.model';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-my-invoices',
  templateUrl: './my-invoices.component.html',
  styleUrls: ['./my-invoices.component.scss']
})
export class MyInvoicesComponent implements OnInit {

  registerForm: FormGroup;
  invoiceHtml: string;
  public customers: Array<Customer> = [];
  end = new FormControl(new Date());
  customer: Customer;
  start = new FormControl(new Date());

  constructor(private invoiceService: InvoiceService, private customerService: CustomersService, private formBuilder: FormBuilder) { }

  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      start: ['', Validators.required],
      end: ['', Validators.required],
      customer: ['', [Validators.required]]
    });
    this.customerService.findAll().subscribe((data)  => {
      this.customers = data;
    });
  }

  save() {
    if (this.registerForm.invalid) {
      return;
    }
    this.invoiceService
      .generateInvoice(this.registerForm.controls.start.value,
        this.registerForm.controls.end.value,
        this.registerForm.controls.customer.value)
      .subscribe((data) => {
      this.invoiceHtml = data;
    });
  }
}

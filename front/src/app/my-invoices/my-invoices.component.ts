import {Component, OnInit} from '@angular/core';
import {InvoiceService} from '../services/invoice.service';
import {CustomersService} from '../services/customers.service';
import {Customer} from '../shared/models/customer.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-my-invoices',
  templateUrl: './my-invoices.component.html',
  styleUrls: ['./my-invoices.component.scss']
})
export class MyInvoicesComponent implements OnInit {

  registerForm: FormGroup;
  customers: Array<Customer> = [];

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

  downloadInvoice() {
    if (this.registerForm.invalid) {
      return;
    }
    this.invoiceService.downloadInvoice(this.registerForm.controls.start.value,
      this.registerForm.controls.end.value,
      this.registerForm.controls.customer.value).subscribe(response => {

      const blob = new Blob([response], { type: 'application/pdf' });
      if (window.navigator && window.navigator.msSaveOrOpenBlob) {
        window.navigator.msSaveOrOpenBlob(blob);
        return;
      }
      const data = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = data;
      link.download = 'file.pdf';
      link.click();
      window.URL.revokeObjectURL(data);
    });
  }
}

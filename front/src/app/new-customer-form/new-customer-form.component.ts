import { Component, OnInit } from '@angular/core';
import {CustomersService} from '../services/customers.service';

@Component({
  selector: 'app-new-customer-form',
  templateUrl: './new-customer-form.component.html',
  styleUrls: ['./new-customer-form.component.scss']
})
export class NewCustomerFormComponent implements OnInit {

  name: string;

  constructor(private customerService: CustomersService) { }

  ngOnInit() {
    this.customerService.newCustomer.subscribe(() => {
      this.name = '';
    });
  }

  onSave() {
    this.customerService.create(this.name);
  }
}

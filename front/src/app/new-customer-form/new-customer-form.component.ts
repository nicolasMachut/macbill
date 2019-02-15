import { Component, OnInit } from '@angular/core';
import {CustomersService} from '../services/customers.service';

@Component({
  selector: 'app-new-customer-form',
  templateUrl: './new-customer-form.component.html',
  styleUrls: ['./new-customer-form.component.scss']
})
export class NewCustomerFormComponent implements OnInit {

  name = 'test';

  constructor(private customerService: CustomersService) { }

  ngOnInit() {
  }

  onSave() {
    this.customerService.create(this.name).subscribe(data => {
      console.log(data);
    });
  }

}

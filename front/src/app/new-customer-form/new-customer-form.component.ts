import { Component, OnInit } from '@angular/core';
import {CustomersService} from '../services/customers.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../shared/models/customer.model';
import {Address} from '../shared/models/address.model';
import {MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-new-customer-form',
  templateUrl: './new-customer-form.component.html',
  styleUrls: ['./new-customer-form.component.scss']
})
export class NewCustomerFormComponent implements OnInit {

  newCustomerForm: FormGroup;

  constructor(private customerService: CustomersService,
              private fb: FormBuilder,
              private dialogRef: MatDialogRef<NewCustomerFormComponent>) {
    this.newCustomerForm = this.fb.group({
      name: ['', Validators.required ],
      companyType: ['', Validators.required ],
      streetNumber: ['', Validators.required ],
      route: ['', Validators.required ],
      route2: ['', Validators.required ],
      postalCode: ['', Validators.required ],
      city: ['', Validators.required ]
    });
  }

  ngOnInit() {
    this.customerService.newCustomer.subscribe(() => {
      this.newCustomerForm.reset();
      this.dialogRef.close();
    });
  }

  onSave() {
    const customer = new Customer();
    customer.name = this.newCustomerForm.controls.name.value;
    customer.companyType = this.newCustomerForm.controls.companyType.value;
    const address = new Address();
    address.streetNumber = this.newCustomerForm.controls.streetNumber.value;
    address.route = this.newCustomerForm.controls.route.value;
    address.route2 = this.newCustomerForm.controls.route2.value;
    address.postalCode = this.newCustomerForm.controls.postalCode.value;
    address.city = this.newCustomerForm.controls.city.value;
    customer.address = address;
    this.customerService.create(customer);
  }
}

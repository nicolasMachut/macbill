import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material';
import {CustomersService} from '../services/customers.service';
import {Customer} from '../shared/models/customer.model';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {WorkDayService} from '../services/work-day.service';
import {WorkDay} from '../shared/interfaces/WorkDay';

@Component({
  selector: 'app-new-work-day',
  templateUrl: './new-work-day.component.html',
  styleUrls: ['./new-work-day.component.scss']
})
export class NewWorkDayComponent implements OnInit {
  public customers: Array<Customer> = [];
  public workDay: WorkDay;
  newWorkDayForm: FormGroup;
  displayEntireForm = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              private customerService: CustomersService,
              private formBuilder: FormBuilder,
              private workDayService: WorkDayService) {
    this.workDay = data.newDay;
  }

  ngOnInit() {
    this.newWorkDayForm = this.formBuilder.group({
      date: ['', Validators.required],
      customer: ['', Validators.required],
      price: ['', Validators.required],
      isTva: ['', Validators.required]
    });
    this.customerService.findAll().subscribe(data => {
      this.customers = data;
    });
    this.newWorkDayForm.controls.date.setValue(this.workDay.start);
    this.onChanges();
  }

  onChanges(): void {
    this.displayEntireForm = false;
    this.newWorkDayForm.get('customer').valueChanges.subscribe(customer => {
      this.workDayService.findLastForCustomer(customer.id).subscribe(wd => {
        if (wd !== null) {
          this.newWorkDayForm.controls.price.setValue(wd.price);
          this.newWorkDayForm.controls.isTva.setValue(wd.isTva);
        }
        this.displayEntireForm = true;
      });
    });
  }

  onSaveDay() {
    if (this.newWorkDayForm.invalid) {
      return;
    }
    this.workDay.customerId = this.newWorkDayForm.controls.customer.value.id;
    this.workDay.isTva = this.newWorkDayForm.controls.isTva.value;
    this.workDay.title = this.newWorkDayForm.controls.customer.value.name;
    this.workDay.price = this.newWorkDayForm.controls.price.value;
    this.workDayService.create(this.workDay);
  }
}

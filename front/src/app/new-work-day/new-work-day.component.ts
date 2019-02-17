import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material';
import {CustomersService} from '../services/customers.service';
import {Customer} from '../shared/models/customer.model';
import {FormControl} from '@angular/forms';
import {WorkDayService} from '../services/work-day.service';
import {WorkDay} from '../shared/interfaces/WorkDay';

@Component({
  selector: 'app-new-work-day',
  templateUrl: './new-work-day.component.html',
  styleUrls: ['./new-work-day.component.scss']
})
export class NewWorkDayComponent implements OnInit {
  private customers: Array<Customer> = [];
  private customer: Customer;
  private workDay: WorkDay;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              private customerService: CustomersService,
              private workDayService: WorkDayService) {
    this.workDay = data.newDay;
  }

  ngOnInit() {
    this.customerService.findAll().subscribe(data => {
      this.customers = data;
    });
  }

  onSaveDay() {
    this.workDay.customerId = this.customer.id;
    this.workDay.title = this.customer.name;
    this.workDayService.create(this.workDay);
  }
}

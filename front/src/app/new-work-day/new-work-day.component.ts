import {Component, Inject, Input, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {CustomersService} from '../services/customers.service';
import {Customer} from '../shared/models/customer.model';
import {FormControl} from '@angular/forms';
import {WorkDayService} from '../services/work-day.service';

@Component({
  selector: 'app-new-work-day',
  templateUrl: './new-work-day.component.html',
  styleUrls: ['./new-work-day.component.scss']
})
export class NewWorkDayComponent implements OnInit {
  customers: Array<Customer> = [];
  date = new FormControl(new Date());

  constructor(@Inject(MAT_DIALOG_DATA) public data: object,
              private customerService: CustomersService,
              private workDayService: WorkDayService) {
  }

  ngOnInit() {
    this.customerService.findAll().subscribe(data => {
      this.customers = data;
    });
  }

  onSaveDay() {
    this.workDayService.create(this.data.newDay);
  }
}

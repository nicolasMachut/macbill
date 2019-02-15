import {Component, NgModule, OnInit} from '@angular/core';
import {MatList} from '@angular/material';
import {CustomersService} from '../services/customers.service';

@NgModule({
  imports: [MatList],
})

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.scss']
})
export class CustomersListComponent implements OnInit {
  customers: Array<object> = [];

  constructor(private customerService: CustomersService) {}

  ngOnInit() {
    this.customerService.findAll().subscribe(data => {
      this.customers = data;
    });
  }
}

import {Component, NgModule, OnInit} from '@angular/core';
import {MatList} from '@angular/material';

@NgModule({
  imports: [MatList],
})

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.scss']
})
export class CustomersListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

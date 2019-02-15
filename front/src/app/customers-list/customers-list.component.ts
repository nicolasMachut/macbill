import {Component, NgModule, OnInit} from '@angular/core';
import {MatList, MatSnackBar} from '@angular/material';
import {CustomersService} from '../services/customers.service';
import {Customer} from '../shared/models/customer.model';

@NgModule({
  imports: [MatList],
})

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.scss']
})
export class CustomersListComponent implements OnInit {
  customers: Array<Customer> = [];

  constructor(private customerService: CustomersService, private snackBar: MatSnackBar) {}

  ngOnInit() {
    this.customerService.findAll().subscribe(data => {
      this.customers = data;
    });
    this.customerService.newCustomer.subscribe(customer => {
      this.customers.push(customer);
      this.snackBar.open('Le client ' + customer.name + ' à été ajouté');
    });
  }

  onDelete(customerToDelete: Customer) {
    this.customerService.delete(customerToDelete).subscribe(() => {
      this.customers = this.customers.filter(customer => customer.id !== customerToDelete.id);
    });
    this.snackBar.open('Le client ' + customerToDelete.name + ' à été supprimé');
  }
}

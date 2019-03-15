import {Component, NgModule, OnInit} from '@angular/core';
import {MatDialog, MatList} from '@angular/material';
import {CustomersService} from '../services/customers.service';
import {Customer} from '../shared/models/customer.model';
import {SnackbarService} from '../services/snackbar.service';
import {NewCustomerFormComponent} from "../new-customer-form/new-customer-form.component";

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
  tableColumns: string[] = ['name', 'companyType', 'streetNumber', 'route', 'route2', 'postalCode', 'city', 'delete'];

  constructor(private customerService: CustomersService, private snackBarService: SnackbarService, public dialog: MatDialog) {}

  ngOnInit() {
    this.customerService.findAll().subscribe(data => {
      this.customers = data;
    });
    this.customerService.newCustomer.subscribe(customer => {
      this.customers.push(customer);
      this.snackBarService.open('Le client ' + customer.name + ' à été ajouté');
    });
  }

  onDelete(customerToDelete: Customer) {
    this.customerService.delete(customerToDelete).subscribe(() => {
      this.customers = this.customers.filter(customer => customer.id !== customerToDelete.id);
    });
    this.snackBarService.open('Le client ' + customerToDelete.name + ' à été supprimé');
  }

  openModal() {
    const dialogRef = this.dialog.open(NewCustomerFormComponent, {
      width: '50%',
      data: {}
    });
    dialogRef.afterClosed().subscribe(result => {
      this.customerService.findAll().subscribe(data => {
        this.customers = data;
      });
    });
  }
}

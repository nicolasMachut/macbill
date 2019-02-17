import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from './app.material.module';
import {CustomersService} from './services/customers.service';
import {HttpClientModule} from '@angular/common/http';
import { NewCustomerFormComponent } from './new-customer-form/new-customer-form.component';
import {FormsModule} from '@angular/forms';
import { MyCustomersComponent } from './my-customers/my-customers.component';
import { CalendarComponent } from './calendar/calendar.component';

import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import {CommonModule} from '@angular/common';
import {NewWorkDayComponent} from './new-work-day/new-work-day.component';
import {WorkDayService} from './services/work-day.service';
import {SnackbarService} from './services/snackbar.service';

@NgModule({
  declarations: [
    AppComponent,
    CustomersListComponent,
    NewCustomerFormComponent,
    MyCustomersComponent,
    CalendarComponent,
    NewWorkDayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppMaterialModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    FormsModule,
    NgbModalModule,
    FlatpickrModule.forRoot(),
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    })
  ],
  providers: [CustomersService, WorkDayService, SnackbarService],
  bootstrap: [AppComponent],
  exports: [CalendarComponent]
})
export class AppModule { }

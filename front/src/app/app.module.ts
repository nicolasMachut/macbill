import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from './app.material.module';
import {CustomersService} from './services/customers.service';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { NewCustomerFormComponent } from './new-customer-form/new-customer-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MyCustomersComponent } from './my-customers/my-customers.component';
import { CalendarComponent } from './calendar/calendar.component';
import {CommonModule} from '@angular/common';
import {NewWorkDayComponent} from './new-work-day/new-work-day.component';
import {WorkDayService} from './services/work-day.service';
import {SnackbarService} from './services/snackbar.service';
import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import {JwtInterceptor} from './helpers/jwt.interceptor';
import {ErrorInterceptor} from './helpers/error.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    CustomersListComponent,
    NewCustomerFormComponent,
    MyCustomersComponent,
    CalendarComponent,
    NewWorkDayComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
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
  providers: [
    CustomersService,
    WorkDayService,
    SnackbarService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
  exports: [CalendarComponent]
})
export class AppModule { }

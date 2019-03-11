import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from './app.material.module';
import {CustomersService} from './services/customers.service';
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
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {AuthInterceptor} from './shared/auth.interceptor';
import {OktaAuthModule} from '@okta/okta-angular';
import { HttpClientModule } from '@angular/common/http';
import {DashboardComponent} from './dashboard/dashboard.component';
import { environment } from '../environments/environment';
import {InvoiceService} from './services/invoice.service';
import { MyInvoicesComponent } from './my-invoices/my-invoices.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomersListComponent,
    NewCustomerFormComponent,
    MyCustomersComponent,
    CalendarComponent,
    NewWorkDayComponent,
    DashboardComponent,
    MyInvoicesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    AppMaterialModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    OktaAuthModule.initAuth({
      issuer: 'https://dev-734864.okta.com/oauth2/default',
      redirectUri: environment.oktaRedirectUrl,
      clientId: '0oabu9wtkD4MkzXAe356'
    }),
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
    InvoiceService,
    SnackbarService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent],
  exports: [CalendarComponent]
})
export class AppModule { }

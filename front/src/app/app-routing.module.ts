import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MyCustomersComponent} from './my-customers/my-customers.component';
import {CalendarComponent} from './calendar/calendar.component';
import { OktaCallbackComponent, OktaAuthGuard } from '@okta/okta-angular';
import {MyInvoicesComponent} from './my-invoices/my-invoices.component';
import {MyProfileComponent} from './my-profile/my-profile.component';

const routes: Routes = [
  { path: 'myProfile', component: MyProfileComponent, canActivate: [OktaAuthGuard] },
  { path: 'myCustomers', component: MyCustomersComponent, canActivate: [OktaAuthGuard] },
  { path: 'dashboard', component: CalendarComponent, canActivate: [OktaAuthGuard]},
  { path: 'invoices', component: MyInvoicesComponent, canActivate: [OktaAuthGuard] },
  { path: 'implicit/callback', component: OktaCallbackComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

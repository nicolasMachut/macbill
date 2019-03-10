import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MyCustomersComponent} from './my-customers/my-customers.component';
import {CalendarComponent} from './calendar/calendar.component';
import { OktaCallbackComponent, OktaAuthGuard } from '@okta/okta-angular';

const routes: Routes = [
  { path: 'myCustomers', component: MyCustomersComponent, canActivate: [OktaAuthGuard] },
  { path: 'dashboard', component: CalendarComponent, canActivate: [OktaAuthGuard] },
  { path: 'implicit/callback', component: OktaCallbackComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

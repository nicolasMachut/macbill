import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MyCustomersComponent} from './my-customers/my-customers.component';
import {CalendarComponent} from './calendar/calendar.component';

const routes: Routes = [
  { path: 'myCustomers', component: MyCustomersComponent },
  { path: 'dashboard', component: CalendarComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

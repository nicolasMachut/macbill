import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MyCustomersComponent} from './my-customers/my-customers.component';
import {CalendarComponent} from './calendar/calendar.component';
import {AuthGuard} from './guards/auth.guards';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  { path: 'myCustomers', component: MyCustomersComponent, canActivate: [AuthGuard] },
  { path: 'dashboard', component: CalendarComponent, canActivate: [AuthGuard] },
  {
    path: 'login',
    component: LoginComponent
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

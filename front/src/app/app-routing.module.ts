import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MyCustomersComponent} from './my-customers/my-customers.component';
import {DemoComponent} from './demo-component/demo-component.component';

const routes: Routes = [
  { path: 'myCustomers', component: MyCustomersComponent },
  { path: 'dashboard', component: DemoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

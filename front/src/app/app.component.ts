import {Component, NgModule, OnInit} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatList} from '@angular/material';
import {AuthenticationService} from './services/authentification.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
@NgModule({
  imports: [BrowserAnimationsModule, MatList],
})
export class AppComponent implements OnInit {
  title = 'MacBill';
  email;
  constructor(private authentificationService: AuthenticationService) {}

  ngOnInit(): void {
    if (this.authentificationService.currentUserValue) {
      this.email = this.authentificationService.currentUserValue.email;
    }
  }

  logout() {
    this.authentificationService.logout();
  }
}

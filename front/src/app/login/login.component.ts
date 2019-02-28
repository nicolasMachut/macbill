import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import {AuthenticationService} from '../services/authentification.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from "../shared/models/user.modal";

@Component({ templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit {
  returnUrl: string;
  error = '';

  signupForm: FormGroup;
  loginForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private fb: FormBuilder
  ) {
    this.createForm();
  }

  createForm() {
    this.signupForm = this.fb.group({
      firstName: ['', Validators.required ],
      lastName: ['', Validators.required ],
      email: ['', [Validators.required, Validators.email] ],
      password: ['', Validators.required ]
    });
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email] ],
      password: ['', Validators.required ]
    });
  }

  ngOnInit() {

    // reset login status
    this.authenticationService.logout();

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  onSignup() {
    const user = new User();
    user.email = this.signupForm.controls.email.value;
    user.password = this.signupForm.controls.password.value;
    user.firstName = this.signupForm.controls.firstName.value;
    user.lastName = this.signupForm.controls.lastName.value;
    this.authenticationService.signup(user);
  }

  onSubmit() {
    this.authenticationService.login(this.loginForm.controls.email.value, this.loginForm.controls.password.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate([this.returnUrl]);
        },
        error => {
          this.error = error;
        });
  }
}

import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Profile} from '../shared/models/profile.model';
import {ProfileService} from '../services/profile.service';
import {Address} from '../shared/models/address.model';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})
export class MyProfileComponent implements OnInit {

  profileForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private profileService: ProfileService) { }

  ngOnInit() {
    this.profileForm = this.formBuilder.group({
      id: [null],
      companyName: ['', Validators.required],
      siret: ['', Validators.required],
      tvaIntracom: ['', Validators.required],
      owner: ['', Validators.required],
      iban: ['', Validators.required],
      bic: ['', Validators.required],
      streetNumber: ['', Validators.required],
      route: ['', Validators.required],
      route2: ['', Validators.required],
      postalCode: ['', Validators.required],
      city: ['', Validators.required],
    });
    this.profileService.getProfile().subscribe(profile => {
      if (profile) {
        this.objectToForm(profile);
      }
    });
  }

  objectToForm(profile: Profile) {
    this.profileForm.setValue({
      id: profile.id,
      companyName: profile.companyName,
      siret:  profile.siret,
      tvaIntracom: profile.tvaIntracom,
      owner: profile.owner,
      iban: profile.iban,
      bic: profile.bic,
      streetNumber: profile.address.streetNumber,
      route: profile.address.route,
      route2: profile.address.route2,
      postalCode: profile.address.postalCode,
      city: profile.address.city
    });
  }

  save() {
    if (this.profileForm.invalid) {
      return;
    }
    const profile = new Profile();
    profile.id = this.profileForm.controls.id.value;
    profile.companyName = this.profileForm.controls.companyName.value;
    profile.siret =  this.profileForm.controls.siret.value;
    profile.tvaIntracom = this.profileForm.controls.tvaIntracom.value;
    profile.owner = this.profileForm.controls.owner.value;
    profile.iban = this.profileForm.controls.iban.value;
    profile.bic = this.profileForm.controls.bic.value;
    const address = new Address();
    address.streetNumber = this.profileForm.controls.streetNumber.value;
    address.route = this.profileForm.controls.route.value;
    address.route2 = this.profileForm.controls.route2.value;
    address.postalCode = this.profileForm.controls.postalCode.value;
    address.city = this.profileForm.controls.city.value;
    profile.address = address;
    this.profileService.updateProfile(profile).subscribe(p => {
      this.objectToForm(p);
    });
  }

}

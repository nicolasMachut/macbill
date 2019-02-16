import { NgModule } from '@angular/core';
import {
  MatButtonModule, MatCheckboxModule,
  MatToolbarModule, MatChipsModule,
  MatOptionModule, MatGridListModule,
  MatProgressBarModule, MatSliderModule,
  MatSlideToggleModule, MatMenuModule,
  MatDialogModule, MatSnackBarModule,
  MatSelectModule, MatInputModule,
  MatSidenavModule, MatCardModule,
  MatIconModule, MatRadioModule,
  MatProgressSpinnerModule, MatTabsModule, MatListModule, MatNativeDateModule, MatDatepickerModule
} from '@angular/material';

@NgModule({
  imports: [
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule, MatChipsModule,
    MatOptionModule, MatGridListModule,
    MatProgressBarModule, MatSliderModule,
    MatSlideToggleModule, MatMenuModule,
    MatDialogModule, MatSnackBarModule,
    MatSelectModule, MatInputModule,
    MatSidenavModule, MatCardModule,
    MatIconModule, MatRadioModule,
    MatProgressSpinnerModule,
    MatTabsModule, MatListModule,
    MatNativeDateModule, MatDatepickerModule
  ],
  exports: [
    MatButtonModule, MatCheckboxModule,
    MatToolbarModule, MatChipsModule,
    MatOptionModule, MatGridListModule,
    MatProgressBarModule, MatSliderModule,
    MatSlideToggleModule, MatMenuModule,
    MatDialogModule, MatSnackBarModule,
    MatSelectModule, MatInputModule,
    MatSidenavModule, MatCardModule,
    MatIconModule, MatRadioModule,
    MatProgressSpinnerModule, MatTabsModule,
    MatListModule, MatNativeDateModule, MatDatepickerModule
  ],
})
export class AppMaterialModule { }

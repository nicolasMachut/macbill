import {Injectable} from '@angular/core';
import {MatSnackBar} from '@angular/material';

@Injectable()
export class SnackbarService {

  constructor(private snackBar: MatSnackBar) { }

  open(message: string) {
    this.snackBar.open(message, '', {
      duration: 3000
    });
  }
}

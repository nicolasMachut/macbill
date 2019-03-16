import {Injectable} from '@angular/core';
import {MatDialog} from '@angular/material';
import {ErrorDialogComponent} from './errordialog.component';

@Injectable()
export class ErrorDialogService {

  constructor(public dialog: MatDialog) { }
  openDialog(message): void {
    const dialogRef = this.dialog.open(ErrorDialogComponent, {
      width: '300px',
      data: message
    });

    dialogRef.afterClosed().subscribe(result => {
      // console.log('The dialog was closed');
    });
  }
}

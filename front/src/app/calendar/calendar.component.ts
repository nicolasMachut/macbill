import {
  Component,
  ChangeDetectionStrategy,
  ViewChild,
  TemplateRef, NgModule, OnInit
} from '@angular/core';
import {
  startOfDay,
  endOfDay
} from 'date-fns';
import { Subject } from 'rxjs';
import {
  CalendarView
} from 'angular-calendar';
import {NewWorkDayComponent} from '../new-work-day/new-work-day.component';
import {MatDialog} from '@angular/material';
import {WorkDayService} from '../services/work-day.service';
import {SnackbarService} from '../services/snackbar.service';
import {WorkDay} from '../shared/interfaces/WorkDay';
import localeFr from '@angular/common/locales/fr';
import {registerLocaleData} from '@angular/common';

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA'
  }
};

registerLocaleData(localeFr);

@NgModule({
  entryComponents: [
    NewWorkDayComponent
  ],
})

@Component({
  selector: 'app-root',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['./calendar.component.scss'],
  templateUrl: './calendar.component.html'
})
export class CalendarComponent implements OnInit {
  @ViewChild('new') modalContent: TemplateRef<any>;

  view: CalendarView = CalendarView.Month;

  CalendarView = CalendarView;

  viewDate: Date = new Date();

  refresh: Subject<any> = new Subject();

  workDays: WorkDay[] = [];

  activeDayIsOpen = false;

  constructor(public dialog: MatDialog,
              private workDayService: WorkDayService,
              private snackBarService: SnackbarService) {}

  dayClicked({ date }: { date: Date; }): void {
    const newDay: WorkDay = {
      title: '',
      start: startOfDay(date),
      end: endOfDay(date),
      allDay: true,
      color: colors.red
    };
    this.dialog.open(NewWorkDayComponent, {
      data: {newDay}
    });
  }

  ngOnInit(): void {
    this.workDayService.findAll().subscribe(days => {
      this.workDays = days.map(day => {
        day.start = new Date(day.start);
        day.end = new Date(day.end);
        return day;
      });
      this.refresh.next();
    });

    this.workDayService.newWorkDay.subscribe(workDay => {
      workDay.start = new Date(workDay.start);
      workDay.end = new Date(workDay.end);
      this.workDays.push(workDay);
      this.snackBarService.open('Vous avez ajouté une journée sur le client ' + workDay.title);
      this.dialog.closeAll();
      this.refresh.next();
    });
  }

  workDayClicked(workDay: WorkDay) {
    this.workDayService.delete(workDay).subscribe(() => {
      this.workDays = this.workDays.filter(wd => {
        return wd.id !== workDay.id;
      });
      this.snackBarService.open('Journée pour le client ' + workDay.title + ' supprimée');
      this.refresh.next();
    });
  }
}

import {
  Component,
  ChangeDetectionStrategy,
  ViewChild,
  TemplateRef, NgModule
} from '@angular/core';
import {
  startOfDay,
  endOfDay,
  subDays,
  addDays,
  endOfMonth,
  isSameDay,
  isSameMonth,
  addHours
} from 'date-fns';
import { Subject } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {
  CalendarEvent,
  CalendarEventAction,
  CalendarEventTimesChangedEvent,
  CalendarView
} from 'angular-calendar';
import {NewWorkDayComponent} from "../new-work-day/new-work-day.component";
import {MatDialog} from "@angular/material";
import {WorkDayService} from "../services/work-day.service";

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

@NgModule({
  entryComponents: [
    NewWorkDayComponent
  ],
})

@Component({
  selector: 'app-root',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['./demo-component.component.scss'],
  templateUrl: './demo-component.component.html'
})
export class DemoComponent {
  @ViewChild('new') modalContent: TemplateRef<any>;

  view: CalendarView = CalendarView.Month;

  CalendarView = CalendarView;

  viewDate: Date = new Date();

  modalData: {
    action: string;
    event: CalendarEvent;
  };

  actions: CalendarEventAction[] = [
    {
      label: '<i class="fa fa-fw fa-pencil"></i>',
      onClick: ({ event }: { event: CalendarEvent }): void => {
        this.handleEvent('Edited', event);
      }
    },
    {
      label: '<i class="fa fa-fw fa-times"></i>',
      onClick: ({ event }: { event: CalendarEvent }): void => {
        this.events = this.events.filter(iEvent => iEvent !== event);
        this.handleEvent('Deleted', event);
      }
    }
  ];

  refresh: Subject<any> = new Subject();

  events: CalendarEvent[] = [];

  activeDayIsOpen = false;

  constructor(private modal: NgbModal, public dialog: MatDialog, private workDayService: WorkDayService) {}

  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    const newDay = {
      title: 'Client',
      start: startOfDay(new Date()),
      end: endOfDay(new Date()),
      allDay: true,
      color: colors.red,
      draggable: true
    };
    this.dialog.open(NewWorkDayComponent, {
      width: '250px',
      data: {newDay}
    });
    if (isSameMonth(date, this.viewDate)) {
      this.viewDate = date;
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
      }
    }
  }

  eventTimesChanged({
                      event,
                      newStart,
                      newEnd
                    }: CalendarEventTimesChangedEvent): void {
    event.start = newStart;
    event.end = newEnd;
    // this.handleEvent('Dropped or resized', event);
    this.refresh.next();
  }

  handleEvent(action: string, event: CalendarEvent): void {
    this.modalData = { event, action };
    this.modal.open(this.modalContent, { size: 'lg' });
  }

  addEvent(): void {
    this.events.push({
      title: 'Client',
      start: startOfDay(new Date()),
      end: endOfDay(new Date()),
      allDay: true,
      color: colors.red,
      draggable: true
    });
    this.workDayService.create();
    this.refresh.next();
  }
  updateDateEvent(event): void {
    event.end = event.start;
    this.refresh.next();
  }
}

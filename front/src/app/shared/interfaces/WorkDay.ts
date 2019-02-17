import {CalendarEvent} from 'angular-calendar/modules/calendar.module';
import {Customer} from '../models/customer.model';

export interface WorkDay extends CalendarEvent {
  customerId?: string;
  customer?: Customer;
}

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewWorkDayComponent } from './new-work-day.component';

describe('NewWorkDayComponent', () => {
  let component: NewWorkDayComponent;
  let fixture: ComponentFixture<NewWorkDayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewWorkDayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewWorkDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

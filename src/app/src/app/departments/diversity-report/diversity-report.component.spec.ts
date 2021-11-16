import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiversityReportComponent } from './diversity-report.component';

describe('DiversityReportComponent', () => {
  let component: DiversityReportComponent;
  let fixture: ComponentFixture<DiversityReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiversityReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiversityReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

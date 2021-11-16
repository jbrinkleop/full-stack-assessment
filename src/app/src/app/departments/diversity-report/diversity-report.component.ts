import { Component, OnInit } from '@angular/core';
import { DepartmentsService } from '../../services/departments.service';
import { DepartmentDetails, Diversity, DiversityMapValue } from '../../interfaces/department-details.interface';
import { ChartOptions, ChartType } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-diversity-report',
  templateUrl: './diversity-report.component.html',
  styleUrls: ['./diversity-report.component.scss']
})
export class DiversityReportComponent implements OnInit {

  public diversityDetails: Diversity[];
  public diversityMap = new Map<string, DiversityMapValue[]>();
  public pieChartType: ChartType = 'pie';
  public pieChartColors = [
      {
        backgroundColor: ['rgba(255,0,0,0.3)', 'rgba(0,255,0,0.3)', 'rgba(0,0,255,0.3)', 'rgba(255,255,0,0.2)', 'rgba(0,100,96,1)' ],
      },
    ];
  public showSpinner: boolean;

  constructor(
    private departmentService: DepartmentsService
  ) { }

  ngOnInit(): void {
    this.showSpinner = true;
    this.getDiversityDetails();
  }

  pieChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
    tooltips: {
      enabled: true,
      mode: 'single',
      callbacks: {
        label: function (tooltipItems: any, data: any) {
          let total = 0;
          data.datasets[0].data.forEach((value: number) => {
            total = total + value;
          });
          return (Math.round(data.datasets[0].data[tooltipItems.index]/total * 100)).toString()+'%' ;
        }
      }
    },
  };

  public getDiversityDetails(){
    this.departmentService.getDiversityByDepartment().subscribe((diversityDetails: Diversity[]) => {
      this.diversityDetails = diversityDetails;
      this.formatDiversityDetails(); 
    }, error => {});
  }

  public formatDiversityDetails() {
    this.diversityDetails.forEach(detail => {
      if (!this.diversityMap.has(detail.deptName)) {
        let value: DiversityMapValue[] = [{gender: [], genderCount: []}];    
        value[0].gender.push(detail.gender);
        value[0].genderCount.push(detail.genderCount);
        this.diversityMap.set(detail.deptName, value);
      } else{
        let value = this.diversityMap.get(detail.deptName) || [];
        value[0].gender.push(detail.gender);
        value[0].genderCount.push(detail.genderCount);
        (this.diversityMap.get(detail.deptName) || []).push(value[0]);
      }
    });
    this.showSpinner = false;
  }

}

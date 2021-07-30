import { Component, OnInit } from '@angular/core';
import { DepartmentReport } from 'src/app/models/DepartmentReport';
import { DepartmentServiceService } from 'src/app/service/department-service.service';

@Component({
  selector: 'app-departments-dashboard',
  templateUrl: './departments-dashboard.component.html',
  styleUrls: ['./departments-dashboard.component.scss']
})
export class DepartmentsDashboardComponent implements OnInit {
  loading: boolean = true;

  multi: any[] = [];
  view = [700, 400];

  // options
  showXAxis: boolean = true;
  showYAxis: boolean = true;
  gradient: boolean = true;
  showLegend: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Department';
  showYAxisLabel: boolean = true;
  yAxisLabel: string = 'Totals (Revenue, Rating, Absences)';
  legendTitle: string = 'Legend';

  colorScheme = {
    domain: ['#5AA454', '#C7B42C', '#F0F8FF','#FF0000']
  };

  constructor(
    private departmentService: DepartmentServiceService
  ) {
   }

  ngOnInit() {
    this.departmentService.fetchReportTotals()
      .then(
        (data) => {
          const dataArr = data as DepartmentReport[];
          dataArr.forEach(
            (departmentReport) => {
              let item = {
                name: departmentReport.name,
                series: [
                  {
                    name: 'Average Rating',
                    value: departmentReport.averageRating
                  },
                  {
                    name: 'Absences',
                    value: departmentReport.totalAbsences
                  }
                ]
              };
              this.multi.push(item);
            }
          );
          this.loading    = false;
        },
        (error) => {
          this.loading = false;
        }
      );
  }

}

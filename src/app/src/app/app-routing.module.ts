import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EmployeesHomeComponent } from './employees/employees-home/employees-home.component';
import { DepartmentsComponent } from './departments/departments.component';
import { DiversityReportComponent } from './departments/diversity-report/diversity-report.component'

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: 'employees' , component: EmployeesHomeComponent},
  { path: 'departments', component: DepartmentsComponent},
  { path: 'reports', component: DiversityReportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DepartmentsDashboardComponent } from './home/departments/departments-dashboard/departments-dashboard.component';
import { EmployeeEditComponent } from './home/employees/employee-edit/employee-edit.component';
import { EmployeesTableComponent } from './home/employees/employees-table/employees-table.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: "employees", pathMatch:'full', component: EmployeesTableComponent },
  { path: "employees/:id", component: EmployeeEditComponent},
  { path: "reports", children: [
    {path:"department",component:DepartmentsDashboardComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

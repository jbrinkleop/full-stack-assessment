import { DepartmentDetails } from './department-details.interface';

export interface EmployeeDetails {
    id: number;
    firstName: string;
    lastName: string;
    jobTitle: string;
    department: DepartmentDetails
    emailId: string;
    serviceDate: Date;
    endDate: Date;
    empStatus: string;
}
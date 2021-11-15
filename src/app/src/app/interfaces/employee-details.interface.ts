import { DepartmentDetails } from './department-details.interface';

export interface EmployeeDetails {
    id?: number;
    firstName: string;
    lastName: string;
    jobTitle: string;
    gender: string;
    department: DepartmentDetails
    emailId?: string;
    serviceDate: string;
    endDate?: Date;
    empStatus?: string;
}

export interface Form {
    firstName: string;
    lastName: string;
    jobTitle: string;
    gender: string;
    department: string
    serviceDate: Date;
    empStatus: string;
}
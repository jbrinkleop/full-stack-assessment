import { DepartmentDetails } from './department-details.interface';

export interface EmployeeDetails {
    id?: number;
    firstName: string;
    lastName: string;
    jobTitle: string;
    gender: string;
    department: DepartmentDetails
    emailId?: string;
    dateOfBirth: string;
    isEditable?: boolean;
}

export interface EmployeeDetailsResponse {
    status: boolean,
    message: string,
    employeeList: Array<EmployeeDetails>
}

export interface Form {
    firstName: string;
    lastName: string;
    jobTitle: string;
    gender: string;
    department: string
    dateOfBirth: Date;
}

export interface EmployeeUpdateDetails {
    empId: number;
    jobTitle: string;
}
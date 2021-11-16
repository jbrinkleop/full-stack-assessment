export interface DepartmentDetails {
    id: number;
    deptName: string; 
}

export interface Diversity {
    deptName: string;
    gender: string;
    genderCount: number;
}

export interface DiversityMapValue {
    gender: string[];
    genderCount: number[];
}
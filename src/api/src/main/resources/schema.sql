DROP TABLE IF EXISTS departments;
CREATE TABLE departments(
    id int AUTO_INCREMENT  PRIMARY KEY,
    name varchar(1000) NOT NULL
);

DROP TABLE IF EXISTS employees;
CREATE TABLE employees(
    id int AUTO_INCREMENT  PRIMARY KEY,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    gender varchar(50) NOT NULL,
    dept_id int,
    FOREIGN KEY (dept_id) REFERENCES departments(id),
    email_id varchar(50) UNIQUE NOT NULL,
    job_title varchar (100) NOT NULL,
    emp_status varchar (30) DEFAULT 'Active',
    service_date date NOT NULL,
    end_date date
);

DROP TABLE IF EXISTS contact_details;
CREATE TABLE contact_details(
    id int AUTO_INCREMENT PRIMARY KEY,
    emp_id int,
    FOREIGN KEY (emp_id) REFERENCES employees(id),
    address varchar(1000) NOT NULL,
    contact_no varchar(15) NOT NULL,
    emergency_contact_name varchar(50) NOT NULL,
    emergency_contact_no varchar(15) NOT NULL
);

DROP TABLE IF EXISTS revenues;
CREATE TABLE revenues(
    id int AUTO_INCREMENT  PRIMARY KEY,
    dept_id int,
    FOREIGN KEY (dept_id) REFERENCES departments(id),
    quarter int NOT NULL,
    assessment_date date NOT NULL,
    revenue double NOT NULL
);
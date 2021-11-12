INSERT INTO departments(name) values ('Engineering');
INSERT INTO departments(name) values ('Sales');
INSERT INTO employees(first_name, last_name, dept_id, email_id, job_title, service_date, end_date) values ('Tom', 'Hardy', 1, 'tomhardy@observepoint.com', 'Director', '2015-04-01', null );
INSERT INTO employees(first_name, last_name, dept_id, email_id, job_title, service_date, end_date) values ('Jane', 'Doe', 2, 'janedoe@observepoint.com', 'Software Engineer', '2020-04-01', null );
INSERT INTO contact_details(emp_id, address, contact_no, emergency_contact_name, emergency_contact_no) values ('1', 'Salt Lake City, UT', '123-456-789', 'Jill Hardy', '987-654-321');
INSERT INTO contact_details(emp_id, address, contact_no, emergency_contact_name, emergency_contact_no) values ('2', 'Pleasant Grove, UT', '103-959-889', 'John Doe', '107-694-231');
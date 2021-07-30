DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;
CREATE TABLE departments(
    id int AUTO_INCREMENT  PRIMARY KEY,
    name varchar(1000) NOT NULL,
	revenue INT DEFAULT 0
);

CREATE TABLE employees (
	id int AUTO_INCREMENT PRIMARY KEY,
	dep_id int NOT NULL,
	name varchar(100) NOT NULL,
	email varchar(50) NOT NULL,
	rating INT DEFAULT 0,
	absences INT DEFAULT 0,
	gender varchar(20) DEFAULT '',
       FOREIGN KEY (dep_id) REFERENCES departments(id) ON DELETE CASCADE
);

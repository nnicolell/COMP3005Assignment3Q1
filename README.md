# COMP 3005 Assignment 3 Question 1

## Author
Nicole Lim 101191181

## Setup Instructions
1. Open pgAdmin4
2. Create a new database called "Assignment 3"
3. Open the Query Tool for the newly created database
4. Run the following queries:
```  
CREATE TABLE students (

	student_id SERIAL PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	email TEXT NOT NULL UNIQUE,
	enrollment_date DATE
);
```
```
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES

('John', 'Doe', 'john.doe@example.com', '2023-09-01'),

('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),

('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
```
6. Clone the"COMP3005Assignment3Q1" project
7. Open the "COMP3005Assignment3Q1" project
8. Run the main method in Assignment3Q1.java
   

## Methods
* getAllStudents()
  * Retrieves all student records from the "students" table by executing a SELECT query and displays the result in the terminal.
* addStudent(String first_name, String last_name, String email, String enrollment_date)
  * Adds a new student record to the "students" table through an INSERT query. The new student records contains the information sent through the parameters.
* updateStudentEmail(String student_id, String new_email)
  * Updates the email of the student with the student_id specified throguh an UPDATE query.
* deleteStudent(String student_id)
  * Deletes the student record that has the student_id specified through a DELETE query.
  
## Demo
A demo of the project can be found here: https://youtu.be/jmZwFUYYGlI

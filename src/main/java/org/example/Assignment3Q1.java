package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Assignment3Q1 {
    static String url = "jdbc:postgresql://localhost:5432/Assignment3";
    static String user = "postgres";
    static String password = "postgres";
    static ResultSet resultSet;

    /**
     * Runs the SELECT query to retrieve and display all records in the students table.
     */
    public static void getAllStudents(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students;");
            resultSet = statement.getResultSet();
            while (resultSet.next()){
                System.out.print(resultSet.getInt("student_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "\t");
                System.out.print(resultSet.getString("email") + "\t");
                System.out.println(resultSet.getString("enrollment_date") + "\t");
            }

        } catch (Exception e){}
    }

    /**
     * Runs the INSERT query to add a new student record into the students table.
     */
    public static void addStudent(String first_name, String last_name, String email, String enrollment_date){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('"+ first_name + "', '" + last_name+ "', '"+email+ "', '"+enrollment_date+"');";
            statement.executeQuery(query);

        } catch (Exception e){}
    }

    /**
     * Runs the UPDATE query to update the student with the specified student_id with a new email.
     */
    public static void updateStudentEmail(String student_id, String new_email){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String query = "UPDATE students SET email = '" + new_email + "' WHERE student_id = '" + student_id +"';";
            statement.executeQuery(query);

        } catch (Exception e){}
    }

    /**
     * Runs the DELETE query to delete the student with the specified student_id
     */
    public static void deleteStudent(String student_id) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String query = "DELETE FROM students WHERE student_id = '" + student_id +"';";
            statement.executeQuery(query);

        } catch (Exception e){}
    }

    public static void main(String[] args) {
        System.out.println("Retrieving and displaying all records from students table:");
        System.out.println("getAllStudents()");
        getAllStudents();

        System.out.println("Adding a new student record into the students table:");
        System.out.println("addStudent(\"Nicole\", \"Lim\", \"nicole.lim@carleton.ca\", \"2024-03-19\")");
        addStudent("Nicole", "Lim", "nicole.lim@carleton.ca", "2024-03-19");

        System.out.println("Updating the email address for a student with a specified student_id");
        System.out.println("updateStudentEmail(\"1\", \"jdoe@example.ca\")");
        updateStudentEmail("1", "jdoe@example.ca");
//
        System.out.println("Deleting the record of the student with the specified student_id");
        System.out.println("deleteStudent(\"2\");");
        deleteStudent("2");
    }
}
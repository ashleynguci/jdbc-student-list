package JdbcExercises;

import java.sql.*;
import java.util.Scanner;
/**
 * A minimal example of executing an SQL INSERT statement
 * 
 * @author Kari
 * @version 1.0
 */
public class SimpleStudentInsertProgram {
	
	public static void main(String[] args) {
		String username = ConnectionParameters.username;			 
		String password = ConnectionParameters.password;
		String databaseURL = ConnectionParameters.databaseURL;
		Connection dbConnection = null;	
		Scanner input = new Scanner(System.in);
		
		System.out.println("=== INSERTING A NEW STUDENT === \n");
		System.out.println("Enter student data");
		System.out.print("Id: ");
		int studentId = Integer.parseInt(input.nextLine());
		System.out.print("First name: ");
		String firstname = input.nextLine();
		System.out.print("Last name: ");
		String lastname = input.nextLine();
		System.out.print("Street: ");
		String streetaddress = input.nextLine();
		System.out.print("Postcode: ");
		String postcode = input.nextLine();
		System.out.print("Post office: ");
		String postoffice = input.nextLine();
			input.close();	
		try {
			dbConnection = DriverManager.getConnection(databaseURL, username, password);
							
			String sqlText = "INSERT INTO Student (id, firstname,lastname,streetaddress,postcode,postoffice) VALUES (?, ?,?,?, ?, ?)";
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, lastname);
			preparedStatement.setString(4, streetaddress);
			preparedStatement.setString(5, postcode);
			preparedStatement.setString(6, postoffice);
			
			preparedStatement.executeUpdate();

			System.out.println("Student data saved succesfully!");
			
		} catch (SQLException sqle) {
			
			// First, check if the problem is primary key violation (the error code is vendor-dependent)
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("Cannot insert the student. " +
			        "The student id (" + studentId + ") is already in data.");
			} else {
				System.out.println("===== Database error =====\n" + sqle.getMessage());
			}
			
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException sqle) {
					System.out.println("\nClose connection failed. \n" + sqle.getMessage());
				}
			}
		}
		
	}
}
// End
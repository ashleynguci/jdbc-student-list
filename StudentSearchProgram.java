package JdbcExercises;

import java.util.ArrayList;
import java.util.Scanner;
public class StudentSearchProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.print("Enter student id: ");
			Scanner input = new Scanner(System.in);
			int givenId = Integer.parseInt(input.nextLine());
			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.getStudentById(givenId);
			
		
			
				System.out.println(student.getFirstname() + " " + student.getLastname() + ", " + student.getStreetaddress() + ", "+ student.getPostcode()+" "+student.getPostoffice());		
		
		} catch (Exception ex) {
			System.out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println("=== System error message (for the developer's eyes only) === \n" + ex.getMessage());
		}
	}
	

}

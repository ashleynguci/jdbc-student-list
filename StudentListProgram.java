package JdbcExercises;
import java.util.ArrayList;

/**
 * Database access example using the DAO design pattern.
 * NB! There is no JDBC-related code in this class!
 * 
 * @author Kari
 * @version 1.0
 */
public class StudentListProgram {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("=== LISTING ALL STUDENTS ===");
			
			// 1. Create a DAO object for accessing the data
			StudentDAO studentDAO = new StudentDAO();
			
			// 2. Get a list of all movies
			ArrayList<Student> StudentList = studentDAO.getAllStudents();
		
			for (Student student : StudentList) {
				System.out.println(student.getFirstname() + " " + student.getLastname() + ", " + student.getStreetaddress() + ", "+ student.getPostcode()+" "+student.getPostoffice());		
			}	
		
		} catch (Exception ex) {
			System.out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println("=== System error message (for the developer's eyes only) === \n" + ex.getMessage());
		}
	}
}
// End
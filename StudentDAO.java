package JdbcExercises;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JdbcExercises.ConnectionParameters;
import JdbcExercises.Student;
import MovieDB_examples.Movie;
public class StudentDAO {
	private final String username;			 
	private final String password; 
	private final String databaseURL;
	public StudentDAO() throws Exception {
		username = ConnectionParameters.username;			 
		password = ConnectionParameters.password;
		databaseURL = ConnectionParameters.databaseURL;
		
		// In *Tomcat 8* the JDBC driver must be explicitly loaded as below
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 
    }
	
	/**
	 * Opens a new database connection 
	 * @throws SQLException
	 */
	private Connection openConnection() throws SQLException	{
		Connection dbConnection = DriverManager.getConnection(databaseURL, username, password);
		return dbConnection;
	}
	
	/**
	 * Closes an existing database connection 
	 * @throws SQLException
	 */
	private void closeConnection(Connection dbConnection) throws SQLException {
		if (dbConnection != null) {
			dbConnection.close();
		}
	}
	public ArrayList<Student> getAllStudents() throws SQLException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Connection dbConnection = null;
		
		try {
			dbConnection = openConnection();

			String sqlText = 
					"SELECT * FROM Student ORDER BY id";
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstname,lastname,streetaddress,postcode,postoffice));
			}

			
			return studentList;
			
		} catch (SQLException sqle)	{
			throw sqle;	// Let the caller decide what to do with the exception
			
		} finally {
			closeConnection(dbConnection);
		}
	}
	public Student getStudentById(int givenId) throws SQLException {
		Student studentList = new Student();
		Connection dbConnection = null;
		
		try {
			dbConnection = openConnection();

			String sqlText = 
					"SELECT * FROM Student WHERE id = ? ORDER BY id";
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, givenId);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");
				studentList.setFirstname(firstname);
				studentList.setLastname(lastname);
				studentList.setStreetaddress(streetaddress);
				studentList.setPostcode(postcode);
				studentList.setPostoffice(postoffice);
			}
			
			return studentList;
			
		} catch (SQLException sqle)	{
			throw sqle;  // Let the caller decide what to do with the exception
			
		} finally {
			closeConnection(dbConnection);
		}

	
	}
		
}

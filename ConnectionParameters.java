package JdbcExercises;

/**
 * ConnectionParameters.java	Reusable DBMS connection configuration parameter settings
 * 
 * Here you set the Database URL, username, and password to connect the desired database.
 * In addition, the vendor-specific error code for primary key violation is defined here.
 * 
 * NB! The mariadb.haaga-helia.fi server is accessible in the Internet from everywhere
 */

public class ConnectionParameters {
	
	// Set your own MariaDB username and password here!
	public static final String username = "bgh579"; 
	public static final String password = "zuMY3b63k";
	
	
	// Do NOT change any of the settings below!
	private static final String databaseName = username;
	public static final String databaseURL = "jdbc:mysql://localhost:3306/" + databaseName;
	public static final String jdbcDriver = "org.mariadb.jdbc.Driver";
	
	// PK violation: error code in MariaDB is 1062
	public static final int PK_VIOLATION_ERROR = 1062; 
}
// End
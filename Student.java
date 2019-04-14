package JdbcExercises;

public class Student {
	private int id;
	private String firstname ;
	private String lastname ;
	private String streetaddress ;
	private String postcode ;
	private String postoffice ;
	public Student() {
		
		id = -1;
		firstname = "";
		lastname = "";
		streetaddress = "";
		postcode = "";
		postoffice = "";
	}
	public Student(int id, String firstname, String lastname, String streetaddress, String postcode,
			String postoffice) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.streetaddress = streetaddress;
		this.postcode = postcode;
		this.postoffice = postoffice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPostoffice() {
		return postoffice;
	}
	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", streetaddress="
				+ streetaddress + ", postcode=" + postcode + ", postoffice=" + postoffice + "]";
	}
	
	
	
}

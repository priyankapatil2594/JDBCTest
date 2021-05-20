package studentmanagementsystem;

public class Studentinfo {

	    private int id;
	    private String firstname;
	    private String lastname;
	    private String address;

	    public Studentinfo() {
	    }

	    public Studentinfo(int id, String firstname, String lastname, String address) {
	        this.id = id;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.address= address;
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
	
	    public String getaddress() {
	        return address;
	    }

	    public void setaddress(String address) {
	        this.address=address;
	    }
	
}

package studentmanagementsystem;

import java.sql.*;

public class Studentmgmt{
	static String url = "jdbc:mysql://localhost:3306/studentdb";
	static String userName = "root";
	static String password = "pihu@1234";
	static String driverClassPath = "com.mysql.jdbc.Driver";

	public static Connection getDataBaseConnetion() {
		Connection con = null;
		try {
			Class.forName(driverClassPath);
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void saveStudent(Studentinfo std) {

		int affetctedRow = 0;
        Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into tblstudentdetails (studentid,studentfirstname,studentlastname,studentaddress) values(?,?,?,?)");
			stmt.setInt(1, std.getId());
			stmt.setString(2, std.getFirstname());
			stmt.setString(3, std.getLastname());
			stmt.setString(4, std.getaddress());
			
			affetctedRow = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(affetctedRow == 0){
			System.out.println("Student information not saved...: affected Rows = "+affetctedRow);
		}else{
			
			System.out.println("Student information saved succesfully : affected Rows  = "+affetctedRow);
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int updateStudent(int id,String name) {

		int affetctedRow = 0;

		Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			String query = "UPDATE tblstudentdetails SET studentfirstname = ? WHERE studentid = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(2, id);
			stmt.setString(1, name);
			affetctedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(affetctedRow == 0){
			System.out.println("Student information not  Update ... : affected Rows are = "+affetctedRow);
		}else{
			
			System.out.println("Student information updated succesfully : affected Rows are = "+affetctedRow);
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return affetctedRow;
	}
	
	public static void deleteStudent(int id) {

		int affetctedRow = 0;

		Connection con = getDataBaseConnetion();
		PreparedStatement stmt;
		try {
			String query = "delete from tblstudentdetails where studentid = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			affetctedRow = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(affetctedRow == 0){
			System.out.println("Student information not Deleted  : affected Rows are = "+affetctedRow);
		}else{
			
			System.out.println("Student information Deleted succesfully : affected Rows are = "+affetctedRow);
		}
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Studentinfo s = new Studentinfo(6,"Kiran", "Patil", "Kolhapur");
		
	    Studentmgmt.saveStudent(s);
	    Studentmgmt.updateStudent(6,"Supriya");
	    Studentmgmt.deleteStudent(4);
	    
	}	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

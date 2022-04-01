package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class StudentController {

	private StudentModel model = new StudentModel();
	private StudentView view;

	public StudentController() {
		
	}
	
	public StudentController(StudentModel model, StudentView view) {
		this.model = model;
		this.view = view;
	}
	
	public void registerStudent(int id, String name, int math, int science, int english) {
		try {
			// Connect to database
			Connection conn = null;
			String connectionURL = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
			
			conn = DriverManager.getConnection(connectionURL, "root", "syafiq123");
		
			// Create a statement to retrieve objects
			Statement s = conn.createStatement();        

			// Insert data to the table
			s.executeUpdate ("INSERT INTO STUDINFO VALUES ("+id+",'"+name+"',"+math+","+science+","+english+")"); 
	
		} catch (Exception o) {
			o.printStackTrace();
		}
	}
	
	public void readStudentData(int studentID){
		
		Connection conn = null;
		String connectionURL = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
		try {
		conn = DriverManager.getConnection(connectionURL, "root", "syafiq123");
		
		// create a Statement from the connection
				Statement statement = conn.createStatement();
		
		// Retrieve results from the table
				ResultSet rs = statement.executeQuery ("Select * from studinfo"); 
				
				// Count columns
				ResultSetMetaData rsmd =rs.getMetaData(); 
				int i =rsmd.getColumnCount( );
						
				// Insert records to Model class
				while(rs.next( ) ) { 
					for(int j=1; j<=i; j++) { 
						if(Integer.valueOf(rs.getString( 1)) == studentID) {
							if(j == 1)
								model.setStudID(Integer.valueOf(rs.getString( j)));
							else if(j == 2)
								model.setStudName(rs.getString( j));
							else if(j == 3)
								model.setMath(Integer.valueOf(rs.getString( j)));
							else if(j == 4)
								model.setScience(Integer.valueOf(rs.getString( j)));
							else if(j == 5)
								model.setEnglish(Integer.valueOf(rs.getString( j)));
					}}
				}
				updateData();
		} catch (Exception o) {
			System.out.println(o.getMessage());
		}
	}
	
	public void updateData() {
		view.displayStudentData(model.getStudID(), model.getStudName(), model.getMath(), model.getScience(), model.getEnglish());
	}
	
}

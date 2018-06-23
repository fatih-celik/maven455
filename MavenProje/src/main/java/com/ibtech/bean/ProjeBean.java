package com.ibtech.bean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import com.ibtech.model.Student;

@ManagedBean(name="projeBean")
@ViewScoped

public class ProjeBean {
	
	private Student student ;
	private List<Student> studentList; 
	   final String JDBC_DRIVER = "org.h2.Driver";   
	   final String DB_URL = "jdbc:h2:~/h2database";  
	   
	   final String USER = "admin"; 
	   final String PASS = ""; 
	Connection connect = null;
	Statement stmt = null; 
	/*
	public void DbConnection() {
		try {

			Class.forName("JDBC_DRIVER"); 

			 connect = DriverManager.getConnection(DB_URL,USER,PASS);
			// System.out.println("Connection established"+connect);
			 
			 stmt=connect.createStatement();
		        String sql =  "CREATE TABLE   Car " + 
		                "(car_id INTEGER not NULL, " + 
		                " cname VARCHAR(255), " +  
		                " color VARCHAR(255), " + 
		                " speed INTEGER, " +  
		                " Manufactured_Country VARCHAR(100), " +  
		                " PRIMARY KEY ( car_id ))";
		        stmt.executeUpdate(sql);
		        
		         stmt.close(); 
		         connect.close();
		      } catch(SQLException se){ 
	         //Handle errors for JDBC 
	         se.printStackTrace(); 
	      } catch(Exception e) { 
	         //Handle errors for Class.forName 
	         e.printStackTrace(); 
	      } finally { 
	         //finally block used to close resources 
	         try{ 
	            if(stmt!=null) stmt.close(); 
	         } catch(SQLException se2) { 
	         } // nothing we can do 
	         try { 
	            if(connect!=null) connect.close(); 
	         } catch(SQLException se){ 
	            se.printStackTrace(); 
	         } //end finally try 
	      } //end try 
	}
	
	
	*/
	
	
	public void DbConnection() {
        try
        {
            Class.forName("JDBC_DRIVER");
            connect = DriverManager.getConnection("jdbc:h2:~/student");
            stmt = connect.createStatement();
	        String sql =  "CREATE TABLE   Car " + 
	                "(car_id INTEGER not NULL, " + 
	                " cname VARCHAR(255), " +  
	                " color VARCHAR(255), " + 
	                " speed INTEGER, " +  
	                " Manufactured_Country VARCHAR(100), " +  
	                " PRIMARY KEY ( car_id ))";
	        stmt.executeUpdate(sql);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
    
		
		
		
		
		
	
	   
	public ProjeBean() {
		student = new Student();
		studentList =new ArrayList<Student>();
		DbConnection();
		
	}
	

	
	public void ekle() {
		studentList.add(student);
		student = new Student();
	}
	
	public String deleteAction(Student student) {
	    
		studentList.remove(student);
		return null;
	}
 
	
	
	/*
    public void delete() throws IOException {
        // DAO save the delete
    	Student e = studentList.get(studentList.size() - 1);
        studentList.remove(e);
    }
    */
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public String saveAction() {
	    
		//var olan tüm değerleri al ama editable=false yap
		for (Student student : studentList){
			student.setEditable(false);
		}
		//sayfaya geri döner
		return null;
		
	}
	
	public String editAction(Student student) {
	    
		student.setEditable(true);
		return null;
	}

	
}

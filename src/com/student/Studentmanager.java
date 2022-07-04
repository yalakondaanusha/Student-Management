package com.student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Studentmanager {

  static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","root");
		
  


        public void addStudent()throws NumberFormatException,IOException,SQLException
		{
		
		

		System.out.println("Enter Student Id:");
		int studentid=Integer.parseInt(br.readLine());
		System.out.println("Enter Student Name:");
		String studentName=br.readLine();
		System.out.println("Enter Student Gender:");
		String studentGender=br.readLine();
		System.out.println("Enter Student Department:");
		String studentDepartment=br.readLine();
		System.out.println("Enter Student Year:");
		int studentYear=Integer.parseInt(br.readLine());
		System.out.println("Enter student Mobile Number:");
		long studentMobile=Long.parseLong(br.readLine());

		
		PreparedStatement stmt=conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
		stmt.setInt(1,studentid);
		stmt.setString(2,studentName);
		stmt.setString(3,studentGender);
		stmt.setString(4,studentDepartment);
		stmt.setDouble(5,studentYear);
		stmt.setLong(6,studentMobile);

		if(stmt.executeUpdate()>0)
		{
		System.out.println("student information added!!");
		}
		else
		{
		System.out.println("Somthing went wrong!!");
		}


		}


		void deleteStudentById()throws NumberFormatException,IOException,SQLException
		{
		System.out.println("Enter Student Id:");
		int studentid=Integer.parseInt(br.readLine());

		PreparedStatement ps=conn.prepareStatement("delete from student where studentId=?");
		ps.setInt(1,studentid);
		if(ps.executeUpdate()>0)
		{
		System.out.println("Record deleted!!");
		}
		else
		{
		System.out.println("Problem in student record deletion!!");
		}

		}


		void fetchStudentById()throws NumberFormatException,IOException,SQLException
		{

		System.out.println("Enter student Id:");
		int studentid=Integer.parseInt(br.readLine());
		PreparedStatement ps=conn.prepareStatement("select *  from student where studentId=?");
		ps.setInt(1,studentid);
		ResultSet result=ps.executeQuery();

		if(result.next())
		{
		System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getInt(5)+" "+result.getLong(6));
		}


		}


		void fetchAllstudents()throws SQLException
		{

		PreparedStatement ps=conn.prepareStatement("select *  from student ");
		ResultSet result=ps.executeQuery();

		while(result.next())
		{
		System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getInt(5)+" "+result.getLong(6));
		}
		}

		void updateStudentById()throws NumberFormatException,IOException,SQLException
		{
		System.out.println("Enter student Id:");
		int studentid=Integer.parseInt(br.readLine());


		System.out.println("Enter new student Year:");
		int studentYear=Integer.parseInt(br.readLine());

		System.out.println("Enter new student Branch:");
		String studentBranch=br.readLine();

		System.out.println("Enter new student Mobile Number:");
		long studentMobile=Long.parseLong(br.readLine());

		PreparedStatement ps=conn.prepareStatement("update student set studentYear=?,studentBranch=?,studentMobile where studentId=?");
		ps.setInt(1,studentYear);
		ps.setString(2,studentBranch);
		ps.setLong(3,studentMobile);
		ps.setInt(4,studentid);
		if(ps.executeUpdate()>0)
		{
		System.out.println("student record updated!!");
		}
		else
		{
		System.out.println("problem in update!!");
		}
		

		}
		
		public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
			  Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","root");
					

				
				
				Scanner sc=new Scanner(System.in);
				Studentmanager studentmanager=new Studentmanager();
				int option;
				do{
					System.out.println("Select one of the operations:");
					System.out.println("1. Add a new student record");
					System.out.println("2. Show a student details");
					System.out.println("3. Update a student details");
					System.out.println("4. Show all student records");
					System.out.println("5. Delete a student record");
					System.out.println("6. Exit");
					System.out.println("Select an operation: ");
					option=sc.nextInt();
					

					}while(option>=1 && option<=5);
		

  
}
}








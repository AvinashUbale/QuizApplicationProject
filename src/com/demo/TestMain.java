package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestMain extends Questions {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = DBUtil.getCon();
		
		String query = "insert into studentRegistration1 values(?,?,?,?,?,?)";
		
		PreparedStatement pst= con.prepareStatement(query);
		
		System.out.println("*****  Welcome to the QUIZ APPLICATION  *****");
		System.out.println();
		System.out.println("User Operations");
		System.out.println("1. Student Registration");
		System.out.println("2. Student Login");
		System.out.println("3. Display The dist of Questions.");
		System.out.println("4. Store Quiz result in to database");
		System.out.println("5. Display Quiz result");
		System.out.println("6. ");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student first Name :");
		String firstName= sc.next();
		
		System.out.println("Enter Student Last Name :");
		String lastName = sc.next();
		
		System.out.println("Enter userName :");
		String userName = sc.next();
		
		System.out.println("Enter Student password :");
		String password = sc.next();
		
		System.out.println("Enter Student city :");
		String city = sc.next();
		
		System.out.println("Enter Student contact :");
		long contact = sc.nextLong();
		
		
		pst.setString(1, firstName);
		pst.setString(2, lastName);
		pst.setString(3, userName);
		pst.setString(4, password);
		pst.setString(5, city);
		pst.setLong(6, contact);
		
		
		int i = pst.executeUpdate();
		
		System.out.println(i+"Data inserted successfully...");
		
		StudentLogin st = new StudentLogin();
		String query1 = "Insert into StudentLogin values(?,?)";
		PreparedStatement pst1 = con.prepareStatement(query1);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter User Name");
        String stud_userName = sc1.next();
        
		System.out.println("Enter Student Password");
		String stud_password = sc.next();
		
		pst1.setString(1, stud_userName);
		pst1.setString(2, stud_password);
		
		int j = pst1.executeUpdate();
		System.out.println(j+"Student Login Successfully");
		
		con.close();
		pst.close();
		
		System.out.println("****  Question List *****");

		
		Scanner sc3 = new Scanner(System.in);
		
		Quiz q = new Quiz();
		q.logic();
		
		System.out.println("Enter your answer :");
		Character ans=sc.next().charAt(0);
		
	    
        System.out.println();
        System.out.println("--------Result---------");
        //System.out.println("Total Questions: "+hmap.size());
        String correctAnsCount = null;
        String wrongAnsCount = null;
		System.out.println("Correct Answered Questions : "+correctAnsCount);
	        System.out.println("Wrong Answered Questions : "+wrongAnsCount);
//	        int percentage=(100*correctAnsCount)/hmap.size();
//	        System.out.println("Percentage : "+percentage);
//	        if(percentage>95){
//	            System.out.println("Performance : Very Good");
//	        }
//	        else if(percentage<35){
//	            System.out.println("Performance : Very Low");
//	        }
//	        else{
//	            System.out.println("Performance : Medium");
//	        }


}
	
}

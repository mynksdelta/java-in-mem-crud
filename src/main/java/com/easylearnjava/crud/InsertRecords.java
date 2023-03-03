package com.easylearnjava.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.easylearnjava.util.DBConnection;

public class InsertRecords {

	public static void main(String[] args) {

		Connection conn = DBConnection.getH2DBConnection();
		try {
			insertEmployeeRecords(conn, 1, "raghu", "kumar", "secret", 2);
			insertEmployeeRecords(conn, 2, "naveen" , "Bhatnagar", "topsecret", 3);
			insertEmployeeRecords(conn, 3, "abhi", "Roy", "supertopsecret", 1);
			insertEmployeeRecords(conn, 4, "mayank", "Jadeja", "superdoopertopsecret", 1);
			insertEmployeeRecords(conn, 5, "puneet", "kumar", "jamesbondleveltopsecret", 11);
			insertEmployeeRecords(conn, 6, "sanchit", "rana", "justanothertopsecret", 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Insert Employee records
	public static void insertEmployeeRecords(Connection connection, int id, String fname, String lname, String pwd, int wex){
		
		PreparedStatement pStmt = null;
		String insertSQL = "INSERT INTO EMPLOYEE (EMP_ID, EMP_FNAME, EMP_LNAME, EMP_PASSWORD, EMP_WEX) VALUES (?,?,?,?,?)";
		try{
			pStmt = connection.prepareStatement(insertSQL);
			pStmt.setInt(1, id);
			pStmt.setString(2, fname);
			pStmt.setString(3, lname);
			pStmt.setString(4, pwd);
			pStmt.setInt(5, wex);
			int count = pStmt.executeUpdate();
			System.out.println("No of records effected : " + count);
			pStmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}		

}


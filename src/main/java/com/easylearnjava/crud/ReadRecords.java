package com.easylearnjava.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.easylearnjava.util.DBConnection;

public class ReadRecords {

	public static void main(String[] args) {

		Connection conn = DBConnection.getH2DBConnection();
		try {
			readEmployeeRecords(conn);
//			readEmployeeRecordsSortedByName(conn);
//			readEmployeeRecordsSortedBySeniority(conn);
//			readEmployeeRecordsHavingCommonSurname(conn);
//			readEmployeeRecordsNameStartedWithS(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Read Employee records
	public static void readEmployeeRecords(Connection connection){
		
		PreparedStatement pStmt = null;
		String readSQL = "SELECT * FROM EMPLOYEE";
		try{
			pStmt = connection.prepareStatement(readSQL);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("EMPLOYEE ID " + "\t" + "EMPLOYEE NAME " + "\t" + "EMPLOYEE PASSWORD"+ "\t" + "EMPLOYEE EXPERIENCE");
			System.out.println("----------- " + "\t" + "-------------- " + "\t" + "-----------------" + "\t" + "-----------------");
			while (rs.next()) {
				int id = rs.getInt("EMP_ID");
				String name = rs.getString("EMP_NAME");
				String password = rs.getString("EMP_PASSWORD");
				int wex = rs.getInt("EMP_WEX");
				System.out.println(id + "\t\t" + name + "\t\t" + password + "\t\t" + wex);
			}			
			pStmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	public static void readEmployeeRecordsSortedByName(Connection connection){
		PreparedStatement pStmt = null;
		String readSQL = "SELECT * FROM EMPLOYEE ORDER BY EMP_NAME";
		try {
			pStmt = connection.prepareStatement(readSQL);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("EMPLOYEE ID " + "\t" + "EMPLOYEE FIRST NAME " + "EMPLOYEE LAST NAME " + "\t" + "EMPLOYEE PASSWORD"+ "\t" + "EMPLOYEE EXPERIENCE");
			System.out.println("----------- " + "\t" + "-------------- " + "\t" + "-----------------" + "\t" + "-----------------" + "\t" + "-----------------");
			while (rs.next()) {
				int id = rs.getInt("EMP_ID");
				String fname = rs.getString("EMP_FNAME");
				String lname = rs.getString("EMP_LNAME");
				String password = rs.getString("EMP_PASSWORD");
				int wex = rs.getInt("EMP_WEX");
				System.out.println(id + "\t\t" + fname + "\t\t" + lname + "\t\t" + password + "\t\t" + wex);
			}
			pStmt.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void readEmployeeRecordsSortedBySeniority(Connection connection){
		PreparedStatement pStmt = null;
		String readSQL = "SELECT * FROM EMPLOYEE ORDER BY EMP_WEX DESC";
		try {
			pStmt = connection.prepareStatement(readSQL);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("EMPLOYEE ID " + "\t" + "EMPLOYEE FIRST NAME " + "EMPLOYEE LAST NAME " + "\t" + "EMPLOYEE PASSWORD"+ "\t" + "EMPLOYEE EXPERIENCE");
			System.out.println("----------- " + "\t" + "-------------- " + "\t" + "-----------------" + "\t" + "-----------------" + "\t" + "-----------------");
			while (rs.next()) {
				int id = rs.getInt("EMP_ID");
				String fname = rs.getString("EMP_FNAME");
				String lname = rs.getString("EMP_LNAME");
				String password = rs.getString("EMP_PASSWORD");
				int wex = rs.getInt("EMP_WEX");
				System.out.println(id + "\t\t" + fname + "\t\t" + lname + "\t\t" + password + "\t\t" + wex);
			}
			pStmt.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void readEmployeeRecordsHavingCommonSurname(Connection connection){
		PreparedStatement pStmt = null;
		String readSQL = "SELECT * FROM EMPLOYEE WHERE EMP_LNAME IN (SELECT EMP_LNAME FROM EMPLOYEE GROUP BY EMP_LNAME HAVING COUNT(EMP_LNAME) > 1)";
		try {
			pStmt = connection.prepareStatement(readSQL);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("EMPLOYEE ID " + "\t" + "EMPLOYEE FIRST NAME " + "EMPLOYEE LAST NAME " + "\t" + "EMPLOYEE PASSWORD"+ "\t" + "EMPLOYEE EXPERIENCE");
			System.out.println("----------- " + "\t" + "-------------- " + "\t" + "-----------------" + "\t" + "-----------------" + "\t" + "-----------------");
			while (rs.next()) {
				int id = rs.getInt("EMP_ID");
				String fname = rs.getString("EMP_FNAME");
				String lname = rs.getString("EMP_LNAME");
				String password = rs.getString("EMP_PASSWORD");
				int wex = rs.getInt("EMP_WEX");
				System.out.println(id + "\t\t" + fname + "\t\t" + lname + "\t\t" + password + "\t\t" + wex);
			}
			pStmt.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void readEmployeeRecordsNameStartedWithS(Connection connection){
		PreparedStatement pStmt = null;
		String readSQL = "SELECT * FROM EMPLOYEE WHERE EMP_FNAME LIKE 's%' AND EMP_FNAME LIKE 'S%' ";
		try {
			pStmt = connection.prepareStatement(readSQL);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("EMPLOYEE ID " + "\t" + "EMPLOYEE FIRST NAME " + "EMPLOYEE LAST NAME " + "\t" + "EMPLOYEE PASSWORD"+ "\t" + "EMPLOYEE EXPERIENCE");
			System.out.println("----------- " + "\t" + "-------------- " + "\t" + "-----------------" + "\t" + "-----------------" + "\t" + "-----------------");
			while (rs.next()) {
				int id = rs.getInt("EMP_ID");
				String fname = rs.getString("EMP_FNAME");
				String lname = rs.getString("EMP_LNAME");
				String password = rs.getString("EMP_PASSWORD");
				int wex = rs.getInt("EMP_WEX");
				System.out.println(id + "\t\t" + fname + "\t\t" + lname + "\t\t" + password + "\t\t" + wex);
			}
			pStmt.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


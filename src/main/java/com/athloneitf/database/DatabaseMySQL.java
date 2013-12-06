package com.athloneitf.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;

import com.athloneitf.datatypes.AITFMember;

public class DatabaseMySQL {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void connectDataBase() {
		if(connect==null){
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/aitf?"
							+ "user=root&password=");

		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	}
	
	public AITFMember loginInstructor(String instructorBarCode){
		AITFMember returnValue=null;
		try {
			PreparedStatement psInstructorLogin =
					connect.prepareStatement("SELECT * FROM aitf_member_table "+
			"WHERE Instructor>0 and MemberBarCode="+instructorBarCode);
			ResultSet loginResult=psInstructorLogin.executeQuery();
			returnValue=parseAITFMember(loginResult);
			if (returnValue!=null){
				logoutAllInstructors();
				// Log instructor into database
				PreparedStatement psRecordLogin =
						connect.prepareStatement("INSERT INTO instructor_login "+
				"(MemberCode,LoginTime) VALUES ("+instructorBarCode+",now())");
				psRecordLogin.executeUpdate();
			}
		} catch(SQLException sqle){sqle.printStackTrace();}
		return returnValue;
	}
	
	private void logoutAllInstructors() throws SQLException{
		// Logout all instructors from database
		PreparedStatement psLogoutInstructors =
				connect.prepareStatement("UPDATE instructor_login SET LogoutTime="+
						"now() WHERE LogoutTime IS NULL");
				psLogoutInstructors.executeUpdate();
	}
	
	private AITFMember parseAITFMember(ResultSet memberResultSet) throws SQLException{
		while(memberResultSet.next()){
			AITFMember returnMember=new AITFMember();
			returnMember.setFirstName(memberResultSet.getString("MemberFirstName"));
			returnMember.setSurname(memberResultSet.getString("MemberSurname"));
			returnMember.setMemberDob(memberResultSet.getDate("DateOfBirth"));
			returnMember.setMemberCode(memberResultSet.getInt("MemberBarCode"));
			return returnMember;
		}
		return null;
	}
	
	
	
	

	public void traceMemberList() {
		// Statements allow to issue SQL queries to the database
		try {
			PreparedStatement preparedStatementMemberList = 
					connect.prepareStatement("Select * from aitf_member_table");
			resultSet = preparedStatementMemberList.executeQuery();
			writeResultSet(resultSet,"MemberBarCode","MemberFirstName"
					,"MemberSurname","DateOfBirth");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	public void writeResultSet(ResultSet resultSet,String...fieldNames ) throws SQLException {

		while (resultSet.next()) {
			for(String fieldName:fieldNames){
				System.out.println(fieldName + resultSet.getString(fieldName)+"\n");
			}

		}
	}

}

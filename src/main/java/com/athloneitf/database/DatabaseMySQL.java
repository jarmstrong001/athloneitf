package com.athloneitf.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;

import com.athloneitf.datatypes.AITFMember;
import com.athloneitf.datatypes.InstructorLogin;
import com.athloneitf.main.SessionFactoryUtil;

public class DatabaseMySQL {

	public Session startSession(){
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return session;
	}
	
	public AITFMember loginInstructor(String instructorBarCode){
		AITFMember returnValue=null;
		try {
			Session session=startSession();
			Query instructorLoginQuery = session.createQuery("FROM AITFMember "+
			"WHERE Instructor=TRUE and MemberBarCode="+instructorBarCode);
			List<AITFMember> instructor=instructorLoginQuery.list();
			System.out.println(instructor.size()+" records");
			session.getTransaction().commit();
			if (!(instructor.size()==0)){
				logoutAllInstructors();
				insertInstructorLogin(instructorBarCode);
				returnValue=instructor.get(0);
			}
		} catch(SQLException sqle){sqle.printStackTrace();}
		return returnValue;
	}
	
	public void insertInstructorLogin(String instructorBarCode){
		// Log instructor into database
		Session session=startSession();
		Query instructorLoginInsert = session.createSQLQuery("INSERT INTO "+
		"InstructorLogin(MemberBarCode,LoginTime) VALUES('"+instructorBarCode+"',now())");
		instructorLoginInsert.executeUpdate();
		session.getTransaction().commit();
		
	}
	
	private void logoutAllInstructors() throws SQLException{
		// Logout all instructors from database
		Session session=startSession();
		Query instructorLoginUpdate = session.createQuery("UPDATE InstructorLogin SET LogoutTime="+
						"now() WHERE LogoutTime IS NULL");
		instructorLoginUpdate.executeUpdate();
		session.getTransaction().commit();
	}
	
	
	
	/*private AITFMember parseAITFMember(ResultSet memberResultSet) throws SQLException{
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
	*/

}

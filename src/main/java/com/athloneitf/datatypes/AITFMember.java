package com.athloneitf.datatypes;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;

@Entity(name="AITFMemberTable")
public class AITFMember{
	
	@Column(name="MemberFirstName")
	private String FirstName;
	@Column(name="MemberSurname")
	private String Surname;
	@Column(name="DateOfBirth")
	private Date memberDob;
	@Column(name="MemberBarCode")
	private int memberCode;
	
		
	public Date getMemberDob() {
		return memberDob;
	}
	public void setMemberDob(Date memberDob) {
		this.memberDob = memberDob;
	}
	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surnmae) {
		Surname = surnmae;
	}
	
	public String toString(){
		return getFirstName()+" "+getSurname()+"\t"+Common.dobDateFormat.format(getMemberDob())+"\t"+getMemberCode();
	}
	
}
	
	
	
	



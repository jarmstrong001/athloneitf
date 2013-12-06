package com.athloneitf.datatypes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Column;

import com.athloneitf.main.Common;

@Entity(name="AITF_Member_Table")
public class AITFMember{
	
	@Column(name="MemberFirstName")
	private String firstName;
	@Column(name="MemberSurname")
	private String surname;
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
		return firstName;
	}
	public void setFirstName(String memberFirstName) {
		firstName = memberFirstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String memberSurname) {
		surname = memberSurname;
	}
	
	public String getName() {
		return firstName+" "+surname;
	}
	
	public String toString(){
		return getFirstName()+" "+getSurname()+"\t"+Common.dobDateFormat.format(getMemberDob())+"\t"+getMemberCode();
	}
	
}
	
	
	
	



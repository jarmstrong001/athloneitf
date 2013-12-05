package com.athloneitf.datatypes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AITFMember{
	
	private String memberName;
	private Date memberDob;
	private int memberCode;
	private SimpleDateFormat dobDateFormat=new SimpleDateFormat("dd/MMM/yyyy");
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
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
	
	public String toString(){
		return getMemberName()+"\t"+dobDateFormat.format(getMemberDob())+"\t"+getMemberCode();
	}
	
	
	
	


}
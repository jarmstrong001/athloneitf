package com.athloneitf.datatypes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AITFClass {
	
	private ClassType classType;
	private Date classDate;
	private Instructor classInstructor;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd/MMM/yyyy");
	
	
	public Instructor getClassInstructor() {
		return classInstructor;
	}
	public void setClassInstructor(Instructor classInstructor) {
		this.classInstructor = classInstructor;
	}
	
	public Date getClassDate() {
		return classDate;
	}
	public void setClassDate(Date classDate) {
		this.classDate = classDate;
	}
	
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	
	public String toString(){
		return classType+" class\n"+dateFormat.format(getClassDate())+
				"\n"+getClassInstructor().getInstructorName();
		
	}
	
	
	
}

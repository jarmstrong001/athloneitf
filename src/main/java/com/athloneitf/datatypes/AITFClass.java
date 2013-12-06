package com.athloneitf.datatypes;

import java.util.Calendar;
import java.util.Date;

import com.athloneitf.main.Common;

public class AITFClass {
	
	private ClassType classType;
	private Date classDate;
	private Instructor classInstructor;
	
	
	
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
	
	public int getDayOfWeek(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getClassDate());
		return calendar.get(Calendar.DAY_OF_WEEK);		
	}
	
		public String toString(){
		return classType+" class\n"+Common.dateFormat.format(getClassDate())+
				"\n"+getClassInstructor().getInstructorName();
		
	}
	
	
	
}

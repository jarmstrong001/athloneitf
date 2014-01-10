package com.athloneitf.datatypes;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

import com.athloneitf.main.Common;

@Entity
public class AITFSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AITFScheduleId")
	private int id;
	@Column
	private String className;
	@Column
	private int dayOfWeek;
	@Column
	private int time;
	@Column
	private int duration;
	@Enumerated(EnumType.STRING)
	ClassType classType;
	
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	/*public String toString(){
		return getClassName()+" "+getTime()+" "+
	getDayOfWeek()+" for "+getDuration()+" minutes "+getClassType();
	}*/
	
	public String toString(){
		return getClassName()+" "+Common.getDayOfWeek(getDayOfWeek());
	}
	
}

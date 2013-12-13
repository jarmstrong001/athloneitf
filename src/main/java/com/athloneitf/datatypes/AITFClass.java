package com.athloneitf.datatypes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import com.athloneitf.main.Common;

@Entity
public class AITFClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AITFClassId")
	private int id;
	@Enumerated(EnumType.STRING)
	private ClassType classType;
	@Column
	private Date classDate;
	@ManyToOne
	@JoinColumn(name = "MemberBarCode")
	private AITFMember classInstructor;
	@ManyToOne
	private AITFSchedule aitfSchedule;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AITFSchedule getAitfScheduleId() {
		return aitfSchedule;
	}

	public void setAitfScheduleId(AITFSchedule aitfSchedule) {
		this.aitfSchedule = aitfSchedule;
	}

	public AITFMember getClassInstructor() {
		return classInstructor;
	}

	public void setClassInstructor(AITFMember classInstructor) {
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

	public int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getClassDate());
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public String toString() {
		return classType + " class\n"
				+ Common.dateFormat.format(getClassDate()) + "\n"
				+ getClassInstructor().getName();
	}

}

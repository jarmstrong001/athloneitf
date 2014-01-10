package com.athloneitf.datatypes;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class AITFClassTest {
	
	@Test
	public void test() {
		AITFMember instructor=new AITFMember();
		instructor.setFirstName("Paul");
		instructor.setSurname("Fox");
		
		AITFClass aitfClass=new AITFClass();
		aitfClass.setClassDate(new Date(0));
		aitfClass.setClassInstructor(instructor);
		aitfClass.setClassType(ClassType.TAEKWONDO);
		
		System.out.println(aitfClass.toString());
		assertEquals(aitfClass.toString(), "TAEKWONDO class\n01:00 01/Jan/1970\nPaul Fox");
		
	}
}

package com.athloneitf.main;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;

import com.athloneitf.datatypes.*;

public class InitializeData {

	public static void main(String[] args) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		createMember(session);
		
		queryMember(session);
		
		createSchedule(session);
		
		querySchedule(session);
	}

    private static void queryMember(Session session) {
        Query query = session.createQuery("from AITFMember");                 
        List <AITFMember>list = query.list();
        java.util.Iterator<AITFMember> iter = list.iterator();
        while (iter.hasNext()) {

        	AITFMember person = iter.next();
            System.out.println(person.toString());

        }

        //session.getTransaction().commit();

    }
    
    private static void querySchedule(Session session) {
        Query query = session.createQuery("from AITFSchedule");                 
        List <AITFSchedule>list = query.list();
        java.util.Iterator<AITFSchedule> iter = list.iterator();
        while (iter.hasNext()) {

        	AITFSchedule person = iter.next();
            System.out.println(person.toString());

        }

        session.getTransaction().commit();

    }

    public static void createMember(Session session) {
    	AITFMember person = new AITFMember();
    	AITFMember person2 = new AITFMember();
    	AITFMember person3 = new AITFMember();
    	AITFMember person4 = new AITFMember();
    	

        person.setFirstName("Paul");
        person.setSurname("Fox");       
        person.setMemberCode(12345001);
        Calendar c=Calendar.getInstance();
        c.set(1980,2,12,0,0,0);
        person.setMemberDob(c.getTime());
        person.setInstructor(true);
        person.setScannedInStatus(false);
        session.save(person);
        
        person2.setFirstName("Kelly");
        person2.setSurname("McHugh");
        person2.setMemberCode(12346002);
        c.set(1999,3,22,0,0,0);
        person2.setMemberDob(c.getTime());
        person2.setInstructor(false);
        person2.setScannedInStatus(false);
        session.save(person2);
        
        person3.setFirstName("Joss");
        person3.setSurname("Armstrong");
        person3.setMemberCode(12346001);
        c.set(1978,1,16,0,0,0);
        person3.setMemberDob(c.getTime());
        person3.setInstructor(false);
        person3.setScannedInStatus(false);
        session.save(person3);
        
        person4.setFirstName("Isobel");
        person4.setSurname("Fox");
        person4.setMemberCode(12345002);
        c.set(1981,2,29,0,0,0);
        person4.setMemberDob(c.getTime());
        person4.setInstructor(false);
        person4.setScannedInStatus(false);
        session.save(person4);
        
    }
    
    public static void createSchedule(Session session) {
    	List<AITFSchedule> scheduleList=new ArrayList<AITFSchedule>(22);
    	for(int i=0;i<22;i++){
    		AITFSchedule a=new AITFSchedule();
    		scheduleList.add(i,a);
    	}
    	
    	AITFSchedule schedule=scheduleList.get(21);
    	schedule.setClassName("Other");
    	schedule.setDayOfWeek(1);
    	schedule.setTime(0000);
    	schedule.setId(0);
    	schedule.setDuration(0);
    	schedule.setClassType(ClassType.OTHER);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(0);
    	schedule.setClassName("Ninjas 6yrs beginners");
    	schedule.setDayOfWeek(2);
    	schedule.setTime(1700);
    	schedule.setId(1);
    	schedule.setDuration(45);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(1);    	
    	schedule.setClassName("Ninjas beginners");
    	schedule.setDayOfWeek(4);
    	schedule.setTime(1615);
    	schedule.setId(2);
    	schedule.setDuration(45);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(2); 
    	schedule.setClassName("Ninjas intermediate");
    	schedule.setDayOfWeek(4);
    	schedule.setTime(1715);
    	schedule.setId(3);
    	schedule.setDuration(45);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(3); 
    	schedule.setClassName("Ninjas beginners");
    	schedule.setDayOfWeek(7);
    	schedule.setTime(930);
    	schedule.setId(4);
    	schedule.setDuration(45);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(4); 
    	schedule.setClassName("Beginners 7-12 Monday");
    	schedule.setDayOfWeek(2);
    	schedule.setTime(1800);
    	schedule.setId(5);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(5); 
    	schedule.setClassName("Beginners 7-12 Tuesday");
    	schedule.setDayOfWeek(3);
    	schedule.setTime(1600);
    	schedule.setId(6);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(6);     	
    	schedule.setClassName("Beginners 7-12 Thursday");
    	schedule.setDayOfWeek(5);
    	schedule.setTime(1700);
    	schedule.setId(7);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(7);     	
    	schedule.setClassName("Beginners 13-17/Adult");
    	schedule.setDayOfWeek(2);
    	schedule.setTime(1900);
    	schedule.setId(8);
    	schedule.setDuration(75);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(8); 
    	schedule.setClassName("Intermediate 13-17/Adult");
    	schedule.setDayOfWeek(3);
    	schedule.setTime(1900);
    	schedule.setId(9);
    	schedule.setDuration(90);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(9); 
       	schedule.setClassName("Yellow Tag - Yellow Belt Children");
    	schedule.setDayOfWeek(3);
    	schedule.setTime(1700);
    	schedule.setId(10);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(10); 
    	schedule.setClassName("Green Stripe - Red Belt Children");
    	schedule.setDayOfWeek(3);
    	schedule.setTime(1800);
    	schedule.setId(11);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(11); 
    	schedule.setClassName("Yellow Tag - Green Tag Children");
    	schedule.setDayOfWeek(5);
    	schedule.setTime(1600);
    	schedule.setId(12);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(12); 
    	schedule.setClassName("Green Stripe - Red Children");
    	schedule.setDayOfWeek(5);
    	schedule.setTime(1800);
    	schedule.setId(13);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(13); 
    	schedule.setClassName("Yellow & Up");
    	schedule.setDayOfWeek(6);
    	schedule.setTime(1600);
    	schedule.setId(14);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(14); 
    	schedule.setClassName("Red-Black & Intermediate Adult");
    	schedule.setDayOfWeek(5);
    	schedule.setTime(1900);
    	schedule.setId(15);
    	schedule.setDuration(90);
    	schedule.setClassType(ClassType.TAEKWONDO);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(15); 
    	schedule.setClassName("Beginners");
    	schedule.setDayOfWeek(2);
    	schedule.setTime(1000);
    	schedule.setId(16);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.SKYBOXING);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(16); 
    	schedule.setClassName("Beginners");
    	schedule.setDayOfWeek(4);
    	schedule.setTime(1000);
    	schedule.setId(17);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.SKYBOXING);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(17); 
    	schedule.setClassName("Beginners");
    	schedule.setDayOfWeek(6);
    	schedule.setTime(1000);
    	schedule.setId(18);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.SKYBOXING);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(18); 
    	schedule.setClassName("Challenge");
    	schedule.setDayOfWeek(2);
    	schedule.setTime(2030);
    	schedule.setId(19);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.SKYBOXING);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(19); 
    	schedule.setClassName("Challenge");
    	schedule.setDayOfWeek(4);
    	schedule.setTime(2030);
    	schedule.setId(20);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.SKYBOXING);
    	session.save(schedule);
    	
    	schedule=scheduleList.get(20); 
    	schedule.setClassName("Challenge");
    	schedule.setDayOfWeek(6);
    	schedule.setTime(1930);
    	schedule.setId(21);
    	schedule.setDuration(60);
    	schedule.setClassType(ClassType.SKYBOXING);
    	session.save(schedule);
    	
    }

}

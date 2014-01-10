package com.athloneitf.datatypes;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.athloneitf.main.SessionFactoryUtil;

public class TestAITFMember {

	public static void main(String[] args) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		createMember(session);
		
		queryMember(session);
	}

    private static void queryMember(Session session) {
        Query query = session.createQuery("from AITFMember");                 
        List <AITFMember>list = query.list();
        java.util.Iterator<AITFMember> iter = list.iterator();
        while (iter.hasNext()) {

        	AITFMember person = iter.next();
            System.out.println(person.toString());

        }

        session.getTransaction().commit();

    }

    public static void createMember(Session session) {
    	AITFMember person = new AITFMember();

        person.setFirstName("Paul");
        person.setSurname("Fox");       
        person.setMemberCode(12345001);
        Calendar c=Calendar.getInstance();
        c.set(1980,2,12,0,0,0);
        person.setMemberDob(c.getTime());
        person.setInstructor(true);

        session.save(person);
    }
    
    
	
}

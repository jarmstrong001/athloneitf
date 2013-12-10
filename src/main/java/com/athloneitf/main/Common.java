package com.athloneitf.main;

import java.text.SimpleDateFormat;

import org.hibernate.Session;

public class Common {

	public static SimpleDateFormat dobDateFormat=new SimpleDateFormat("dd/MMM/yyyy");
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm dd/MMM/yyyy");
	
	public static void delay(int ms){
		try {
		    Thread.sleep(ms);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public static Session startSession(){
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return session;
	}
}

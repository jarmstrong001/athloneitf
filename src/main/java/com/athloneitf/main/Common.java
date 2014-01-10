package com.athloneitf.main;

import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;

import com.athloneitf.datatypes.*;

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
	
	public static AITFMember getLoggedInInstructor(){
		Session session=startSession();
		Query instructorLoggedInQuery = session.createQuery("FROM InstructorLogin "+
				"WHERE LogoutTime=NULL");
				List<InstructorLogin> instructor=instructorLoggedInQuery.list();
				System.out.println(instructor.size()+" records");
				session.getTransaction().commit();
				return Common.getMember(""+instructor.get(0).getMemberCode());		
	}
	
	public static AITFMember getMember(String barCode){
		AITFMember returnMember=null;
		Session session=startSession();
		Query memberQuery = session.createQuery("FROM AITFMember "+
				"WHERE MemberBarCode="+barCode);
				List<AITFMember> member=memberQuery.list();
				System.out.println(member.size()+" records");
				session.getTransaction().commit();
				if(member.size()>0) returnMember=member.get(0);
				return returnMember;		
	}
	
	public static void memberScanIn(AITFMember member){
		Session session=startSession();
		MemberScanIn scanIn=new MemberScanIn();
		scanIn.setMemberCode(member.getMemberCode());
		scanIn.setScanInTime(new Date());
		member.setScannedInStatus(true);
		session.update(member);
		session.save(scanIn);
		session.getTransaction().commit();
		
	}
	
	public static void memberScanOut(AITFMember member,boolean auto){
		Session session=startSession();
		MemberScanOut scanOut=new MemberScanOut();
		scanOut.setMemberCode(member.getMemberCode());
		scanOut.setScanOutTime(new Date());
		scanOut.setAutoScanOut(auto);
		member.setScannedInStatus(false);
		session.save(member);
		session.save(scanOut);
		session.getTransaction().commit();
	}
	
	public static void autoScanOut(){
		List<AITFMember> memberList; 
		Session session=startSession();
		Query memberQuery = session.createQuery("FROM AITFMember ");
		memberList=memberQuery.list();
		session.getTransaction().commit();
		for(AITFMember member:memberList){
			if(member.isScannedInStatus()) {
				autoScanOutMember(member);
			}
		}
		
	}
	
	public static void autoScanOutMember(AITFMember member){
		Session session=startSession();
		List<MemberScanIn> latest=session.createQuery("FROM MemberScanIn BY scanInTime DESC LIMIT 1").list();
		if(latest.size()>0){
			Calendar c= new GregorianCalendar();
			c.roll(Calendar.HOUR_OF_DAY,false);
			System.out.println("Time to compare with scan in:"+c.toString());
		if(latest.get(0).getScanInTime().compareTo(c.getTime())<0){
			memberScanOut(member,true);
		}
				
		}
		return;
	}
	
	public static boolean isMemberScannedIn(String barCode){
		autoScanOut();
		AITFMember member=getMember(barCode);
		return member.isScannedInStatus();		
	}
	
	public static String getDayOfWeek(int i){
		switch(i){
        case 1: return "Sunday"; 
        case 2: return "Monday"; 
        case 3: return "Tuesday"; 
        case 4: return "Wednesday";
        case 5: return "Thursday"; 
        case 6: return "Friday"; 
        case 7: return "Saturday"; 
        default: return ("Invalid Day Number");
    }
	}
	
	
}

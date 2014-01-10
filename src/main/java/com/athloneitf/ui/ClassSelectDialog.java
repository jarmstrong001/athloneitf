package com.athloneitf.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import org.hibernate.Session;

import com.athloneitf.datatypes.*;
import com.athloneitf.main.Common;

public class ClassSelectDialog extends JDialog {
	
	private static final long serialVersionUID = -705825594149403522L;
	private Session session=Common.startSession();
	private final JList classJList;
	private final JButton selectClassButton=new JButton("Select Class");
	private final JPanel panel=new JPanel();
	
	
	public ClassSelectDialog(AITFMember instructor) {
		
	final List<AITFSchedule> classList=session.createQuery("FROM AITFSchedule").list();
	session.getTransaction().commit();
	classJList=new JList(classList.toArray());
	panel.add(classJList);
	panel.add(selectClassButton);
	selectClassButton.addActionListener(new ActionListener()
			{
				private AITFClass thisClass=new AITFClass();
				public void actionPerformed(ActionEvent e){
					AITFSchedule scheduledClass=classList.get((classJList.getSelectedIndex()));
					thisClass.setClassDate(new Date());
					thisClass.setClassInstructor(Common.getLoggedInInstructor());
					thisClass.setClassType(scheduledClass.getClassType());
					thisClass.setAitfScheduleId(scheduledClass);
					session=Common.startSession();
					session.save(thisClass);
					session.getTransaction().commit();
					
					MemberCheckInInterface mcii=new MemberCheckInInterface(thisClass);
        			mcii.setVisible(true);
				}
			
			}
			);
	
	
	
	this.add(panel);
	this.setSize(400,500);
	this.setVisible(true);
	
	
			
	}
}

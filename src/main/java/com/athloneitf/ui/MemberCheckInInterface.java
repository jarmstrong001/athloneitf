/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.athloneitf.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.athloneitf.datatypes.*;
import com.athloneitf.main.Common;

public class MemberCheckInInterface extends JFrame {

	private static final long serialVersionUID = 6927324337756533205L;
	private AITFMember instructor;
	private final JLabel clock;
	private ActionListener updateClockAction = new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  clock.setText(new Date().toString()); 
		    }
      };
	
	public MemberCheckInInterface(AITFClass thisClass){
		instructor=Common.getLoggedInInstructor();
		setTitle("Athlone ITF - instructor "+instructor.getName());
		setSize(400,400);
		Timer t = new Timer(1000, updateClockAction);
		t.start();
		
				
		 final JPanel loginPanel = new JPanel();
	        final JLabel scanInLabel = new JLabel("Enter barcode to scan into class");
	        final JTextField scanInTextField = new JTextField(10);
	        final JLabel resultLabel = new JLabel("                ");
	        loginPanel.add(scanInLabel);
	        loginPanel.add(scanInTextField);
	        loginPanel.add(resultLabel);
	        add(loginPanel,BorderLayout.CENTER);
	        File file;
	        if(thisClass.getClassType()==ClassType.TAEKWONDO) file=new File("Taekwondo.png");
	        else file=new File("Skyboxing.jpg");
	        BufferedImage myPicture=null;
	        try {
				BufferedImage myOversizedPicture=ImageIO.read(file);
				myPicture=Common.resize(myOversizedPicture,300,200);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	        add(picLabel,BorderLayout.NORTH);
	        
	        clock= new JLabel(new Date().toString());
	        
	        add(clock,BorderLayout.SOUTH);
	        
		        
	        setVisible(true);
	        
	        scanInTextField.requestFocusInWindow();
	        scanInTextField.addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent event)
	        	{
	        		String memberBarCode=scanInTextField.getText();
	        		AITFMember member=Common.getMember(memberBarCode);
	        		if(member!=null) {
	        			System.out.println(member.toString());
	        			if(Common.isMemberScannedIn(""+member.getMemberCode())){
	        				Common.memberScanOut(member, false);
	        				resultLabel.setText(member.getName()+" scanned out of class at "+Common.timeFormat.format(new Date()));
	        			}
	        			else {	        				
	        				Common.memberScanIn(member);
	        				resultLabel.setText(member.getName()+" scanned into class at "+Common.timeFormat.format(new Date()));
	        			}
	        		}
	        		else {
	        			resultLabel.setText("No Member in database for barcode "+memberBarCode);
	        			
	        		}
	        		scanInTextField.setText("");
	        	}
	        	
	        	
	        });
	        
	      
		}
	
	
}


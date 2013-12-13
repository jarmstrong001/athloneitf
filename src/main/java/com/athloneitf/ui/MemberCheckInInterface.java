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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.athloneitf.datatypes.AITFClass;
import com.athloneitf.datatypes.AITFMember;
import com.athloneitf.main.Common;

public class MemberCheckInInterface extends JFrame {

	private static final long serialVersionUID = 6927324337756533205L;
	private AITFMember instructor;
	
	public MemberCheckInInterface(AITFClass thisClass){
		instructor=Common.getLoggedInInstructor();
		setTitle("Athlone ITF - instructor "+instructor.getName());
		setSize(400,400);
		
		 final JPanel loginPanel = new JPanel();
	        final JLabel scanInLabel = new JLabel("Enter barcode to scan into class");
	        final JTextField scanInTextField = new JTextField(10);
	        final JLabel resultLabel = new JLabel("                ");
	        loginPanel.add(scanInLabel);
	        loginPanel.add(scanInTextField);
	        loginPanel.add(resultLabel);
	        add(loginPanel);
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
	        				resultLabel.setText(member.getName()+" scanned out of class");
	        			}
	        			else {	        				
	        				Common.memberScanIn(member);
	        				resultLabel.setText(member.getName()+" scanned into class");
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


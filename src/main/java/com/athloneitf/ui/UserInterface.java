package com.athloneitf.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.athloneitf.database.DatabaseMySQL;
import com.athloneitf.datatypes.AITFMember;
import com.athloneitf.main.Common;

public class UserInterface extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static DatabaseMySQL database;

	static {
		database=new DatabaseMySQL();
		database.connectDataBase();
	}
		
	public UserInterface(){
		
        //make sure the program exits when the frame closes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Athlone ITF Instructor Login");
        setSize(300,250);
        
        final JPanel loginPanel = new JPanel();
        final JLabel loginLabel = new JLabel("Enter barcode to login");
        final JTextField loginTextField = new JTextField(10);
        final JLabel resultLabel = new JLabel("                ");
        loginPanel.add(loginLabel);
        loginPanel.add(loginTextField);
        loginPanel.add(resultLabel);
        add(loginPanel);
        setVisible(true);
        
        loginTextField.requestFocusInWindow();
        loginTextField.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent event)
        	{
        		AITFMember instructor=database.loginInstructor(loginTextField.getText());
        		if(instructor!=null) {
        			System.out.println(instructor.toString());
        			/*resultLabel.setVisible(false);
        			resultLabel.setText(instructor.getName()+" logging in");
        			resultLabel.setVisible(true);*/
        			MemberCheckInInterface mcii=new MemberCheckInInterface(instructor);
        			Common.delay(2000);
        			mcii.setVisible(true);
        			UserInterface.this.dispose();
        		}
        		else {
        			resultLabel.setText("Invalid Login");
        			loginTextField.setText("");
        		}
        		
        	}
        	
        	
        });
	}
	
	
	
}

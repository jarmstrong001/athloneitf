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

import javax.swing.JFrame;

import com.athloneitf.datatypes.AITFMember;

public class MemberCheckInInterface extends JFrame {

	public MemberCheckInInterface(AITFMember instructor){
		setTitle("Athlone ITF - instructor "+instructor.getName());
		setSize(400,400);
	}
}

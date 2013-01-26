/*
 * @author Rami Stefanidis
 * 
 **********************************************************************
 * This code and its derivatives belong to FDM Group PLC and may not be
 * copied,reproduced, amended or used in any way without permission
 * from FDM group PLC
 **********************************************************************
 * Current Version
 * ===============
 * Revision:  1.0
 * Date/time: 26/01/2013
 **********************************************************************
 */


package com.fdm.login.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisplayUtility {

	private BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	
	public void displayMessage(String line){
		
		
		System.out.print(line);
	}
	
	public String readFromKeyboard(){
		
		String returnValue = null;
		try{
			returnValue = read.readLine();
		}
		catch(IOException e){
			displayMessage("There has been an error reading, please try again or contact Systems administrator.\n");
			
		}
		return returnValue;
		
	}
	
	public void displayMessageAndWaitForEnter(String line){
	
		
		displayMessage(line);
		displayMessage("Press \'Enter\' to continue.\n");
		readFromKeyboard();

	}
	
	public void displayExit(){
		displayMessage("****************************************************************\n");
		displayMessage("GoodBye - Thank you for using FDM Trading Platform Application.\n");
		displayMessage("****************************************************************\n");
	}
}

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

package com.fdm.tradingplatform.adminModule.view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class DisplayUtility {
	
	private static Logger logger=Logger.getLogger("log");

	private BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	
	public void displayMessage(String line){
		logger.trace("Start displayMessage("+line+")");
		
		System.out.print(line);
		
		logger.trace("End displayMessage()");
	}
	
	public void displayWaitForEnter(){
	
		
		
		displayMessage("\nPress \'Enter\' to continue.\n");
		readFromKeyboard();
		
		logger.trace("End displayMessage()");
	}
	
	public String readFromKeyboard(){
		logger.trace("Start readFromKeyboard()");
		
		try{
			return read.readLine();
		}
		catch(IOException e){
			displayMessage("There has been an error reading, please try again or contact Systems administrator.\n");
			logger.error("there was an error reading from keyboard",e);
		}
		return null;
		
	}
	
	public void displayExit(){
		logger.trace("Start displayExit()");
		displayMessage("****************************************************************\n");
		displayMessage("GoodBye - Thank you for using FDM Trading Platform Application.\n");
		displayMessage("****************************************************************\n");
		
		logger.debug("show exit message");
	}
}

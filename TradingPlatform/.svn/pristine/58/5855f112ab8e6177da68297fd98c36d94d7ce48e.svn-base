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

import org.apache.log4j.Logger;

public class MainMenu extends Menu{
	private static Logger logger=Logger.getLogger("log");
	private final String choicesRegex="1|2|3|4|5|6|7|8|9|10|11|12";
	
	public MainMenu(DisplayUtility displayUtility){
		this.displayUtility=displayUtility;
		
		logger.debug("new MainMenu");
	}
	
	public int getUserInput(){
		logger.trace("Start getUserInput()");
		
		return checkInput(choicesRegex);
	}
		
	public String displayMenu(){
		logger.trace("Start display Menu");
		
		displayUtility.displayMessage("**********************************\n");
		displayUtility.displayMessage("    SYSTEMS ADMINISTRATOR MENU\n");
		displayUtility.displayMessage("**********************************\n");
		displayUtility.displayMessage("1. Add new User\n");
		displayUtility.displayMessage("2. Remove existing User\n");
		displayUtility.displayMessage("3. Ban existing User\n");
		displayUtility.displayMessage("4. Unban existing User\n");
		displayUtility.displayMessage("5. Update User Password\n");
		displayUtility.displayMessage("6. Update User Role\n");
		displayUtility.displayMessage("7. View outstanding user requests\n");
		displayUtility.displayMessage("8. View assigned user requests\n");
		displayUtility.displayMessage("9. View completed user requests\n");
		displayUtility.displayMessage("10. Assign a User Requests\n");
		displayUtility.displayMessage("11. Mark a User Requests as completed\n");
		displayUtility.displayMessage("12. Logout\n");
		displayUtility.displayMessage("Enter Choice:");
	
		
		return displayUtility.readFromKeyboard();
	}

}



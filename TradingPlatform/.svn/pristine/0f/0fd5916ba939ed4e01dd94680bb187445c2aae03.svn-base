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

public class UpdateUserDetails extends Menu{
	private static Logger logger = Logger.getLogger("log");
	private final String choicesRegex="[1|2]";
	private final int UPDATE_PASSWORD_OPTION=1;
	private final int UPDATE_ROLE_OPTION=2;
	
	public UpdateUserDetails(DisplayUtility displayUtility) {

		this.displayUtility = displayUtility;

		logger.debug("new UpdateUserDetails()");
	}

	public String displayMenu() {
		logger.trace("Start displayMenu()");

		this.displayUtility.displayMessage("***************************************************************\n");
		this.displayUtility.displayMessage("Update User Details. Please select an option from the menu.\n");
		this.displayUtility.displayMessage("***************************************************************\n");
		this.displayUtility.displayMessage("1. Update password\n");
		this.displayUtility.displayMessage("2. Update user Role permissions\n");
		this.displayUtility.displayMessage("Select number: ");
		return this.displayUtility.readFromKeyboard();
	}

	public UserInputVO getUserInput(UserInputVO userInputVO) {
		logger.trace("Start getUserInput()");

		userInputVO = new UserInputVO();

		int selectedChoice = checkInput(choicesRegex);
		userInputVO.setSecondLevelInputtype(selectedChoice);
		displayUtility.displayMessage("Please enter the user's username to update:");
		userInputVO.setUsername(displayUtility.readFromKeyboard());
		
		if (selectedChoice == UPDATE_PASSWORD_OPTION) {
			displayUtility.displayMessage("\nPlease enter the user's new password:");
			userInputVO.setPassword(displayUtility.readFromKeyboard());

		} else if (selectedChoice == UPDATE_ROLE_OPTION) {
			displayUtility.displayMessage("\nPlease enter the new role name the user will have:");
			userInputVO.setRoleName(displayUtility.readFromKeyboard());
		}

		logger.trace("end getUserInputVO");
		return userInputVO;
	}
}

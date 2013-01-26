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

public class AddUser {
	private static Logger logger = Logger.getLogger("log");

	private DisplayUtility displayUtility;

	public AddUser(DisplayUtility displayUtility) {

		this.displayUtility = displayUtility;
		logger.debug("new AddUser");
	}

	public UserInputVO getUserInput(UserInputVO userInputVO) {
		logger.trace("Start getUserInput()");

		displayUtility.displayMessage("****** ADD NEW USER ******\n");
		displayUtility.displayMessage("Please enter the new user's username:");
		userInputVO.setUsername(displayUtility.readFromKeyboard());

		displayUtility.displayMessage("Please enter the new user's password:");
		userInputVO.setPassword(displayUtility.readFromKeyboard());

		displayUtility.displayMessage("Please enter the new user's rolename associated with this account:");
		userInputVO.setRoleName(displayUtility.readFromKeyboard().toLowerCase());

		logger.trace("End getUserInput()");

		return userInputVO;
	}

}

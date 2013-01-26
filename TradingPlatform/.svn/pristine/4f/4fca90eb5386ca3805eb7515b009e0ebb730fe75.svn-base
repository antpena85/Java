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

public class RemoveUser {
	private static Logger logger = Logger.getLogger("log");

	private DisplayUtility displayUtility;

	public RemoveUser(DisplayUtility displayUtility) {
		this.displayUtility = displayUtility;
		logger.debug("new removeUser");
	}

	public UserInputVO getUserInput(UserInputVO userInputVO) {
		logger.trace("Start UserInputVO()");

		displayUtility.displayMessage("****** REMOVE EXISTING USER ******\n");
		displayUtility.displayMessage("Please enter the user's username:");
		userInputVO.setUsername(displayUtility.readFromKeyboard());

		return userInputVO;
	}
}

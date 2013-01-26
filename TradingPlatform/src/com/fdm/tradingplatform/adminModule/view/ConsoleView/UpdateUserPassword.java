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

public class UpdateUserPassword {
	
		private static Logger logger = Logger.getLogger("log");
		private DisplayUtility displayUtility;
				
		public UpdateUserPassword(DisplayUtility displayUtility) {

			this.displayUtility = displayUtility;

			logger.debug("new UpdateUserDetails()");
		}

		public UserInputVO getUserInput(UserInputVO userInputVO) {
			logger.trace("Start getUserInput()");

			displayUtility.displayMessage("Please enter the user's username to update:");
			userInputVO.setUsername(displayUtility.readFromKeyboard());
			displayUtility.displayMessage("\nPlease enter the user's new password:");
			userInputVO.setPassword(displayUtility.readFromKeyboard());

			logger.trace("end getUserInputVO");
			return userInputVO;
		}
}




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

public class BanUser {
	private static Logger logger = Logger.getLogger("log");

	private DisplayUtility displayUtility;

	public BanUser(DisplayUtility displayUtility) {

		this.displayUtility = displayUtility;
	}

	public UserInputVO getUserInput(UserInputVO userInputVO) {
		logger.trace("Start userInputVO()");

		displayUtility.displayMessage("****** Ban User ******\n");
		displayUtility.displayMessage("Please enter the user's username:");
		userInputVO.setUsername(displayUtility.readFromKeyboard());

		logger.debug("vo.setUserName=" + userInputVO.getUsername());

		logger.trace("end userInputVO()");
		return userInputVO;
	}

}

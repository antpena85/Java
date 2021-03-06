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

import com.fdm.tradingplatform.adminModule.view.ConsoleView.DisplayUtility;
import com.fdm.tradingplatform.model.UserVO;

public class LoginMenu {

	private DisplayUtility displayUtility;

	public LoginMenu(DisplayUtility displayUtility) {
		this.displayUtility = displayUtility;
	}

	public UserVO newLogin(){
		UserVO login = new UserVO();
	
			displayUtility.displayMessage("Username:");
			login.setUsername(displayUtility.readFromKeyboard());
		
			displayUtility.displayMessage("Password:");
			login.setPassword(displayUtility.readFromKeyboard());

		return login;

	}

}

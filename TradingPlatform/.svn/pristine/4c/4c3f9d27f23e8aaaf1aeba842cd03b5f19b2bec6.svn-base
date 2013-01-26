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

package com.fdm.login.controller;

import org.apache.log4j.Logger;
import com.fdm.login.model._LoginManager;
import com.fdm.login.view.iViewLogin;
import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.UserVO;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;

public class LoginController {
	private static Logger logger = Logger.getLogger("log");

	private iViewLogin displayManager;
	private _LoginManager loginManager;
	private LoginAction action;
	private UserClientToken userToken;
	private boolean isRunning;
	
	public LoginController(iViewLogin displayManager,_LoginManager loginManager){
		this.loginManager=loginManager;
		this.displayManager=displayManager;
	}

	public UserClientToken setup() {
		logger.trace("Start setup()");

		action = new AuthenticateAction();
		isRunning=true;
		runApp();
		return userToken;
	}

	public void runApp() {

		while (isRunning) {
			try {
				actionUserInput(displayManager.displayLoginFormAndGetInput());
			} catch (TradingPlatformException e) {
				displayManager.displayMessageAndWaitForEnter(e.getMessage() + '\n');
			} catch (Exception e){
				displayManager.displayMessageAndWaitForEnter(e.getMessage() + '\n');
			}
		}

	}

	public void actionUserInput(UserVO userInputAccount) {

		try {
			userToken = action.execute(userInputAccount, loginManager,displayManager);

		} catch (TradingPlatformException e) {
			displayManager.displayMessage(e.getMessage());
			userToken = null;
		} catch (Exception e){
			displayManager.displayMessage(e.getMessage());
		}

		if (userToken != null) {
			displayManager.displayMessage("User has successfully logged in");
			isRunning = false;
		}
	}

}

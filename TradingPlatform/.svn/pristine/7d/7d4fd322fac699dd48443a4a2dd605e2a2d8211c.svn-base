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


import com.fdm.tradingplatform.model.UserVO;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;

public class ConsoleViewLogin implements iViewLogin{

	private DisplayUtility displayUtility= new DisplayUtility();
	private LoginMenu loginMenu= new LoginMenu(this.displayUtility);
	private MainMenu mainMenu=new MainMenu(this.displayUtility);
	
	
	@Override
	public UserVO displayLoginFormAndGetInput() throws TradingPlatformException {
		
		return selectSubMenu(mainMenu.getUserInput());
		
	}
	
	private UserVO selectSubMenu(int choice) throws TradingPlatformException{
		
		UserVO userInputLogin = null;
		
		switch(choice){
		
			case 1:
				userInputLogin = loginMenu.newLogin();
				break;
			case 2:
				displayUtility.displayExit();
				System.exit(0);
		}
		
		return userInputLogin;
	}
		
	public void displayMessage(String message){
		
		displayUtility.displayMessage(message+'\n');
	}
	
	public void displayMessageAndWaitForEnter(String message){
	
		displayUtility.displayMessageAndWaitForEnter(message);
		
	}


}

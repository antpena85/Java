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

public abstract class Menu {
	
	protected DisplayUtility displayUtility;
	
	protected static Logger logger=Logger.getLogger("log");

	public int checkInput(String regex){
		logger.trace("checkInput()");
		
		
		boolean isIncorrect = true;
		String choiceSelected=null;
		while(isIncorrect){
			choiceSelected=displayMenu();
			logger.debug("selected choice="+choiceSelected+ "  regex="+regex);
			if(choiceSelected.matches(regex)){
				isIncorrect=false;
					logger.debug("isIncorrect="+false);
			}
			else{
				displayUtility.displayMessage("Invalid Choice - Please try again.\n");
			}
			
		}
			
			logger.trace("end checkInput(), choice="+choiceSelected);
		return Integer.parseInt(choiceSelected);
	}
	
	public abstract String displayMenu();
}

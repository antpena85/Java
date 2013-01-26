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

package com.fdm.tradingplatform.model;

import java.util.Properties;

import com.fdm.login.view.ConsoleViewLogin;
import com.fdm.login.view.iViewLogin;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.ConsoleView;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.iView;

public class ViewFactory {
	
	Properties properties = TradingPlatformProperties.getInstance();
	
	public iView getiView(){
		
		if(properties.getProperty("viewType").equals("CONSOLE"))
			return new ConsoleView();
			
		return null;
	}
	
	public iViewLogin getiViewLogin(){
		if(properties.getProperty("viewType").equals("CONSOLE"))
			return new ConsoleViewLogin();
			
		return null;
	}

}

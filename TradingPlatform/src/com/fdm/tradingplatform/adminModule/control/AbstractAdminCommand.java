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

package com.fdm.tradingplatform.adminModule.control;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.model.TradingPlatformProperties;

public abstract class AbstractAdminCommand {
	protected static Logger logger = Logger.getLogger("log");
	protected Properties properties = TradingPlatformProperties.getInstance();
	protected final String functionDescription;
	
	public AbstractAdminCommand(String functionDescription){
		this.functionDescription=functionDescription;
	}
		
	public String getFunctionDescription() {
		return functionDescription;
	}

}

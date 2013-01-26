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

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class UserServerToken {
	private static Logger logger=Logger.getLogger("log");
	
	private String username;
	private int hashCode;
	private Map<String,String> roles;
	private Properties properties = TradingPlatformProperties.getInstance();
	
	public UserServerToken(UserClientToken userClientToken,Map<String,String> roles){
		if(userClientToken==null)
			throw new NullPointerException(properties.getProperty("NULLPOINTER_ERROR_MESSAGE"));
		
		this.username=userClientToken.getUsername();
		this.hashCode=userClientToken.getHashCode();
		this.roles=roles;
		
		logger.debug("new userServerToken");
		
	}

	public String getUsername() {return username;}

	public void setUsername(String username) {
		if(username==null)
			throw new NullPointerException(properties.getProperty("NULLPOINTER_ERROR_MESSAGE"));
		if(username.length()<2)
			throw new IllegalArgumentException(properties.getProperty("ILLEAGAL_ARGUMENT_MESSAGE"));
		logger.trace("Start setUsername ("+username+")");
		
		this.username = username;
	}

	public int getHashCode() {return hashCode;}

	public void setHashCode(int hashCode) {
		logger.trace("Start setHashCode("+hashCode+")");
		if(hashCode==0)
			throw new IllegalArgumentException(properties.getProperty("ILLEAGAL_ARGUMENT_MESSAGE"));

		this.hashCode = hashCode;
	}

	public Map<String,String> getRoles() {return roles;}

	public void setRoles(Map<String,String> roles) {
		logger.trace("Start setRoles()");
		
		this.roles = roles;
	}
	
	public String getRole(String functionName){return roles.get(functionName);}
	
}
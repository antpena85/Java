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

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.model.storage.Databean;

public class UserVO implements Databean {
	private static Logger logger = Logger.getLogger("log");

	private String username;
	private String password;
	private String rolename;
	private String status;
	
	public UserVO() {
		logger.debug("new UserVO");
	}

	public UserVO(String username, String password) {
		if(username==null || password==null)
			throw new NullPointerException(System.getProperty("NULLPOINTER_ERROR_MESSAGE"));
		if(username.length() < 2 || password.length() < 2)
			throw new IllegalArgumentException(System.getProperty("ILLEAGAL_ARGUMENT_MESSAGE"));
		
		this.username = username;
		this.password = password;

		logger.debug("new userVO(" + username + "," + password + ")");
	}

	public UserVO(String username, String password, String rolename, String status) {
		if(username==null || password==null || rolename==null || status==null)
			throw new NullPointerException(System.getProperty("NULLPOINTER_ERROR_MESSAGE"));
		if(username.length() < 2 || password.length() < 2 || rolename.length() < 2 || status.length() < 2)
			throw new IllegalArgumentException(System.getProperty("ILLEAGAL_ARGUMENT_MESSAGE"));
		
		this.username = username;
		this.password = password;
		this.rolename = rolename;
		this.status = status;

		logger.debug("new userVo(" + username + "," + password + "," + rolename + "," + status + ")");
	}

	public UserVO(Map<String, String> fields) {

		this.username = (String) fields.get("username");
		this.password = (String) fields.get("password");
		this.rolename = (String) fields.get("rolename");
		this.status = (String) fields.get("status");
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		if(rolename==null)
			throw new NullPointerException(System.getProperty("NULLPOINTER_ERROR_MESSAGE"));
		if(rolename.length() < 2)
			throw new IllegalArgumentException(System.getProperty("ILLEAGAL_ARGUMENT_MESSAGE"));
		logger.trace("setrolename(" + rolename + ")");

		this.rolename = rolename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		logger.trace("setStatus(" + status + ")");
		if(status==null)
			throw new NullPointerException(System.getProperty("NULLPOINTER_ERROR_MESSAGE"));
		if(status.length() < 2)
			throw new IllegalArgumentException(System.getProperty("ILLEAGAL_ARGUMENT_MESSAGE"));

		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		logger.trace("setUsername(" + username + ")");
		if(username==null)
			throw new NullPointerException(System.getProperty("NULLPOINTER_ERROR_MESSAGE"));
		if(username.length() < 2)
			throw new IllegalArgumentException(System.getProperty("ILLEAGAL_ARGUMENT_MESSAGE"));
		
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		logger.trace("setPassword(" + password + ")");
		
		if(password==null)
			throw new NullPointerException(System.getProperty("NULLPOINTER_ERROR_MESSAGE"));
		if(password.length() < 2)
			throw new IllegalArgumentException(System.getProperty("ILLEAGAL_ARGUMENT_MESSAGE"));
		
		this.password = password;
	}

	public String getAttribute(String attribute) {
		logger.trace("getAttribute(" + attribute + ")");

		if (attribute.equals("username"))
			return username;
		else if (attribute.equals("password"))
			return password;
		else if (attribute.equals("rolename"))
			return rolename;
		else if (attribute.equals("status"))
			return status;
		else
			return null;
	}
}

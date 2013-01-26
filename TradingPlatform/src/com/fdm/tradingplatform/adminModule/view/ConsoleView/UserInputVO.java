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

public class UserInputVO {
	private static Logger logger=Logger.getLogger("log");
	
	private String username;
	private String password;
	private String status;
	private String roleName;
	private int inputType;
	private int secondLevelInputtype;
	
	
	public String getUsername() {
			logger.trace("getUsername="+username);
		return username;
	}
	public void setUsername(String username) {
			logger.trace("setUsername="+username);
		this.username = username;
	}
	public String getPassword() {
			logger.trace("getpassword="+password);
		return password;
	}
	public void setPassword(String password) {
			logger.trace("getPassword="+password);
		this.password = password;
	}
	public String getStatus() {
			logger.trace("getStatus="+status);
		return status;
	}
	public void setStatus(String status) {
			logger.trace("setStatus="+status);
		this.status = status;
	}
	public String getRoleName() {
			logger.trace("getroleName="+roleName);
		return roleName;
	}
	public void setRoleName(String roleName) {
			logger.trace("setroleName="+roleName);
		this.roleName = roleName;
	}
	public int getInputType() {
			logger.trace("getInputType="+inputType);

		return inputType;
	}
	public void setInputType(int inputType) {
			logger.trace("setInputType="+roleName);
		this.inputType = inputType;
	}
	public int getSecondLevelInputtype() {
		return secondLevelInputtype;
	}
	public void setSecondLevelInputtype(int secondLevelInputtype) {
		this.secondLevelInputtype = secondLevelInputtype;
	}
	
	
}

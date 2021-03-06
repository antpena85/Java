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

package com.fdm.tradingplatform.adminModule.model;

import java.util.Map;

import org.apache.log4j.Logger;

import utility.Utility;

import com.fdm.tradingplatform.model.exception.TradingPlatformException;
import com.fdm.tradingplatform.model.storage.Databean;
import com.fdm.tradingplatform.model.storage.iDao;

public class Validator {
	private static Logger logger = Logger.getLogger("log");
	


	public Validator() {

	}

	public boolean username(String username,int usernamePolicyMinSize, int usernamePolicyMaxSize , String usernamePolicyRegex) {
		if (!Utility.checkLength(username, usernamePolicyMinSize, usernamePolicyMaxSize) || !username.matches(usernamePolicyRegex)) {
			logger.error("Failed username test:"+username);
			return false;
		} else{
			logger.info("Passed username test:"+username);
			return true;
		}
	}

	public boolean password(String password, int passwordPolicyMinSize,int passwordPolicyMaxSize ) {
		if (!Utility.checkLength(password, passwordPolicyMinSize, passwordPolicyMaxSize) || !Utility.hasUpperCase(password) || !Utility.hasNumber(password)) {
			logger.error("Failed password test:"+password);
			return false;
		} else{
			logger.info("Passed password test:"+password);
			return true;
		}
	}

	public boolean rolename(String rolename, int rolenamePolicyMinSize, int rolenamePolicyMaxSize, iDao roleDao ) {

		if (!Utility.checkLength(rolename, rolenamePolicyMinSize, rolenamePolicyMaxSize)) {
			logger.error("Failed rolename test:"+rolename);
			return false;
		}

		Map<String, Databean> roles = getRoles(roleDao);

		if (roles.get(rolename) == null) {
			logger.error("Failed rolename test:"+rolename);
			return false;
		}
		else{
			logger.error("Failed rolename test:"+rolename);
			return true;
		}
	}

	private Map<String, Databean> getRoles(iDao roleDao) {
		logger.info("Attempt to get Roles:");
		try {
			return roleDao.selectAll();
		} catch (TradingPlatformException e) {
			logger.error("Failed to get Roles.");
			throw new RuntimeException(System.getProperty("RUNTIME_ERROR_MESSAGE"));
		}

	}
}

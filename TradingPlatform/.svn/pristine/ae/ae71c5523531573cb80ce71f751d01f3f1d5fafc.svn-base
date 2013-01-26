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
import java.util.Properties;

import org.apache.log4j.Logger;

import utility.Utility;

import com.fdm.tradingplatform.model.TradingPlatformProperties;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;
import com.fdm.tradingplatform.model.storage.Databean;
import com.fdm.tradingplatform.model.storage.iDao;

public class Validator {
	private static Logger logger = Logger.getLogger("log");
	private Properties properties=TradingPlatformProperties.getInstance();;
	private int usernamePolicyMinSize;
	private int usernamePolicyMaxSize;
	private int passwordPolicyMinSize;
	private int passwordPolicyMaxSize;
	private int rolenamePolicyMinSize;
	private int rolenamePolicyMaxSize;
	private String usernamePolicyRegex;
	private iDao roleDao;
	

	public Validator(iDao roleDao) {
		usernamePolicyMinSize = Integer.parseInt(properties.getProperty("UsernamePolicyMinSize"));
		usernamePolicyMaxSize = Integer.parseInt(properties.getProperty("UsernamePolicyMaxSize"));
		passwordPolicyMinSize = Integer.parseInt(properties.getProperty("PasswordPolicyMinSize"));
		passwordPolicyMaxSize = Integer.parseInt(properties.getProperty("PasswordPolicyMaxSize"));
		rolenamePolicyMinSize = Integer.parseInt(properties.getProperty("RolenamePolicyMinSize"));
		rolenamePolicyMaxSize = Integer.parseInt(properties.getProperty("RolenamePolicyMaxSize"));
		usernamePolicyRegex = properties.getProperty("UsernamePolicyRegex");
		this.roleDao=roleDao;
	}

	public boolean username(String username) {
		if (!Utility.checkLength(username, usernamePolicyMinSize, usernamePolicyMaxSize) || !username.matches(usernamePolicyRegex)) {
			logger.error("Failed username test:"+username);
			return false;
		} else{
			logger.info("Passed username test:"+username);
			return true;
		}
	}

	public boolean password(String password) {
		if (!Utility.checkLength(password, passwordPolicyMinSize, passwordPolicyMaxSize) || !Utility.hasUpperCase(password) || !Utility.hasNumber(password)) {
			logger.error("Failed password test:"+password);
			return false;
		} else{
			logger.info("Passed password test:"+password);
			return true;
		}
	}

	public boolean rolename(String rolename) {

		if (!Utility.checkLength(rolename, rolenamePolicyMinSize, rolenamePolicyMaxSize)) {
			logger.error("Failed rolename test:"+rolename);
			return false;
		}

		Map<String, Databean> roles = getRoles();

		if (roles.get(rolename) == null) {
			logger.error("Failed rolename test:"+rolename);
			return false;
		}
		else{
			logger.error("Failed rolename test:"+rolename);
			return true;
		}
	}

	private Map<String, Databean> getRoles() {
		logger.info("Attempt to get Roles:");
		try {
			return roleDao.selectAll();
		} catch (TradingPlatformException e) {
			logger.error("Failed to get Roles.");
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		}

	}
}

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

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.model.exception.TradingPlatformException;
import com.fdm.tradingplatform.model.storage.iDao;

public class UserLoginMap {

	private static Logger logger = Logger.getLogger("log");

	private Map<String, UserServerToken> loggedinUsers;
	private static UserLoginMap firstInstance;
	private UserVO user;
	private RoleVO userRole;

	private UserLoginMap() {

		loggedinUsers = new HashMap<String, UserServerToken>();


		logger.debug("new UserLoginMap");
	}

	public static UserLoginMap getInstance() {
		logger.trace("Start getInstance()");

		if (firstInstance == null)
			firstInstance = new UserLoginMap();

		return firstInstance;
	}

	public UserServerToken getUserServerToken(String username) {
		return loggedinUsers.get(username);
	}

	public void removeUserFromLoginMap(UserClientToken userClientToken) {
		logger.trace("removeUserFromLoginMap(" + userClientToken.getUsername() + ")");

		loggedinUsers.remove(userClientToken.getUsername());
	}

	public void addUserToLoginMap(UserClientToken userClientToken, iDao userDao,iDao roleDao) throws TradingPlatformException {
		logger.trace("Start addUserToLoginMap" + userClientToken.getUsername());
		
		user = (UserVO) userDao.select(userClientToken.getUsername());
		userRole = (RoleVO) roleDao.select(user.getRolename());

		loggedinUsers.put(userClientToken.getUsername(), new UserServerToken(userClientToken, userRole.getRoles()));

		logger.info("User:" + userClientToken.getUsername() + " has logged in.");
	}

}

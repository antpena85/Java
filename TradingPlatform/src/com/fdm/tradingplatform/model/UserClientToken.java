package com.fdm.tradingplatform.model;

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.model.exception.TradingPlatformException;
import com.fdm.tradingplatform.model.storage.iDao;

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

public class UserClientToken {
	private static Logger logger = Logger.getLogger("log");

	private String username;
	private int hashCode;
	private UserLoginMap userLoginMap = UserLoginMap.getInstance();

	public UserClientToken(String username, iDao userDao, iDao roleDao) throws TradingPlatformException {

		this.username = username;
		String hashToken = (username + String.valueOf(System.currentTimeMillis()));

		this.hashCode = hashToken.hashCode();

		userLoginMap.addUserToLoginMap(this, userDao,roleDao);
		logger.debug("created usertoken client token for:" + username);
	}

	public String getUsername() {
		logger.trace("getUserName()=" + username);
		return username;
	}

	public int getHashCode() {
		logger.trace("getHashCode()=" + hashCode);
		return hashCode;
	}

}

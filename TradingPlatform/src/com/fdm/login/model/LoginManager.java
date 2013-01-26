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

package com.fdm.login.model;

import java.util.Properties;

import com.fdm.tradingplatform.model.TradingPlatformProperties;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;
import com.fdm.tradingplatform.model.storage.iDao;
import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.UserVO;

public class LoginManager implements _LoginManager {

	private iDao userDao;
	private iDao roleDao;

	public LoginManager(iDao userDao,iDao roleDao) {
		this.userDao=userDao;
		this.roleDao=roleDao;
	}

	@Override
	public UserClientToken authenticator(UserVO userInput, UserVO userStoredAccount)throws TradingPlatformException {
		
		Properties properties = TradingPlatformProperties.getInstance();
		
		if (userStoredAccount == null || userInput.getPassword() == null || (!userInput.getPassword().equals(userStoredAccount.getPassword())))
			throw new TradingPlatformException(properties.getProperty("USERNAME_OR_PASSWORD_ERROR_MESSAGE"));
		
		if (userStoredAccount.getStatus().equals("inActive"))
			throw new TradingPlatformException(properties.getProperty("USER_IS_BANNED_MESSAGE"));
		
		return new UserClientToken(userInput.getUsername(), userDao,roleDao);
	
	}


	public UserVO getUserAccount(String username)throws TradingPlatformException {
		
		return (UserVO) userDao.select(username);
	}

}

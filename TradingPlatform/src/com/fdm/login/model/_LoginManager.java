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



import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.UserVO;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;

public interface _LoginManager {

	public UserClientToken authenticator(UserVO userInputAccount, UserVO userStoredAccount)throws TradingPlatformException;
	
	public UserVO getUserAccount(String username) throws TradingPlatformException;
}

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

package com.fdm.login.controller;

import com.fdm.login.model.LoginManager;
import com.fdm.login.view.iViewLogin;
import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.UserVO;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;

public interface iLoginCommand {

	public UserClientToken execute(UserVO userInputAccount,	LoginManager loginManager, iViewLogin displayManager)	throws TradingPlatformException;

}

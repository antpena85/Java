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

package com.fdm.tradingplatform.adminModule.control;

import com.fdm.tradingplatform.adminModule.model.AdminManager;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.UserInputVO;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.iView;
import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;

public interface iAdminCommand {

	public void execute(UserClientToken userClientToken, UserInputVO userInputVO, AdminManager adminManager, iView displayManager) throws TradingPlatformException;
	public String getFunctionDescription();
}

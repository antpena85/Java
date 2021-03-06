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

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.adminModule.model.AdminManager;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.UserInputVO;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.iView;
import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;

public class BanUserAction extends AbstractAdminCommand implements iAdminCommand {
	public BanUserAction() {
		super(System.getProperty("BAN_USER"));
	}
	private static Logger logger = Logger.getLogger("log");

	@Override
	public void execute(UserClientToken userClientToken, UserInputVO userInputVO, AdminManager adminManager, iView displayManager) throws TradingPlatformException {
		logger.trace("Start execute");

			adminManager.banUser(userInputVO);
			displayManager.displayMessage("\n" + userInputVO.getUsername() + System.getProperty("BAN_USER_SUCCESS"));
		

		logger.info(userClientToken.getUsername() + " has banned " + userInputVO.getUsername());
		logger.trace("End execute");
	}

}

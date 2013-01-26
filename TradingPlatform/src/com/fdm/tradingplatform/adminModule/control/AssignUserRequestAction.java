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

import java.util.Map;

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.adminModule.model.AdminManager;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.UserInputVO;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.iView;
import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;
import com.fdm.tradingplatform.model.storage.Databean;

public class AssignUserRequestAction extends AbstractAdminCommand implements iAdminCommand {

	public AssignUserRequestAction() {
		super("assignUserRequest");
		
	}
	private static Logger logger = Logger.getLogger("log");
	
	@Override
	public void execute(UserClientToken userClientToken, UserInputVO userInputVO, AdminManager adminManager, iView displayManager) throws TradingPlatformException {
		logger.trace("Start execute");

		Map<String, Databean> userRequests = adminManager.getUserRequests("new");

		if (!userRequests.isEmpty()) {
			String requestNumber = displayManager.checkInput(displayManager.formatRequestsToDisplay(userRequests));
			adminManager.ChangeUserRequestStatus(requestNumber, userClientToken.getUsername(), "accepted");
			displayManager.displayMessage("User request Number:" + requestNumber + "  has been assigned to " + userClientToken.getUsername());
		} else
			displayManager.displayMessage(properties.getProperty("NO_MORE_REQUESTS"));

		logger.trace("End execute");

	}





}

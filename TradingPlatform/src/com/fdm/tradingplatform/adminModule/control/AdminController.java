package com.fdm.tradingplatform.adminModule.control;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.adminModule.model.AdminManager;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.UserInputVO;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.iView;

import com.fdm.tradingplatform.model.Selected;
import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;

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

public class AdminController {
	private static Logger logger = Logger.getLogger("log");
	private iView displayManager;
	private AdminManager adminManager;
	private boolean isRunning;
	private Helper helper;
	private UserClientToken userClientToken;
	private UserInputVO userInputVO;
	private iAdminCommand action;
	private Map<Integer, iAdminCommand> command;
	private enum Menu {
		ADD_USER(1), 
		REMOVE_USER(2), 
		BAN_USER(3), 
		UNBAN_USER(4), 
		UPDATE_USER_PASSWORD(5), 
		UPDATE_USER_ROLE(6),
		VIEW_OUTSTANDING_REQUESTS(7), 
		VIEW_ASSIGNED_REQUESTS(8), 
		VIEW_COMPLETED_REQUESTS(9), 
		ASSIGN_USER_REQUEST(10), 
		MARK_AS_COMPLETE(11), 
		LOGOUT(12);
		private final int optionValue;

		Menu(int optionValue) {
			this.optionValue = optionValue;
		}

		public int option() {
			return optionValue;
		}
	}

	public AdminController(UserClientToken userClientToken, iView viewManager, AdminManager adminManager) {
		this.userClientToken = userClientToken;
		this.displayManager = viewManager;
		this.adminManager = adminManager;
		logger.trace("new AdminController");
	}

	public void setup() {
		logger.trace("Start setup()");
		this.helper = new Helper(this.displayManager);

		loadCommandMap();

		if (helper.checkPermission(userClientToken, "adminScreen")) {
			this.isRunning = true;
			run();
		} else
			this.isRunning = false;

		logger.trace("End startup()");
	}

	public void run() {
		logger.trace("start run()");

		while (this.isRunning) {
			userInputVO = displayManager.displayMenuAndgetInput();
			this.action = command.get(Integer.valueOf(userInputVO.getInputType()));

			if (helper.checkPermission(userClientToken, action.getFunctionDescription()))
				
			actionUserInput(userInputVO);
		}

		logger.trace("End run()");
	}

	private void actionUserInput(UserInputVO userInputVO) {
		logger.trace("Start actionUserInput() with option:" + userInputVO.getInputType());

		if (userInputVO.getInputType() == Menu.LOGOUT.option()) {
			this.isRunning = false;
		}

		try {
			action.execute(userClientToken, userInputVO, adminManager, displayManager);
		} catch (TradingPlatformException e) {
			displayManager.displayMessage(e.getMessage());
		} catch (Exception e) {
			displayManager.displayMessage(e.getMessage());
		}

		logger.trace("End actionUserInput(), isRunning=" + isRunning);
	}

	private void loadCommandMap() {

		command = new HashMap<Integer, iAdminCommand>();
		command.put(Selected.Option.ADD_USER.option(), new AddUserAction());
		command.put(Selected.Option.REMOVE_USER.option(), new RemoveUserAction());
		command.put(Selected.Option.BAN_USER.option(), new BanUserAction());
		command.put(Selected.Option.UNBAN_USER.option(), new UnBanUserAction());
		command.put(Selected.Option.UPDATE_USER_PASSWORD.option(), new UpdateUserPasswordAction());
		command.put(Selected.Option.UPDATE_USER_ROLE.option(), new UpdateUserRoleAction());
		command.put(Selected.Option.VIEW_OUTSTANDING_REQUESTS.option(), new ViewOutstandingUserRequestsAction());
		command.put(Selected.Option.VIEW_ASSIGNED_REQUESTS.option(), new ViewAssignedUserRequestsAction());
		command.put(Selected.Option.VIEW_COMPLETED_REQUESTS.option(), new ViewCompletedUserRequestsAction());
		command.put(Selected.Option.ASSIGN_USER_REQUEST.option(), new AssignUserRequestAction());
		command.put(Selected.Option.MARK_AS_COMPLETE.option(), new MarkAsCompleteUserRequestAction());
		command.put(Selected.Option.LOGOUT.option(), new LogoutUserAction());

	}

}

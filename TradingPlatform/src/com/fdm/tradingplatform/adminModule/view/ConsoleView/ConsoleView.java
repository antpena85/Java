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

package com.fdm.tradingplatform.adminModule.view.ConsoleView;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.model.Selected;
import com.fdm.tradingplatform.model.Selected.Option;
import com.fdm.tradingplatform.model.UserRequestVO;
import com.fdm.tradingplatform.model.storage.Databean;


public class ConsoleView implements iView {
	private static Logger logger = Logger.getLogger("log");
	private DisplayUtility utility;
	private MainMenu mainMenu;
	private AddUser addUser;
	private RemoveUser removeUser;
	private BanUser banUser;
	private UnBanUser unBanUser;
	private UpdateUserPassword updateUserPassword;
	private UpdateUserRole updateUserRole;
	
	public ConsoleView(){
		utility = new DisplayUtility();
		mainMenu = new MainMenu(this.utility);
		addUser = new AddUser(this.utility);
		removeUser = new RemoveUser(this.utility);
		banUser = new BanUser(this.utility);
		unBanUser = new UnBanUser(this.utility);
		updateUserPassword = new UpdateUserPassword(this.utility);
		updateUserRole= new UpdateUserRole(this.utility);
	}
	public UserInputVO displayMenuAndgetInput() {
		logger.trace("start displayMenuAndGetInput()");

		return (selectSubMenu(mainMenu.getUserInput()));
	}

	public String checkInput(String regex) {

		boolean isIncorrect = true;

		String choice = null;
		while (isIncorrect) {
			utility.displayMessage("Select a choice:");
			choice = utility.readFromKeyboard();
			logger.debug("choice=" + choice);
			if (choice.matches(regex) && choice.length() > 0) {
				isIncorrect = false;
				logger.debug("isIncorrect=" + false);
			} else {
				utility.displayMessage("Invalid Choice - Please try again.\n");
			}
		}

		return choice;
	}

	private UserInputVO selectSubMenu(int choiceSelected) {
		logger.trace("Start SelectSubMenu(" + choiceSelected + ")");
		
		UserInputVO userInputVO = new UserInputVO();
		Option optionSelected = Selected.Option.lookUp(choiceSelected);
		
		switch (optionSelected) {

		case ADD_USER:
			userInputVO = addUser.getUserInput(userInputVO);
			logger.debug("vo assigned from choice 1");
			break;
		case REMOVE_USER:
			userInputVO = removeUser.getUserInput(userInputVO);
			logger.debug("vo assigned from choice 2");
			break;
		case BAN_USER:
			userInputVO = banUser.getUserInput(userInputVO);
			logger.debug("vo assigned from choice 3");
			break;
		case UNBAN_USER:
			userInputVO = unBanUser.getUserInput(userInputVO);
			logger.debug("vo assigned from choice 4");
			break;
		case UPDATE_USER_PASSWORD:
			userInputVO = updateUserPassword.getUserInput(userInputVO);
			logger.debug("vo assigned from choice 5");
			break;
		case UPDATE_USER_ROLE:
			userInputVO = updateUserRole.getUserInput(userInputVO);
			logger.debug("vo assigned from choice 6");
			break;
		case VIEW_OUTSTANDING_REQUESTS:
			//No input needed
			logger.debug("vo assigned from choice 7");
			break;
		case VIEW_ASSIGNED_REQUESTS:
			//No input needed
			logger.debug("vo assigned from choice 8");
			break;
		case VIEW_COMPLETED_REQUESTS:
			//No input needed
			logger.debug("vo assigned from choice 9");
			break;
		case ASSIGN_USER_REQUEST:
			//No input needed
			logger.debug("vo assigned from choice 10");
			break;
		case MARK_AS_COMPLETE:
			logger.debug("vo assigned from choice 11");
			break;
		case LOGOUT:
			logger.debug("vo assigned from choice 11");
			break;
		}
		
		userInputVO.setInputType(choiceSelected);
		logger.debug("vo.SetInputType=" + userInputVO.getInputType());
		return userInputVO;

	}

	public void displayMessage(String message) {
		logger.trace("Start displayMessage(" + message + ")");

		utility.displayMessage(message);
		utility.displayWaitForEnter();
	}

	public String formatRequestsToDisplay(Map<String, Databean> userRequests) {
		StringBuffer requestPackageForDisplay = new StringBuffer();
		StringBuffer requestsNumberRegex = new StringBuffer();

		UserRequestVO userRequestVO;

		for(String key : userRequests.keySet()){
			userRequestVO = (UserRequestVO) userRequests.get(key);
			
			requestsNumberRegex.append(userRequestVO.getAttribute("requestNumber"));
			requestsNumberRegex.append("|");
			
			requestPackageForDisplay.append("\n\n");
			requestPackageForDisplay.append("Request Number: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("requestNumber"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Administrator: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("administrator"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Request Title: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("requestTitle"));
			requestPackageForDisplay.append('\n');
			requestPackageForDisplay.append("Requestor: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("requestor"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Username: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("username"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Password: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("password"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Rolename: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("rolename"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Status: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("status"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Date Registerd: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("date-registered"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Date Updated: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("date-updated"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Date Completed: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("date-completed"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("Additional Info: ");
			requestPackageForDisplay.append(userRequestVO.getAttribute("additionalInfo"));
			requestPackageForDisplay.append("\n");
			requestPackageForDisplay.append("==============================\n");
		}
		displayMessage(requestPackageForDisplay.toString());
		return requestsNumberRegex.toString();
	}


}

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

package com.fdm.login.view;

public class MainMenu {

	private DisplayUtility displayUtility;

	public MainMenu(DisplayUtility displayUtility) {
		this.displayUtility = displayUtility;
	}

	public int getUserInput() {

		return checkInput();
	}

	private int checkInput() {
		String choiceSelected=null;
		boolean isIncorrect = true;

		while (isIncorrect) {
			choiceSelected = displayMenu();
			if (choiceSelected.matches("[1-2]")) {
				isIncorrect = false;
			} else {
				displayUtility.displayMessage("Invalid Choice - Please try again.\n");
			}
		}
		return Integer.parseInt(choiceSelected);
	}

	private String displayMenu() {

		displayUtility.displayMessage("**********************************\n");
		displayUtility.displayMessage("FDM TRADING PLATFORM APPLICATION\n");
		displayUtility.displayMessage("**********************************\n");
		displayUtility.displayMessage("1. Login\n");
		displayUtility.displayMessage("2. Exit\n");
		displayUtility.displayMessage("Enter Choice:");
		return displayUtility.readFromKeyboard();
	}

}

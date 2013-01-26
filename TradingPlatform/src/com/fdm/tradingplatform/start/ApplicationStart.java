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

package com.fdm.tradingplatform.start;


import com.fdm.login.controller.LoginController;
import com.fdm.login.model.LoginManager;
import com.fdm.login.view.iViewLogin;
import com.fdm.tradingplatform.adminModule.control.AdminController;
import com.fdm.tradingplatform.adminModule.model.AdminManager;
import com.fdm.tradingplatform.adminModule.model.Validator;
import com.fdm.tradingplatform.adminModule.view.ConsoleView.iView;
import com.fdm.tradingplatform.model.Context;
import com.fdm.tradingplatform.model.DaoFactory;
import com.fdm.tradingplatform.model.UserClientToken;
import com.fdm.tradingplatform.model.ViewFactory;
import com.fdm.tradingplatform.model.storage.iDao;



public class ApplicationStart {


	
	public static void main(String[] args){
		Context context = Context.getInstance();
		DaoFactory daoFactory = new DaoFactory(context);
		ViewFactory viewFactory = new ViewFactory();
		iDao userDao=(iDao) daoFactory.getInstance(DaoFactory.TypeOfInstance.USER);
		iDao userRequestDao = (iDao) daoFactory.getInstance(DaoFactory.TypeOfInstance.REQUEST);
		iDao roleDao = (iDao) daoFactory.getInstance(DaoFactory.TypeOfInstance.ROLE);
		iView consoleView = viewFactory.getiView();
		iViewLogin consoleViewLogin = viewFactory.getiViewLogin();
		Validator validator = new Validator(roleDao);
		
		LoginManager loginManager = new LoginManager(userDao,roleDao);
		AdminManager adminManager = new AdminManager(validator,userDao,userRequestDao);
		UserClientToken userToken=null;

		try{
			LoginController loginController = new LoginController(consoleViewLogin,loginManager);
			userToken=loginController.setup();
		
			AdminController adminController = new AdminController(userToken,consoleView,adminManager);
			adminController.setup();
		}finally{
			context.cleanUp();
		}
		
		

		
	}

}

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

package com.fdm.tradingplatform.model;

import java.util.Map;

import com.fdm.tradingplatform.model.exception.TradingPlatformException;
import com.fdm.tradingplatform.model.storage.Databean;
import com.fdm.tradingplatform.model.storage.iDao;

public class TPMessage {
	static Context context = Context.getInstance();
	private static DaoFactory daoFactory = new DaoFactory(context);


	public static final String AVAILIABLE_ROLES = getAvailiableRolesMessage(getRoles());

	private static String getAvailiableRolesMessage(Map<String, Databean> roles) {
		StringBuffer rolenameMessage = new StringBuffer();
		int counter = 0;

		rolenameMessage.append("\nThe role does not exist, please try one of the following:\n\n");

		for(String key : roles.keySet()){
			RoleVO roleVO = (RoleVO) roles.get(key);
			rolenameMessage.append(++counter);
			rolenameMessage.append(".");
			rolenameMessage.append(roleVO.getName());
			rolenameMessage.append("\n");
		}
		return rolenameMessage.toString();
	}

	
	
	private static Map<String, Databean> getRoles() {

		iDao roleDao = daoFactory.getInstance(DaoFactory.TypeOfInstance.ROLE);
		try {
			return  roleDao.selectAll();
		} catch (TradingPlatformException e) {
			throw new RuntimeException(System.getProperty("RUNTIME_ERROR_MESSAGE"));
		}
	}
}

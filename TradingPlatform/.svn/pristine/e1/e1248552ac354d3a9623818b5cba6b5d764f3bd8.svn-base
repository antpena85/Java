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

import java.util.HashMap;
import java.util.Map;

public class XmlConnectionPool implements iConnectionPool {

	Map<String, String> filePaths;

	public XmlConnectionPool(Map<String, String> filePaths) {

		this.filePaths = new HashMap<String, String>(filePaths);
	}

	public String getConnection(String key) {

		return filePaths.get(key);
	}

}

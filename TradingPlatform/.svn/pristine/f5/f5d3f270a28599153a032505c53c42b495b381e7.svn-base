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

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import com.fdm.tradingplatform.model.TradingPlatformProperties;

public class Context {

	private Map<String, Object> context;
	private Properties properties;
	private static Context firstInstance = null;
	private int CONNECTION_POOL_SIZE = 5;
	private Vector<Connection> connectionPool;
	private DatabaseConnectionFactory dbConnectionFactory;

	private Context() {
		this.properties = TradingPlatformProperties.getInstance();
		context = new HashMap<String, Object>();
		connectionPool = new Vector<Connection>();
		dbConnectionFactory = new DatabaseConnectionFactory();
		

		if (properties.getProperty("storageMedium").equals("XML"))
			loadXmlEnviornmentVariables();
		else if (properties.getProperty("storageMedium").equals("DATABASE"))
			loadDatabaseEnviornmentVariables();

	}

	public static Context getInstance() {

		if (firstInstance == null)
			firstInstance = new Context();

		return firstInstance;
	}

	public Object getName(String name) {

		return context.get(name);
	}
	
	private void loadXmlEnviornmentVariables() {
		Map<String, String> filePathsMap = new HashMap<String, String>();

		filePathsMap.put("USER", properties.getProperty("userXmlDaoFilePath"));
		filePathsMap.put("ROLE", properties.getProperty("roleXmlDaoFilePath"));
		filePathsMap.put("REQUEST", properties.getProperty("userRequestXmlDaoFilePath"));

		context.put("CONNECTION_POOL", new XmlConnectionPool(filePathsMap));

	}

	private void loadDatabaseEnviornmentVariables() {

		for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
			connectionPool.addElement(dbConnectionFactory.makeNewConnection());

		}

		context.put("CONNECTION_POOL", new DatabaseConnectionPool(connectionPool));
	}

	private void closeDatabaseConnections() {
		for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
			Connection connection = connectionPool.elementAt(i);
			try {
				connection.close();
			} catch (SQLException e) {

			}

		}
	}

	public void cleanUp() {

		if (properties.getProperty("storageMedium").equals("XML")) {

		} else if (properties.getProperty("storageMedium").equals("DATABASE")) {
			closeDatabaseConnections();
		}
	}

}

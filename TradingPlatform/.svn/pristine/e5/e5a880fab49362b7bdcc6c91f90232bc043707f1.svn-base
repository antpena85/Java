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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionFactory {

	private String databaseUrl;
	private String userName;
	private String password;
	private Properties properties;
	private static boolean isDatabaseDriverLoaded = false;

	public Connection makeNewConnection() {

		properties = TradingPlatformProperties.getInstance();

		if (properties.getProperty("Database").equals("oracle")) {
			databaseUrl = properties.getProperty("OracleDataBaseUrl");
			userName = properties.getProperty("OracleUsername");
			password = properties.getProperty("OraclePassword");

			if (!isDatabaseDriverLoaded) {
				loadDatabaseDriver(properties.getProperty("OracleClassForName"));
			}
		}

		return createNewConnection();
	}

	private void loadDatabaseDriver(String databaseDriver) {

		try {
			Class.forName(databaseDriver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		}

		isDatabaseDriverLoaded = true;
	}

	private Connection createNewConnection() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(databaseUrl, userName, password);
		} catch (SQLException sqle) {
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		}

		return connection;
	}

}

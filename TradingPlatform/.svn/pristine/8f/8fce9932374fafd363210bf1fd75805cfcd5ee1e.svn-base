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


public class DatabaseConnectionInfoFactory {

	private String databaseUrl;
	private String userName;
	private String password;
	private static boolean isDatabaseDriverLoaded = false;

	public DatabaseConnectionInfoFactory(){

		if (System.getProperty("Database").equals("oracle")) {
			databaseUrl = System.getProperty("OracleDataBaseUrl");
			userName = System.getProperty("OracleUsername");
			password = System.getProperty("OraclePassword");			
			if (!isDatabaseDriverLoaded) {
				loadDatabaseDriver(System.getProperty("OracleClassForName"));
			}
		}
	}

	private void loadDatabaseDriver(String databaseDriver) {

		try {
			Class.forName(databaseDriver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(System.getProperty("RUNTIME_ERROR_MESSAGE"));
		}

		isDatabaseDriverLoaded = true;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}


}

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

package com.fdm.tradingplatform.model.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.fdm.tradingplatform.model.DatabaseConnectionFactory;
import com.fdm.tradingplatform.model.DatabaseConnectionPool;
import com.fdm.tradingplatform.model.TradingPlatformProperties;

public abstract class AbstractDatabaseDao implements iDao{
	protected static Logger logger = Logger.getLogger("log");
	protected DatabaseConnectionPool connectionPool;
	protected Properties properties;
	protected PreparedStatement statement;
	protected DatabaseConnectionFactory dbConnectionFactory;
	protected Connection connection;

	protected AbstractDatabaseDao(DatabaseConnectionPool connectionPool) {

		properties = TradingPlatformProperties.getInstance();
		this.connectionPool = connectionPool;
	}

	protected Connection getDatabaseConnection() {
		logger.info("Giving out a connection.");
		return connectionPool.openConnection();
	}

	protected void closeDatabaseConnection() {

		connectionPool.returnConnection(connection);
	}

}

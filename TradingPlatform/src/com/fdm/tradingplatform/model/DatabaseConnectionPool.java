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
import java.util.Vector;

public class DatabaseConnectionPool implements iConnectionPool {

	private Vector<Connection> connectionPool;
	private Connection connection;

	public DatabaseConnectionPool(Vector<Connection> connectionPool) {
		this.connectionPool = connectionPool;
	}

	public DatabaseConnectionPool getConnection(String key) {
		return this;
	}

	public Connection openConnection() {

		if (connectionPool.size() > 0) {
			connection = connectionPool.firstElement();
			connectionPool.removeElementAt(0);
		}
		return connection;
	}
	
	public int size(){
		return connectionPool.size();
	}
	public void returnConnection(Connection connection) {
		connectionPool.add(connection);
	}

}

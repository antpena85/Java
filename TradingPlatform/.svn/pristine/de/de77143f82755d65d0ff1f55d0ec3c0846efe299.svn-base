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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.fdm.tradingplatform.model.DatabaseConnectionPool;
import com.fdm.tradingplatform.model.UserRequestVO;
import com.fdm.tradingplatform.model.exception.TradingPlatformException;

public class UserRequestDatabaseDao extends AbstractDatabaseDao implements iDao {

	
	public UserRequestDatabaseDao(DatabaseConnectionPool connectionPool) {
		super(connectionPool);
	}

	@Override
	public Databean select(String primaryKey) throws TradingPlatformException {

		UserRequestVO userRequestVO = new UserRequestVO();
		try {
			connection = getDatabaseConnection();
			statement = connection.prepareStatement(properties.getProperty("SELECT_A_SINGLE_REQUEST"));
			statement.setString(1, primaryKey);
			ResultSet rs = statement.executeQuery();

			rs.next();

			userRequestVO.setAttribute("requestNumber", rs.getString(1));
			userRequestVO.setAttribute("administrator", rs.getString(2));
			userRequestVO.setAttribute("requestTitle", rs.getString(3));
			userRequestVO.setAttribute("requestor", rs.getString(4));
			userRequestVO.setAttribute("username", rs.getString(5));
			userRequestVO.setAttribute("password", rs.getString(6));
			userRequestVO.setAttribute("rolename", rs.getString(7));
			userRequestVO.setAttribute("status", rs.getString(8));
			userRequestVO.setAttribute("date-registered", rs.getString(9));
			userRequestVO.setAttribute("date-completed", rs.getString(10));
			userRequestVO.setAttribute("date-updated", rs.getString(11));
			userRequestVO.setAttribute("additionalInfo", rs.getString(12));

			return (Databean) userRequestVO;
		} catch (SQLException e) {
			throw new TradingPlatformException(properties.getProperty("SQL_ERROR_MESSAGE"));
		} finally {
			closeDatabaseConnection();
		}
	}

	@Override
	public void insert(Databean bean) throws TradingPlatformException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Databean bean) throws TradingPlatformException {

		UserRequestVO userRequestVO = (UserRequestVO) bean;
		connection = getDatabaseConnection();

		try {
			statement = connection.prepareStatement(properties.getProperty("UPDATE_USER_REQUEST"));

			statement.setString(1, userRequestVO.getAttribute("administrator"));
			statement.setString(2, userRequestVO.getAttribute("requestTitle"));
			statement.setString(3, userRequestVO.getAttribute("requestor"));
			statement.setString(4, userRequestVO.getAttribute("username"));
			statement.setString(5, userRequestVO.getAttribute("password"));
			statement.setString(6, userRequestVO.getAttribute("rolename"));
			statement.setString(7, userRequestVO.getAttribute("status"));
			statement.setString(8, userRequestVO.getAttribute("date-registered"));
			statement.setString(9, userRequestVO.getAttribute("date-completed"));
			statement.setString(10, userRequestVO.getAttribute("date-updated"));
			statement.setString(11, userRequestVO.getAttribute("additionalInfo"));
			statement.setString(12, userRequestVO.getAttribute("requestNumber"));
		
			
			statement.executeQuery();
		} catch (SQLException e) {
			throw new TradingPlatformException(properties.getProperty("SQL_ERROR_MESSAGE"));
		} finally {
			closeDatabaseConnection();
		}
	}

	@Override
	public void delete(String primaryKey) throws TradingPlatformException {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String,Databean> selectAll() throws TradingPlatformException {

		Map<String,Databean> userRequests = new HashMap<String,Databean>();
		try {
			connection = getDatabaseConnection();
			statement = connection.prepareStatement(properties.getProperty("SELECT_ALL_REQUESTS"));
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				UserRequestVO userRequestVO = new UserRequestVO();
				userRequestVO.setAttribute("requestNumber", rs.getString(1));
				userRequestVO.setAttribute("administrator", rs.getString(2));
				userRequestVO.setAttribute("requestTitle", rs.getString(3));
				userRequestVO.setAttribute("requestor", rs.getString(4));
				userRequestVO.setAttribute("username", rs.getString(5));
				userRequestVO.setAttribute("password", rs.getString(6));
				userRequestVO.setAttribute("rolename", rs.getString(7));
				userRequestVO.setAttribute("status", rs.getString(8));
				userRequestVO.setAttribute("date-registered", rs.getString(9));
				userRequestVO.setAttribute("date-completed", rs.getString(10));
				userRequestVO.setAttribute("date-updated", rs.getString(11));
				userRequestVO.setAttribute("additionalInfo", rs.getString(12));

				userRequests.put((String) userRequestVO.getAttribute("requestNumber"), userRequestVO);
			}
		} catch (SQLException e) {
			throw new TradingPlatformException(properties.getProperty("SQL_ERROR_MESSAGE"));
		} finally {
			closeDatabaseConnection();
		}
		return userRequests;
	}

}

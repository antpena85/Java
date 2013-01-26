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

import java.util.Map;

import com.fdm.tradingplatform.model.exception.TradingPlatformException;

public interface iDao {

	public Databean select(String primaryKey) throws TradingPlatformException;

	public void insert(Databean bean) throws TradingPlatformException;

	public void update(Databean bean) throws TradingPlatformException;

	public void delete(String primaryKey) throws TradingPlatformException;

	public Map<String,Databean> selectAll() throws TradingPlatformException;

}

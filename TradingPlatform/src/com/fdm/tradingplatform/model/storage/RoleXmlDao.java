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

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.fdm.tradingplatform.model.RoleVO;

public class RoleXmlDao extends AbstractXmlDao implements iDao {

	private static Logger logger = Logger.getLogger("log");

	private static iDao firstInstance = null;

	private RoleXmlDao(String xmlFilePath) {
		super(xmlFilePath, "roles", "role", "roleFields");
		loadXml();
	}

	public static iDao getInstance(String xmlFilePath) {

		if (firstInstance == null)
			firstInstance = new RoleXmlDao(xmlFilePath);
		return firstInstance;
	}

	@Override
	public Databean select(String primaryKey) {

		logger.trace("return role:" + primaryKey);
		return (Databean) storage.get(primaryKey);
	}

	@Override
	public void insert(Databean bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Databean bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String primaryKey) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void storeElement(Map<String,String> xmlElement) {
		String rolename = (String) xmlElement.get("name");
		xmlElement.remove("name");
		storage.put(rolename, new RoleVO(rolename, new HashMap<String,String>(xmlElement)));
	}

	@Override
	public Map<String, Databean> selectAll() {

		return new HashMap<String, Databean>(storage);
	}

}

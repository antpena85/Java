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
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.fdm.tradingplatform.model.TradingPlatformProperties;

public abstract class AbstractXmlDao implements iDao {

	private static Logger logger = Logger.getLogger("log");
	protected Map<String, Databean> storage = new HashMap<String, Databean>();
	private Properties properties = TradingPlatformProperties.getInstance();
	private XmlParserEngine xmlHandler;

	public AbstractXmlDao(String xmlFileLocation, String xmlRootTag, String xmlChildTag, String propertiesVariableNameWithXmlFields) {

		this.xmlHandler = new XmlParserEngine(xmlFileLocation, xmlRootTag, xmlChildTag, properties.getProperty(propertiesVariableNameWithXmlFields).split(";"));
	}

	protected void saveXml() {

		xmlHandler.saveXml(storage);
	}

	protected void loadXml() {
		logger.trace("Attempting to load xml file:");
		//Map[] xmlElements = xmlHandler.loadXml();
		List<Map<String,String>> xmlElements = xmlHandler.loadXml();
		
		for(Map<String,String> element : xmlElements){
			storeElement(element);
		}
//		for (int i = 0; i < xmlElements.length; i++) {
//			storeElement(xmlElements[i]);
//		}
	}

	protected abstract void storeElement(Map<String,String> xmlElement);

}

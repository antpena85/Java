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


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.fdm.tradingplatform.model.TradingPlatformProperties;

public class XmlParserEngine {

	private String xmlFileLocation;
	private String xmlRootTag;
	private String xmlChildTag;
	private String[] xmlFields;
	private DocumentBuilder documentBuilder;
	private Document document;
	protected DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	protected Properties properties= TradingPlatformProperties.getInstance();

	public XmlParserEngine(String xmlFileLocation, String xmlRootTag, String xmlChildTag, String[] xmlFields) {

		this.xmlFileLocation = xmlFileLocation;
		this.xmlRootTag = xmlRootTag;
		this.xmlChildTag = xmlChildTag;
		this.xmlFields = xmlFields;

		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(xmlFileLocation);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		} catch (SAXException e) {
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		} catch (IOException e) {
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		}

		document.getDocumentElement().normalize();
	}

	public List<Map<String,String>> loadXml() {
		NodeList listOfChildElements = document.getElementsByTagName(xmlChildTag);
		Node elementNode;
		Element nodeElement;
		NodeList fieldList;
		Element fieldElement;
		NodeList fieldText;
		//Map<String,String>[] xmlElements = new Map[listOfChildElements.getLength()];
		List<Map<String,String>> xmlElements = new ArrayList<Map<String,String>>();
		Map<String, String> xmlElementBuffer = new HashMap<String, String>();

		for (int i = 0; i < listOfChildElements.getLength(); i++) {

			elementNode = listOfChildElements.item(i);
			xmlElementBuffer.clear();

			if (elementNode.getNodeType() == Node.ELEMENT_NODE) {

				nodeElement = (Element) elementNode;
				for (String fieldName : xmlFields) {
					fieldList = nodeElement.getElementsByTagName(fieldName);
					fieldElement = (Element) fieldList.item(0);
					fieldText = fieldElement.getChildNodes();
					if (fieldText.getLength() != 0) {
						xmlElementBuffer.put(fieldName, ((Node) fieldText.item(0)).getNodeValue().trim());
					}
				}
			//	xmlElements[i] = new HashMap<String,String>(xmlElementBuffer);
				xmlElements.add(new HashMap<String,String>(xmlElementBuffer));
			}
		}
		return xmlElements;
	}

	public void saveXml(Map<String,Databean> storage) {

		Element elementBuffer;
		Text elementTextBuffer;
		Document xmlDocument = null;
		Databean bean;
		Element childElement;
		xmlDocument = documentBuilder.newDocument();
		xmlDocument.setXmlStandalone(true);

		Element rootNode = xmlDocument.createElement(xmlRootTag);
		xmlDocument.appendChild(rootNode);

		for(String key : storage.keySet()){

			bean = storage.get(key);
			childElement = xmlDocument.createElement(xmlChildTag);
			rootNode.appendChild(childElement);

			for (String fieldName : xmlFields) {
				elementBuffer = xmlDocument.createElement(fieldName);
				childElement.appendChild(elementBuffer);
				elementTextBuffer = xmlDocument.createTextNode(bean.getAttribute(fieldName));
				elementBuffer.appendChild(elementTextBuffer);
				childElement.appendChild(elementBuffer);
			}

		}
		writeXmlToFile(transformXmlDocument(xmlDocument));
	}

	private String transformXmlDocument(Document xmlDocument) {

		String xmlString = null;
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer xmlTransformer = null;
		try {
			xmlTransformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		}
		xmlTransformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		xmlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
		xmlTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		StringWriter stringWriter = new StringWriter();
		StreamResult result = new StreamResult(stringWriter);
		DOMSource source = new DOMSource(xmlDocument);
		try {
			xmlTransformer.transform(source, result);
		} catch (TransformerException e) {
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		}
		xmlString = stringWriter.toString();

		return xmlString;
	}

	protected void writeXmlToFile(String xmlString) {

		FileWriter fstream;
		try {
			fstream = new FileWriter(xmlFileLocation);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(xmlString);
			out.close();
		} catch (IOException e) {
			throw new RuntimeException(properties.getProperty("RUNTIME_ERROR_MESSAGE"));
		}
	}
}

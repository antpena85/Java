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

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class TradingPlatformProperties {
	private static Logger logger = Logger.getLogger("log");

	private static Properties firstInstance = null;
	private static FileInputStream configPropertiesFileInputStream;

	public static Properties getInstance() {

		if (firstInstance == null) {
			firstInstance = new Properties();
			try {
				configPropertiesFileInputStream = new FileInputStream("config.properties");
				firstInstance.load(configPropertiesFileInputStream);
				logger.debug("load config.properties file");
			} catch (FileNotFoundException e) {
				logger.error("Properties file not found", e);

				try {
					FileWriter fstream = new FileWriter("./config.properties");
					BufferedWriter out = new BufferedWriter(fstream);
					out.write(fileContents());
					out.close();
					throw new RuntimeException(firstInstance.getProperty("RUNTIME_ERROR_MESSAGE"));
				} catch (IOException e1) {
					logger.error("IO exception", e);
					throw new RuntimeException(firstInstance.getProperty("RUNTIME_ERROR_MESSAGE"));
				}

			} catch (IOException e) {
				logger.error("IO exception", e);
				throw new RuntimeException(firstInstance.getProperty("RUNTIME_ERROR_MESSAGE"));

			}

		}
		logger.debug("return firstInstance");
		return firstInstance;
	}

	private static String fileContents() {

		String contents = " This variable contains the path that will hold users information" + "userXmlDaoFilePath=.//xmlStorage//userxmlfiledao.xml" +

		"#This variable contains the path that will hold roles" + "roleXmlDaoFilePath=.//xmlStorage//rolexml.xml" +

		"This variable contains the path that holds user requests" + "userRequestXmlDaoFilePath=.//xmlStorage//userrequestxml.xml" +

		"#This variable defines the storage medium the application will use" + "#Availiable [XML | DATABASE]" + "storageMedium=XML" +

		"#This variable holds the fields of the user xml file" + "userFields=username;password;rolename;status" +

		"#This variable holds the role fields in the role xml file"
				+ "roleFields=name;addUser;removeUser;changePermission;userRegistration;banUser;updateUserDetails;adminScreen;unBanUser;viewUserRequest;assignUserRequest;markAsCompleteUserRequest" +

				"#this variable holds the requests fields in the request xml file"
				+ "requestFields=requestNumber;administrator;requestTitle;requestor;username;password;rolename;status;date-registered;date-completed;date-updated;additionalInfo" +

				"#The Variables below will hold the TradingPlatform Policy that data must follow" +

				"#Size of Usernames" + "UsernamePolicyMinSize=5" + "UsernamePolicyMaxSize=15" +

				"#Size of Password" + "PasswordPolicyMinSize=8" + "PasswordPolicyMaxSize=15" +

				"#Size of rolename" + "RolenamePolicyMinSize=4" + "RolenamePolicyMaxSize=25" +

				"#Username regex" + "UsernamePolicyRegex=[A-z]+[A-z|0-9]*" +

				"#Database Used" + "Database=oracle" +

				"#Oracle Database value" + "#OracleDataBaseUrl=jdbc:oracle:thin:@ORABTN001:1521:xe" +

				"OracleDataBaseUrl=jdbc:oracle:thin:@86.54.76.84:1521:xe" +

				"#Oracle UserName" + "OracleUsername=rahamimbenavraham" +

				"Oracle password" + "OraclePassword=oracle" +

				"OracleClassForName=oracle.jdbc.driver.OracleDriver";

		return contents;
	}

}

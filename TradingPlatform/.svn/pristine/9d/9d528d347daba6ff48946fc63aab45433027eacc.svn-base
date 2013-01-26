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

import java.util.HashMap;
import java.util.Map;

public class Selected {
	
	public static enum Option{
			ADD_USER(1), 
			REMOVE_USER(2), 
			BAN_USER(3), 
			UNBAN_USER(4), 
			UPDATE_USER_PASSWORD(5), 
			UPDATE_USER_ROLE(6),
			VIEW_OUTSTANDING_REQUESTS(7), 
			VIEW_ASSIGNED_REQUESTS(8), 
			VIEW_COMPLETED_REQUESTS(9), 
			ASSIGN_USER_REQUEST(10), 
			MARK_AS_COMPLETE(11), 
			LOGOUT(12);
			
			static Map<Integer,Option> options = new HashMap<Integer,Option>();
			static{
				
				
				for(Option o : Option.values()){
					options.put(o.optionValue,o);
				}
			}
		
			private final int optionValue;
			Option(int optionValue) {
				this.optionValue = optionValue;
			}
			public int option() {
				return optionValue;
			}
			
			public static Option lookUp(int key){
				return (Option) options.get(key);
				
			}

	}

}

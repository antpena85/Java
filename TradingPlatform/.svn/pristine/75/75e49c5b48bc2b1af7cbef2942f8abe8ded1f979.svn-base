package com.fdm.tradingplatform.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordService {
	private static PasswordService instance;

	public synchronized String encrypt(String clearPassword) {
		byte[] digestedPassword=null;
		StringBuffer hexString = new StringBuffer();

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.update(clearPassword.getBytes("UTF-8"));
			digestedPassword = messageDigest.digest();
	        for (int i=0;i<digestedPassword.length;i++) {
	            hexString.append(Integer.toHexString(0xFF & digestedPassword[i]));
	        }
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hexString.toString();

	}

	public static synchronized PasswordService getInstance() {
		if (instance == null) {
			instance = new PasswordService();
		}
		return instance;
	}
}


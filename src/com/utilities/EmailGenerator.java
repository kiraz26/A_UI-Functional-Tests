package com.utilities;

public class EmailGenerator {
	
	private final static String domain = "@cybertek.com";
	
	public static String generate(String username) {
		return username.toLowerCase()+domain;
	}
	
	
}

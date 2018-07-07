package com.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationDemo {

	public static void main(String[] args) throws IOException {
		// . means the home folder of the project
		String path = "./configuration.properties";
		// String path =
		// "C:\\Users\\Halil\\eclipse-workspace\\A_UI-Functional-Tests\\configuration.properties";
		// this class is needed so that java can read the file.
		// Java can only read the input stream. It cannot open file directly.
		FileInputStream input = new FileInputStream(path);
		// Properties is class that read properties files
		Properties properties = new Properties();
		// load the values in the file to the properties object
		properties.load(input);

		// properties can give the values based on the keys passed

		String val = properties.getProperty("url");
		System.out.println(val);

	}

}

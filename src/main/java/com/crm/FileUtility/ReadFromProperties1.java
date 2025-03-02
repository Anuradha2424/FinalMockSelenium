package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties1 {

	public static String getData(String key) throws IOException {
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\dws.properties");
	prop.load(fis);
	String data=prop.getProperty(key);
	return data;
	}
	
}

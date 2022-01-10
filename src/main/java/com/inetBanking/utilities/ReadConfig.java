package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig{

	public static FileInputStream  fis;
	public static Properties prop;

	public ReadConfig() {
 
		File src = new File("./Configuration/config.properties");
		
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is"+e.getMessage());
		}
	}

	public String getApplication() {

		String url = prop.getProperty("baseURL");
		return url;	
	}
	public String getUsername() {

		String uname = prop.getProperty("username");
		return uname;
	}	

	public String getPassword() {

		String pass = prop.getProperty("password");
		return pass;
	}	

	public String getChromePath() {

		String chropath = prop.getProperty("chromepath");
		return chropath;
	}	
	public String getEdgePath() {

		String epath = prop.getProperty("edgepath");
		return epath;
	}

	public String getFirePath() {

		String firepath = prop.getProperty("firefoxpath");
		return firepath;
	}	
}

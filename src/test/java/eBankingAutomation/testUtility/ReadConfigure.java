package eBankingAutomation.testUtility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadConfigure {
	Properties pro;

	public ReadConfigure()  {
		File file = new File("./Configuration/configure.properties");
		try {
			FileInputStream fi = new FileInputStream(file);
			pro = new Properties();
			pro.load(fi);
		}

		catch (IOException e) {
			System.out.println("Exception" + e.getMessage());
		}

	}

	public String getURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username=pro.getProperty("userID");
		return username;	
	}
	
	public String getPassword() {
		String password=pro.getProperty("userPass");
		return password;	
	}
	
	
}

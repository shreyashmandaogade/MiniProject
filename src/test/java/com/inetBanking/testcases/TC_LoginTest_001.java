package com.inetBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	public static LoginPage lp;

	@Test
	public void loginTest() throws Exception {

		driver.get(baseURL);
		logger.info("URL is opened");
		lp = new LoginPage(driver);
		
		lp.setUserName(username,password);
		logger.info("Entered username");
		logger.info("Entered password");
		
		lp.clickSubmit();
	  	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("Login Test passed");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}		
	}
}

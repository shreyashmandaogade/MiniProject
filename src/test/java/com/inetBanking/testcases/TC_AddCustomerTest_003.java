package com.inetBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws Exception{
	
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username,password);
		
		logger.info("User name is provided");
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		logger.info("providing customer details....");

		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custState("AP");
		addcust.custpinno("5000074");
		addcust.custtelephone("987890091");

		String email = randomestring()+"@gmail.com";
		addcust.custemailid(email);

		addcust.custpassword("abcdef");
		addcust.custbtnSubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}

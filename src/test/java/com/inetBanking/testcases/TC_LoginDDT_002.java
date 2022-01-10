package com.inetBanking.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelUtility;

public class TC_LoginDDT_002 extends BaseClass{


	@Test(dataProvider ="LoginData")
	public void loginDDT(String user,String pwd) throws Exception {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user, pwd);
		
		logger.info("username provided");
		logger.info("password provided");
		lp.clickSubmit();

		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@DataProvider(name="LoginData")
	String [][] getData() throws Exception{
		
		String path = System.getProperty("user.dir")+"/src/main/resources/LoginData.xlsx";

		int rownum = ExcelUtility.getRowCount(path,"Sheet1");
		int colcount = ExcelUtility.getCellCount(path,"Sheet1",1);		

		String loginData[][] = new String [rownum][colcount];

		for(int i=1 ;i<rownum; i++) 
		{
			for(int j=0; j<colcount; j++) 
			{

				loginData[i-1][j] =  ExcelUtility.getCellData(path,"Sheet1",i, j);
			}	
		}
		return loginData;
	}
}

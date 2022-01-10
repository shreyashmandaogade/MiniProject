package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	@FindBy(name="uid")
	WebElement txtUserName;

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	WebElement btnLogin;

	@FindBy(xpath="//a[text()='Log out']")
	WebElement lnkLogout;

	public LoginPage(WebDriver rdriver){
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void setUserName(String uname,String password) {

		txtUserName.sendKeys(uname);
		txtPassword.sendKeys(password);

	}
	public void clickSubmit() {
		btnLogin.click();
	}

	public void clickLogout() {
		lnkLogout.click();
	}
}

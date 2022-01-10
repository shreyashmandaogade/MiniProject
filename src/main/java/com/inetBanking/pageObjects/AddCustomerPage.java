package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;   

	public AddCustomerPage(WebDriver rdriver){
		
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using ="//a[text()='New Customer']")
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using ="name")
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using ="rad1")
	WebElement rdgender;

	@FindBy(how = How.ID_OR_NAME, using ="dob")
	WebElement txtdob;

	@FindBy(how = How.NAME, using ="addr")
	WebElement txtaddress;

	@FindBy(how = How.NAME, using ="city")
	WebElement txtcity;

	@FindBy(how = How.NAME, using ="state")
	WebElement txtstate;

	@FindBy(how = How.NAME, using ="pinno")
	WebElement txtpinno;

	@FindBy(how = How.NAME, using ="telephoneno")
	WebElement txttelephoneno;

	@FindBy(how = How.NAME, using ="emailid")
	WebElement txtemailid;

	@FindBy(how = How.NAME, using ="password")
	WebElement txtpassword;

	@FindBy(how = How.NAME, using ="sub")
	WebElement btnsubmit;


	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);		
	}

	public void custgender(String cgender) {
		rdgender.click();	
	}

	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}
	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephone(String ctelephoneno) {

		txttelephoneno.sendKeys(ctelephoneno);
	}
	public void custemailid(String cemailid) {

		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custbtnSubmit() {
		btnsubmit.click();
	}
}


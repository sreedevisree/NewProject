package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_087_Customer_POM {
	private WebDriver driver;

	public UNF_087_Customer_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//*********************Start of Customer
	//clicking on the add new customer
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewcustomer_CustomerLnk;
	
	public void clickAddNewcustomer_CustomerLnk(){
		this.addNewcustomer_CustomerLnk.click();
	}
	
	//setting customer group name from the select box
	@FindBy(id="input-customer-group")
	private WebElement custGrpName_Customer_CustomerLnk;
	
	public void setCustGrpName_Customer_CustomerLnk(String custGrpName){
		Select custGrpNameSelect=new Select(this.custGrpName_Customer_CustomerLnk);
		custGrpNameSelect.selectByVisibleText(custGrpName);
	}
	
	//setting the first name
	@FindBy(id="input-firstname")
	private WebElement firstName_Customer_CustomerLnk;
	
	public void setFirstName_Customer_CustomerLnk(String firstName){
		this.firstName_Customer_CustomerLnk.sendKeys(firstName);
	}
	
	//setting the last name
	@FindBy(id="input-lastname")
	private WebElement lastName_Customer_CustomerLnk;
		
	public void setlastName_Customer_CustomerLnk(String lastName){
		this.lastName_Customer_CustomerLnk.sendKeys(lastName);
	}	
	
	//setting the email
	@FindBy(id="input-email")
	private WebElement email_Customer_CustomerLnk;
		
	public void setEmailCustomer_CustomerLnk(String email){
		this.email_Customer_CustomerLnk.sendKeys(email);
	}
	
	//setting the Telephone
	@FindBy(id="input-telephone")
	private WebElement telePh_Customer_CustomerLnk;
		
	public void setTelePh_Customer_CustomerLnk(String telePh){
		this.telePh_Customer_CustomerLnk.sendKeys(telePh);
	}	
	
	//setting the password
	@FindBy(id="input-password")
	private WebElement password_Customer_CustomerLnk;
		
	public void setpassword_Customer_CustomerLnk(String password){
		this.password_Customer_CustomerLnk.sendKeys(password);
	}
	
	//setting the confirm password
	@FindBy(id="input-confirm")
	private WebElement cnfPsw_Customer_CustomerLnk;
		
	public void setCnfPsw_Customer_CustomerLnk(String cnfPsw){
		this.cnfPsw_Customer_CustomerLnk.sendKeys(cnfPsw);
	}	
	
	//clicking on save button
	@FindBy(xpath="//button[@type='submit']")
	private WebElement save_Customer_CustomerLnk;
	
	public void clickSave_Customer_CustomerLnk(){
		this.save_Customer_CustomerLnk.click();
	}
	
	//getting the Customer creation confirmation message 
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement custConfirmationMsg;
	
	public String getCustConfirmationMsg(){
		return this.custConfirmationMsg.getText();
	}
	
	//*********************End of Customer 
}

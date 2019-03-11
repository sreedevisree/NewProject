package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_086_CustomerGrp_CustomerPOM {
	private WebDriver driver;

	public UNF_086_CustomerGrp_CustomerPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*********************Start of Customer Group
	//clicking on the add new customer
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewcustomer_CustomerLnk;
	
	public void clickAddNewcustomer_CustomerLnk(){
		this.addNewcustomer_CustomerLnk.click();
	}
	
	//setting customer group name
	@FindBy(xpath="//input[@placeholder='Customer Group Name']")
	private WebElement custGrpName_CustomerGrp_CustomerLnk;
	
	public String setCustGrpName_CustomerGrp_CustomerLnk(String custGrpName){
		this.custGrpName_CustomerGrp_CustomerLnk.sendKeys(custGrpName);
		/*Select custGrpNameSelect=new Select(this.custGrpName_CustomerGrp_CustomerLnk);
		custGrpNameSelect.selectByVisibleText(custGrpName);
		//return custGrpNameSelect.getFirstSelectedOption().getText();
*/		return custGrpName;
	}
	
	//setting customer group description
	@FindBy(xpath="//textarea[@id='input-description1']")
	private WebElement custGrpDsc_CustomerGrp_CustomerLnk;
	
	public String setCustGrpDsc_CustomerGrp_CustomerLnk(String custGrpDsc){
		this.custGrpDsc_CustomerGrp_CustomerLnk.sendKeys(custGrpDsc);
		return custGrpDsc_CustomerGrp_CustomerLnk.getText();
	}	
	
	//clicking on yes radio button
	@FindBy(xpath="//input[@value='1']")
	private WebElement approveNewCust_CustomerGrp_CustomerLnk;
	
	public void clickApproveNewCust_CustomerGrp_CustomerLnk(){
		this.approveNewCust_CustomerGrp_CustomerLnk.click();
	}
	
	//clicking on save button
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn_CustomerGrp_CustomerLnk;
	
	public void clickSaveBtn_CustomerGrp_CustomerLnk(){
		this.saveBtn_CustomerGrp_CustomerLnk.click();
	}

	//*********************End of Customer Group
	
	
	//*********************Start of Customer 
	
	//click on add new customer button
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addBtn_Customer_CustomerLnk;
	
	public void clickAddBtn_Customer_CustomerLnk(){
		this.addBtn_Customer_CustomerLnk.click();
	}
	
	//setting customer group description
	@FindBy(xpath="//select[@id='input-customer-group']")
	private WebElement custGrpName1_CustomerGrp_CustomerLnk;
	
	public String setCustGrpName1_CustomerGrp_CustomerLnk(String custGrpName){
		this.custGrpName1_CustomerGrp_CustomerLnk.click();
		Select custGrpSelect=new Select(this.custGrpName1_CustomerGrp_CustomerLnk);
		custGrpSelect.selectByVisibleText(custGrpName);
		return custGrpName;
	}
	
	//setting the first name
	@FindBy(id="input-firstname")
	private WebElement firstName_Customer_CustomerLnk;
	
	public String setFirstName_Customer_CustomerLnk(String firstName){
		this.firstName_Customer_CustomerLnk.sendKeys(firstName);
		return firstName;
	}
	
	//setting the last name
	@FindBy(id="input-lastname")
	private WebElement lastName_Customer_CustomerLnk;
		
	public String setlastName_Customer_CustomerLnk(String lastName){
		this.lastName_Customer_CustomerLnk.sendKeys(lastName);
		return lastName;
	}	
	
	//setting the email
	@FindBy(id="input-email")
	private WebElement email_Customer_CustomerLnk;
		
	public String setEmailCustomer_CustomerLnk(String email){
		this.email_Customer_CustomerLnk.sendKeys(email);
		return email;
	}
	
	//setting the Telephone
	@FindBy(id="input-telephone")
	private WebElement telePh_Customer_CustomerLnk;
		
	public String setTelePh_Customer_CustomerLnk(String telePh){
		this.telePh_Customer_CustomerLnk.sendKeys(telePh);
		return telePh;
	}	
	
	//setting the password
	@FindBy(id="input-password")
	private WebElement password_Customer_CustomerLnk;
		
	public String setpassword_Customer_CustomerLnk(String password){
		this.password_Customer_CustomerLnk.sendKeys(password);
		return password;
	}
	
	//setting the confirm password
	@FindBy(id="input-confirm")
	private WebElement cnfPsw_Customer_CustomerLnk;
		
	public String setCnfPsw_Customer_CustomerLnk(String cnfPsw){
		this.cnfPsw_Customer_CustomerLnk.sendKeys(cnfPsw);
		return cnfPsw;
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
	
	//getting the confirmation message of creating the customer
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement confirmationMsg_Customer_CustomerLnk;
	
	public String getConfirmationMsg_Customer_CustomerLnk(){
		return this.confirmationMsg_Customer_CustomerLnk.getText();
	}
	//*********************End of Customer 
}

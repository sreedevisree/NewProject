package com.training.pom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_059_Marketing_AffiliatePOM {
	private WebDriver driver;

	public UNF_059_Marketing_AffiliatePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on add new affiliate icon from Marketing tab
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewAffiliate_Marketing;

	public void clickAddNewAffiliate_Marketing() {
		this.addNewAffiliate_Marketing.click();
	}
	
	//setting the first name
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstNameAffiliate_Marketing;
	
	public void setFirstNameAffiliate_Marketing(String firstName){
		this.firstNameAffiliate_Marketing.sendKeys(firstName);
	}
	
	//setting Last Name textbox
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastNameAffiliate_Marketing;
	
	public void setLastNameAffiliate_Marketing(String lastName){
		this.lastNameAffiliate_Marketing.sendKeys(lastName);
	}

	//setting email textbox
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement eMailAffiliate_Marketing;
	
	public void setEMAilAffiliate_Marketing(String email){
		this.eMailAffiliate_Marketing.sendKeys(email);
	}
	
	//setting of Telephone textbox
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneNoAffiliate_Marketing;
	
	public void setTelePhoneNoAffiliate_Marketing(String telePhoneNo){
		this.telephoneNoAffiliate_Marketing.sendKeys(telePhoneNo);;
	}
	
	//setting Password textbox
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordAffiliate_Marketing;
	
	public void setPasswordAffiliate_Marketing(String password){
		this.passwordAffiliate_Marketing.sendKeys(password);;
	}

	//setting Confirm password textbox

	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPasswordAffiliate_Marketing;
	
	public void setConfirmPasswordAffiliate_Marketing(String password){
		this.confirmPasswordAffiliate_Marketing.sendKeys(password);
	}	
	
	//setting address1
	@FindBy(xpath="//input[@placeholder='Address 1']")
	private WebElement address1Affiliate_Marketing;
	
	public void setAddress1Affiliate_Marketing(String address1){
		this.address1Affiliate_Marketing.sendKeys(address1);
	}
	
	//setting address2
	@FindBy(xpath="//input[@id='input-address-2']")
	private WebElement address2Affiliate_Marketing;
	
	public void setAddress2Affiliate_Marketing(String address2){
		this.address2Affiliate_Marketing.sendKeys(address2);
	}	

	//setting city
	@FindBy(xpath="//input[@id='input-city']")
	private WebElement cityAffiliate_Marketing;
	
	public void setcityAffiliate_Marketing(String city){
		this.cityAffiliate_Marketing.sendKeys(city);
	}	

	//setting of PostCode
	@FindBy(xpath="//input[@id='input-postcode']")
	private WebElement postCodeAffiliate_Marketing;
	
	public void setPostCodeAffiliate_Marketing(String postCode){
		this.postCodeAffiliate_Marketing.sendKeys(postCode);
	}
	
	//setting the country name;
	public void setCountryAffiliate_Marketing(String country){
		Select countryAffiliate_Marketing=new Select(driver.findElement(By.xpath("//select[@id='input-country']")));
		countryAffiliate_Marketing.selectByVisibleText(country);
	}
	
	//setting state name
	public void setStateAffiliate_Marketing(String state){
		Select stateAffiliate_Marketing=new Select(driver.findElement(By.xpath("//select[@id='input-zone']")));
		stateAffiliate_Marketing.selectByVisibleText(state);
	}

	//************ Start of Payment Details tab
	//clicking on the payments tab
	@FindBy(xpath="//a[contains(text(),'Payment Details')]")
	private WebElement paymnetsAffiliate_Marketing;
	
	public void clickPaymentsAffiliate_Marketing(){
		this.paymnetsAffiliate_Marketing.click();
	}
	
	//setting the Cheque payee name details
	@FindBy(xpath="//input[@id='input-cheque']")
	private WebElement chequePayeeNamePaymnets_Affiliate_Marketing;
	
	public void setChequePPayeeNamePaymnets_Affiliate_Marketing(String chequePayeeName){
		this.chequePayeeNamePaymnets_Affiliate_Marketing.sendKeys(chequePayeeName);
	}
	
	//Saving the details
	@FindBy(xpath="//button[@type='submit']")
	private WebElement save_Affiliate_Marketing;
	
	public void clicksave_Affiliate_Marketing(){
		this.save_Affiliate_Marketing.click();
	}
	
	//getting the confirmation message
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement confirmationMsg_Affiliate_Marketing;
	
	public String getConfirmationMsg_Affiliate_Marketing(){
		return this.confirmationMsg_Affiliate_Marketing.getText();
	}
	

	//************ End of Payment Details tab
}

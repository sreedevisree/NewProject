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

public class UNF_087_CustomerGroup_POM {
	private WebDriver driver;

	public UNF_087_CustomerGroup_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//clicking on add new Customer Groups
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNew_CustomerGroups_Customer;
	
	public void clickAddNew_CustomerGroups_Customer(){
	this.addNew_CustomerGroups_Customer.click();
	}
	
	//setting the value for Customer Group name
	@FindBy(xpath="//input[@placeholder='Customer Group Name']")
	private WebElement custGrpName_CustomerGroups_Customer;
	
	public void setCustGrpName_CustomerGroups_Customer(String custGrpName){
		this.custGrpName_CustomerGroups_Customer.sendKeys(custGrpName);
	}
	
	// setting value for Description textbox
	@FindBy(xpath="//textarea[@id='input-description1']")
	private WebElement custGrpDesc_CustomerGroups_Customer;
	
	public void setCustGrpDesc_CustomerGroups_Customer(String custGrpDesc){
		this.custGrpDesc_CustomerGroups_Customer.sendKeys(custGrpDesc);
	}
	
	//setting the Approve New Customers radio button to yes
	@FindBy(xpath="//input[@value='1']")
	private WebElement appNewCust_CustomerGroups_Customer;
	
	public void setAppNewCust_CustomerGroups_Customer(){
		this.appNewCust_CustomerGroups_Customer.click();
	}
	
	//clicking on Save button
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn_CustomerGroups_Customer;
	
	public void clickSaveBtn_CustomerGroups_Customer(){
		this.saveBtn_CustomerGroups_Customer.click();
	}
	
	//getting the customer group creation confirmation message
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement custGrpConfMsg;
	
	public String getCustGrpConfMsg(){
		return this.custGrpConfMsg.getText();
	}
		

}

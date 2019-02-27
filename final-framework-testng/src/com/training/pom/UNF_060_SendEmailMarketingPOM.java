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

public class UNF_060_SendEmailMarketingPOM {
	private WebDriver driver;

	public UNF_060_SendEmailMarketingPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on add new affiliate icon from Marketing tab
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewAffiliate_Marketing;

	public void clickAddNewAffiliate_Marketing() {
		this.addNewAffiliate_Marketing.click();
	}
	
	//setting To value
	@FindBy(xpath="//select[@name='to']")
	private WebElement to_Mail_Marketing;
	
	public void setToLstAffiliate_Marketing(String toName){
		Select toMailLst_Marketing=new Select(this.to_Mail_Marketing);
		toMailLst_Marketing.selectByVisibleText(toName);
	}
	
	public String getToLstAffiliate_Marketing(){
		return this.to_Mail_Marketing.getText();
	}
	
	//setting the subject line of the mail
	@FindBy(xpath="//input[@placeholder='Subject']")
	private WebElement subject_Mail_Marketing;
	
	public void setSubject_Mail_Marketing(String subject){
		this.subject_Mail_Marketing.clear();
		this.subject_Mail_Marketing.sendKeys(subject);
	}

	public String getSubject_Mail_Marketing(){
		return this.subject_Mail_Marketing.getText();
	}
	
	//setting the msg line of the mail
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[8]/div[1]/div[1]/div[3]/div[2]")
	private WebElement msg_Mail_Marketing;
		
	public void setMsg_Mail_Marketing(String msg){
		this.msg_Mail_Marketing.clear();
		this.msg_Mail_Marketing.sendKeys(msg);
	}
	
	public String getMsg_Mail_Marketing(){
		return this.msg_Mail_Marketing.getText();
	}
	
	//click on send button
	@FindBy(xpath="//button[@id='button-send']")
	private WebElement send_Mail_Marketing;
	
	public void clickSend_Mail_Marketing(){
		this.send_Mail_Marketing.click();
	}
	
	//getting the default values of From field
	@FindBy(xpath="//select[@name='store_id']")
	private WebElement fromFld_Mail_Marketing;
	
	public String getFromFld_Mail_Marketing(){
		return this.fromFld_Mail_Marketing.getText();
	}

}

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//log in as Admin
public class AdminLoginPOM {
	private WebDriver driver;

	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//login page text field
	@FindBy(xpath="//h1[@class='panel-title']")
	private WebElement loginTitle;
	
	//getting the login window title
	public String getLoginTitle(){
		return this.loginTitle.getText();
	}
	
	// user name field
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userName;
	
	// set password field
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	
	// submit button
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;

	// set user name
	public void sendUserName(String userName) {
		this.userName.sendKeys(userName);
	}

	// set password
	public void sendPassWord(String password) {
		this.password.sendKeys(password);
	}

	// click submit button
	public void clickSubmitBtn() {
		this.submitBtn.click();
	}
}

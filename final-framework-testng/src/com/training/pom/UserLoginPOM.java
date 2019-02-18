package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPOM {
	private WebDriver driver;

	public UserLoginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// logout confirmation field
	@FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
	private WebElement logOutConf;

	// getting the log out confirmation value
	public String getLogOutConf() {
		return this.logOutConf.getText();
	}

	// my account field to get log in button
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAcc;

	// clicking on my account link
	public void clickMyAccount() {
		this.myAcc.click();
	}

	// log in field
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement login;

	// clicking on log
	public void clickLogin() {
		this.login.click();
	}

	// email address field
	@FindBy(xpath = "//input[@placeholder='E-Mail Address']")
	private WebElement eMailAddress;
	// password field
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	// login button
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;

	// setting the email address
	public void sendEMailAddress(String emailAdd) {
		this.eMailAddress.sendKeys(emailAdd);
	}

	// setting the password
	public void sendPassWord(String password) {
		this.password.sendKeys(password);
	}

	// clicking on the log in button
	public void clickLoginBtn() {
		this.loginBtn.click();
	}
}

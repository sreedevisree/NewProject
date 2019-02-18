package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformStorePOM {
	private WebDriver driver; 
		
	public UniformStorePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//user name field
	@FindBy(xpath="//span[contains(text(),'SreedeviTest test')]")
	private WebElement userName;
	
	//clicking on user name
	public void clickUserName(){
		this.userName.click();
	}
	
	//log out 
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'Logout')]")
	private WebElement logOut;
	
	//clicking on log out button
	public void clickLogOut(){
		this.logOut.click();
	}

}

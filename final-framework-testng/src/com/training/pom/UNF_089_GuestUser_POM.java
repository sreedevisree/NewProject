package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_089_GuestUser_POM {
	private WebDriver driver;

	public UNF_089_GuestUser_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//clicking on one of the uniform
	@FindBy(xpath="//img[@title='REGULAR T-SHIRTS (Rust)']")
	private WebElement adduniform_GuestLogin;
	
	public void clickAdduniform_GuestLogin(){
	this.adduniform_GuestLogin.click();
	}

	//click on chest size
	@FindBy(xpath="//select[@id='input-option376']")
	private WebElement chestSize_GuestLogin;
	
	public void setChestSize_GuestLogin(String chestSize) {
		Select chestSizeSel=new Select(chestSize_GuestLogin);
		chestSizeSel.selectByVisibleText(chestSize);
		
	}
	
	//click on close button of the image
	@FindBy(xpath="//div[@class='mfp-figure']//figure")
	private WebElement close_GuestLogin;
	
	public void clickClose_GuestLogin(){
		driver.switchTo().activeElement().click();
		//this.close_GuestLogin.click();
	}
	
	//clicking on add to cart
	@FindBy(id="button-cart")
	private WebElement addToCart_GuestLogin;
	
	public void clickAddToCart_GuestLogin(){
		this.addToCart_GuestLogin.click();
	}
	
	//clicking on the cart
	@FindBy(xpath="/html[1]/body[1]/nav[1]/header[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/div[1]/button[1]")
	private WebElement cart_GuestLogin;
	
	public void clickCart_GuestLogin() throws AWTException{
		this.cart_GuestLogin.click();
	}
	
	//clicking on view cart button
	@FindBy(xpath="//strong[contains(text(),'View Cart')]")
	private WebElement viewCart_GuestLogin;
	
	public void clickViewCart_GuestLogin(){
		this.viewCart_GuestLogin.click();
	}
	
	//click on checkout
	@FindBy(xpath="//strong[contains(text(),'Checkout')]")
	private WebElement checkOut_GuestLogin;
	
	public void clickCheckOut_GuestLogin(){
		this.checkOut_GuestLogin.click();
	}
}

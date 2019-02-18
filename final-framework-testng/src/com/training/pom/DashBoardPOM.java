package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPOM {
	private WebDriver driver; 
		
	public DashBoardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Customer activity link
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	private WebElement customerActivity;
	
	//clicking on customer activity
	public void clickCustomerActivityLnk(){
		this.customerActivity.click();
	}
	
	//customer link
	@FindBy(xpath="//a[@class='parent'][contains(text(),'Customers')]")
	private WebElement customerLnk;
	
	//clicking on customre link
	public void clickCustomerLnk(){
		this.customerLnk.click();
	}
	
	//customer online link
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[3]/ul[1]/li[1]/a[1]")
	private WebElement customerOnlineLnk;
	
	//clicking on customer online link
	public void clickCustomerOnlineLnk(){
		this.customerOnlineLnk.click();
	}
	
	//logout button
	@FindBy (xpath="//span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement logOutBtn;
	
	//report list
	@FindBy (xpath="//li[@id='reports']")
	private WebElement reportLst;
	
	//product list field
	@FindBy (xpath="//a[@class='parent'][contains(text(),'Products')]")
	private WebElement prodLst;
	
	//purchase field
	@FindBy (xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
	private WebElement purchase;
	
	//clicking on report list
	public void clickreportLst(){
		this.reportLst.click();
	}
	
	//clicking on product list
	public void clickProdLst(){
		this.prodLst.click();
	}
	
	//clicking on purchase 
	public void clickPurchase(){
		this.purchase.click();
	}
	
	//clicking on log out button
	public void clickLogOutBtn(){
		this.logOutBtn.click();
	}

}

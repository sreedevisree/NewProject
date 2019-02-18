package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPurchasedReportPOM {
	private WebDriver driver; 
	
	public ProductPurchasedReportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//order status field	
	@FindBy (xpath="//select[@name='filter_order_status_id']")
	private WebElement orderStatus;
	
	//filter button
	@FindBy(xpath="//button[contains(text(),'Filter')]")
	private WebElement filterBtn;
	
	//product name field
	@FindBy(xpath="//td[contains(text(),'Product Name')]")
	private WebElement prodName;
	
	//getting the product name
	public String getProdNameHeader(){
		return this.prodName.getText();
	}
	
	//clicking on order status field
	public void clickOrderStatus(){
		Select orderStatusOpt= new Select(orderStatus);
		orderStatusOpt.selectByIndex(0);
	}
	
	//clciking on filter button
	public void clickFilterBtn(){
		this.filterBtn.click();
	}

}

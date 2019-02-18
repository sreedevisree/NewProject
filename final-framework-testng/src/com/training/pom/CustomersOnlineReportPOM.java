package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersOnlineReportPOM {
	private WebDriver driver;

	public CustomersOnlineReportPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// customer name field
	@FindBy(xpath = "//input[@placeholder='Customer']")
	private WebElement customerTestBox;

	// setting customer name
	public void setCustomerTestBox(String custName) {
		this.customerTestBox.sendKeys(custName);
	}

	// filter button
	@FindBy(xpath = "//button[@id='button-filter']")
	private WebElement filterBtn;

	// clicking on filter button
	public void clickFilterBtn() {
		this.filterBtn.click();
	}

	// customer name from the table
	@FindBy(xpath = "//td[contains(text(),'SreedeviTest test')]")
	private WebElement customerValue;

	// getting the customer name from the table
	public String getCustomerValue() {
		return this.customerValue.getText();
	}

}

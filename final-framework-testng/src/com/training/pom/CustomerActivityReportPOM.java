package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerActivityReportPOM {
	private WebDriver driver;

	public CustomerActivityReportPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// comment text field
	@FindBy(xpath = "//div[@id='container']//tbody//tr[1]//td[1]")
	private WebElement commentValue;

	// getting the comment value
	public String getComment() {
		return this.commentValue.getText();
	}

	// customer test field
	@FindBy(xpath = "//input[@name='filter_customer']")
	private WebElement customerTextBox;

	// setting the customer name field
	public void setCustomerName(String custName) {
		this.customerTextBox.sendKeys(custName);
	}

	// filter button
	@FindBy(xpath = "//button[@id='button-filter']")
	private WebElement filterBtn;

	// clicking on filter button
	public void clickFilterBtn() {
		this.filterBtn.click();
	}
}

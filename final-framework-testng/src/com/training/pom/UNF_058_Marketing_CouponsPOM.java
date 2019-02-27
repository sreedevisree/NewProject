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

public class UNF_058_Marketing_CouponsPOM {
	private WebDriver driver;

	public UNF_058_Marketing_CouponsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on add new coupons icon
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewCoupons_Marketing;

	public void clickAddNewCoupons_Marketing() {
		this.addNewCoupons_Marketing.click();
	}

	// set values in Coupon Name textbox
	@FindBy(xpath = "//input[@placeholder='Coupon Name']")
	private WebElement couponName_CouponsTab_Marketing;

	public void setCouponName_CouponsTab_Marketing(String coupon) {
		this.couponName_CouponsTab_Marketing.sendKeys(coupon);
	}
	
	// set values in Code textbox
	@FindBy(xpath = "//input[@id='input-code']")
	private WebElement code_CouponsTab_Marketing;

	public void setCode_CouponsTab_Marketing(String code) {
		this.code_CouponsTab_Marketing.sendKeys(code);
	}
	
	// set values in discount textbox
	@FindBy(xpath = "//input[@id='input-discount']")
	private WebElement discount_CouponsTab_Marketing;

	public void setDiscount_CouponsTab_Marketing(String discount) {
		this.discount_CouponsTab_Marketing.sendKeys(discount);
	}

	// set values in product textbox

	public void setProduct_CouponsTab_Marketing(String product) {
		driver.findElement(By.xpath("//input[@id='input-product']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+product+"')]")).click();
				
	}
	
	// select the date start from the date picker
	@FindBy(xpath = "//input[@placeholder='Date Start']")
	private WebElement dateStart_CouponsTab_Marketing;

	// clicking on the start date and getting the current date
	public void setDateStart_CouponsTab_Marketing() {
		this.dateStart_CouponsTab_Marketing.clear();
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String today1 = (String) (formattedDate.format(c.getTime()));
		this.dateStart_CouponsTab_Marketing.sendKeys(today1);
	}

	// select the end date from the date picker as current date pulse 1
	@FindBy(xpath = "//input[@id='input-date-end']")
	private WebElement dateEnd_CouponsTab_Marketing;

	// clicking on the start date and getting the current date
	public void setDateEnd_CouponsTab_Marketing() {
		this.dateEnd_CouponsTab_Marketing.clear();
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		String tomorrow = (String) (formattedDate.format(c.getTime()));
		System.out.println("tomorrows date is "+tomorrow);
		this.dateEnd_CouponsTab_Marketing.sendKeys(tomorrow);
	}

	//clicking on the save icon
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveIcn_CouponsTab_Marketing;
	
	public void clickSaveIcn_CouponsTab_Marketing(){
		this.saveIcn_CouponsTab_Marketing.click();
	}
	
	//getting the error message from the code text
	@FindBy(xpath="//*[@id='tab-general']/div[2]/div/div")
	private WebElement ErrorMsg_CouponsTab_Marketing;
	
	public String getErrorMsg_CouponsTab_Marketing(){
		return this.ErrorMsg_CouponsTab_Marketing.getText();
	}
	
	//getting the saved message from the code text
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]/text()")
	private WebElement couponSavedMsg_CouponsTab_Marketing;
	
	public String getCouponSavedMsg_CouponsTab_Marketing(){
		return this.couponSavedMsg_CouponsTab_Marketing.getText();
	}	
}

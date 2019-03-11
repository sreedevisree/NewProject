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
	// ********************Start of Customer icon
	//clicking on customer icon of the dashboard
	@FindBy(xpath="//li[@id='customer']")
	private WebElement customerIcn;
	
	public void clickCustomerIcn(){
		this.customerIcn.click();
	}
	
	// Click on Customer Groups link
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[2]/a[1]")
	private WebElement CustGrp_CustomerIcn;
	
	public void clickCustGrp_CustomerIcn(){
		this.CustGrp_CustomerIcn.click();
	}
	
	// ********************End of Customer icon
	
	// ********************Start of Marketing section
	//clicking on customer group
	@FindBy(xpath="//a[contains(text(),'Customer Groups')]")
	private WebElement customerGroup_CustomerLnk;
	
	public void clickCustomerGroup_CustomerLnk(){
		this.customerGroup_CustomerLnk.click();
	}
	
	//clicking on the customer link
	@FindBy(xpath="//li[@class='active open']//a[contains(text(),'Customers')]")
	private WebElement custLnk_CustomerLnk;
	
	public void clickCustLnk_CustomerLnk(){
		this.custLnk_CustomerLnk.click();
	}
	
	// ********************End of Marketing section
	
	// ********************Start of Marketing section
	// clicking on Marketing icon
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[7]/a[1]")
	private WebElement marketingIcn;

	public void clickMarketingIcn() {
		this.marketingIcn.click();
	}

	//Click on Affiliates link
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[7]/ul[1]/li[2]/a[1]")
	private WebElement affiliatesLnk_Marketing;
	
	public void clickAffiliates_MarketingIcn(){
		this.affiliatesLnk_Marketing.click();
	}
	
	//Click on Mail link
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[7]/ul[1]/li[4]/a[1]")
	private WebElement mailLnk_Marketing;
	
	public void clickMail_MarketingIcn(){
		this.mailLnk_Marketing.click();
	}	
	
	// clicking on Coupons link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[7]/ul[1]/li[3]/a[1]")
	private WebElement couponsLnk_MarketingIcn;

	public void clickCouponsLnk_MarketingIcn() {
		this.couponsLnk_MarketingIcn.click();
	}

	// ********************End of Marketing section
	// Catelog icon from dashboard
	@FindBy(xpath = "//i[@class='fa fa-tags fa-fw']")
	private WebElement catelogIcn;

	// clicking on Catelog icon from dashboard
	public void clickCatelogIcn() {
		this.catelogIcn.click();
	}

	// Products link from Catelog icon
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[2]")
	private WebElement productsLnk;

	// clicking on Products link from Catelog icon
	public void clickCatelogProductLnk() {
		this.productsLnk.click();
	}

	// Customer activity link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	private WebElement customerActivity;

	// clicking on customer activity
	public void clickCustomerActivityLnk() {
		this.customerActivity.click();
	}

	// customer link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[6]/a[1]/i[1]")
	private WebElement customerLnk;

	// clicking on customre link
	public void clickCustomerLnk() {
		this.customerLnk.click();
	}

	// customer online link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[3]/ul[1]/li[1]/a[1]")
	private WebElement customerOnlineLnk;

	// clicking on customer online link
	public void clickCustomerOnlineLnk() {
		this.customerOnlineLnk.click();
	}

	// logout button
	@FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement logOutBtn;

	// report list
	@FindBy(xpath = "//li[@id='reports']")
	private WebElement reportLst;

	// product list field
	@FindBy(xpath = "//a[@class='parent'][contains(text(),'Products')]")
	private WebElement prodLst;

	// purchase field
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
	private WebElement purchase;

	// clicking on report list
	public void clickreportLst() {
		this.reportLst.click();
	}

	// clicking on product list
	public void clickProdLst() {
		this.prodLst.click();
	}

	// clicking on purchase
	public void clickPurchase() {
		this.purchase.click();
	}

	// clicking on log out button
	public void clickLogOutBtn() {
		this.logOutBtn.click();
	}

}

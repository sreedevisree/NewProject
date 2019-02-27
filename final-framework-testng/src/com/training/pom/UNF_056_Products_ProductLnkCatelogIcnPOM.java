package com.training.pom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_056_Products_ProductLnkCatelogIcnPOM {
	private WebDriver driver;

	public UNF_056_Products_ProductLnkCatelogIcnPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Adding products to products list : add icon
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addProductIcon_ProductListPage;
	
	//clicking on the add product icon on products list
	public void clickAddProductIcon__ProductListPage(){
		this.addProductIcon_ProductListPage.click();
	}
	
	
	
	// Quantity textbox of Discount tab
	@FindBy(xpath = "//input[@name='product_discount[0][quantity]']")
	private WebElement quantity_DiscountTab;

	// clicking on Quantity textbox of Discount tab
	public void setQuantity_DiscountTab() {
		this.quantity_DiscountTab.sendKeys("1");
	}

	// confirmation message on the Products
	@FindBy(xpath = "//*[@id='content']/div[2]/div[1]")
	private WebElement confirmationMsg_Products;

	public String getConfirmationMsg_Products() {
		return this.confirmationMsg_Products.getText();
	}

	// clicking on the save button from the edit product screen
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement saveBtn_DiscountTab;

	public void clickSaveBtn_DiscountTab() {
		this.saveBtn_DiscountTab.click();
	}

	// select the date start from the date picker
	@FindBy(xpath = "//input[@placeholder='Date Start']")
	private WebElement dateStart_DiscountTab;

	// clicking on the start date and getting the current date
	public void setDateStart_DiscountTab() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String today1 = (String) (formattedDate.format(c.getTime()));
		this.dateStart_DiscountTab.sendKeys(today1);
	}

	// select the end date from the date picker as current date pulse 1
	@FindBy(xpath = "//input[@placeholder='Date End']")
	private WebElement dateEnd_DiscountTab;

	// clicking on the start date and getting the current date
	public void setDateEnd_DiscountTab() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		String tomorrow = (String) (formattedDate.format(c.getTime()));
		this.dateEnd_DiscountTab.sendKeys(tomorrow);
	}

	// Price textbox of Discount tab
	@FindBy(xpath = "//td[@class='text-right']//input[@placeholder='Price']")
	private WebElement price_DiscountTab;

	// setting a value to Price textbox of Discount tab
	public void setPrice_DiscountTab() {
		this.price_DiscountTab.sendKeys("50");
	}

	// Add discount icon
	@FindBy(xpath = "//table[@id='discount']//i[@class='fa fa-plus-circle']")
	private WebElement addDiscountIcn;

	// click on add discount icon
	public void clickAddDiscountIcn() {
		this.addDiscountIcn.click();
	}

	// Data tab
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	private WebElement dataTab;

	// clickin on Data tab
	public void clickDataTab() {
		this.dataTab.click();
	}

	// Quantity textbox
	@FindBy(xpath = "//input[@placeholder='Quantity']")
	private WebElement quantity;

	// setting the quantity
	public void setQuantity() {
		this.quantity.clear();
		this.quantity.sendKeys("30");
	}

	// Discount tab
	@FindBy(xpath = "//a[contains(text(),'Discount')]")
	private WebElement discountTab;

	// click on Discount tab
	public void clickDiscountTab() {
		this.discountTab.click();
	}

	// Editing the productname
	@FindBy(xpath = "//td[@class='text-right']//a[@class='btn btn-primary']")
	private WebElement editBox;

	// clicking on the edit box of the product name
	public void clickEditProductName() {
		this.editBox.click();
	}

	// Filter button
	@FindBy(xpath = "//button[@id='button-filter']")
	private WebElement filterBtn;

	// clicking on filterBtn
	public void clickFilterBtn() {
		this.filterBtn.click();
	}

	// Product from Catelog_Product
	@FindBy(xpath = "//input[@placeholder='Product Name']")
	private WebElement productName_ProductLnk_CatelogIcn;

	// setting a product vlaue in Product from Catelog_Product
	public void setProductName_ProductLnk_CatelogIcn(String productName) {
		this.productName_ProductLnk_CatelogIcn.sendKeys(productName);
	}
}

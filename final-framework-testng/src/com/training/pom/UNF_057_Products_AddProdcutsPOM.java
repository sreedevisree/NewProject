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

public class UNF_057_Products_AddProdcutsPOM {
	private WebDriver driver;

	public UNF_057_Products_AddProdcutsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Adding products details to the Link tab of the Add products page of
	// Link tab
	@FindBy(xpath = "//a[contains(text(),'Links')]")
	private WebElement linkTab_ProductsPage;

	// clicking on the data tab of the products page
	public void clickLinkTab_ProductsPage() {
		this.linkTab_ProductsPage.click();
	}

	// Adding products details to the Link tab of the Add products page of
	// Link tab:Categories text
	@FindBy(xpath = "//input[@id='input-category']")
	private WebElement categorieslinkTab_ProductsPage;

	// clicking on the Categories of data tab of the products page
	public void clickCategoriesLinkTab_ProductsPage() {
		this.categorieslinkTab_ProductsPage.click();
	}

	// Adding products details to the Link tab of the Add products page of
	// Link tab:selecting the Categories value from the select box
	// clicking on the Categories of Link tab of the products page
	public void setSelectValueOfCategorieslinkTab_ProductsPage(String categoriesValue) {
		driver.findElement(By.xpath("//a[contains(text(),'" + categoriesValue + "')]")).click();
	}

	// Adding products details to the Link tab of the Add products page of
	// Link tab:Categories text after adding the iteams
	@FindBy(xpath = "//body/div/div/div[@class='container-fluid']/div[@class='panel panel-default']/div[@class='panel-body']/form[@class='form-horizontal']/div[@class='tab-content']/div[@class='tab-pane active']/div[2]/div[1]/div[1]")
	private WebElement categoriesSelecedlinkTab_ProductsPage;

	// Getting the added selected Categories of the Link tab from products page
	public String getCategoriesSelecedlinkTab_ProductsPage() {
		return this.categoriesSelecedlinkTab_ProductsPage.getText();
	}

	// Adding products details to the Discount tab of the Add products page of
	// Discount tab:
	@FindBy(xpath = "//a[contains(text(),'Discount')]")
	private WebElement discountTab_ProductsPage;

	// clicking on the discount tab of the products page
	public void clickDiscountTab_ProductsPage() {
		this.discountTab_ProductsPage.click();
	}

	// Adding products details to the Discount tab of the Add products page of
	// Discount tab: Add Icon
	@FindBy(xpath = "//table[@id='discount']//button[@type='button']")
	private WebElement addIcn_discountTab_ProductsPage;

	// clicking on the Add Icon of discount tab of the products page
	public void clickAddIcn_discountTab_ProductsPage() {
		this.addIcn_discountTab_ProductsPage.click();
	}

	// Adding products details to the Discount tab of the Add products page of
	// Discount tab: Quantity text box
	@FindBy(xpath = "//td[@class='text-right']//input[@name='product_discount[0][quantity]']")
	private WebElement quantityTxt_discountTab_ProductsPage;

	// setting the quantity in discount tab of the products page
	public void setQuantityTxt_discountTab_ProductsPage(String quantity) {
		this.quantityTxt_discountTab_ProductsPage.sendKeys(quantity);
	}

	// Adding products details to the Discount tab of the Add products page of
	// Discount tab: Price text box
	@FindBy(xpath = "//td[@class='text-right']//input[@placeholder='Price']")
	private WebElement priceTxt_discountTab_ProductsPage;

	// setting the quantity in discount tab of the products page
	public void setpriceTxt_discountTab_ProductsPage(String price) {
		this.priceTxt_discountTab_ProductsPage.sendKeys(price);
	}

	// Adding products details to the Discount tab of the Add products page of
	// Discount tab: Price text box
	// select the date start from the date picker
	@FindBy(xpath = "//input[@placeholder='Date Start']")
	private WebElement dateStart_DiscountTab_ProductsPage;

	// clicking on the start date and getting the current date
	public void setDateStart_DiscountTab() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String today1 = (String) (formattedDate.format(c.getTime()));
		this.dateStart_DiscountTab_ProductsPage.sendKeys(today1);
	}

	// select the end date from the date picker as current date pulse 1
	@FindBy(xpath = "//input[@placeholder='Date End']")
	private WebElement dateEnd__DiscountTab_ProductsPage;

	// clicking on the start date and getting the current date
	public void setDateEnd_DiscountTab() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		String tomorrow = (String) (formattedDate.format(c.getTime()));
		this.dateEnd__DiscountTab_ProductsPage.sendKeys(tomorrow);
	}

	// Saving products details to the Discount tab of the Add products page of
	// Submit Icon
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveIcn_ProductsPage;

	// clicking on the save button of the products page
	public void clickSave_ProductsPage() {
		this.saveIcn_ProductsPage.click();
		;
	}

	// confirmation message
	@FindBy(xpath = "//*[@id='content']/div[2]/div[1]")
	private WebElement confMsg_ProductsPage;

	// getting the confirmation message after saving
	public String getConfMsg_ProductsPage() {
		return this.confMsg_ProductsPage.getText();
	}

	// Adding products details to the Data tab of the Add products page of
	// Data tab
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	private WebElement dataTab_ProductsPage;

	// clicking on the data tab of the products page
	public void clickDataTab_ProductsPage() {
		this.dataTab_ProductsPage.click();
	}

	// Adding products details to the Data tab of the Add products page
	// Data tab: Model textbox
	@FindBy(xpath = "//input[@id='input-model']")
	private WebElement model_dataTab_ProductsPage;

	// clicking on the data tab of the products page
	public void setModel_dataTab_ProductsPage(String modelName) {
		this.model_dataTab_ProductsPage.clear();
		this.model_dataTab_ProductsPage.sendKeys(modelName);
	}

	// Adding products details to the Data tab of the Add products page
	// Data tab: Price textbox
	@FindBy(xpath = "//input[@id='input-price']")
	private WebElement price_dataTab_ProductsPage;

	// clicking on the data tab of the products page
	public void setPrice_dataTab_ProductsPage(String price) {
		this.price_dataTab_ProductsPage.clear();
		this.price_dataTab_ProductsPage.sendKeys(price);
	}

	// Adding products details to the Data tab of the Add products page
	// Data tab: Quantity textbox
	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement quantity_dataTab_ProductsPage;

	// clicking on the data tab of the products page
	public void setQuantity_dataTab_ProductsPage(String quantity) {
		this.quantity_dataTab_ProductsPage.clear();
		this.quantity_dataTab_ProductsPage.sendKeys(quantity);
	}

	// Adding products details to the General tab of the Add products page of
	// Genral tab : Product Name
	@FindBy(xpath = "//input[@id='input-name1']")
	private WebElement ProductName_GenralTab_ProductsPage;

	// clicking on the add product icon on products list
	public void setProductName_GenralTab_ProductsPage(String productName) {
		this.ProductName_GenralTab_ProductsPage.clear();
		this.ProductName_GenralTab_ProductsPage.sendKeys(productName);
	}

	// Adding products details to the General tab of the Add products page of
	// products : Meta Tag Title
	@FindBy(xpath = "//input[@id='input-meta-title1']")
	private WebElement metaTagTitle_GenralTab_ProductsPage;

	// clicking on the add product icon on products list
	public void setMetaTagTitle_GenralTab_ProductsPage(String metaTagTitleName) {
		this.metaTagTitle_GenralTab_ProductsPage.clear();
		this.metaTagTitle_GenralTab_ProductsPage.sendKeys(metaTagTitleName);
	}
}

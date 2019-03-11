package com.training.pom;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_090_Products_POM {
	private WebDriver driver;

	public UNF_090_Products_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//adding product details of the catalog icon
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addProd_CatalogIcn;
	
	public void clickAddProd_CatalogIcn(){
		this.addProd_CatalogIcn.click();
	}
	
	//clicking on save button
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn_CatalogIcn;
	
	public void clickSaveBtn_CatalogIcn(){
		this.saveBtn_CatalogIcn.click();
	}
	
	//get the confirmation message
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement confirProdMsg__CatalogIcn;
	
	public String getConfirProdMsg__CatalogIcn(){
		return this.confirProdMsg__CatalogIcn.getText();
	}
	
	//*************Start of Genral Tab
	@FindBy(id="input-name1")
	private WebElement prodName_GenralTab_ProductLnk_CatalogIcn;
	
	public void setProdName_GenralTab_ProductLnk_CatalogIcn(String prodName){
		this.prodName_GenralTab_ProductLnk_CatalogIcn.sendKeys(prodName);
	}
	
	//clicking on Meta Tag Title
	@FindBy(id="input-meta-title1")
	private WebElement metaTitle_GenralTab_ProductLnk_CatalogIcn;
	
	public void setMetaTitle_GenralTab_ProductLnk_CatalogIcn(String metaTitle){
		this.metaTitle_GenralTab_ProductLnk_CatalogIcn.sendKeys(metaTitle);
	}
	//*************End of Genral Tab

	//*************start of Data Tab
	
	//click on Data tab
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab_DataTab_ProductLnk_CatalogIcn;
	
	public void clickDataTab_GenralTab_ProductLnk_CatalogIcn(){
		this.dataTab_DataTab_ProductLnk_CatalogIcn.click();
	}

	//setting the model textbox
	@FindBy(id="input-model")
	private WebElement modelNo_DataTab_ProductLnk_CatalogIcn;
	
	public void setModelNo_DataTab_ProductLnk_CatalogIcn(String modelNo){
		this.modelNo_DataTab_ProductLnk_CatalogIcn.clear();
		this.modelNo_DataTab_ProductLnk_CatalogIcn.sendKeys(modelNo);
	}
	
	//setting the price 
	@FindBy(id="input-price")
	private WebElement price_DataTab_ProductLnk_CatalogIcn;
	
	public void setPrice__DataTab_ProductLnk_CatalogIcn(String price){
		this.price_DataTab_ProductLnk_CatalogIcn.clear();
		this.price_DataTab_ProductLnk_CatalogIcn.sendKeys(price);
	}
	
	//setting the quantity
	@FindBy(id="input-quantity")
	private WebElement quantity_DataTab_ProductLnk_CatalogIcn;
	
	public void setQuantity_DataTab_ProductLnk_CatalogIcn(String quantity){
		this.quantity_DataTab_ProductLnk_CatalogIcn.clear();
		this.quantity_DataTab_ProductLnk_CatalogIcn.sendKeys(quantity);
	}
	//*************End of Data Tab
	
	//*************Start of Links Tab
	//clicking on links tab
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement linkTab_ProductLnk_CatalogIcn;
	
	public void clickLinkTab_ProductLnk_CatalogIcn(){
		this.linkTab_ProductLnk_CatalogIcn.click();
	}
	
	//selecting the value from catagory dropdown
	@FindBy(id="input-category")
	private WebElement category_LinkTab_ProductLnk_CatalogIcn;
	
	public void setCategory_LinkTab_ProductLnk_CatalogIcn(String category){
		this.category_LinkTab_ProductLnk_CatalogIcn.click();
		////a[contains(text(),'Blazers Test(5-7)')]
		driver.findElement(By.xpath("//a[contains(text(),'"+category+"')]")).click();		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		/*Select categorySel=new Select(this.category_LinkTab_ProductLnk_CatalogIcn);
		categorySel.selectByVisibleText(category);*/
	}
	
	//*************End of Links Tab
	
	//*************Start of Discount Tab
	//click on discount
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	private WebElement discountTab_ProductLnk_CatalogIcn;
	
	public void clickDiscountTab_ProductLnk_CatalogIcn(){
		this.discountTab_ProductLnk_CatalogIcn.click();
	}
	
	@FindBy(xpath="//table[@id='discount']//button[@type='button']")
	private WebElement addDiscount_DiscountTab_ProductLnk_CatalogIcn;
	
	public void clickAddDiscount_DiscountTab_ProductLnk_CatalogIcn(){
		this.addDiscount_DiscountTab_ProductLnk_CatalogIcn.click();
	}
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	private WebElement quantity_DiscountTab_ProductLnk_CatalogIcn;
	
	public void setQuantity_DiscountTab_ProductLnk_CatalogIcn(String quantity){
		this.quantity_DiscountTab_ProductLnk_CatalogIcn.clear();
		this.quantity_DiscountTab_ProductLnk_CatalogIcn.sendKeys(quantity);
	}
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	private WebElement price_DiscountTab_ProductLnk_CatalogIcn;
	
	public void setPrice_DiscountTab_ProductLnk_CatalogIcn(String price){
		this.price_DiscountTab_ProductLnk_CatalogIcn.clear();
		this.price_DiscountTab_ProductLnk_CatalogIcn.sendKeys(price);
	}
	
	@FindBy(xpath = "//input[@placeholder='Date Start']")
	private WebElement dateStart_DiscountTab_ProductLnk_CatalogIcn;

	// clicking on the start date and getting the current date
	public void setDateStart_DiscountTab_ProductLnk_CatalogIcn() {
		this.dateStart_DiscountTab_ProductLnk_CatalogIcn.clear();
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String today1 = (String) (formattedDate.format(c.getTime()));
		this.dateStart_DiscountTab_ProductLnk_CatalogIcn.sendKeys(today1);
	}

	// select the end date from the date picker as current date pulse 1
	@FindBy(xpath = "//input[@placeholder='Date End']")
	private WebElement dateEnd_DiscountTab_ProductLnk_CatalogIcn;

	// clicking on the start date and getting the current date
	public void setDateEnd_DiscountTab_ProductLnk_CatalogIcn() {
		this.dateEnd_DiscountTab_ProductLnk_CatalogIcn.clear();
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		String tomorrow = (String) (formattedDate.format(c.getTime()));
		System.out.println("tomorrows date is "+tomorrow);
		this.dateEnd_DiscountTab_ProductLnk_CatalogIcn.sendKeys(tomorrow);
	}
	//*************End of Discount Tab
	
	//*************Start of Rewards Point Tab
	//clicking on rewards point tab
	@FindBy(xpath="//a[@href='#tab-reward']")
	private WebElement rewardPtTab_ProductLnk_CatalogIcn;
	
	public void clickRewardPtTab_ProductLnk_CatalogIcn(){
		this.rewardPtTab_ProductLnk_CatalogIcn.click();
	}
	
	//setting the points
	@FindBy(id="input-points")
	private WebElement points_RewardsPtTab_ProductLnk_CatalogIcn;
	
	public void setPoints_RewardsPtTab_ProductLnk_CatalogIcn(String points){
		this.points_RewardsPtTab_ProductLnk_CatalogIcn.clear();
		this.points_RewardsPtTab_ProductLnk_CatalogIcn.sendKeys(points);
	}
	
	//*************End of Rewards Point Tab	
	
	
	

}
;
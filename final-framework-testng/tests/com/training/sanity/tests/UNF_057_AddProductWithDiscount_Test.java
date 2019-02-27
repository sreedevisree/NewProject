package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.UNF_056_Products_ProductLnkCatelogIcnPOM;
import com.training.pom.UNF_057_Products_AddProdcutsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_057_AddProductWithDiscount_Test {
	private WebDriver driver;
	String adminURL;
	private static Properties properties;
	private ScreenShot screenShot;
	AdminLoginPOM adminLogin;
	DashBoardPOM dbp;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLogin = new AdminLoginPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		driver.get(adminURL);
		adminLogin.sendUserName("admin");
		adminLogin.sendPassWord("admin@123");
		adminLogin.clickSubmitBtn();
		screenShot.captureScreenShot("Login_UNF_057.png");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	// adding details to the Genral tab
	@Test(priority = 0)
	public void addproductsToGenralTab() {
		DashBoardPOM dPOM = new DashBoardPOM(driver);
		dPOM.clickCatelogIcn();
		dPOM.clickCatelogProductLnk();

		// 3. Click on Add New icon
		UNF_056_Products_ProductLnkCatelogIcnPOM pplciPOM = new UNF_056_Products_ProductLnkCatelogIcnPOM(driver);
		pplciPOM.clickAddProductIcon__ProductListPage();
		String productName = "Shoes";
		UNF_057_Products_AddProdcutsPOM papPOM = new UNF_057_Products_AddProdcutsPOM(driver);
		papPOM.setProductName_GenralTab_ProductsPage(productName);

		// 5. Enter Valid credentials in Meta Tag Title of General tab
		String metaTagTitleName = "Shoes for students";
		papPOM.setMetaTagTitle_GenralTab_ProductsPage(metaTagTitleName);
	}

	// adding details to the Data tab
	@Test(priority = 1)
	public void addproductsToDataTab() {
		// 6. Click on Data tab
		UNF_056_Products_ProductLnkCatelogIcnPOM pplciPOM = new UNF_056_Products_ProductLnkCatelogIcnPOM(driver);
		pplciPOM.clickDataTab();

		// 7. Enter valid credentials in Model textbox
		UNF_057_Products_AddProdcutsPOM papPOM = new UNF_057_Products_AddProdcutsPOM(driver);
		String modelName = "SHS-103";
		papPOM.setModel_dataTab_ProductsPage(modelName);
		// 8. Enter valid credentials in Price textbox
		String price = "1000";
		papPOM.setPrice_dataTab_ProductsPage(price);
		// 9. Enter valid credentials in Quantity textbox
		String quantity = "20";
		papPOM.setQuantity_dataTab_ProductsPage(quantity);
	}

	// adding details to the Link tab
	@Test(priority = 2)
	public void addproductsToLinkTab() {
		// 10. Click on Links tab
		UNF_057_Products_AddProdcutsPOM papPOM = new UNF_057_Products_AddProdcutsPOM(driver);
		papPOM.clickLinkTab_ProductsPage();

		// 11. Click on Categories textbox
		papPOM.clickCategoriesLinkTab_ProductsPage();

		// 12. Select Category from displayed category list
		String categoriesValue = "Sports Uniform";
		papPOM.setSelectValueOfCategorieslinkTab_ProductsPage(categoriesValue);
		Assert.assertTrue(categoriesValue.contains(papPOM.getCategoriesSelecedlinkTab_ProductsPage()));
		screenShot.captureScreenShot("Added Category of Link Tab_UNF_057.png");

	}

	// adding details to the Discount tab
	@Test(priority = 3)
	public void addproductsToDiscountTab() {
		// 13. Click on Discount tab
		UNF_057_Products_AddProdcutsPOM papPOM = new UNF_057_Products_AddProdcutsPOM(driver);
		papPOM.clickDiscountTab_ProductsPage();

		// 14. Click on Add discount icon
		papPOM.clickAddIcn_discountTab_ProductsPage();

		// 15. Enter valid credentials in Quantity textbox
		String quantity = "2";
		papPOM.setQuantityTxt_discountTab_ProductsPage(quantity);

		// 16. Enter valid credentials in Price textbox
		String price = "1000";
		papPOM.setpriceTxt_discountTab_ProductsPage(price);

		// 17. Select valid start date as current date
		papPOM.setDateStart_DiscountTab();

		// 18. Select valid end date as current date+one day
		papPOM.setDateEnd_DiscountTab();

		// 20. Click on Save icon
		papPOM.clickSave_ProductsPage();
		Assert.assertTrue(papPOM.getConfMsg_ProductsPage().contains("Success: You have modified products"));
		screenShot.captureScreenShot("Confirmation_Message_UNF_057.png");
	}

}

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_056_AddDiscountToExistingProduct_Test {
	private WebDriver driver;
	String adminURL;
	private static Properties properties;
	private ScreenShot screenShot;
	AdminLoginPOM adminLogin;
	DashBoardPOM dbp;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLogin = new AdminLoginPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		driver.get(adminURL);
		adminLogin.sendUserName("admin");
		adminLogin.sendPassWord("admin@123");
		adminLogin.clickSubmitBtn();
		screenShot.captureScreenShot("Login_UNF_056.png");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 1)
	public void addDiscountExistingProduct() throws Exception {
		//1. Click on Catelog icon
		DashBoardPOM dPOM = new DashBoardPOM(driver);
		dPOM.clickCatelogIcn();
		//2. Click on Products link
		dPOM.clickCatelogProductLnk();
		//3. Click on Edit icon of the Product
		UNF_056_Products_ProductLnkCatelogIcnPOM ppcPOM = new UNF_056_Products_ProductLnkCatelogIcnPOM(driver);
		String productName = "Girls Blazer(9th-12th STD)";
		ppcPOM.setProductName_ProductLnk_CatelogIcn(productName);
		ppcPOM.clickFilterBtn();
		ppcPOM.clickEditProductName();
		//4. Click on Data tab
		ppcPOM.clickDataTab();
		//5. Clear data from Quantity textbox and 6. Enter valid credentials in Quantity textbox
		ppcPOM.setQuantity();
		//7. Click on Discount tab
		ppcPOM.clickDiscountTab();
		//8. Click on Add discount icon
		ppcPOM.clickAddDiscountIcn();
		//9. Enter valid credentials in Quantity textbox
		ppcPOM.setQuantity_DiscountTab();
		//10. Enter valid credentials in Price textbox
		ppcPOM.setPrice_DiscountTab();
		//11. Select valid start date as current date
		ppcPOM.setDateStart_DiscountTab();
		//12. Select valid end date as current date+one day
		ppcPOM.setDateEnd_DiscountTab();
		//14. Click on Save icon
		ppcPOM.clickSaveBtn_DiscountTab();

		Assert.assertTrue(ppcPOM.getConfirmationMsg_Products().contains("Success: You have modified products"));

		screenShot.captureScreenShot("Confirmation Message_UNF_056.png");
	}

}

package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductPurchasedReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductPurchasedDetailsTest {
	private WebDriver driver;
	String adminURL;
	private static Properties properties;
	private ScreenShot screenShot;
	AdminLoginPOM adminLogin;// = new AdminLoginPOM(driver); 
	
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
		screenShot.captureScreenShot("Login_UNF_026.png");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority=1)
	public void productPurchasedDetails() {
		DashBoardPOM dashboard = new DashBoardPOM(driver);
		dashboard.clickreportLst();
		dashboard.clickProdLst();
		dashboard.clickPurchase();	
		ProductPurchasedReportPOM pprd = new ProductPurchasedReportPOM(driver);
		pprd.clickOrderStatus();
		String checkProd="Product Name";
		Assert.assertEquals(checkProd, pprd.getProdNameHeader());
		screenShot.captureScreenShot("Product_Purchased_details_UNF_026.png");
	}
}

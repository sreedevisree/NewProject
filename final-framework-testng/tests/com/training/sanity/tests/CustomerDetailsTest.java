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
import com.training.pom.CustomersOnlineReportPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductPurchasedReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CustomerDetailsTest {
	private WebDriver driver;
	String adminURL;
	private static Properties properties;
	private ScreenShot screenShot;
	AdminLoginPOM adminLogin;// = new AdminLoginPOM(driver);
	// DashBoardPOM dashboard = new DashBoardPOM(driver);

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
		screenShot.captureScreenShot("Login_Customer_UNF_027.png");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 1)
	public void dashboardSelection() {
		DashBoardPOM dashboard = new DashBoardPOM(driver);
		dashboard.clickreportLst();
		dashboard.clickCustomerLnk();
		CustomersOnlineReportPOM custOnlineReport = new CustomersOnlineReportPOM(driver);
		custOnlineReport.setCustomerTestBox("sreedeviTest test");
		custOnlineReport.clickFilterBtn();
		String checkCustName = "SreedeviTest test";
		Assert.assertEquals(checkCustName, custOnlineReport.getCustomerValue());
		screenShot.captureScreenShot("CustomerOnline_Customer_UNF_027.png");
	}
}

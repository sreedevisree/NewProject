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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.UNF_056_Products_ProductLnkCatelogIcnPOM;
import com.training.pom.UNF_057_Products_AddProdcutsPOM;
import com.training.pom.UNF_058_Marketing_CouponsPOM;
import com.training.pom.UNF_059_Marketing_AffiliatePOM;
import com.training.pom.UNF_060_SendEmailMarketingPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_060_SendEmailMarketing_Test {
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
		screenShot.captureScreenShot("Login_UNF_060.png");
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	// add discount to the product
	@Test(priority = 0)
	public void addDiscountToProduct() {
		// 1. Click on Marketing icon
		DashBoardPOM dPOM = new DashBoardPOM(driver);
		dPOM.clickMarketingIcn();

		// 2. Click on Mail link
		dPOM.clickMail_MarketingIcn();

		// 3. Select valid credentials in To list box
		UNF_060_SendEmailMarketingPOM smmPOM = new UNF_060_SendEmailMarketingPOM(driver);
		String toName = "All Affiliates";
		smmPOM.setToLstAffiliate_Marketing(toName);

		// 4. Enter valid credentials in Subject textbox
		String subject = "New Product Launch";
		smmPOM.setSubject_Mail_Marketing(subject);

		// 5. Enter valid credentials in Message textbox
		String msg = "New Product Launch to be launched on 25th  February 2019";
		smmPOM.setMsg_Mail_Marketing(msg);

		// 6. Click on Mail icon
		smmPOM.clickSend_Mail_Marketing();

		// 7. Select valid credentials in To list box
		toName = "Products";
		smmPOM.setToLstAffiliate_Marketing(toName);

		// 8. Enter valid credentials in Subject textbox
		subject = "Customers";
		smmPOM.setSubject_Mail_Marketing(subject);

		// 9. Enter valid credentials in Message textbox
		msg = "New Product Launch";
		smmPOM.setMsg_Mail_Marketing(msg);

		// 10. Click on Mail icon
		smmPOM.clickSend_Mail_Marketing();

		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(smmPOM.getFromFld_Mail_Marketing().contains("Default"));
		softAssertion.assertTrue(smmPOM.getToLstAffiliate_Marketing().contains("All Newsletter Subscribers"));
		softAssertion.assertTrue(smmPOM.getSubject_Mail_Marketing().contains(" "));
		softAssertion.assertTrue(smmPOM.getMsg_Mail_Marketing().contains("  "));
		screenShot.captureScreenShot("Default email_060.png");

	}
}

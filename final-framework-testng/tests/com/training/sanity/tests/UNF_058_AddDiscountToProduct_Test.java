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

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.UNF_056_Products_ProductLnkCatelogIcnPOM;
import com.training.pom.UNF_057_Products_AddProdcutsPOM;
import com.training.pom.UNF_058_Marketing_CouponsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_058_AddDiscountToProduct_Test {
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
		screenShot.captureScreenShot("Login_UNF_058.png");
	}

	@AfterClass public void tearDown() throws Exception { 
		Thread.sleep(1000);
	    driver.quit(); 
	 }

	// add discount to the product
	@Test(priority = 0)
	public void addDiscountToProduct() {
		// 1. Click on Marketing icon
		DashBoardPOM dPOM = new DashBoardPOM(driver);
		dPOM.clickMarketingIcn();

		// 2. Click on Coupons link
		dPOM.clickCouponsLnk_MarketingIcn();

		// 3. click on Add New icon
		UNF_058_Marketing_CouponsPOM mcPOM = new UNF_058_Marketing_CouponsPOM(driver);
		mcPOM.clickAddNewCoupons_Marketing();

		// 4. enter valid credentials in Coupon Name textbox
		String coupon = "Gift Voucher";
		mcPOM.setCouponName_CouponsTab_Marketing(coupon);

		// 5. enter valid credentials in Code textbox
		String code = "GV";
		mcPOM.setCode_CouponsTab_Marketing(code);

		// 6. enter valid credentials in Discount textbox
		String discount = "200";
		mcPOM.setDiscount_CouponsTab_Marketing(discount);

		// 7. enter valid credentials in Product textbox
		String product = "Blazer Girls(7-8)";
		mcPOM.setProduct_CouponsTab_Marketing(product);

		// 8. Select valid start date as current date
		mcPOM.setDateStart_CouponsTab_Marketing();

		// 9. Select valid end date as current date+one day
		mcPOM.setDateEnd_CouponsTab_Marketing();

		// 10. Click on Save icon
		mcPOM.clickSaveIcn_CouponsTab_Marketing();

		// validation of lenght of the Code....the code lenght should be between
		// 3 and 8 character
		Assert.assertTrue(
				mcPOM.getErrorMsg_CouponsTab_Marketing().contains("Code must be between 3 and 10 characters"));
		screenShot.captureScreenShot("CodeLength Validation_058.png");

		Assert.assertTrue(
				mcPOM.getCouponSavedMsg_CouponsTab_Marketing().contains("Success: You have modified coupons"));
		screenShot.captureScreenShot("CouponSavedValidation_058.png");

	}
}

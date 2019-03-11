/*UNF_089	To verify whether application allows user to place an order as guest user & 
admin to change order order status as complete*/
	
package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.UNF_088_AddCustAndCustGroupDetailsProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.UNF_087_CustomerGroup_POM;
import com.training.pom.UNF_087_Customer_POM;
import com.training.pom.UNF_089_GuestUser_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_089_ChangeOrderStatus_Test {
	private WebDriver driver;
	String baseURL;
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
		baseURL = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(baseURL);
		screenShot.captureScreenShot("Login_UNF_089.png");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		driver.quit();
	}

	@Test(priority = 0)
	public void changeOrderStatus() throws AWTException  {
		//click on image of T Shirt
		UNF_089_GuestUser_POM guPOM=new UNF_089_GuestUser_POM(driver);
		guPOM.clickAdduniform_GuestLogin();
		// Click on Add to Cart button
		guPOM.setChestSize_GuestLogin("30");
		guPOM.clickClose_GuestLogin();
		guPOM.clickAddToCart_GuestLogin();
		// Mouse Over to Cart Icon
		guPOM.clickCart_GuestLogin();
		// click on View Cart button
		guPOM.clickViewCart_GuestLogin();
		// Click on Checkout button
		guPOM.clickCheckOut_GuestLogin();
		// Click on Guest Checkout radio button
		System.out.println("No Guest Checkout radio button");
		//Assert.assertNull(driver.findElement(By.id("Guest Checkout")), "No Guest Checkout radio button");

	}

	
}

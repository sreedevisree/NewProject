package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UniformStorePOM;
import com.training.pom.UserLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UserLogOut {
	private WebDriver driver;
	String url;
	private static Properties properties;
	private ScreenShot screenShot;
	UserLoginPOM userLogIn;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		userLogIn = new UserLoginPOM(driver);
		url = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(url);
		userLogIn.clickMyAccount();
		userLogIn.clickLogin();
		userLogIn.sendEMailAddress("sreedevisreedharantest22@gmail.com");
		userLogIn.sendPassWord("P@ssWord1234");
		userLogIn.clickLoginBtn();
		screenShot.captureScreenShot("Login_UNF _030.png");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 1)
	public void userLogOut() {
		UniformStorePOM uniformStore = new UniformStorePOM(driver);
		uniformStore.clickUserName();
		uniformStore.clickLogOut();
		String conf = "ACCOUNT LOGOUT";
		Assert.assertEquals(conf, userLogIn.getLogOutConf());
		screenShot.captureScreenShot("Logout_UNF _030.png");
	}

}

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
import com.training.pom.UNF_059_Marketing_AffiliatePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_059_AddAffiliateToMarketing_Test {
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
		screenShot.captureScreenShot("Login_UNF_059.png");
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

		// 2. Click on Affiliates link
		dPOM.clickAffiliates_MarketingIcn();
		
		//3. Click on Add New icon
		UNF_059_Marketing_AffiliatePOM maPOM=new UNF_059_Marketing_AffiliatePOM(driver);
		maPOM.clickAddNewAffiliate_Marketing();
		
		//4. Enter valid credentials in First Name textbox
		String firstName="Trisha";
		maPOM.setFirstNameAffiliate_Marketing(firstName);
		
		//5. Enter valid credentials in Last Name textbox
		String lastName="Sharma";
		maPOM.setLastNameAffiliate_Marketing(lastName);
		
		//6. Enter valid credentials in E-Mail textbox
		String email="trisha.sharma4@gmail.com";
		maPOM.setEMAilAffiliate_Marketing(email);
		
		//7. Enter valid credentials in Telephone textbox
		String telePhoneNo="9765376551";
		maPOM.setTelePhoneNoAffiliate_Marketing(telePhoneNo);

		//8. Enter valid credentials in Password textbox
		String password="trisha234";
		maPOM.setPasswordAffiliate_Marketing(password);
		
		//9. Enter valid credentials in Confirm password textbox
		String confirmPassword="trisha234";
		maPOM.setConfirmPasswordAffiliate_Marketing(confirmPassword);
		
		//10. Enter valid credentials in Address1 textbox
		String address1="K R Road";
		maPOM.setAddress1Affiliate_Marketing(address1);
		
		//11. Enter valid credentials in Address2 textbox
		String address2="bangalore";
		maPOM.setAddress2Affiliate_Marketing(address2);
		
		//12. Enter valid credentials in City textbox
		String city="bangalore";
		maPOM.setcityAffiliate_Marketing(city);
		
		//13. Enter valid credentials in Post Code textbox
		String postCode="560022";
		maPOM.setPostCodeAffiliate_Marketing(postCode);
		
		//14. Select credentials from Country list box
		String country="India";
		maPOM.setCountryAffiliate_Marketing(country);
		
		//15. Select credentials from Region/State list box
		String state="Karnataka";
		maPOM.setStateAffiliate_Marketing(state);
		
		//16. Click on Payment Details tab
		maPOM.clickPaymentsAffiliate_Marketing();
		
		//17. Enter valid credentials in Cheque payee Name textbox
		String chequePayeeName="Trisha";
		maPOM.setChequePPayeeNamePaymnets_Affiliate_Marketing(chequePayeeName);
		
		//18. click on Save icon
		maPOM.clicksave_Affiliate_Marketing();
		
		//getting the confirmation message
		Assert.assertTrue(maPOM.getConfirmationMsg_Affiliate_Marketing().contains("Success: You have modified affiliates"));
		screenShot.captureScreenShot("Confirmation Message_UNF_059.png");
		
	}
}

/*UNF_086--	To verify whether application allows admin to create a group & register 
user to the group & getting stored in datbase*/
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.UNF_086_DataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.LoginPOM;
import com.training.pom.UNF_086_CustomerGrp_CustomerPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_086_CreateGroupAndRegisterUser_Test {
	private WebDriver driver;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	String adminURL;
	AdminLoginPOM adminLogin;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLogin = new AdminLoginPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		driver.get(adminURL);
		adminLogin.sendUserName("admin");
		adminLogin.sendPassWord("admin@123");
		adminLogin.clickSubmitBtn();
		screenShot.captureScreenShot("Login_UNF_086.png");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
//		Thread.sleep(1000);
		driver.quit();
	}


	@Test(priority=0,dataProvider = "db-inputs", dataProviderClass = UNF_086_DataProviders.class)
	public void createGroup_Test(String custGrpName, String custGrpDsc) {
		DashBoardPOM dPOM=new DashBoardPOM(driver);
		// click on Customer icon
		dPOM.clickCustomerIcn();
		// Click on Customer Groups link
		dPOM.clickCustGrp_CustomerIcn();
		// Click on Add New icon
		UNF_086_CustomerGrp_CustomerPOM cgcPOM=new UNF_086_CustomerGrp_CustomerPOM(driver);
		cgcPOM.clickAddNewcustomer_CustomerLnk();
		// Enter valid credentials in Customer Group Name textbox
		String custGrpNameStr=cgcPOM.setCustGrpName_CustomerGrp_CustomerLnk("Gold member");
		Assert.assertEquals(custGrpNameStr, custGrpName);
		//cgcPOM.setCustGrpName_CustomerGrp_CustomerLnk(custGrpName);
		// Enter valid credentials in Description textbox
		String custGrpDescStr=cgcPOM.setCustGrpDsc_CustomerGrp_CustomerLnk("Gold member");
		Assert.assertEquals(custGrpNameStr, custGrpName);
		//cgcPOM.setCustGrpDsc_CustomerGrp_CustomerLnk(custGrpDsc)
		// Click yes radio button of Approve New Customers section
		cgcPOM.clickApproveNewCust_CustomerGrp_CustomerLnk();
		// Click on Save button
		cgcPOM.clickSaveBtn_CustomerGrp_CustomerLnk();
		screenShot.captureScreenShot("Customer Group_UNF_086.png");
	}
	@Test(priority=1,dataProvider = "db-inputs1", dataProviderClass = UNF_086_DataProviders.class)
	public void createUser_Test(String custGrpName, String firstName, String lastName, String email,String telePh, String password, String passwordConf){
		// click on Customer icon
		DashBoardPOM dPOM=new DashBoardPOM(driver);
		dPOM.clickCustomerIcn();
		// Click on Customers link
		dPOM.clickCustLnk_CustomerLnk();
		// Click on Add new icon
		UNF_086_CustomerGrp_CustomerPOM cgcPOM=new UNF_086_CustomerGrp_CustomerPOM(driver);
		cgcPOM.clickAddNewcustomer_CustomerLnk();
		// Select valid credentials in Customer group list box
		String custGrpNameStr=cgcPOM.setCustGrpName1_CustomerGrp_CustomerLnk("Gold member");
		Assert.assertEquals(custGrpNameStr, custGrpName);
		// Enter valid credentials in First Name textbox
		String firstNameStr=cgcPOM.setFirstName_Customer_CustomerLnk("neha");
		Assert.assertEquals(firstName,firstNameStr);
		// Enter valid credentials in Last Name textbox
		String lastNameStr=cgcPOM.setlastName_Customer_CustomerLnk("b");
		Assert.assertEquals(lastName,lastNameStr);
		// Enter valid credentials in E-Mail textbox
		String emailStr=cgcPOM.setEmailCustomer_CustomerLnk("neha@gmail.com");
		Assert.assertEquals(email,emailStr);
		// Enter valid credentials in Telephone textbox
		String telePhNoStr=cgcPOM.setTelePh_Customer_CustomerLnk("9876464663");
		Assert.assertEquals(telePh,telePhNoStr);
		// Enter valid credentials in Password textbox
		String passWordStr=cgcPOM.setpassword_Customer_CustomerLnk("neha2");
		Assert.assertEquals(password,passWordStr);
		// Enter valid credentials in Confirm password textbox
		String passConfStr=cgcPOM.setCnfPsw_Customer_CustomerLnk("neha2");
		Assert.assertEquals(passwordConf,passConfStr);
		// Click on save icon
		cgcPOM.clickSave_Customer_CustomerLnk();
		//getting the customer confirmation message
		Assert.assertTrue(cgcPOM.getConfirmationMsg_Customer_CustomerLnk().contains("Success: You have modified customers"));
		screenShot.captureScreenShot("Customer Confirmation Msg_UNF_086.png");
	}

}
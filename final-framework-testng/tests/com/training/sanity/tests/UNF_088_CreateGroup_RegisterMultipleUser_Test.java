/*UNF_088	--- To verify whether application displays error message upion entering invalid 
details while creating user
*/
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_088_CreateGroup_RegisterMultipleUser_Test {
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
		screenShot.captureScreenShot("Login_UNF_088.png");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		driver.quit();
	}

	@Test(priority = 0, dataProvider = "excel-inputs", dataProviderClass = UNF_088_AddCustAndCustGroupDetailsProviders.class)
	public void addCustomerGroup(String custGrpName, String custGrpDesc) {
		// click on Customer icon
		DashBoardPOM dPOM = new DashBoardPOM(driver);
		dPOM.clickCustomerLnk();

		// Click on Customer Groups link
		dPOM.clickCustomerGroup_CustomerLnk();

		// Click on Add New icon
		UNF_087_CustomerGroup_POM cgmuPOM = new UNF_087_CustomerGroup_POM(driver);
		cgmuPOM.clickAddNew_CustomerGroups_Customer();

		// Enter valid credentials in Customer Group Name textbox
		cgmuPOM.setCustGrpName_CustomerGroups_Customer(custGrpName);

		// Enter valid credentials in Description textbox
		cgmuPOM.setCustGrpDesc_CustomerGroups_Customer(custGrpDesc);

		// Click yes radio button of Approve New Customers section
		cgmuPOM.setAppNewCust_CustomerGroups_Customer();

		// Click on Save button
		cgmuPOM.clickSaveBtn_CustomerGroups_Customer();

		System.out.println(cgmuPOM.getCustGrpConfMsg());
		Assert.assertTrue(cgmuPOM.getCustGrpConfMsg().contains("Success: You have modified customer groups!"));
		screenShot.captureScreenShot("Customer Group Creation Confirmation MSG_"+custGrpName+"_UNF_088.png");

	}

	@Test(priority = 1, dataProvider = "excel-inputs", dataProviderClass = UNF_088_AddCustAndCustGroupDetailsProviders.class)
	public void addCustomer(String custGrpName, String firstName, String lastName, String email, String telePh,
			String password, String cnfPsw) {
		DashBoardPOM dPOM = new DashBoardPOM(driver);
		dPOM.clickCustomerLnk();
		UNF_087_CustomerGroup_POM cgmuPOM = new UNF_087_CustomerGroup_POM(driver);

		// click on Customer icon
		dPOM.clickCustomerLnk();

		// Click on Customers link
		dPOM.clickCustLnk_CustomerLnk();

		// Click on Add new icon
		cgmuPOM.clickAddNew_CustomerGroups_Customer();

		// Select valid credentials in Customer group list box
		UNF_087_Customer_POM cPOM = new UNF_087_Customer_POM(driver);
		cPOM.setCustGrpName_Customer_CustomerLnk(custGrpName);

		// Enter valid credentials in First Name textbox
		cPOM.setFirstName_Customer_CustomerLnk(firstName);

		// Enter valid credentials in Last Name textbox
		cPOM.setlastName_Customer_CustomerLnk(lastName);

		// Enter valid credentials in E-Mail textbox
		cPOM.setEmailCustomer_CustomerLnk(email);

		// Enter valid credentials in Telephone textbox
		cPOM.setTelePh_Customer_CustomerLnk(telePh);

		// Enter valid credentials in Password textbox
		cPOM.setpassword_Customer_CustomerLnk(password);

		// Enter valid credentials in Confirm password textbox
		cPOM.setCnfPsw_Customer_CustomerLnk(cnfPsw);

		// Click on save icon
		cPOM.clickSave_Customer_CustomerLnk();

		System.out.println("message is "+cPOM.getCustConfirmationMsg());
		Assert.assertTrue(cPOM.getCustConfirmationMsg().contains("Success: You have modified customers"));
		screenShot.captureScreenShot("UNF_088"+firstName+" "+lastName+"Customer Confirmation MSG_"+".png");
	}

}

/*UNF_090	To verify whether application displays error message upon entering invalid 
details while adding product with reward points*/
	
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

import com.training.dataproviders.UNF_090_ProdDetailsProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.DashBoardPOM;
import com.training.pom.UNF_090_Products_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_090_AddingProduct_RewardPoints_Test {
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
		screenShot.captureScreenShot("Login_UNF_090.png");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		driver.quit();
	}

	@Test(priority = 0, dataProvider = "excel-inputs", dataProviderClass = UNF_090_ProdDetailsProviders.class)
	public void addProductWithRewardPoints(String prodName, String metaTitle, String modelNo, String price,String category, String quantity,  String quantityDiscount, String priceDiscount, String points){
		// Click on Catelog icon
		DashBoardPOM dPOM=new DashBoardPOM(driver);
		dPOM.clickCatelogIcn();
		
		// Click on Products link
		dPOM.clickCatelogProductLnk();
		
		// Click on Add New icon
		UNF_090_Products_POM pPOM=new UNF_090_Products_POM(driver);
		pPOM.clickAddProd_CatalogIcn();
		
		// Enter Valid credentials in Product Name of General tab
		pPOM.setProdName_GenralTab_ProductLnk_CatalogIcn(prodName);
		
		// Enter Valid credentials in Meta Tag Title of General tab
		pPOM.setMetaTitle_GenralTab_ProductLnk_CatalogIcn(metaTitle);
		
		// Click on Data tab
		pPOM.clickDataTab_GenralTab_ProductLnk_CatalogIcn();
		
		// Enter valid credentials in Model textbox
		pPOM.setModelNo_DataTab_ProductLnk_CatalogIcn(modelNo);
		
		// Enter valid credentials in Price textbox
		pPOM.setPrice__DataTab_ProductLnk_CatalogIcn(price);
		
		// Enter valid credentials in Quantity textbox
		pPOM.setQuantity_DataTab_ProductLnk_CatalogIcn(quantity);
		
		// Click on Links tab
		pPOM.clickLinkTab_ProductLnk_CatalogIcn();
		
		// Click on Categories textbox and Select Category from displayed category list
		pPOM.setCategory_LinkTab_ProductLnk_CatalogIcn(category);
		
		// Click on Discount tab
		pPOM.clickDiscountTab_ProductLnk_CatalogIcn();
		
		// Click on Add discount icon
		pPOM.clickAddDiscount_DiscountTab_ProductLnk_CatalogIcn();
		
		// Enter valid credentials in Quantity textbox
		pPOM.setQuantity_DiscountTab_ProductLnk_CatalogIcn(quantityDiscount);
		
		// Enter valid credentials in Price textbox
		pPOM.setPrice_DiscountTab_ProductLnk_CatalogIcn(priceDiscount);
		
		// Select valid start date as current date
		pPOM.setDateStart_DiscountTab_ProductLnk_CatalogIcn();
		
		// Select valid end date as current date+one day
		pPOM.setDateEnd_DiscountTab_ProductLnk_CatalogIcn();
		
		// Click on Rewards Point tab
		pPOM.clickRewardPtTab_ProductLnk_CatalogIcn();
		
		// Enter valid credentials in points textbox
		pPOM.setPoints_RewardsPtTab_ProductLnk_CatalogIcn(points);
		
		// Click on Save icon
		pPOM.clickSaveBtn_CatalogIcn();
		
		screenShot.captureScreenShot("confirmation msg "+prodName+"_090.png");
		System.out.println("Message is "+pPOM.getConfirProdMsg__CatalogIcn());
		//Assert.assertTrue(pPOM.getConfirProdMsg__CatalogIcn().contains("Success: You have modified products"));
		Assert.assertTrue(pPOM.getConfirProdMsg__CatalogIcn().contains("Warning: Please check the form carefully for errors"));
		
	}

}

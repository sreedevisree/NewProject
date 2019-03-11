package com.training.dataproviders;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class AddCustAndCustGroupDetailsProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(Method m){
		if(m.getName().equalsIgnoreCase("addCustomerGroup")){
			String fileName ="C:/Users/SreedeviSreedharan/Desktop/New folder (2)/New/Test Data/Uniform_CustGrp_Test Data.xlsx"; 
			return new ApachePOIExcelRead().getExcelContent(fileName);
		} 
		else{
			String fileName ="C:/Users/SreedeviSreedharan/Desktop/New folder (2)/New/Test Data/Uniform_Cust_Test Data.xlsx"; 
			return new ApachePOIExcelRead().getExcelContent(fileName);
		}
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}

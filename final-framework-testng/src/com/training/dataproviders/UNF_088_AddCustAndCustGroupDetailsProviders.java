package com.training.dataproviders;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.training.readexcel.UNF_087_ApachePOIExcelRead;

public class UNF_088_AddCustAndCustGroupDetailsProviders {
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(Method m){
		if(m.getName().equalsIgnoreCase("addCustomerGroup")){
								
			String fileName ="C:/Users/SreedeviSreedharan/Desktop/New folder (2)/New/Test Data/UNF_088_CreateGroup_RegisterMultipleUser_Test Data/Uniform_CustAndGrp_Test Data.xlsx"; 
			return new UNF_087_ApachePOIExcelRead().getExcelContent(fileName,"CustGrp");
		} 
		else{
			String fileName ="C:/Users/SreedeviSreedharan/Desktop/New folder (2)/New/Test Data/UNF_088_CreateGroup_RegisterMultipleUser_Test Data/Uniform_CustAndGrp_Test Data.xlsx";
			return new UNF_087_ApachePOIExcelRead().getExcelContent(fileName,"Cust");
		}
	}
}

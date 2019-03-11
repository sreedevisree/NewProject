package com.training.dataproviders;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.training.readexcel.UNF_090_ApachePOIExcelRead;

public class UNF_090_ProdDetailsProviders {
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(Method m){
			String fileName ="C:/Users/SreedeviSreedharan/Desktop/New folder (2)/New/Test Data/UNF_090_ProdDetailsProviders/ProdDetails.xlsx"; 
			return new UNF_090_ApachePOIExcelRead().getExcelContent(fileName);
	}
}

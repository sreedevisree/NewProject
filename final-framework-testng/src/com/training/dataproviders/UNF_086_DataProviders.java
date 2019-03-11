package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.CustomerGrpDetailsBean;
import com.training.bean.LoginBean;
import com.training.dao.CustomerGroupDAO;

public class UNF_086_DataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {
		List<CustomerGrpDetailsBean> list = new CustomerGroupDAO().getCustGrpDetails(); 
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(CustomerGrpDetailsBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getCustGrpName(); 
			obj[1] = temp.getCustGrpDsc(); 
			result[count ++] = obj; 
		}
		return result;
	}
	@DataProvider(name = "db-inputs1")
	public Object [][] getDBData1() {
		List<CustomerGrpDetailsBean> list = new CustomerGroupDAO().getCustGrpDetails1(); 
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(CustomerGrpDetailsBean temp : list){
			Object[]  obj = new Object[7]; 
			obj[0] = temp.getCustGrpName(); 
			obj[1] = temp.getCustFirstName(); 
			obj[2] = temp.getCustLastName(); 
			obj[3] = temp.getEmail(); 
			obj[4] = temp.getTeleNo(); 
			obj[5] = temp.getPassWord(); 
			obj[6] = temp.getConfPassWord(); 
			result[count ++] = obj; 
		}
		return result;
	}	
}

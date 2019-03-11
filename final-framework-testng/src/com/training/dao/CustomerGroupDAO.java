package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.CustomerGrpDetailsBean;
import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class CustomerGroupDAO {
	
	Properties properties; 
	
	public CustomerGroupDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<CustomerGrpDetailsBean> getCustGrpDetails(){
		String sql = properties.getProperty("get.logins"); 
		GetConnection gc  = new GetConnection(); 
		List<CustomerGrpDetailsBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<CustomerGrpDetailsBean>(); 
			gc.rs1 = gc.ps1.executeQuery(); 
			while(gc.rs1.next()) {
				CustomerGrpDetailsBean temp = new CustomerGrpDetailsBean(); 
				temp.setCustGrpName(gc.rs1.getString(1));
				temp.setCustGrpDsc(gc.rs1.getString(2));
				list.add(temp); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; 
	}
	
	public List<CustomerGrpDetailsBean> getCustGrpDetails1(){
		String sql = properties.getProperty("get.logins1"); 
		
		GetConnection gc  = new GetConnection(); 
		List<CustomerGrpDetailsBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<CustomerGrpDetailsBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				CustomerGrpDetailsBean temp = new CustomerGrpDetailsBean(); 
				temp.setCustGrpName(gc.rs1.getString(1));
				temp.setCustFirstName(gc.rs1.getString(2));
				temp.setCustLastName(gc.rs1.getString(3));
				temp.setEmail(gc.rs1.getString(4));
				temp.setTeleNo(gc.rs1.getString(5));
				temp.setPassWord(gc.rs1.getString(6));
				temp.setConfPassWord(gc.rs1.getString(7));
				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}

	
	public static void main(String[] args) {
		new CustomerGroupDAO().getCustGrpDetails().forEach(System.out :: println);
	}
	
	
}

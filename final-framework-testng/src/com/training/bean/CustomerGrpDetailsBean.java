package com.training.bean;

public class CustomerGrpDetailsBean {
	private String url; 
	private String driver; 	
	private String custGrpName, custGrpDsc;
	private String custFirstName, custLastName, email, teleNo, passWord, confPassWord;

	public CustomerGrpDetailsBean() {
	}

	public CustomerGrpDetailsBean(String url, String driver,String custGrpName, String custGrpDsc,String custFirstName,String custLastName, String  email,String  teleNo, String passWord, String confPassWord) {
		super();
		this.url = url;
		this.driver = driver;
		this.custGrpName = custGrpName;
		this.custGrpDsc = custGrpDsc;
		this.custFirstName=custFirstName;
		this.custLastName=custLastName;
		this.email=email;
		this.teleNo=teleNo;
		this.passWord=passWord;
		this.confPassWord=confPassWord;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	public String getCustGrpDsc() {
		return custGrpName;
	}

	public void setCustGrpDsc(String custGrpDsc) {
		this.custGrpDsc = custGrpDsc;
	}

	public String getCustGrpName() {
		return custGrpName;
	}

	public void setCustGrpName(String custGrpName) {
		this.custGrpName = custGrpName;
	}
	
	public String getCustFirstName() {
		return custFirstName ;
	}

	public void setCustFirstName (String custFirstName ) {
		this.custFirstName  = custFirstName ;
	}
	
	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTeleNo() {
		return teleNo;
	}

	public void setTeleNo(String teleNo) {
		this.teleNo = teleNo;
	}
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getConfPassWord() {
		return confPassWord;
	}

	public void setConfPassWord(String confPassWord) {
		this.confPassWord = confPassWord;
	}
	
	@Override
	public String toString() {
		return "LoginBean [customer group name =" + custGrpName + ", customer group description =" + custGrpDsc + "]";
	}

}

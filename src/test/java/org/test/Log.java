package org.test;

import org.base.LoginBase;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Log extends LoginBase{
	@BeforeTest
	public void setExcel() {
		fileName="Excel";
		
	}
	
	@Test(dataProvider="login")
	public void launch(String[] login) {
		
		LoginPage lo=new LoginPage(driver);
		 boolean username = lo.getUsername();
		 Assert.assertEquals(username, true);
		 boolean password = lo.getPassword();
		 Assert.assertTrue(password);
		 
		
		new LoginPage(driver)
		.enterUserName(login[0])
		.enterPassword(login[1])
		.logIn();
	
		
	}

}

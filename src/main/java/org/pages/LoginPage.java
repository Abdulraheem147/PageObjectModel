package org.pages;

import org.base.LoginBase;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends LoginBase {
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
		
	}
	
	
	//locators
	public boolean getUsername() {
		return driver.findElement(By.xpath("(//td[@align='right'])[1]")).isDisplayed();
	}
	public boolean getPassword() {
		return driver.findElement(By.xpath("(//td[@align='right'])[2]")).isDisplayed();
	}
	
	
	
	
	
	
	
	
	//actions
	/**
	 * @description-grt the data from user and type on yhe user name field
	 * @param name-pass the user to be login
	 * @return 
	 */
	public LoginPage enterUserName(String name){
		driver.findElement(By.id("username")).sendKeys("AbdulRaheem");
		return this;
	}
    public LoginPage enterPassword(String pass) {
    	driver.findElement(By.id("password")).sendKeys("Raheem@123");
    	return this;
    }
    public DashBoard logIn() {
    	driver.findElement(By.id("login")).click();
    	return new DashBoard();
    }
    public Forget forgetPassword() {
    	driver.findElement(By.linkText("Forgot Password?")).click();
    	return new Forget();
    }
    /**
     * @description-this method is used to login the app
     * @param name
     * @param password
     */
    
    
    public void log(String name,String password) {
    	enterUserName(name);
    	enterPassword(password);
    	logIn();
    }
}

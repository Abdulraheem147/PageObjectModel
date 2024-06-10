package org.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class LoginBase  {
	String URL="https://adactinhotelapp.com/";
	 protected  RemoteWebDriver driver =null;
	 public String fileName="";
	 @DataProvider(name="login")
	 public String[][] dataProvider() throws IOException {
		 String[][] data = Excel3.throwData(fileName);
		 return data;
	 }
	@BeforeMethod
	public void adactin() {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
	}
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}

}

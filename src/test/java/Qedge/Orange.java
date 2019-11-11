package Qedge;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Orange {
	WebDriver driver;
  @Test(dataProvider = "supplydata")
  public void login(String username,String password) {
	  driver.get("http://orangehrm.qedgetech.com/");
	  driver.manage().window().maximize(); 
	driver.findElement(By.name("txtUsername")).sendKeys(username);
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.name("Submit")).click();
	if(driver.getCurrentUrl().contains("dash"))
	{
		Reporter.log("Login Success",true);
	}
	else
	{
		Reporter.log("Login Fail",true);
	}
  }

  @DataProvider
  public Object[][] supplydata() {
   Object [][]login=new Object[3][2];
   login[0][0]="Admin";
   login[0][1]="Qedge123!@#";
   login[1][0]="test";
   login[1][1]="admin";
   login[2][0]="Admin";
   login[2][1]="Qedge123!@#";
   return login;
  }
  @BeforeTest
  public void beforeTest() {
 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
 driver=new ChromeDriver();
 
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}

package nov11;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Gid_Example {
	WebDriver driver;
	DesiredCapabilities cap;
@BeforeTest
public void launch()throws Throwable
{
cap=new DesiredCapabilities();
cap.setBrowserName("chrome");
cap.setPlatform(Platform.WINDOWS);
//connect test case to hub
driver=new RemoteWebDriver(new URL("http://localhost:5550/wd/hub"), cap);
driver.get("http://orangehrm.qedgetech.com/");
driver.manage().window().maximize();
}
@Test
public void login()throws Throwable
{
	driver.findElement(By.name("txtUsername")).sendKeys("admin");
	driver.findElement(By.name("txtPassword")).sendKeys("admin");
	driver.findElement(By.name("Submit")).click();
	Thread.sleep(5000);
	if(driver.getCurrentUrl().contains("dash"))
	{
		System.out.println("Login success");
	}
	else
	{
		System.out.println("Login Failed");
	}
	
}
@AfterTest
public void logout()throws Throwable
{
	Thread.sleep(5000);
driver.quit();	
}
}

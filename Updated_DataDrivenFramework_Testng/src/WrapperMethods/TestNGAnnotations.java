package WrapperMethods;

import static WrapperMethods.SeleniumWrappers.*;
import static Config.GlobalParameters.*;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGAnnotations extends GlobalParameters 
{	
	public static void testLogout() throws Exception
{
driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
}
//@SuppressWarnings("static-access")
public static void startTest() throws Exception
{ 
new BrowserInstance();
open(url);
driver.manage().window().maximize(); 
}
public static void stopTest() throws Exception
{
quitBrowser();
  
}
   
@BeforeMethod(alwaysRun=true)
public void beforeClass()
{
try {
startTest();
} 

catch (Exception e) { 
log(e.getMessage());
}
} 
 
@AfterMethod(alwaysRun=true)
public void afterClass() throws Exception
{
stopTest();
}
 

 
}


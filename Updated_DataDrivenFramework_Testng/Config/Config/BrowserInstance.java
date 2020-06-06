package Config;
//import static Config.XlsReader.configDetails;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
@SuppressWarnings("unused")
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class BrowserInstance extends GlobalParameters
{
	public BrowserInstance() throws Exception
	{	
	try{
		if (BROWSER.equals("FF"))
		{
            try{
            	DesiredCapabilities cap=new DesiredCapabilities();
                cap.setCapability("firefox_binary", "D:\\firefox\\Mozilla Firefox\\firefox.exe");
                driver = new FirefoxDriver(cap);	
			ATUReports.setWebDriver(driver);
			ATUReports.add("FF Browser Instance created",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            }
            catch(Exception e)
            {
             ATUReports.add("FF Browser Instance Failed",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            }			
		}
		else if (BROWSER.equals("IE"))
		{
		  try{
			File IEDriver = new File("D:\\Selenium_Automation_Framework\\IEDriverServer.exe");   
			System.setProperty("webdriver.ie.driver", "D:\\Selenium_Automation_Framework\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			driver = new InternetExplorerDriver();
			ATUReports.setWebDriver(driver);
			ATUReports.add("IE Browser Instance created",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            }
        catch(Exception e)
        {
         ATUReports.add("IE Browser Instance Failed",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
        }
			
		} 
		
		else if (BROWSER.equals("CH"))
		{
          try{
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver = new ChromeDriver();
			ATUReports.setWebDriver(driver);
			ATUReports.add("CH Browser Instance Failed",LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
           }
        catch(Exception e)
        {
         ATUReports.add("CH Browser Instance Failed",LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
        }
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Browser Selection","Error", JOptionPane.ERROR_MESSAGE);
		}
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript("window.moveTo(0, 0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);");
		((JavascriptExecutor)driver).executeScript("window.resizeTo(1024, 768);");
		}
	catch(Exception ee)
		{
			JOptionPane.showMessageDialog(null, BROWSER+" Driver Not Available","Driver Initialization Eception", JOptionPane.WARNING_MESSAGE);
		
		}
      }

	
}
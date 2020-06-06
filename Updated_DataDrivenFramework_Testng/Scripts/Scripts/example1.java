package Scripts;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import WrapperMethods.TestNGAnnotations;
import Config.ExcelWrappers;
@SuppressWarnings("unused")
//@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })

public class example1 extends TestNGAnnotations {
	@BeforeTest
	public void isSkipped(){
		if(ExcelWrappers.isSkip("LoginTest"))
			throw new SkipException("Runmode set to No");
	}
	
	@Test(dataProvider="getData")
	public void testLogin(String username, String password) throws InterruptedException, IOException{
		
		
	
		

		
	}
	@DataProvider
	public Object[][] getData(){
		return ExcelWrappers.getData("LoginTest");
	}
}

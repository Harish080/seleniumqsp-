package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver sDriver;
public WebDriver driver;
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("DataBase connection");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	@BeforeClass
	public void BC() throws Throwable
	{
		
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValue("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
			
		}
		
		System.out.println("Browser Launching");
		sDriver = driver;
	}
	
	@BeforeMethod
	public void BM() throws Throwable
	{
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValue("browser");
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		driver.get(URL);

		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(USERNAME, PASSWORD);

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);
		
		System.out.println("Login to Application");
	}
	
	@AfterMethod
	public void AM()
	{
		//HomePage home = new HomePage(driver);
		//home.logoutApp();
		System.out.println("Logout from Application");
	}
	
	@AfterClass
	public void AC()
	{
	//	driver.quit();
		System.out.println("close the Browser");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("parallel execution close");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("Close DAtaBAse");
	}
}
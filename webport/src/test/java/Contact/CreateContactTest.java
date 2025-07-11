package Contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.ContactValidationPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.OrganizationLookUpImg;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass{
@Test
	public void createcontact() throws Throwable {
		
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

	//pull1
//push1
		//new 123
	//branching new
		
		Thread.sleep(2000);

		Pom_Repo.HomePage home = new Pom_Repo.HomePage(driver);
		home.clickContactLink();
		

		ContactLookUpImgPage lookUp = new ContactLookUpImgPage(driver);
		lookUp.clickLookUp();
		
		CreateContactPage contactPage = new CreateContactPage(driver);
		
		
		String FirstName = elib.getExcelData("Contact", 0, 0);
		String LastName = elib.getExcelData("Contact", 1, 0);
		contactPage.enterContactDetails(FirstName, LastName);

		contactPage.clickSaveButton();
		


		ContactValidationPage validate = new ContactValidationPage(driver);
		validate.validateContactFirstNAme(driver, FirstName);
		validate.validateContactLastNAme(driver, LastName);
		Thread.sleep(2000);
		

		
		home.logoutApp();
	}

}



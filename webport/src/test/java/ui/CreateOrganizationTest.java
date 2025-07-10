package ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
//org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Pom_Repo.HomePage;
import Pom_Repo.OrganizationLookUpImg;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Generic_Utilities.ExtentReportImp.class)
public class CreateOrganizationTest extends BaseClass {
@Test
public void 	CreateOrganizationTest() throws EncryptedDocumentException, IOException, Throwable
{

			HomePage home=new HomePage(driver);
	home.clickOrgLink();
	OrganizationLookUpImg lookup = new OrganizationLookUpImg(driver);
	lookup.orglookupimg();
		
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

	
		FileInputStream fes = new FileInputStream("./src/test/resources/exceldata.xlsx");

		
		Workbook book = WorkbookFactory.create(fes);

		
		Sheet sheet = book.getSheet("Sheet1");

		
		Row row = sheet.getRow(0);

	
		Cell cell = row.getCell(0);

		
		String OrgName = cell.getStringCellValue() + ranNum;
		System.out.println(OrgName);
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
//---------------------------------------------------------------------------------------------------------------------------------------
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(0);
		DataFormatter format = new DataFormatter();
		String PhnNum = format.formatCellValue(cell1);
		System.out.println(PhnNum);
		driver.findElement(By.name("phone")).sendKeys(PhnNum);
//----------------------------------------------------------------------------------------------------------------------------------				
		Row row2 = sheet.getRow(2);
		Cell cell2 = row2.getCell(0);
		DataFormatter format1 = new DataFormatter();
		String mailId = format1.formatCellValue(cell2);
		System.out.println(mailId);
		driver.findElement(By.id("email1")).sendKeys(mailId);

		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
//---------------------------------------------------------------------------------------------------------------------------------------
	
		Thread.sleep(2000);
		
		home.logoutApp();
		}
}
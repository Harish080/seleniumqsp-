package testNg;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class contactdata {

	@Test(dataProvider = "readContactData") 
    public void createContact(String firstName, String lastName) throws Throwable {
		WebDriverManager.edgedriver().setup();

		WebDriver driver=new EdgeDriver();
        driver.get("http://localhost:8888");
        driver.manage().window().maximize();

        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();

        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();

        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

        Thread.sleep(2000); 

        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.quit();
    }

@DataProvider
public Object[][] readContactData() {
    Object[][] objArr = new Object[3][2];

    objArr[0][0] = "shobha";
    objArr[0][1] = "Rani";

    objArr[1][0] = "Rathin";
    objArr[1][1] = "reddy";

    objArr[2][0] = "Within";
    objArr[2][1] = "Reddy";

    return objArr;
}}

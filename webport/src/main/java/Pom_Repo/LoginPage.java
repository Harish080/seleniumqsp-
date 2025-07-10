package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="user_name")
	private WebElement usertextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordtextfield;
	
	@FindBy(id="submitbutton")
	private WebElement loginbutton;

	public WebElement getUsertextfield() {
		return usertextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public void loginIntoApp(String uSERNAME, String pASSWORD) {
		usertextfield.sendKeys(uSERNAME);
		passwordtextfield.sendKeys(pASSWORD);
		loginbutton.click();
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}

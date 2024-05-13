package SpiceJetPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SpiceJetUtils.SetCommonfunction;


public class LoginjetPage extends SetCommonfunction

{
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement mobno;
	
	@FindBy(xpath="//input[@data-testid='password-input-box-cta']")
	WebElement password;
	
	@FindBy(xpath="//div[@data-testid='login-cta']")
	WebElement login;
	
	@FindBy(xpath="//*[@data-testid='to-testID-origin']")
	WebElement FromTo; 
	
	@FindBy(xpath="//div[text()='Bengaluru']")
	WebElement Beng;
	
	@FindBy(xpath="//div[text()='Delhi']")
	WebElement Delhi;
	
	public LoginjetPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickLogin()
	{
		click(Login);
	}
	
	public void Mobno(String no)
	{
		typeText(mobno,no);
	}
	
	public void Password(String pass)
	{
		typeText(password,pass);
	}
	
	public void ClickLoginButton()
	{
		click(login);
	}
	
	
	public void FromTo() 
	{
		click(FromTo);
		
	}

	public void Benglore()
	{
		click(Beng);
		
	}

	public void delh() 
	{
	click(Delhi);	
		
	}

}

package SpiceJetPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SpiceJetUtils.SetCommonfunction;


public class BookingPage extends SetCommonfunction

{

	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']")
	WebElement continuecl;
	
	
	@FindBy(xpath="//*[@data-testid='title-contact-detail-card']")
	WebElement details;
	@FindBy(xpath="//*[contains(text(),'Mrs')]")
	WebElement chooseMrs;
	@FindBy(xpath="//*[@data-testid='first-inputbox-contact-details']")
	WebElement fname;
	@FindBy(xpath="//*[@data-testid='last-inputbox-contact-details']")
	WebElement lname;
	@FindBy(xpath="//*[@data-testid='contact-number-input-box']")
	WebElement cnum;
	@FindBy(xpath="//*[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement email;
	@FindBy(xpath="//*[@data-testid='city-inputbox-contact-details']")
	WebElement city;
	
	@FindBy(xpath="//*[@data-testid='traveller-0-title-field']")
	WebElement passen;
	@FindBy(xpath="(//*[contains(text(),'Mrs')])[2]")
	WebElement choosemrs;
	@FindBy(xpath="//input[@data-testid='traveller-0-first-traveller-info-input-box']")
	WebElement pname;
	@FindBy(xpath="//input[@data-testid='traveller-0-last-traveller-info-input-box']")
	WebElement plname;
	@FindBy(xpath="//input[@data-testid='sc-member-mobile-number-input-box']")
	WebElement plPhname;
	@FindBy(xpath="//div[@data-testid='traveller-0-travel-info-cta']")
	WebElement next;
	
	
	@FindBy(xpath="//div[@data-testid='traveller-info-continue-cta']")
	WebElement adsClick;		

	public void BookingFlights(String Name,String lstname,String contactno,String gmail,String City,String name,String Last,String Num)
	{
		
		actionClick(continuecl);
		click(details);
		click(chooseMrs);
		typeText(fname,Name);
		typeText(lname,lstname);
		typeText(cnum,contactno);
		typeText(email,gmail);
		typeText(city,City);
		
		click(passen);
		click(choosemrs);
		typeText(pname, name);
		typeText(plname, Last);
		typeText(plPhname, Num);
		click(next);
	}
}

package SpiceJetPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SpiceJetUtils.Reports;
import SpiceJetUtils.SetCommonfunction;

public class FlightStatusPage extends SetCommonfunction 

{
	
	@FindBy(xpath="//div[@data-testid='check-in-horizontal-nav-tabs']")
	WebElement check;

	@FindBy(xpath="//div[text()='Web Check-In']")
	WebElement Check;
	
	@FindBy(xpath="//div[@data-testid='flight status-horizontal-nav-tabs']")
	WebElement fstatus;

	@FindBy(xpath="//div[text()='Flight Status']")
	WebElement Status;

	

	public void CheckStatus() throws InterruptedException
	{
		
		click(check);
		if(Check.isDisplayed())
			Reports.reportStep("pass","checkin validated");
		else
			Reports.reportStep("fail","checkin not validated");
		Thread.sleep(2000);
	}	
	
	
	public void Flightstatus() throws InterruptedException
	{
		click(fstatus);
		if(Status.isDisplayed())
			Reports.reportStep("pass","status validated");
		else
			Reports.reportStep("fail","status not validated");
		Thread.sleep(2000);
	}

}

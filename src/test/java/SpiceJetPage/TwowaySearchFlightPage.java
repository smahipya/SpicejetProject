package SpiceJetPage;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SpiceJetUtils.SetCommonfunction;


public class TwowaySearchFlightPage extends SetCommonfunction

{

	SetCommonfunction set = new SetCommonfunction();

	@FindBy(xpath="//*[@data-testid='to-testID-origin']")
	WebElement clorigin;
	
	@FindBy(xpath="//div[text()='Mumbai']")
	WebElement depar;
	
	@FindBy(xpath="//div[text()='Chennai']")
	WebElement destin;
	
	@FindBy(xpath="//div[text()='Return Date']")
	WebElement returndate;
	
	@FindBy(xpath="//div[contains(text(),'Currency')]")
	WebElement currency;
	
	@FindBy(xpath="(//div[contains(text(),'INR')])[1]")
	WebElement country;
	
	@FindBy(xpath="//div[contains(text(),'Search Flight')]")
	WebElement flights;	
	
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']")
	WebElement continuecl;
	
	public void roundTrip()
	{
		click(clorigin);
		click(depar);
		click(destin);
	}
	public void  Choosedate(int fDay)
	{
		LocalDate fDate = LocalDate.now().plusDays(fDay);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
		final String date = String.valueOf(fDate.getDayOfMonth());
		final String month = fDate.format(formatter);
		final String year = String.valueOf(fDate.getYear());
		WebElement	clickDate=driver.findElement(By.xpath(" //div[contains(@data-testid,'month-"+month+"-"+year+"')]//div[@data-testid='undefined-calendar-day-"+date+"']/div"));
	
		click(clickDate);
		click(returndate);
		set.calender("October", "2024", "15");
	}
	
	
	public void Searchflights() throws InterruptedException
	{
		
		click(currency);
		click(country);
		actionClick(flights);
		Thread.sleep(8000);
		click(continuecl);
		
	}
}

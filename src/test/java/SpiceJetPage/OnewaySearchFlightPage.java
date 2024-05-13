package SpiceJetPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SpiceJetUtils.SetCommonfunction;

public class OnewaySearchFlightPage extends SetCommonfunction
{
	
	
	@FindBy(xpath="//*[@data-testid='to-testID-origin']//input")
	WebElement origin;
		
	@FindBy(xpath="//div[text()='Delhi']")
	WebElement departure;

	@FindBy(xpath="//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']//div[text()='Chennai']")
	WebElement destination;
	
	@FindBy(xpath="//div[@data-testid='home-page-travellers']")
	WebElement travellers;

	@FindBy(xpath="//*[@data-testid='Adult-testID-plus-one-cta']")
	WebElement adults; 

	@FindBy(xpath="//*[@data-testid='Children-testID-plus-one-cta']")
	WebElement childrens; 

	@FindBy(xpath="//*[@data-testid='Infant-testID-plus-one-cta']")
	WebElement infants; 

	@FindBy(xpath="//div[contains(text(),'Currency')]")
	WebElement currency; 

	@FindBy(xpath="(//div[contains(text(),'INR')])[1]")
	WebElement chooseCurrency;

	@FindBy(xpath="//div[contains(text(),'Search Flight')]")
	WebElement flights;
	
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']")
	WebElement payment;
	

	public void clickOrigin()
	{
		click(origin);
		typeText(origin,"DEL");
		click(destination);
		
		
	}	

	public void  date(int fDay)
	{
		LocalDate fDate = LocalDate.now().plusDays(fDay);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
		final String date = String.valueOf(fDate.getDayOfMonth());
		final String month = fDate.format(formatter);
		final String year = String.valueOf(fDate.getYear());
		WebElement	Date=driver.findElement(By.xpath(" //div[contains(@data-testid,'month-"+month+"-"+year+"')]//div[@data-testid='undefined-calendar-day-"+date+"']/div"));
		click(Date);

	}

	public void Travellers()
	{
		click(travellers);
		
	}

	public void Adults()
	{
		click(adults);
	}
	
	
	public void clickCurrency()
	{
		click(currency);
		
	}
	
	public void chooseCurrency()
	{
		click(chooseCurrency);
		
	}

	public void searchFlights()
	{

		actionClick(flights);

	}
	public void BookingFlights()
	{
		click(payment);
	}


}

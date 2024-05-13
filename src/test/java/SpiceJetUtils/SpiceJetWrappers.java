package SpiceJetUtils;

import org.openqa.selenium.support.PageFactory;

import SpiceJetPage.BookingPage;
import SpiceJetPage.FlightStatusPage;
import SpiceJetPage.LoginjetPage;
import SpiceJetPage.OnewaySearchFlightPage;
import SpiceJetPage.TwowaySearchFlightPage;



public class SpiceJetWrappers extends SetCommonfunction

{
	
	SetCommonfunction set = new SetCommonfunction();

	
	public void loginSpicejet()
	{
		try
		{
			LoginjetPage login=PageFactory.initElements(driver, LoginjetPage.class);
			set.frameByname("juspay-hidden-form1693479009936");
			login.ClickLogin();
			driver.switchTo().defaultContent();
			login.Mobno("8788154200");
			login.Password("Sweety@10");
			login.ClickLoginButton();
			Thread.sleep(4000);
			//login.SelectFrom("BOM");
			//login.SelectTo("DEL");
			//login.FromTo();
			//login.Benglore();
			//login.delh();
			Thread.sleep(4000);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void invalidLogin()
	{
		try
		{
			LoginjetPage login=PageFactory.initElements(driver, LoginjetPage.class);
			set.frameByname("juspay-hidden-form1693479009936");
			login.ClickLogin();
			driver.switchTo().defaultContent();
			login.Mobno("8788154200");
			login.Password("Sweety@10");
			login.ClickLoginButton();
			Thread.sleep(4000);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//=========================================================================
	
	public void oneWayFlight()
	{
		try
		{
			OnewaySearchFlightPage owPage=PageFactory.initElements(driver, OnewaySearchFlightPage.class);
		
		   
			owPage.clickOrigin();
			
			owPage.date(10);
			owPage.Travellers();
			owPage.Adults();
			
			owPage.clickCurrency();
			owPage.chooseCurrency();
			Thread.sleep(4000);
			owPage.searchFlights();
			Thread.sleep(9000);
			owPage.BookingFlights();
			Thread.sleep(9000);
		}
		 catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}
	//===========================================================
	
	public void RoundTripFlight()
	{
		try
		{
			TwowaySearchFlightPage twPage=PageFactory.initElements(driver, TwowaySearchFlightPage.class);

			twPage.roundTrip();
			twPage.Choosedate(10);
		
			twPage.Searchflights();
			Thread.sleep(9000);
			
		}
		 catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}
	
	public void bookingFlights()
	{
		try
		{
			BookingPage bPage=PageFactory.initElements(driver, BookingPage.class);
			bPage.BookingFlights("mahi","mahe","9677672869","mahi015@gmail.com","priya","Sweety", "hari", "8438115670");
			
			
		}
		 catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}	
		public void FlightStatus() throws InterruptedException
		{
			
			FlightStatusPage stPage=PageFactory.initElements(driver, FlightStatusPage.class);
			stPage.CheckStatus();

			stPage.Flightstatus();
		}
		
}

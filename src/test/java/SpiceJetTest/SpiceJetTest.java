package SpiceJetTest;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SpiceJetUtils.Reports;
import SpiceJetUtils.SetCommonfunction;
import SpiceJetUtils.SpiceJetWrappers;

public class SpiceJetTest extends SetCommonfunction

{
	
	SpiceJetWrappers jet=new SpiceJetWrappers();
	SetCommonfunction set= new SetCommonfunction();
	
	@DataProvider(name="SpicejetData")
	public Object[][] readExcel() throws IOException
	{
		Object[][] data=null;
		XSSFWorkbook workbook=null;
	  
		try
		{
			
			workbook= new XSSFWorkbook("C:\\Users\\santh\\eclipse-workspace\\SpicejetProject\\spicejet.xlsx");	
			XSSFSheet sheet= workbook.getSheetAt(0);
			XSSFRow row= sheet.getRow(0);
			
			int noOfRows=sheet.getPhysicalNumberOfRows();
			
			int noOfCells= row.getPhysicalNumberOfCells();
			
			data= new Object[noOfRows-1][noOfCells]; //data[5][2]
			
			for(int i=1; i<noOfRows;i++)
			{
				for(int j=0; j<noOfCells;j++)
				{
					String cellValue=sheet.getRow(i).getCell(j).getStringCellValue();
					data[i][j]=cellValue;
					System.out.println("Cell Value -->"+cellValue);
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			workbook.close();
		}
		
		return data;
	}
	
	@Test(priority=1)
	public void SpiceJetLoginTestCases()
	{
		try
		{
			Reports.startReport();
			Reports.setTCDesc("Valid Spicejet Login functionality");
			launchBrowser("https://www.spicejet.com/");		
			jet.loginSpicejet();			
			screenshot("loginpage");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	@Test(priority=2)
	
	public void SpiceJetInvalidLoginTestCase()
	{
		try
		{
			Reports.startReport();
			Reports.setTCDesc("Valid Spicejet Login functionality");
			launchBrowser("https://www.spicejet.com/");			//launch browser test case
			jet.invalidLogin();		
			screenshot("invalidloginpage");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test(priority=3)
	
	public void Roundtrip()
	{
		try
		{
			Reports.startReport();
			Reports.setTCDesc("roundtrip flight search ");
			launchBrowser("https://www.spicejet.com/");			//launch browser test case
			jet.loginSpicejet();									//login to spicejet test case
			
			jet.RoundTripFlight();
		
			screenshot("roundTrip Flight search");
			jet.bookingFlights();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	@Test(priority=4)
	
	public void OnewayFlight()
	{
		Reports.startReport();
		Reports.setTCDesc("Valid Spicejet Login functionality");
		launchBrowser("https://www.spicejet.com/");			
		jet.loginSpicejet();
		jet.oneWayFlight();
		jet.bookingFlights();
		screenshot("Flightbook");
	}
	
	
	@Test(priority=5)
	
	public void flightStatus() throws InterruptedException
	{
		launchBrowser("https://www.spicejet.com/");			
		jet.loginSpicejet();	
		jet.FlightStatus();
	}

}

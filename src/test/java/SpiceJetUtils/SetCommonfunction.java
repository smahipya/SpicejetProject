package SpiceJetUtils;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SetCommonfunction {
	
	public static WebDriver driver;
	
	public void launchBrowser(String url)
	{
		try
		{
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(url);
			Reports.reportStep("PASS", "The chrome browser launched successfully with the given url ("+url+")");
			
		}
		catch(Exception ex)
		{
			System.out.println("Problem in launching the browser");
			Reports.reportStep("FAIL", "Problem while launching the chrome browser with the given url ("+url+")");
			ex.printStackTrace();
		}
	}
	
	//method to close all the browsers
	@AfterMethod
	public void closeAllBrowsers()
	{
		try
		{
			driver.quit();
			Reports.reportStep("PASS", "Browsers closed successfully");
		}
		catch(Exception ex)
		{
			System.out.println("Problem in closing all the browsers");
			Reports.reportStep("FAIL", "Problem in closing all the browsers");
			ex.printStackTrace();
		}
	}
	
	//methods to close the current active browser
	public void closeBrowser()
	{
		try
		{
			driver.close();
			//Reports.reportStep("PASS", "Browser closed successfully");
		}
		catch(Exception ex)
		{
			System.out.println("Problem in closing the browser");
			//Reports.reportStep("FAIL", "Problem in closing the browser");
			ex.printStackTrace();
		}
	}

	public void typeText(WebElement ele, String text)
	{
		try
		{
			waitForMe(ele,20);
			ele.clear();
			ele.sendKeys(text);
			//Reports.reportStep("PASS", "Entered the given text ("+text+") successfully ");

		}
		catch(Exception ex)
		{
			System.out.println("problem in sendkeys method");
			Reports.reportStep("FAIL", "Problem while entering the given text ("+text+")");

			ex.printStackTrace();
		}
		
	}
	//click 
	public void click(WebElement ele)
	{
		try
		{
			waitForMe(ele,20);
			ele.click();
			Reports.reportStep("PASS", "Clicked on the given webelement successfully ");

		}
		catch(Exception ex)
		{
			System.out.println("problem in click option");
			Reports.reportStep("FAIL", "Problem while clicking on the webElement ");
			ex.printStackTrace();
		}
	}
	//navigate forward
	public void navigateforward()
	{
		try
		{
			driver.navigate().forward();
		}
		catch(Exception ex)
		{
			System.out.println("problem in navigate forward");
			ex.printStackTrace();
		}
	}
	//navigate back
	public void navigateBack()
	{
		try
		{
			driver.navigate().back();
		}
		catch(Exception ex)
		{
			System.out.println("problem in navigate back");
			ex.printStackTrace();
		}
	}
	//navigate refresh
	public void navigateRefresh()
	{
		try
		{
			driver.navigate().refresh();
		}
		catch(Exception ex)
		{
			System.out.println("problem in navigate refresh");
			ex.printStackTrace();
		}
	}
	//explicit wait
	public void waitForMe(WebElement ele, int timeout)
	{
		try
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		}
		catch(Exception ex)
		{
			System.out.println("problem in explicit wait");
			ex.printStackTrace();
		}
	}
	//fluent wait
	public void pollingWait(WebElement ele, int timeout, int pollingFrequency)
	{
		try
		{
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeout)) 
					.pollingEvery(Duration.ofSeconds(pollingFrequency));
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		}
		catch(Exception ex)
		{
			System.out.println("problem in fluent wait");
			ex.printStackTrace();
		}
	}
	
	//selectby visibletext
	public void selectByVisibleText(WebElement ele, String visibleText)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByVisibleText(visibleText);
		}
		catch(Exception ex)
		{
			System.out.println("problem in selectByVisible text");
			ex.printStackTrace();
		}
		
	}
	
	//SelectbyIndex
	public void selectByIndex(WebElement ele, int value)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByIndex(value);
		}
		catch(Exception ex)
		{
			System.out.println("problem in selectBy index");
			ex.printStackTrace();
		}
	}
	//SelectByValue
	public void selectByValue(WebElement ele, String value)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByValue(value);
		}
		catch(Exception ex)
		{
			System.out.println("problem in selectBy value");
			ex.printStackTrace();
		}
	}
	//acceptAlert
	public void acceptAlert()
	{
		try
		{
			Alert promptAlert= driver.switchTo().alert();
			promptAlert.accept();
		}
		catch(Exception ex)
		{
			System.out.println("problem in accept alert");
			ex.printStackTrace();
		}
	}
	//dismissAlert
	public void dismissAlert()
	{
		try
		{
			Alert promptAlert= driver.switchTo().alert();
			promptAlert.dismiss();
		}
		catch(Exception ex)
		{
			System.out.println("problem in dismiss alert");
			ex.printStackTrace();
		}
	}
	//getTxtFromAlert
	public void getTextmethod()
	{
		try
		{
			Alert alert= driver.switchTo().alert();

			String alertText=alert.getText();
			System.out.println(alertText);

		}
		catch(Exception ex)
		{
			System.out.println("problem in getText method");
			ex.printStackTrace();
		}
	}
	//typeTextInAlert
	public void typeTextmethod(String text)
	{
		try
		{
			Alert alert= driver.switchTo().alert();
			alert.sendKeys(text);
			alert.accept();

		}
		catch(Exception ex)
		{
			System.out.println("problem in typeText in alert");
			ex.printStackTrace();
		}
	}
	
	//Frames
	public void frameByWebElement(WebElement ele)
	{
		try
		{
			driver.switchTo().frame(ele);

		}
		catch(Exception ex)
		{
			System.out.println("problem in frames");
			ex.printStackTrace();
		}
	}
	//FrameByIndex
	public void frameByIndex(int frame)
	{
		try
		{
			driver.switchTo().frame(frame);

		}
		catch(Exception ex)
		{
			System.out.println("problem in frameBy index");
			ex.printStackTrace();
		}
	}
	
	//FrameByName
		public void frameByname(String nameOrId)
		{
			try
			{
				driver.switchTo().frame(nameOrId);

			}
			catch(Exception ex)
			{
				System.out.println("problem in frameBy name");
				ex.printStackTrace();
			}
		}
	//isSelected method	
	public boolean verifySelected(WebElement ele)
	{
		boolean retVal=false;
		try
		{
			if(ele.isSelected())
			{
				retVal=true;
				System.out.println("Element is selected");
			}
			else
			{
				retVal=false;
				System.out.println("Element is not selected");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return retVal;
	}
		
		//isEnabled
	public boolean verifyEnabled(WebElement ele)
	{
	boolean	retVal=false;
		try
		{
			if(ele.isEnabled())
			{
				retVal=true;
				System.out.println("element is enabled");	
			}
			else
			{
				retVal=false;
				System.out.println("element is not enabled");
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return retVal;
	}
	//isDisplayed
	public boolean verifyDisplayed(WebElement ele)
	{
	boolean	retVal=false;
		try
		{
			if(ele.isDisplayed())
			{
				retVal=true;
				System.out.println("element is displayed");	
			}
			else
			{
				retVal=false;
				System.out.println("element is not displayed");
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return retVal;
	}
	//action-click
	public void actionClick(WebElement ele)
	{
		try
		{
			Actions act = new Actions(driver);
			act.click(ele).build().perform();
		}
		catch(Exception ex)
		{
			System.out.println("problem in action click");
			ex.printStackTrace();
		}
	}
//right click	
	public void rightClick(WebElement ele)
	{
		try
		{
			Actions act = new Actions(driver);
			act.contextClick(ele).build().perform();
		}
		catch(Exception ex)
		{
			System.out.println("problem in rightclick method");
			ex.printStackTrace();
		}
	}
	//dragAndDrop
	public void dragAndDrop(WebElement source, WebElement target)
	{
		try
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(source, target).build().perform();
		}
		catch(Exception ex)
		{
			System.out.println("problem in drag and drop method");
			ex.printStackTrace();
		}
	}
	
	//clickAndHold
	public void clickAndhold(WebElement ele)
	{
		try
		{
			Actions act=new Actions(driver);
			act.clickAndHold(ele).build().perform();
		}
		catch(Exception ex)
		{
			System.out.println("problem in click And Hold method");
			ex.printStackTrace();
		}
	}
	//docubleClick
	public void doubleClick(WebElement ele)
	{
		try
		{
			Actions act=new Actions(driver);
			act.doubleClick(ele).build().perform();
		}
		catch(Exception ex)
		{
			System.out.println("problem in doubleclick method");
			ex.printStackTrace();
		}
	}
	//moveToElement
	public void MoveToelement(WebElement ele)
	{
		try
		{
			Actions act=new Actions(driver);
			act.moveToElement(ele).build().perform();
		}
		catch(Exception ex)
		{
			System.out.println("problem in moveToElement method");
			ex.printStackTrace();
		}
	}
	//Keyboard actions
	public void keyboardActions(WebElement ele,String text)
	{
		try
		{
			Actions act=new Actions(driver);
			act.keyDown(ele,Keys.SHIFT).sendKeys(text).perform();
		}
		catch(Exception ex)
		{
			System.out.println("problem in keyBoard actions");
			ex.printStackTrace();
		}
	}
	
	//javascriptexecutor--vertical scroll
	public void jsVerticalScroll(int y)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,"+y+";)");
			
		}
		catch(Exception ex)
		{
			System.out.println("problem in javascript executor vertical scroll");
			ex.printStackTrace();
		}
	}
//horizontalscroll	
	public void jsHorizontalScroll(int x)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo("+x+",0);");
			
		}
		catch(Exception ex)
		{
			System.out.println("problem in javascript executor horizontal scroll");
			ex.printStackTrace();
		}
	}
//scroll down to the bottom of the page
	public void jsscrollDownBottom()
	{
	try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		
	}
	catch(Exception ex)
	{
		System.out.println("problem in  scroll down to the bottom of the page");
		ex.printStackTrace();
	}
	}
//scroll to the top of the page
	public void jsScrollUp()
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,0);");
		}
		catch(Exception ex)
		{
			System.out.println("problem in  scroll  to the top of the page");
			ex.printStackTrace();
		}
	}
	//jsClick
	public void jsClick(WebElement ele)
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",ele);
		}
		catch(Exception ex)
		{
			System.out.println("problem in javascript executor click method");
			ex.printStackTrace();
		}
	}
	//jstitle
	public void jsTitle()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			System.out.println(js.executeScript("return document.title();"));
			
		}
		catch(Exception ex)
		{
			System.out.println("problem in javascript executor title method");
			ex.printStackTrace();
		}
	}
	//typeTextwithout snedkeys
	public void typewithoutSendKeys(WebElement ele,String text)
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='+text+';",ele);
		}
		catch(Exception ex)
		{
			System.out.println("problem in javascriptexecutor typewithout sendkeys method");
			ex.printStackTrace();
		}
	}
	//scrollintoview
	public void scrollintoView(WebElement ele)
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",ele);
		}
		catch(Exception ex)
		{
			System.out.println("problem in scrollIntoview method");
			ex.printStackTrace();
		}
	}
	
		//window handling
	
	public void switchWindows()
	{
		try
		{
			String parentWindow= driver.getWindowHandle();
			Set<String> allWindows= driver.getWindowHandles();
			
			for(String eachWindow:allWindows)
			{
				if(! parentWindow.equals(eachWindow))
				{
					driver.switchTo().window(eachWindow);
				}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("problem in window handling");
			ex.printStackTrace();
		}
	}
	//get Title
	public String getTitle()
	{
		String title="";
		try
		{
		title=driver.getTitle();
		System.out.println(title);
		}
		catch(Exception ex)
		{
			System.out.println("problem in getTitle method");
			ex.printStackTrace();
		}
		return title;
	}
	//getCurrentUrl
	public void getCurrentUrl()
	{
		try
		{
			String currentUrl=driver.getCurrentUrl();
			System.out.println(currentUrl);
		}
		catch(Exception ex)
		{
			System.out.println("problem in getCurrent Url method");
			ex.printStackTrace();
		}
	}
	
	public void screenshot(String screenshotName)
	{
		try
		{
			File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest= new File(System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png");
			FileUtils.copyFile(source, dest);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}	
		//calender
		public void calender(String month1,String year1,String date1)
		{
			try
			{
				WebElement ele=driver.findElement(By.xpath(" //div[contains(@data-testid,'month-"+month1+"-"+year1+"')]//div[@data-testid='undefined-calendar-day-"+date1+"']/div"));
				ele.click();
			}
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
	}

}

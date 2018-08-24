package autoPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class initializzze {

	public static WebDriver driver = null;
	public Properties propety;
	public String url;

	
	public WebDriver InitialiseDriver() throws IOException
	{
		
		propety = new Properties();
		FileInputStream propertyFile = new FileInputStream("C:\\Users\\M\\eclipse-workspace\\SelfPractice2\\src\\autoPractice\\dataProperty.properties");
		
		propety.load(propertyFile);
		String browserName = propety.getProperty("browser");
		
		
	if (browserName.equals("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", "C://Users//M//Selenium_drivers//chromedriver.exe");	
		driver = new ChromeDriver();
//		log.info("Chrome browser selected");
		}
	else if (browserName.contains("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C://Users//M//Selenium_drivers//geckodriver.exe");
		driver = new FirefoxDriver();
//		log.info("Firefox browser selected");
		}
	else if (browserName.equals("IE"))
		{
		System.setProperty("webdriver.ie.driver", "C://Users//M//Selenium_drivers//IEDriverServer.exe");
		driver = new InternetExplorerDriver();	
//		log.info("IE browser selected");
		}
	else
		{
		System.out.println("Incorrect browser");
//		log.error("No browser found");
		}	
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	url = propety.getProperty("url");
	
	return driver;
	
	}

}

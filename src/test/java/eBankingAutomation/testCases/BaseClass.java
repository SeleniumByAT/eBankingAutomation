package eBankingAutomation.testCases;

import java.io.File;
import java.time.Duration;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import eBankingAutomation.testUtility.ReadConfigure;

public class BaseClass {
	ReadConfigure rc = new ReadConfigure();
	public String baseURL = rc.getURL();
	public String userID = rc.getUsername();
	public String userPass = rc.getPassword();
	public static WebDriver driver;
	

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		if (br.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			File file = new File("C:\\Users\\Nandan\\OneDrive\\Desktop\\uBlock-Origin.crx");
			option.addExtensions(file);
			driver = new ChromeDriver(option);
		} else if (br.equals("edge")) {
			driver = new InternetExplorerDriver();
		} else if (br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String tname) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + tname + ".png");
		sourcefile.renameTo(targetfile);
	}

}

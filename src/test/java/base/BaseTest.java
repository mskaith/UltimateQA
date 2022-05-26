package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class BaseTest {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(BaseTest.class.getName());
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\AutomationQA.xlsx");
	public static WebDriverWait wait;
	public static WebElement dropdown;
	public static JavascriptExecutor js;

	// Click Mehod
	public static void click(String lct) {

		if (lct.endsWith("_xp")) {
			driver.findElement(By.xpath(OR.getProperty(lct))).click();
		}

		else if (lct.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(lct))).click();
		} else if (lct.endsWith("_css")) {
			driver.findElement(By.cssSelector(OR.getProperty(lct))).click();
		}
		log.info("Clicking on the element " + lct);

	}

	// Sendkeys
	public static void type(String lct, String value) {

		if (lct.endsWith("_xp")) {

			driver.findElement(By.xpath(OR.getProperty(lct))).sendKeys(value);
		} else if (lct.endsWith("_id")) {

			driver.findElement(By.id(OR.getProperty(lct))).sendKeys(value);
			;
		} else if (lct.endsWith("_css")) {

			driver.findElement(By.cssSelector(OR.getProperty(lct))).sendKeys(value);
		}

		log.info("Typing in an Element: " + lct + " entered the value as : " + value);

	}

	// Setting up the Driver
	
	@BeforeSuite
	public void setUp() {
		
			// configuring log4j
			PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
			
			try {
				fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.info("OR properties loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				log.info("Config properties loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Config.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				log.info("Chrome Driver launched");
			}
			else if(Config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				log.info("Firefox Driver launched");
			}
			
			driver.get(Config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("impli"))));
			js = (JavascriptExecutor) driver;
		

	}
	
	@AfterSuite
	public void tearDown(){
		
		driver.quit();
		
	}

}

package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoaderTimout {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://apps.timeclockwizard.com/Login?Subdomain=qcqae");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("UserName")).sendKeys("sa");
		driver.findElement(By.id("Password")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@value='LogIn']")).click();
		
		//Wait Mechanism
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLoading")));
		System.out.println("1");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		System.out.println("2");
		
		// Clicking on the Pending TimeSheet Request
		driver.findElement(By.xpath("//div[text()='Pending Timesheet Requests']")).click();
		
		//Clicking on the search button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLoading")));
		System.out.println("1");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		System.out.println("2");
		driver.findElement(By.id("btnSearchtimesheet")).click();
		System.out.println("clicked");
	}

}

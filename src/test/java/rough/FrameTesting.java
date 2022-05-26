package rough;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameTesting {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.heroku.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		/*
		WebElement insideFrame = driver.findElement(By.id("cli_deploy"));
		driver.switchTo().frame(insideFrame);
		*/
		
		WebElement exploreHerokuBtn = driver.findElement(By.xpath("(//a[text()='Explore the Heroku Platform'])[2]"));
		
		  ((JavascriptExecutor)
		  driver).executeScript("arguments[0].scrollIntoView(true);",
		  exploreHerokuBtn); Thread.sleep(500);
		  exploreHerokuBtn.click();
		
		//JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("window.scrollBy(0,400)");
		//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//jse.executeScript("window.scrollTo(0,500)");
		//jse.executeScript("javascript:window.scrollBy(250,350)");
		//System.out.println("scrolled down");
		// Clicking on the element
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
				
		System.out.println(driver.getTitle());  
	}

}

package rough;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling2NewTabs {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String parentWindow =driver.getWindowHandle();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

		driver.findElement(By.id("newWindowsBtn")).click();

		// String pageTitle=driver.getTitle();
		// System.out.println(pageTitle);

		Set<String> allWindows = driver.getWindowHandles();
		for (String singleWindow : allWindows) {

			driver.switchTo().window(singleWindow);
			if (driver.getTitle().contains("XPath Practice")) {
				System.out.println(singleWindow);
				break;

			}
		}
		driver.manage().window().maximize();
		driver.switchTo().window(parentWindow);

	}

}

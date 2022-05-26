package rough;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MulipleWindowsHandler {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentWindow=driver.getWindowHandle();
		System.out.println("Parent Window: "+parentWindow);
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> handles=driver.getWindowHandles();
		for(String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				driver.findElement(By.id("firstName")).sendKeys("GTGTGTGTGT");
				
				
			}
		}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("ssdsdsfgttyu");

	}

}

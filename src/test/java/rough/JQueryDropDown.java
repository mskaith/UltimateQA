package rough;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='comboTree654582InputWrapper']/input")));
		//driver.findElement(By.xpath("//div[@id='comboTree654582InputWrapper']/input")).click();
		//WebElement dropDownbtn = driver.findElement(By.xpath("//button[@id='comboTree654582ArrowBtn']/span[@class='comboTreeArrowBtnImg']"));
		//Actions act = new Actions(driver);
		//act.moveToElement(dropDownbtn);
		//dropDownbtn.click();
		//driver.findElement(By.xpath("//button[@id='comboTree654582ArrowBtn']/span[@class='comboTreeArrowBtnImg']")).click();
		driver.findElement(By.id("justAnInputBox")).click();
		System.out.println("clicked the dropdown");

		//List<WebElement> childOptions = driver.findElements(By.xpath(
		//		"//div/h3[text()='Multi Selection']/following-sibling::div/descendant::div[@id='comboTree654582DropDownContainer']/descendant::li[@class='ComboTreeItemChlid']"));
	
		System.out.println("captured the size");
		//System.out.println(childOptions.size());
	
	}

}

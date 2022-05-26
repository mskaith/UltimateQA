package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class AllCoursesPage extends BaseTest {
	@Test(priority =1)
	public void landingOnCoursePage(){
		
		click("coursePageLink_xp");
		
		WebElement coursePageTitle=driver.findElement(By.xpath(OR.getProperty("coursePageTitle")));
		Assert.assertEquals(coursePageTitle.getText(), "All Courses");
		
		}
}

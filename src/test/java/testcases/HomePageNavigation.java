package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import base.BaseTest;

public class HomePageNavigation extends BaseTest {
	@Test(priority=1)
	public void landingOnHomePage() {

		WebElement homePageTitle = driver.findElement(By.xpath(OR.getProperty("homePageTitle")));
		
		

		Assert.assertEquals(homePageTitle.getText(),"Automation Practice");
	}
}

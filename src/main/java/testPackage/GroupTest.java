package testPackage;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupTest {

	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver108.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void addGroup() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		//driver.findElement(By.xpath("//*[@id='side-menu']/li[3]/a/span[1])")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
		driver.findElement(By.linkText("Groups")).click();
		WebElement GroupElement = driver.findElement(By.xpath("//h5[contains(text(),'Groups')]"));
		Assert.assertTrue("Wrong Page!",GroupElement.isDisplayed());
		driver.findElement(By.id("add_new_group")).click();
		//driver.findElement(By.xpath("//div[@class='modal-body']")).sendKeys("ALM");
		driver.findElement(By.xpath("//input[@id='group_name']")).sendKeys("ALM");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}
}

package com.testng.TestNGFramework;

import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Mini_Project {
	static WebDriver driver;
	
	@Test(priority =1 )
	public void toLaunchUrl() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\TestNGFramework\\\\driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void createAccount() {
		driver.findElement(By.partialLinkText("Sign in")).click();
		WebElement emailBox = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		emailBox.sendKeys("kishore2126@gmail.com", Keys.ENTER);
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("kishore");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("vino1209");
		WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
		Select secDay = new Select(day);
		secDay.selectByValue("3");
		WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
		Select secMonth = new Select(month);
		secMonth.selectByValue("3");
		WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
		Select secYear = new Select(year);
		secYear.selectByValue("1997");
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("kishore");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("no 84, Sumithra Nagar");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Poonmallae",Keys.TAB,"Chennai");
		WebElement state=driver.findElement(By.xpath("//select[@id='id_state']"));
		Select secState = new Select(state);
		secState.selectByValue("5");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("60660");
		WebElement text = driver.findElement(By.xpath("//textarea[@id='other']"));
		text.sendKeys("Hiii.. This is my mini project");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("04175606602");
		driver.findElement(By.id("phone_mobile")).sendKeys("8667304304");
		WebElement title = driver.findElement(By.xpath("//input[@id='alias']"));
		title.clear();
		title.sendKeys("Mini Project");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
	}
	
	@Test(priority = 2)
	public void addOnWomen() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		driver.findElement(By.className("sf-with-ul")).click();
		WebElement dress=driver.findElement(By.xpath("//div[@class='product-image-container']/descendant::img[@alt='Printed Chiffon Dress']"));
		scroll.executeScript("arguments[0].scrollIntoView();",dress);
		WebElement dressQuickView = driver.findElement(By.xpath("(//span[text()='Quick view'])[7]"));
		act.moveToElement(dress).moveToElement(dressQuickView).click().build().perform();
		WebElement frameName = driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
		driver.switchTo().frame(frameName);
		driver.findElement(By.className("icon-plus")).click();
		Select secWomen = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
		secWomen.selectByVisibleText("L");
		driver.findElement(By.xpath("//a[@id='color_15']")).click();
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();	
	}
	@Test(priority = 3)
	public void goToDresses() {

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		WebElement dressess = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
		WebElement summerDressess = driver.findElement(By.xpath("(//a[@title='Summer Dresses'])[2]"));
		act.moveToElement(dressess).moveToElement(summerDressess).click().build().perform();
		WebElement printedDress = driver.findElement(By.xpath("(//a[@title='Printed Summer Dress'])[4]"));
		scroll.executeScript("arguments[0].scrollIntoView();", printedDress);
		WebElement dressQuickView = driver.findElement(By.xpath("(//a[@class='quick-view'])[2]"));
		act.moveToElement(printedDress).moveToElement(dressQuickView).click().build().perform();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']")));
		driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
		WebElement size = driver.findElement(By.xpath("//select[@id='group_1']"));
		Select  sec = new Select(size);
		sec.selectByValue("3");
		driver.findElement(By.xpath("//a[@name='White']")).click();
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		
	}

	public void proceedCheckOut() {
	driver.findElement(By.xpath("//p//a[@title=\"Proceed to checkout\"]")).click();
	driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("I can doing automation practice ");
	driver.findElement(By.xpath("//button[@name='processAddress']")).click();
	driver.findElement(By.xpath("//input[@name='cgv']")).click();
	driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
	driver.findElement(By.xpath("//a[@class='bankwire']")).click();
	driver.findElement(By.xpath("//p//button[@type='submit']")).click();	
	
	}
	
	public void screenShot() throws IOException {
		TakesScreenshot snap = (TakesScreenshot) driver;
		File crop = snap.getScreenshotAs(OutputType.FILE);
		File location = new File ("C:\\Users\\hp\\eclipse-workspace\\Selenium_Class\\screenshot\\Mini_Projct.png");
		FileUtils.copyFile(crop, location);
	}
	
	
		
	}



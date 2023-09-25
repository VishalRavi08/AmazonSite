package com.bas;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ravi Dharshini\\eclipse-workspace_inmakes\\HotelApp\\Driver\\chromedriver_new.exe");
		driver = new ChromeDriver();
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static WebDriver browserLaunch(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Ravi Dharshini\\eclipse-workspace\\MavenProject\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Ravi Dharshini\\eclipse-workspace\\MavenProject\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		else {
			System.out.println("Invalid Brower is selected");
		}

		driver.manage().window().maximize();
		return driver;

	}

	public static void clickOnElement(WebElement element) {
		// element.click();
		element.click();
	}

	public static void sendValues(WebElement element, String values) {
		// element.sendKeys("");
		element.sendKeys(values);
	}

	public static void launchUrl(String url) {
		// driver.get("url");
		driver.get(url);
	}

	public static void capture() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File takeAs = ts.getScreenshotAs(OutputType.FILE);
		File loc = new File("C:\\Users\\Ravi Dharshini\\eclipse-workspace\\MavenProject\\ScreenShots\\order.png");
		FileHandler.copy(takeAs, loc);
		System.out.println("ScreenShot is taken successfully");
	}

	public static void x() {
		driver.close();
	}

	public static void q() {
		driver.quit();
	}

	public static void go() {
		driver.navigate().to("https://www.facebook.com/");
	}

	public static void before() {
		driver.navigate().back();
	}

	public static void after() {
		driver.navigate().forward();
	}

	public static void restore() {
		driver.navigate().refresh();
	}

	public static void title() {
		driver.getTitle();
	}

	public static void url() {
		driver.getCurrentUrl();
	}

	public static void text(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void attribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void alert() {
		driver.switchTo().alert();
	}

	public static void robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
	}

	public static void leftclick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick().build().perform();
	}

	public static void doubleclick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick().build().perform();
	}

	public static void clickAndDrag(WebElement element, WebElement element1) {
		Actions a = new Actions(driver);
		a.clickAndHold(element).moveToElement(element1).build().perform();
	}

	public static void radio(WebElement element) {
		// element.click();
		element.click();
	}

	public static void dropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public static void checkBox(WebElement element) {
		element.clear();
	}

	public static void singleDropDown(WebElement element, String methodType, String value) {
		Select s = new Select(element);
		if (methodType.equalsIgnoreCase("Value")) {
			s.selectByValue(value);
		} else if (methodType.equalsIgnoreCase("Index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (methodType.equalsIgnoreCase("VisibleText")) {
			s.selectByVisibleText(value);
		}

	}

	public static void enabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	public static void displayed(WebElement element) {
		boolean displayed = element.isEnabled();
		System.out.println(displayed);
	}

	public static void selected(WebElement element) {
		boolean selected = element.isEnabled();
		System.out.println(selected);
	}

}
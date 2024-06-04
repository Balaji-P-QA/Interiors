package org.interior;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	WebDriver driver;

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://dev.interiorsfurniture.com/");

		driver.manage().window().maximize();

		Thread.sleep(30000);
		
		WebElement allowCookies = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		allowCookies.click();
		Thread.sleep(5000);
	}

	@Test(priority = 1, enabled = true)
	private void login1() throws InterruptedException {

		WebElement accBtn = driver.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", accBtn);
		
		Thread.sleep(5000);

	}

	@Test(priority = 2, enabled = true)
	private void credentials() throws InterruptedException {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys("Balaji@123");

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

		Thread.sleep(4000);

		try {

			WebElement errMsg = driver.findElement(By.xpath("//div[text()='Invalid login or password.']"));

			// error msg is showing the if block will execute, otherwise errmsg is not
			// showing else block is will execute

			if (errMsg.isDisplayed()) {

				// if error msg is showing print the error msg
				System.out.println(errMsg.getText());

			}

		} catch (NoSuchElementException e) {

			// error msg is not showing this statement will execute
			System.out.println("user entered the proper username and password");

		}

	}

	@Test(priority = 3, enabled = false)
	private void withoutRule() throws InterruptedException {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("balaji.p@sysfore");

		Thread.sleep(3000);

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys("Balaji@123");

		// can get the username field value
		String emailId = userName.getAttribute("value");

		// click the submit button
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

		Thread.sleep(3000);
		
		// user name is without @ and .com if block will execute
		if (!emailId.contains("@") | !emailId.contains(".com")) {

			WebElement errmsg = driver.findElement(By.xpath("//div[@id='customer-email-error']"));

			// error msg is showing if block will execute,
			if (errmsg.isDisplayed()) {

				System.out.println("error msg showing properly");
				System.out.println(errmsg.getText());

				// error msg is not showing else block will execute.
			} else {

				System.out.println("error msg is not showing");
			}

			// username with @ and .com else block will execute
		} else {

			System.out.println("user entered the emaild is with @ and .com");

		}

		Thread.sleep(3000);

	}

	@Test(priority = 4, enabled = false)
	private void withoutEmpty() {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("");

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys("");

		// can get the username field value
		String emailId = userName.getAttribute("value");

		String keyword = password.getAttribute("value");

		// click the submit button
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

		// email field is empty if block will execute,email not empty else block will
		// execute
		if (emailId.isEmpty()) {

			System.out.println("username  field is empty");

			WebElement emailErrMsg = driver.findElement(By.xpath("//div[@id='customer-email-error']"));

			if (emailErrMsg.isDisplayed()) {

				System.out.println("please enter your user name");
				System.out.println(emailErrMsg.getText());
			}
		} else {

			System.out.println("username  field is not empty");
		}

		// password field is empty if block will execute,password not empty else block
		// will execute
		if (keyword.isEmpty()) {

			System.out.println("password field is empty");
			WebElement passErrMsg = driver.findElement(By.xpath("//div[@id='pass-error']"));

			if (passErrMsg.isDisplayed()) {

				System.out.println("please enter your password");
				System.out.println(passErrMsg.getText());
			}
		} else {

			System.out.println("password field is not empty");
		}

	}

	@AfterClass
	private void end() {

		driver.quit();

	}

}

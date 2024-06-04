package org.interior;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunction {

	WebDriver driver;

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://dev.interiorsfurniture.com/");

		driver.manage().window().maximize();

		Thread.sleep(30000);

	/*	WebElement allowCookies = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		allowCookies.click();
		Thread.sleep(5000); */
	}

	@Test(priority = 1, enabled = false)
	private void login1() throws InterruptedException {

		WebElement accBtn = driver
				.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", accBtn);

		Thread.sleep(5000);

	}

	@Test(priority = 2, enabled = false)
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

	@Test(priority = 5, enabled = true,dataProvider = "datasFromExcel")
	private void checking(String user,String key)  {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys(user);

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys(key);

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

		// driver.quit();

	}



	@DataProvider
	private Object[][] datasFromExcel() throws IOException {

		File f = new File(
				"C:\\Users\\Balaji.p\\eclipse-workspace\\Karauae\\DatasStorage\\Login credentials for proshop.xlsx");

		FileInputStream fin = new FileInputStream(f);

		Workbook b = new XSSFWorkbook(fin);

		Sheet s = b.getSheetAt(1);

		Row r0 = s.getRow(1);
		Cell c0 = r0.getCell(0);
		String u1 = c0.getStringCellValue();
		Cell c1 = r0.getCell(1);
		String k1 = c1.getStringCellValue();

		Row r1 = s.getRow(2);
		Cell c01 = r1.getCell(0);
		String u01 = c01.getStringCellValue();
		Cell c02 = r1.getCell(1);
		String k01 = c02.getStringCellValue();

		Row r2 = s.getRow(3);
		Cell c001 = r2.getCell(0);
		String u001 = c001.getStringCellValue();
		Cell c002 = r2.getCell(1);
		String k001 = c002.getStringCellValue();

		Row r3 = s.getRow(4);
		Cell c0001 = r3.getCell(0);
		String u0001 = c0001.getStringCellValue();
		Cell c0002 = r2.getCell(1);
		String k0001 = c0002.getStringCellValue();

		Object[][] o = new Object[4][2];

		o[0][0] = u1;
		o[0][1] = k1;
		o[1][0] = u01;
		o[1][1] = k01;
		o[2][0] = u001;
		o[2][1] = k001;
		o[3][0] = u0001;
		o[3][1] = k0001;

		return o;

	}

}

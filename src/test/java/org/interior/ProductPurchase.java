package org.interior;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductPurchase {

	static WebDriver driver;

	JavascriptExecutor js;

	String SelectPayment;
	
	Actions a;

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// url launch

		driver.get("https://www.interiorsfurniture.com/");

		// widow maximize

		driver.manage().window().maximize();

		// apply implicitlywait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// accept cookies
		WebElement acceptCookies = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		acceptCookies.click();

		Thread.sleep(3000);
	}

	@Test(priority = 1, enabled = false)
	private void login() throws InterruptedException {

		// sign logo

		WebElement accBtn = driver
				.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", accBtn);

		Thread.sleep(5000);

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys("Balaji@123");

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

		Thread.sleep(5000);

	}

	@Test(priority = 2, enabled = true)
	private void productSelecting() throws InterruptedException {

		String GeneralSearch = "";
		String Categorieswise = "";
		String CategoriesPagewise = "yes";

		if (GeneralSearch.equals("yes")) {

			WebElement searchbar = driver.findElement(By.xpath("//input[@id='search']"));
			searchbar.sendKeys("WALL DECOR 04170 BLAISE SZ32Wx32Hx3DIN");

			Thread.sleep(2000);

			Thread.sleep(5000);

			int productNum = 1;

			List<WebElement> addToCart = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", addToCart.get(productNum));

			Thread.sleep(2000);

		} else if (Categorieswise.equals("yes")) {

			WebElement furniture = driver.findElement(By.xpath("(//span[text()='Furniture'])[2]"));
			Actions a = new Actions(driver);
			a.moveToElement(furniture).build().perform();

			Thread.sleep(2000);

			WebElement coffeeAndSideTables = driver.findElement(By.xpath("(//span[text()='Coffee & Side Tables'])[2]"));
			coffeeAndSideTables.click();

			Thread.sleep(2000);

			Thread.sleep(5000);

			int productNum = 1;

			List<WebElement> addToCart = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", addToCart.get(productNum));

			Thread.sleep(2000);

		} else if (CategoriesPagewise.equals("yes")) {

			Actions a = new Actions(driver);
			WebElement homedecor = driver.findElement(By.xpath("(//span[text()='Home Decor'])[2]"));
			a.moveToElement(homedecor).build().perform();

			Thread.sleep(1000);
//new
			WebElement mirror = driver.findElement(By.xpath("(//span[text()='Mirrors '])[20000000000]"));
			mirror.click();

			String ExpectProductName = "Coulson mirror- Uttermost";

			ProductPurchasePoj p = new ProductPurchasePoj(driver);

			for (int k = 0; k < p.productNames.size(); k++) {

				String specificProductName = p.productNames.get(k).getText();

				if (specificProductName.equalsIgnoreCase(ExpectProductName)) {

					List<WebElement> addToCart = driver.findElements(By.cssSelector("button[title='Add to Cart']"));
					a = new Actions(driver);
					a.moveToElement(addToCart.get(k)).perform();
					Thread.sleep(1000);
					addToCart.get(k).click();
					break;

				}

				if (k == p.productNames.size() - 1) {

					try {
						WebElement nextBtn = driver.findElement(By.xpath("(//span[text()='Next'])[2]"));
						nextBtn.click();
						k = -1;
						Thread.sleep(5000);
					} catch (Exception e) {

						System.out.println("User Expected Product is not Available");

					}

				}

			}

		}

	}

	@Test(priority = 3, enabled = false)
	private void CartWorks() throws InterruptedException, AWTException {

		// click the cart icon
		WebElement CartBasket = driver.findElement(By.xpath("//a[@class='action showcart']"));
		CartBasket.click();

		Thread.sleep(2000);

		/**/ String viewAndEditCart = "yes";

		// view and Edit cart equals to yes if block will execute
		if (viewAndEditCart.equals("yes")) {

			WebElement viewAndEdit = driver.findElement(By.xpath("//span[text()='View and Edit Cart']"));
			viewAndEdit.click();

			Thread.sleep(2000);

			/**/ String increaseAndDecrease = "yes";

			// increaseAndDecrese is equals to yes if block will execute
			if (increaseAndDecrease.equals("yes")) {

				WebElement enterQty = driver.findElement(By.xpath("//input[@class='input-text qty real-qty']"));
				enterQty.clear();
				enterQty.sendKeys("1");

				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);

				Thread.sleep(5000);

				/**/ String ProceedToCheckout = "yes";

				// ProceedToCheckout is eqals to yes if block will execute,not equals to yes
				// else block will execute
				if (ProceedToCheckout.equals("yes")) {

					// click the proceed to checkout
					WebElement proceed = driver.findElement(By.xpath("//span[text()='Proceed to Checkout']"));
					proceed.click();

				} else {

					// click the continue shopping
					WebElement continueShopping = driver.findElement(By.xpath("//span[text()='Continue Shopping']"));
					continueShopping.click();

				}

			} else {
				// remove the cart product
				WebElement remove = driver.findElement(By.xpath("//span[text()=' Remove item ']"));
				js.executeScript("arguments[0].click();", remove);

			}

		} else {

			// click the proceed to checkout
			WebElement proceed = driver.findElement(By.xpath("//button[text()='Proceed to Checkout']"));
			proceed.click();

		}

	}

	@Test(priority = 4, enabled = false)
	private void checkout() throws InterruptedException {

		/**/ String addNewAddress = "yes";

		if (addNewAddress.equals("")) {

			// scroll Down
			WebElement scrDown = driver.findElement(By.xpath("//span[text()='Ship Here']"));
			js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

			Thread.sleep(3000);

			// click the Add New Address Btn
			WebElement addNewAddressBtn = driver.findElement(By.xpath("//span[text()='New Address']"));
			addNewAddressBtn.click();

			Thread.sleep(3000);

			// select the Name Prefix
			WebElement namePrefix = driver.findElement(By.xpath("(//select[@class='select'])[1]"));
			Select s = new Select(namePrefix);
			s.selectByIndex(2);

			Thread.sleep(2000);

			// enter the Phone number
			WebElement phone = driver.findElement(By.xpath("(//input[@class='input-text'])[9]"));
			phone.sendKeys("9123456789");

			Thread.sleep(2000);

			// enter the Flat No
			WebElement FlatNo = driver.findElement(By.xpath("(//input[@class='input-text'])[11]"));
			FlatNo.sendKeys("001 test flat");

			Thread.sleep(2000);

			// enter the street name
			WebElement street = driver.findElement(By.xpath("(//input[@class='input-text'])[12]"));
			street.sendKeys("test street");

			Thread.sleep(2000);

			// enter the landmark
			WebElement landmark = driver.findElement(By.xpath("(//input[@class='input-text'])[13]"));
			landmark.sendKeys("test school opposite");

			Thread.sleep(2000);

			// select the city
			WebElement city = driver.findElement(By.xpath("(//select[@class='select'])[2]"));
			Select s1 = new Select(city);
			s1.selectByIndex(3);

			Thread.sleep(2000);

			// select the UAE
			WebElement uae = driver.findElement(By.xpath("(//select[@class='select'])[4]"));
			Select s2 = new Select(uae);
			s2.selectByIndex(0);

			Thread.sleep(2000);

			// click the ShipHere button
			WebElement shipHereBtn = driver.findElement(By.xpath("//span[text()='Ship here']"));
			shipHereBtn.click();
		}

		Thread.sleep(2000);

		WebElement scrDown = driver.findElement(By.xpath("//div[text()='Shipping Methods']"));
		js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

		Thread.sleep(3000);

		// click the Next button
		WebElement nextNBtn = driver.findElement(By.xpath("//span[text()='Next']"));
		nextNBtn.click();

	}

	@Test(priority = 5, enabled = false)
	private void checkoutPayment() throws InterruptedException {

		/**/ String discountCode = "";

		// discount code equals to yes if block will execute,otherwise not execute
		if (discountCode.equals("yes")) {

			// enter the discoun code
			WebElement discountCodeName = driver.findElement(By.xpath("//input[@name='discount_code']"));
			discountCodeName.sendKeys("Test@123");

			Thread.sleep(3000);

			// apply the discount code button
			WebElement applyDiscount = driver.findElement(By.xpath("//span[text()='Apply Discount']"));
			applyDiscount.click();

			// validate the discount code
			try {

				// err msg is showing if block will execute, not showing catch block will
				// execute
				WebElement errMsg = driver.findElement(By.xpath("//div[@class='message message-error error']"));

				if (errMsg.isDisplayed()) {
					System.out.println("Please enter the Valid discount code");
				}

			} catch (Exception e) {

				// print the statement
				System.out.println("Discount code Successfully Applied");

			}

		}

		/**/ String useStoreCredit = "yes";

		// useStoreCredit is equals to yes if block will execute,not equals its not
		// execute
		if (useStoreCredit.equals("")) {

			// click the store credit option
			WebElement openStoreCredit = driver.findElement(By.xpath("(//span[@id='block-discount-heading'])[2]"));
			openStoreCredit.click();

			Thread.sleep(2000);

			// enter the Amount
			WebElement creditAmount = driver.findElement(By.xpath("//input[@id='credit-amount']"));
			creditAmount.sendKeys("10");

			Thread.sleep(2000);

			// click the apply store credit button
			WebElement applyStoreCredit = driver.findElement(By.xpath("//button[@id='apply-credit']"));
			applyStoreCredit.click();

			// validate the store credit Amount
			try {

				// err msg is displayed if block will execute, err msg is not showing catch
				// block will execute
				WebElement errMsg = driver.findElement(By.xpath("//div[@class='message message-error error']"));

				if (errMsg.isDisplayed()) {
					System.out.println("Please use Your Proper Balance");
				}

			} catch (Exception e) {

				// print the statement
				System.out.println("Store Credit Amount Successfully Applied");

			}

		}

		/**/ SelectPayment = "Postpay";

		// SelectPayment is equals to cash On Delivery if block will execute.
		// SelectPayment is equals to CC Avenue1 elseif block will execute.
		// SelectPayment is not equals both else block will execute.

		if (SelectPayment.equals("Postpay")) {

			WebElement postpayRadioBtn = driver.findElement(By.xpath("//input[@id='postpay']"));
			postpayRadioBtn.click();

			Thread.sleep(2000);

			WebElement continuePostpayBtn = driver.findElement(By.xpath("//span[text()='Continue to Postpay']"));
			continuePostpayBtn.click();

		} else if (SelectPayment.equals("CC Avenue1")) {

			WebElement ccAvenueRadioBtn = driver.findElement(By.xpath("//input[@id='ccavenue']"));
			ccAvenueRadioBtn.click();

			Thread.sleep(2000);

			WebElement placeOrderBtn = driver.findElement(By.xpath("(//span[text()='Place Order'])[1]"));
			placeOrderBtn.click();

		} else {

			WebElement cashOnDeliveryRadioBtn = driver.findElement(By.xpath("//input[@id='cashondelivery']"));
			cashOnDeliveryRadioBtn.click();

			Thread.sleep(2000);

			WebElement placeOrderBtn = driver.findElement(By.xpath("(//span[text()='Place Order'])[2]"));
			placeOrderBtn.click();
		}

	}

	@Test(priority = 6, enabled = false)
	private void paymentGateway() throws InterruptedException {

		if (SelectPayment.equals("Postpay")) {

			WebElement sendCode = driver.findElement(By.xpath("//button[text()='Send Code']"));
			sendCode.click();

			Thread.sleep(2000);

			try {

				WebElement errMSg = driver.findElement(By.xpath("//div[text()='Please enter a valid phone number.']"));

				if (errMSg.isDisplayed()) {

					System.out.println(errMSg.getText());
				}

			} catch (Exception e) {

				System.out.println("Thankyou for Used Postpay Gateway");
			}

		} else if (SelectPayment.equals("CC Avenue1")) {

			WebElement scrollDown = driver.findElement(By.xpath("(//div[@class='span6'])[2]"));
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);

			Thread.sleep(3000);

			WebElement creditCardNumber = driver.findElement(By.xpath("//input[@id='creditCardNumber']"));
			creditCardNumber.sendKeys("5123450000000008");

			Thread.sleep(3000);

			WebElement expireMonth = driver.findElement(By.xpath("//select[@id='expiryMonthCreditCard']"));
			Select s = new Select(expireMonth);
			s.selectByIndex(1);

			Thread.sleep(2000);

			// enter the expire year
			WebElement expireYear = driver.findElement(By.xpath("//select[@id='expiryYearCreditCard']"));
			Select s1 = new Select(expireYear);
			s1.selectByVisibleText("2039");

			Thread.sleep(1000);

			// enter the CCV number
			WebElement ccvNumber = driver.findElement(By.xpath("//input[@id='CVVNumberCreditCard']"));
			ccvNumber.sendKeys("100");

			Thread.sleep(2000);

			// click the submit button
			WebElement submit = driver.findElement(By.xpath("(//span[text()='Make Payment'])[1]"));
			submit.click();

			Thread.sleep(6000);

			// click the send Any way from submit button
			WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Submit']"));
			submitBtn.click();

			Thread.sleep(8000);

		}

	}

}

package org.interior;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompareAndWishList {

	WebDriver driver;

	JavascriptExecutor js;

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// url launch

		driver.get("https://dev.interiorsfurniture.com/");

		// widow maximize

		driver.manage().window().maximize();

		// apply implicitlywait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// accept cookies
		WebElement acceptCookies = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		acceptCookies.click();

		Thread.sleep(3000);
	}

	@Test(priority = 1, enabled = true)
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

		/**/ String productSelect = "General Search";

		if (productSelect.equals("General Search")) {

			WebElement searchbar = driver.findElement(By.xpath("//input[@id='search']"));
			searchbar.sendKeys("WALL DECOR 04170 BLAISE SZ32Wx32Hx3DIN");

			Thread.sleep(2000);

		} else {

			WebElement furniture = driver.findElement(By.xpath("(//span[text()='Furniture'])[2]"));
			Actions a = new Actions(driver);
			a.moveToElement(furniture).build().perform();

			Thread.sleep(2000);

			WebElement coffeeAndSideTables = driver.findElement(By.xpath("(//span[text()='Coffee & Side Tables'])[2]"));
			coffeeAndSideTables.click();

			Thread.sleep(2000);

		}

		Thread.sleep(5000);

		int productNum = 0;

		List<WebElement> productDetails = driver.findElements(By.xpath("//a[@class='product-item-link']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", productDetails.get(productNum));

		Thread.sleep(2000);
	}

	@Test(priority = 2, enabled = true)
	private void wishList() throws InterruptedException {

		// get the specific product name and fetch that
		WebElement prodctName = driver.findElement(By.xpath("//span[@class='base']"));
		String productName = prodctName.getText();
		System.out.println(productName);

		Thread.sleep(2000);

		// add to wishList that product
		WebElement addToWishList = driver.findElement(By.xpath("//span[text()='Add To Wish List']"));
		addToWishList.click();

		// empty msg is displayed try block will execute,empty msg is not displayed
		// catch block will execute
		try {

			WebElement emptyMsg = driver.findElement(By.xpath("//div[@class='message info empty']"));

			// print the success msg
			if (emptyMsg.isDisplayed()) {

				System.out.println(emptyMsg.getText());

			}

		} catch (Exception e) {

			System.out.println("User expect product is added to our wishList");

			// get the product name and fetch that
			String ProductName = driver.findElement(By.xpath("(//strong[@class='product-item-name'])")).getText();
			System.out.println("User Expected Product Name is" + ProductName);

			Thread.sleep(3000);

			// scroll Down
			WebElement scrDown = driver.findElement(By.xpath("//a[text()='Data Privacy']"));
			js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

			Thread.sleep(3000);

			String WishList = "Update";

			// wishList is equals to update if block will execute.
			// wishList is equals to share elseif block will execute.
			// wishList is not equals to both else block will execute.
			if (WishList.equals("Update")) {

				// enter the quantity here
				WebElement qty = driver.findElement(By.xpath("//input[@class='input-text qty']"));
				qty.clear();
				qty.sendKeys("2");

				// click the updare button
				WebElement updateBtn = driver.findElement(By.xpath("//span[text()='Update Wish List']"));
				updateBtn.click();

				Thread.sleep(1000);

				// validate the Update msg
				WebElement updateMsg = driver
						.findElement(By.xpath("//div[contains(text(),'updated in your Wish List.')]"));

				// msg is showing if block will execute,msg is not showing else block will
				// execute
				if (updateMsg.isDisplayed()) {

					System.out.println(updateMsg.getText());

				} else {
					System.out.println("WishList Update UnscuccessFul");
				}

			} else if (WishList.equals("Share")) {

				// click the sharewishList button
				WebElement shareWishList = driver.findElement(By.xpath("//span[text()='Share Wish List']"));
				shareWishList.click();

				// enter the email address
				WebElement email = driver.findElement(By.xpath("//textarea[@name='emails']"));
				email.sendKeys("test.t@mailinator.com");

				// enter the message
				WebElement msg = driver.findElement(By.xpath("//textarea[@id='message']"));
				msg.sendKeys("Its My Favourite Product");

				// click the share wishListBTn
				WebElement shareWishListBtn = driver.findElement(By.xpath("//span[text()='Share Wish List']"));
				shareWishListBtn.click();

				// validate the sharedMsg
				WebElement shareMsg = driver.findElement(By.xpath("//div[text()='Your wish list has been shared.']"));

				// share msg is displayed if block will execute
				if (shareMsg.isDisplayed()) {

					System.out.println(shareMsg.getText());
					Assert.assertTrue(true);
				}

			} else {

				// click the add to all cart button
				WebElement addAllToCart = driver.findElement(By.xpath("//span[text()='Add All to Cart']"));
				addAllToCart.click();

				// validate the cart msg
				WebElement cartMsg = driver
						.findElement(By.xpath("//div[contains(text(),'product(s) have been added to shopping cart')]"));

				// cart msg is displayed if block will execute
				if (cartMsg.isDisplayed()) {

					System.out.println(cartMsg.getText());
					Assert.assertTrue(true);
				}

			}

			/**/ String remove = "yes";

			// remove is equals to yes if block will execute
			if (remove.equals("yes")) {

				// click the remove btn
				WebElement removeBtn = driver.findElement(By.xpath("//span[text()='Remove item']"));
				removeBtn.click();

				// validate the remove msg
				WebElement removeMSg = driver
						.findElement(By.xpath("//div[contains(text(),'removed from your Wish List.')]"));

				// remove msg is displayed if block will execute
				if (removeMSg.isDisplayed()) {

					System.out.println(removeMSg.getText());
					Assert.assertTrue(true);
				}
			}

		}

	}

	@Test(priority = 3, enabled = false)
	private void addToCompare() throws InterruptedException {

		// get the specific product name and fetch that
		WebElement prodctName = driver.findElement(By.xpath("//span[@class='base']"));
		String productName = prodctName.getText();
		System.out.println(productName);

		Thread.sleep(2000);

		// Click the add to compare Btn
		WebElement addToCompare = driver.findElement(By.xpath("//span[text()='Add To Compare']"));
		addToCompare.click();

		Thread.sleep(2000);

		// validate the compare Popup
		WebElement ComparedPopup = driver
				.findElement(By.xpath("//div[contains(@class,'popup-border ajaxcompare-success-box')]"));

		// compare popup is showing if block will execute
		if (ComparedPopup.isDisplayed()) {

		/**/	String viewComparison = "yes";

			// viewComparison is equals to yes if block will execute
			if (viewComparison.equals(" ")) {

				// click the view compare button
				WebElement viewCompare = driver.findElement(By.xpath("//span[text()='View Comparison']"));
				viewCompare.click();

				Thread.sleep(2000);

				// get the product name and fetch that
				WebElement actualProduct = driver.findElement(By.xpath("//strong[@class='product-item-name']"));
				System.out.println(actualProduct.getText());

				/**/ String needsTo = "Remove";

				// needsTo equal to Remove if block will execute.
				// needTo equals to AddToWishList elseif block will execute.

				if (needsTo.equals("Remove")) {

					// click the cancel button
					List<WebElement> cancelBtn = driver.findElements(By.xpath("(//span[text()='Remove Product'])[2]"));
					js = (JavascriptExecutor) driver;
					/**/ js.executeScript("arguments[0].click();", cancelBtn.get(0));

					Thread.sleep(2000);

					// click the Ok button
					WebElement okBtn = driver.findElement(By.xpath("//span[text()='OK']"));
					okBtn.click();

					Thread.sleep(2000);

					// validate the remove msg
					WebElement removeMsg = driver
							.findElement(By.xpath("//div[contains(text(),'You removed product')]"));

					// removed msg is displayes if block will execute,removed msg is not displayed
					// else block will execute
					if (removeMsg.isDisplayed()) {

						System.out.println(removeMsg.getText());

					} else {

						System.out.println("product is not removed in your Comparison List");
					}

				} else if (needsTo.equals("AddToWishList")) {

					// click the add to wish List button
					List<WebElement> addToWishlist = driver
							.findElements(By.xpath("(//span[text()='Add to Wish List'])"));
					/**/ addToWishlist.get(0).click();

					Thread.sleep(2000);

					// validate the wishList popup
					WebElement addWishListMsg = driver
							.findElement(By.xpath("//div[contains(text(),'added to your Wish List. Click ')]"));

					// wishList popup is displayed if block will execute,not displayed else block
					// will execute
					if (addWishListMsg.isDisplayed()) {

						System.out.println(addWishListMsg.getText());

					} else {

						System.out.println("product is not added in your Wish List");
					}

				}

			}

			else {

				//click to cancel the view comparison 
				WebElement cancelViewComparison = driver.findElement(By.xpath("//a[@class='mb-ajaxsuite-close']"));
				cancelViewComparison.click();
			}

		} else {

			// product is not added in comparison list this statement is printing
			System.out.println("Product is not added to Your Comparison List");

		}

	}

}

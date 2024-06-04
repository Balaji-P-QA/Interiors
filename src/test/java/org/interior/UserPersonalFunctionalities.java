package org.interior;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserPersonalFunctionalities {

	WebDriver driver;

	JavascriptExecutor js;

	String oldPassword;

	String newPassword;
	
	String viewOrder = "yes";
	
	String reOrder = "no";

	@BeforeClass
	private void start() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.interiorsfurniture.com/");

		driver.manage().window().maximize();

		Thread.sleep(30000);

		WebElement allowCookies = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		allowCookies.click();
		Thread.sleep(5000);
	}

	@Test(priority = 1, enabled = true)
	private void login1() throws InterruptedException {

		// click the account Btn
		WebElement accBtn = driver
				.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", accBtn);

		Thread.sleep(5000);

	}

	@Test(priority = 2, enabled = true)
	private void credentials() throws InterruptedException {

		oldPassword = "Balaji@123";

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
		password.sendKeys(oldPassword);

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Sign In']"));
		submit.click();

	}

	@Test(priority = 3, enabled = true)
	private void goToMyAccount() throws InterruptedException {

		// Click the Account Btn
		WebElement accBtn = driver
				.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile proceed-to-checkout']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", accBtn);

		Thread.sleep(3000);

		// click the MyAccount option
		WebElement myAccount = driver.findElement(By.xpath("(//a[text()='My Account'])[1]"));
		js.executeScript("arguments[0].click();", myAccount);

		Thread.sleep(2000);

	}

	@Test(priority = 4, enabled = true)
	private void myOrders() throws InterruptedException {

		// click the My Orders Link
		WebElement myOrders = driver.findElement(By.xpath("(//a[text()='My Orders'])[1]"));
		myOrders.click();

		Thread.sleep(2000);

		// to check the user ordered count
		List<WebElement> ordersCount = driver.findElements(By.xpath("//span[text()='View Order']"));
		System.out.println("User have Ordered " + ordersCount.size() + " Products");


		int num =0;

		// viewOrder is eqals to yes if block will execute,not equal to yes if block
		// will not execute
		if (viewOrder.equals("yes")) {

			// click the view Orders option
			List<WebElement> viewOrders = driver.findElements(By.xpath("//span[text()='View Order']"));
			viewOrders.get(num).click();

			Thread.sleep(3000);

			// get/fetch the ordered Product Name
			WebElement productName = driver.findElement(By.xpath("//strong[@class='product name product-item-name']"));
			System.out.println("User viewed that particular product name is " + productName.getText());

			Thread.sleep(3000);

			// go to back
			WebElement backToMyOrders = driver.findElement(By.xpath("//span[text()='Back to My Orders']"));
			backToMyOrders.click();
		}

		

		// reorder is equals to yes if block will execute ,not equals to yes its not
		// execute
		if (reOrder.equals("yes")) {

			// click the Reorders link
			List<WebElement> reOrders = driver.findElements(By.xpath("//span[text()='Reorder']"));
			reOrders.get(num).click();

			// get the current title
			String title = driver.getTitle();

			// title is equal to shopping cart if block will execute,not equals to shopping
			// cart else block will execute
			if (title.equals("Shopping Cart")) {

				System.out.println("if we clicked he Reorder that product is added to Your cart");
				Assert.assertTrue(true);

			} else {

				System.out.println("if we clicked he Reorder that product is not added to Your cart");
				Assert.assertTrue(false);

			}

			Thread.sleep(5000);

			// go to back
			driver.navigate().back();

		}

	}

	@Test(priority = 5, enabled = false)
	private void myWishList() throws InterruptedException {

		// click the wishList link
		WebElement myWishList = driver.findElement(By.xpath("//a[text()='My Wish List']"));
		myWishList.click();

		Thread.sleep(3000);

		// wish List is empty try block will execute,wish List is not empty catch block
		// will execute
		try {

			WebElement wishLitEmpty = driver.findElement(By.xpath("//div[@class='message info empty']"));

			// err msg validation here
			if (wishLitEmpty.isDisplayed()) {

				System.out.println("User dont have a Product in Our WishList");
			}

		} catch (Exception e) {

			// get the wish List count and print that count
			List<WebElement> wishListCount = driver.findElements(By.xpath("//a[@class='product-item-link']"));
			System.out.println("User have a " + wishListCount.size() + " Products in our WishList");

		}

		// go to back
		WebElement goToBack = driver.findElement(By.xpath("//span[text()='Back']"));
		goToBack.click();

	}

	@Test(priority = 6, enabled = false)
	private void addressBook() throws InterruptedException {

		// click the addressBook
		WebElement addressBook = driver.findElement(By.xpath("//a[text()='Address Book']"));
		addressBook.click();

		Thread.sleep(3000);

		/**/ String changeAddress = "Edit";

		// changeAddress is equals to Edit if block will execute.
		// changeAddress is equal to delete elseif block will execute.
		if (changeAddress.equals("Edit")) {

			// select the which address you edit that
			List<WebElement> edit = driver.findElements(By.xpath("//span[text()='Edit']"));
			edit.get(0).click();

			Thread.sleep(2000);

			// name prefix
			WebElement namePrefix = driver.findElement(By.xpath("//select[@id='prefix']"));
			Select s1 = new Select(namePrefix);

			Thread.sleep(2000);

			// phone
			WebElement phone = driver.findElement(By.xpath("//input[@title='Phone Number']"));
			phone.clear();
			phone.sendKeys("234569876");

			Thread.sleep(2000);

			// flat
			WebElement flatNo = driver.findElement(By.xpath("//input[@id='street_1']"));
			flatNo.clear();
			flatNo.sendKeys("04/t Test Flats");

			Thread.sleep(2000);

			// street
			WebElement street = driver.findElement(By.xpath("//input[@id='street_2']"));
			street.clear();
			street.sendKeys("Test Street");

			Thread.sleep(2000);

			// landmark
			WebElement landMark = driver.findElement(By.xpath("//input[@id='street_3']"));
			landMark.clear();
			landMark.sendKeys("Opposite to Test School");

			// city
			WebElement city = driver.findElement(By.xpath("//select[@id='city']"));
			Select s2 = new Select(city);
			s2.selectByIndex(4);

			Thread.sleep(2000);

			// country
			WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
			Select s3 = new Select(country);
			s3.selectByIndex(0);

			Thread.sleep(2000);

			String defaultt = "";

			// defaultt is equals to billing if block will execute,
			// defaultt is equals to Shipping elseif block will execute
			if (defaultt.equals("billing")) {

				// click the billing checkbox
				driver.findElement(By.xpath("(//input[@class='checkbox'])[1]")).click();

			} else if (defaultt.equals("Shipping")) {

				// click the shipping checkbox
				driver.findElement(By.xpath("(//input[@class='checkbox'])[2]")).click();

			}

			Thread.sleep(2000);

			// click the save address Btn
			WebElement saveAddress = driver.findElement(By.xpath("//span[text()='Save Address']"));
			saveAddress.click();

		} else if (changeAddress.equals("Delete")) {

			// get the Count of Addition address entries
			List<WebElement> addressCount = driver.findElements(By.xpath("//span[text()='Delete']"));
			System.out.println("User have a " + addressCount.size() + " Additional Address entries");

			// delete the particular address
			List<WebElement> addressDelete = driver.findElements(By.xpath("//span[text()='Delete']"));
			addressDelete.get(0).click();

			Thread.sleep(2000);

			// click the Ok option for Confirmation
			WebElement deleteConfirm = driver.findElement(By.xpath("//span[text()='OK']"));
			deleteConfirm.click();

			Thread.sleep(2000);

			// after the delete the single address then get the Additional Address Count
			List<WebElement> afterDeleteAddress = driver.findElements(By.xpath("//span[text()='Delete']"));
			System.out.println("After deleted the single Address User have a " + afterDeleteAddress.size()
					+ " Additional Address");

		}

	}

	@Test(priority = 7, enabled = false)
	private void myProductReviews() throws InterruptedException {

		// click the MyProductReviews
		WebElement myProductReviews = driver.findElement(By.xpath("//a[text()='My Product Reviews']"));
		myProductReviews.click();

		Thread.sleep(2000);

		// validate the MyProductReviews empty Msg,eempty msg is displayed try block
		// will execute,empty msg is not showing catch block will execute
		try {

			WebElement errMsg = driver.findElement(By.xpath("//div[@class='message info empty']"));

			if (errMsg.isDisplayed()) {

				// print the statement
				System.out.println("Still User not give the Review For Any Product");

			}

		} catch (Exception e) {

			// get the Product reviews count and fetch that count
			List<WebElement> reviewsCount = driver.findElements(By.xpath("//span[text()='See Details']"));
			System.out.println("User have given the " + reviewsCount.size() + " Reviews");

		}

		// go to back
		WebElement backBtn = driver.findElement(By.xpath("//span[text()='Back']"));
		backBtn.click();

	}

	@Test(priority = 8, enabled = false)
	private void newsLetterSubscription() throws InterruptedException {

		//click the NewsLetter subscription link 
		WebElement newsLetterSubscription = driver.findElement(By.xpath("//a[text()='Newsletter Subscriptions']"));
		newsLetterSubscription.click();

		//validate the news letter checkbox
		WebElement subscription = driver.findElement(By.xpath("//input[@id='subscription']"));

		//news is subscribed if block will execute
		if (subscription.isSelected()) {

			System.out.println("User Already Subscribed the NewsLetter");

			WebElement back = driver.findElement(By.xpath("//span[text()='Back']"));
			back.click();
			
			Thread.sleep(2000);
			
		} else {

			//news letter not subscribe else block will execute
			subscription.click();

			Thread.sleep(2000);

			//click the save Button
			WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
			saveBtn.click();
			
			Thread.sleep(2000);
			
			WebElement succMsg = driver.findElement(By.xpath("//div[text()='We have saved your subscription.']"));
			System.out.println(succMsg.getText());
			
		}

	}

	@Test(priority = 9, enabled = false)
	private void storeCredit() throws InterruptedException {

		//click the Store credit button
		WebElement storeCredit = driver.findElement(By.xpath("//a[text()='Store Credit']"));
		storeCredit.click();

		Thread.sleep(2000);

		//locate the currrent balance
		WebElement amount = driver.findElement(By.xpath("(//div[@class='block-content'])[2]"));

		try {

			//empty msg is diplayed if block will execute,empty msg is not showing catch block will execute
			WebElement emptyMsg = driver.findElement(By.xpath("//div[@class='message info empty']"));

			if (emptyMsg.isDisplayed()) {

				//print the current balance
				System.out.println("User Store Credit Balance is " + amount.getText());
				System.out.println(emptyMsg.getText());
			}

		} catch (Exception e) {

			//print the current amount
			System.out.println("User Store Credit Current Balance is " + amount.getText());
			System.out.println("User is used the store Credit Amount");
		}
	}

	@Test(priority = 10, enabled = false)
	private void accountInformation() throws InterruptedException {

		//click the Account Information link
		WebElement accountInformation = driver.findElement(By.xpath("//a[text()='Account Information']"));
		accountInformation.click();

		Thread.sleep(2000);

		//get the title
		String title = driver.getTitle();

		//title is equals to Account Information if block will execute
		
		if (title.equals("Account Information")) {

			System.out.println("entered into the Account Information page");

			String changeEmail = "";

			//change email is equals to yes if block will execute, otherwise its not execute
			if (changeEmail.equals("yes")) {

				//click the email checkbox
				WebElement emailCheckbox = driver.findElement(By.xpath("//input[@id='change-email']"));
				emailCheckbox.click();

				Thread.sleep(2000);

				//enter the current password
				WebElement currentPassword = driver.findElement(By.xpath("//input[@id='current-password']"));
				currentPassword.sendKeys(oldPassword);

				//click the save button
				WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
				saveBtn.click();
			}

			String changePassword = "yes";
			
			//change password is equals to yes if block will execute,otherwise its not execute
			if (changePassword.equals("yes")) {

				newPassword = "Balaji@123";

				//click the password checkbox
				WebElement passCheckbox = driver.findElement(By.xpath("//input[@id='change-password']"));
				passCheckbox.click();

				Thread.sleep(2000);

				//enter the current password
				WebElement currentPassword = driver.findElement(By.xpath("//input[@id='current-password']"));
				currentPassword.sendKeys(oldPassword);

				Thread.sleep(2000);

				//enter the new Password
				WebElement newPass = driver.findElement(By.xpath("//input[@id='password']"));
				newPass.sendKeys(newPassword);

				Thread.sleep(2000);

				//enter the confirm new password
				WebElement confirmPass = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
				confirmPass.sendKeys(newPassword);

				Thread.sleep(2000);

				//click the save btn
				WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
				saveBtn.click();
				
				Thread.sleep(5000);
				
				// enter the user name
				WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
				userName.sendKeys("balaji.p@sysfore.com");

				// enter the password
				WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
				password.sendKeys(newPassword);

				// click the submit
				WebElement submit = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
				submit.click();
				
				String title2 = driver.getTitle();
				
				//title2 is equals to my account if block will execute,not equals else block will execute
				if (title2.equals("My Account")) {
					
					System.out.println("Your password Updated succeful");
				} else {

					System.out.println("Your password Updated Unsucceful");

				}

			}

		}

	}
	
	
	@Test(priority=11,enabled=false)
	private void dataPrivacy() throws InterruptedException {

		//click data privacy link
		WebElement dataPrivacy = driver.findElement(By.xpath("//a[text()='Data Privacy']"));
		dataPrivacy.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle();	
		
		//title is equals to data privacy if block will execute,not equal else block will execute
		if (title.equals("Data Privacy")) {
			
			System.out.println("USer entred into Data Privacy page");
			
	        String deleteAccount="yes";
	        
	        //delete account is equals to yes if block will execute
	        if (deleteAccount.equals("yes")) {
				
	        	//click the erase radio Btn
	        	WebElement eraseRadioBtn = driver.findElement(By.xpath("//input[@id='remove_account']"));
	        	eraseRadioBtn.click();
	        	
	        	Thread.sleep(2000);
	        	
	        	//click the submit
	        	WebElement submitt = driver.findElement(By.xpath("//span[text()='Submit']"));
	        	submitt.click();
	        	
	        	Thread.sleep(2000);
	        	
	        	// enter the user name
				WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
				userName.sendKeys("quality.q@mailinator.com");

				// enter the password
				WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
				password.sendKeys("Quality@123");

				// click the submit
				WebElement submit = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
				submit.click();
				
				//validate the msg
				WebElement msg = driver.findElement(By.xpath("//div[text()='We deleted your account.']"));
				if (msg.isDisplayed()) {
					System.out.println(msg.getText());
				}
				
			}
	        
	
			
		} else {

			System.out.println("After clicked the data privacy link its not redirect to Data Privacy page");
			
		}
		
	}
	
	
	@Test(priority=12,enabled=false)
	private void logout() throws InterruptedException {

		// Click the Account Btn
				WebElement accBtn = driver
						.findElement(By.xpath("//div[@class='toggle-tab outside-close mobile ']"));
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", accBtn);

				Thread.sleep(3000);	
				
				//click the logout button
				WebElement logout = driver.findElement(By.xpath("//a[text()=' Log Out']"));
				logout.click();
				
				//validate the signout showing or not
		        WebElement signedOut = driver.findElement(By.xpath("//span[text()='You are signed out']"));
				
		        //signout is displayed if block will execute
				if (signedOut.isDisplayed()) {
					
					System.out.println(signedOut.getText());
				}
		
	}

}

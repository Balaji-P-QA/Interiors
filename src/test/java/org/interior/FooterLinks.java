package org.interior;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	WebDriver driver;
	
	@BeforeClass
	private void start() throws InterruptedException {
    
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://dev.interiorsfurniture.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		
		WebElement allowCookies = driver.findElement(By.xpath("//span[text()='Allow Cookies']"));
		allowCookies.click();
		
		Thread.sleep(4000);
		
		WebElement closePopup = driver.findElement(By.xpath("(//button[@class='action-close'])[3]"));
		closePopup.click();
		
		Thread.sleep(2000);
	}
	
	@Test(priority=1,enabled=true)
	private void furniture() throws InterruptedException {

		WebElement furniture = driver.findElement(By.xpath("//a[text()='Furniture']"));
		furniture.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Furniture")) {
			
			System.out.println("User clicked the furniture link its redirecting to furniture page");
			Reporter.log("User clicked the furniture link its redirecting to furniture page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the furniture link its not redirecting to furniture page");
			Reporter.log("User clicked the furniture link its not redirecting to furniture page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	
	@Test(priority=2,enabled=true)
	private void homeDecore() throws InterruptedException {

		WebElement homeDecore = driver.findElement(By.xpath("//a[text()='Home Decore']"));
		homeDecore.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Home Decor")) {
			
			System.out.println("User clicked the Home Decore link its redirecting to Home Decore page");
			Reporter.log("User clicked the Home Decore link its redirecting to Home Decore page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Home Decore link its not redirecting to Home Decore page");
			Reporter.log("User clicked the Home Decore link its not redirecting to Home Decore page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	

	@Test(priority=3,enabled=true)
	private void rugs() throws InterruptedException {

		WebElement rugs = driver.findElement(By.xpath("//a[text()='Rugs']"));
		rugs.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Rugs")) {
			
			System.out.println("User clicked the Rugs link its redirecting to Rugs page");
			Reporter.log("User clicked the Rugs link its redirecting to Rugs page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Rugs link its not redirecting to Rugs page");
			Reporter.log("User clicked the Rugs link its not redirecting to Rugs page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=4,enabled=true)
	private void lighting() throws InterruptedException {

		WebElement lighting = driver.findElement(By.xpath("//a[text()='Lighting']"));
		lighting.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Lighting")) {
			
			System.out.println("User clicked the Lighting link its redirecting to Lighting page");
			Reporter.log("User clicked the Lighting link its redirecting to Lighting page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Lighting link its not redirecting to Lighting page");
			Reporter.log("User clicked the Lighting link its not redirecting to Lighting page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	

	@Test(priority=5,enabled=true)
	private void armChairsAndRecliners() throws InterruptedException {

		WebElement lighting = driver.findElement(By.xpath("//a[text()='Arm Chairs & Recliners']"));
		lighting.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Armchairs, Recliners & Chaises - Living Rooms - Furniture")) {
			
			System.out.println("User clicked the ArmChairs And Recliners link its redirecting to ArmChairs And Recliners page");
			Reporter.log("User clicked the ArmChairs And Recliners link its redirecting to ArmChairs And Recliners page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the ArmChairs And Recliners link its not redirecting to ArmChairs And Recliners page");
			Reporter.log("User clicked the ArmChairs And Recliners link its not redirecting to ArmChairs And Recliners page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=6,enabled=true)
	private void diningTables() throws InterruptedException {

		WebElement diningTables = driver.findElement(By.xpath("//a[text()='Dining Tables']"));
		diningTables.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Dining Tables - Dining Rooms - Furniture")) {
			
			System.out.println("User clicked the Dining Tables link its redirecting to Dining Tables page");
			Reporter.log("User clicked the Dining Tables link its redirecting to Dining Tables page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Dining Tables link its not redirecting to Dining Tables page");
			Reporter.log("User clicked the Dining Tables link its not redirecting to Dining Tables page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=7,enabled=true)
	private void mattresses() throws InterruptedException {

		WebElement diningTables = driver.findElement(By.xpath("//a[text()='Mattresses']"));
		diningTables.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Mattresses & Beddings - Bedrooms - Furniture")) {
			
			System.out.println("User clicked the Mattresses link its redirecting to Mattresses page");
			Reporter.log("User clicked the Mattresses link its redirecting to Mattressess page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Mattresses link its not redirecting to Mattresses page");
			Reporter.log("User clicked the Mattresses link its not redirecting to Mattresses page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=8,enabled=true)
	private void officeStorage() throws InterruptedException {

		WebElement diningTables = driver.findElement(By.xpath("//a[text()='Office Storage']"));
		diningTables.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Office Storage - Home Offices - Furniture")) {
			
			System.out.println("User clicked the Office Storage link its redirecting to Office Storage page");
			Reporter.log("User clicked the Office Storage link its redirecting to Office Storage page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Office Storage link its not redirecting to Office Storage page");
			Reporter.log("User clicked the Office Storage link its not redirecting to Office Storage page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	
	@Test(priority=9,enabled=true)
	private void tvStandsAndMedia() throws InterruptedException {

		WebElement tvStandsAndMedia = driver.findElement(By.xpath("//a[text()='TV Stands & Media']"));
		tvStandsAndMedia.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("TV stands & Media Consoles - Living Rooms - Furniture")) {
			
			System.out.println("User clicked the TV Stands & Media link its redirecting to TV Stands & Media page");
			Reporter.log("User clicked the TV Stands & Media link its redirecting to TV Stands & Media page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the TV Stands & Media link its not redirecting to TV Stands & Media page");
			Reporter.log("User clicked the TV Stands & Media link its not redirecting to TV Stands & Media page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=10,enabled=true)
	private void mariner() throws InterruptedException {

		WebElement mariner = driver.findElement(By.xpath("//a[text()='Mariner']"));
		mariner.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Mariner")) {
			
			System.out.println("User clicked the Mariner link its redirecting to Mariner page");
			Reporter.log("User clicked the Mariner link its redirecting to Mariner page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Mariner link its not redirecting to Mariner page");
			Reporter.log("User clicked the Mariner link its not redirecting to Mariner page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=11,enabled=true)
	private void cornelioCappellini() throws InterruptedException {

		WebElement cornelioCappellini = driver.findElement(By.xpath("//a[text()='Cornelio Cappellini']"));
		cornelioCappellini.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Cornelio Cappellini")) {
			
			System.out.println("User clicked the Cornelio Cappellini link its redirecting to Cornelio Cappellini page");
			Reporter.log("User clicked the Cornelio Cappellini link its redirecting to Cornelio Cappellini page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Cornelio Cappellini link its not redirecting to Cornelio Cappellini page");
			Reporter.log("User clicked the Cornelio Cappellini link its not redirecting to Cornelio Cappellini page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=12,enabled=true)
	private void lexington() throws InterruptedException {

		WebElement lexington = driver.findElement(By.xpath("//a[text()='Lexington']"));
		lexington.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Lexington")) {
			
			System.out.println("User clicked the Lexington link its redirecting to Lexington page");
			Reporter.log("User clicked the Lexington link its redirecting to Lexington page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Lexington link its not redirecting to Lexington page");
			Reporter.log("User clicked the Lexington link its not redirecting to Lexington page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=13,enabled=true)
	private void bernhardt() throws InterruptedException {

		WebElement bernhardt = driver.findElement(By.xpath("//a[text()='Bernhardt']"));
		bernhardt.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Bernhardt")) {
			
			System.out.println("User clicked the Bernhardt link its redirecting to Bernhardt page");
			Reporter.log("User clicked the Bernhardt link its redirecting to Bernhardt page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Bernhardt link its not redirecting to Bernhardt page");
			Reporter.log("User clicked the Bernhardt link its not redirecting to Bernhardt page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	
	@Test(priority=14,enabled=true)
	private void viewAllBrands() throws InterruptedException {

		WebElement viewAllBrands = driver.findElement(By.xpath("//a[text()='View all brands']"));
		viewAllBrands.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Brands")) {
			
			System.out.println("User clicked the View all brands link its redirecting to Brands page");
			Reporter.log("User clicked the View all brands link its redirecting to Brands page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the View all brands link its not redirecting to Brands page");
			Reporter.log("User clicked the View all brands link its not redirecting to Brands page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=15,enabled=true)
	private void designStudio() throws InterruptedException {

		WebElement designStudio = driver.findElement(By.xpath("//a[text()='Design Studio']"));
		designStudio.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Design Studio")) {
			
			System.out.println("User clicked the Design Studio link its redirecting to Design Studio page");
			Reporter.log("User clicked the Design Studio link its redirecting to Design Studio page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Design Studio link its not redirecting to Design Studio page");
			Reporter.log("User clicked the Design Studio link its not redirecting to Design Studio page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	@Test(priority=16,enabled=true)
	private void curtainStudio() throws InterruptedException {

		WebElement curtainStudio = driver.findElement(By.xpath("(//a[text()='Curtain Studio'])[2]"));
		curtainStudio.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Curtain Studio")) {
			
			System.out.println("User clicked the Curtain Studio link its redirecting to Curtain Studio page");
			Reporter.log("User clicked the Curtain Studio link its redirecting to Curtain Studio page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Curtain Studio link its not redirecting to Curtain Studio page");
			Reporter.log("User clicked the Curtain Studio link its not redirecting to Curtain Studio page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=17,enabled=true)
	private void commercialAndResidentialProjects() throws InterruptedException {

		WebElement commercialAndResidentialProjects = driver.findElement(By.xpath("//a[text()='Commercial & Residential Projects']"));
		commercialAndResidentialProjects.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Commercial & residential projects")) {
			
			System.out.println("User clicked the Commercial & Residential Projects link its redirecting to Commercial & Residential Projects page");
			Reporter.log("User clicked the Commercial & Residential Projects link its redirecting to Commercial & Residential Projects page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Commercial & Residential Projects link its not redirecting to Commercial & Residential Projects page");
			Reporter.log("User clicked the Commercial & Residential Projects link its not redirecting to Commercial & Residential Projects page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=18,enabled=true)
	private void allServices() throws InterruptedException {

		WebElement allServices = driver.findElement(By.xpath("//a[text()='All Services']"));
		allServices.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Services /")) {
			
			System.out.println("User clicked the All Services link its redirecting to All Services page");
			Reporter.log("User clicked the All Services link its redirecting to All Services page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the All Services link its not redirecting to All Services page");
			Reporter.log("User clicked the All Services link its not redirecting to All Services page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=19,enabled=true)
	private void contactUS() throws InterruptedException {

		WebElement contactUS = driver.findElement(By.xpath("(//a[text()='Contact Us'])[3]"));
		contactUS.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Contact Us")) {
			
			System.out.println("User clicked the Contact Us link its redirecting to Contact Us page");
			Reporter.log("User clicked the Contact Us link its redirecting to Contact Us page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Contact Us link its not redirecting to Contact Us page");
			Reporter.log("User clicked the Contact Us link its not redirecting to Contact Us page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=20,enabled=true)
	private void faqs() throws InterruptedException {

		WebElement faqs = driver.findElement(By.xpath("//a[text()='FAQs']"));
		faqs.click();
		
		Thread.sleep(3000);
		
		String url = driver.getCurrentUrl();
		
		if (url.equals("https://dev.interiorsfurniture.com/en/faq/")) {
			
			System.out.println("User clicked the FAQs link its redirecting to FAQs page");
			Reporter.log("User clicked the FAQs link its redirecting to FAQs page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the FAQs link its not redirecting to FAQs page");
			Reporter.log("User clicked the FAQs link its not redirecting to FAQs page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=21,enabled=true)
	private void aboutInteriors() throws InterruptedException {

		WebElement aboutInteriors = driver.findElement(By.xpath("//a[text()='About Interiors']"));
		aboutInteriors.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("About Interiors")) {
			
			System.out.println("User clicked the About Interiors link its redirecting to About Interiors page");
			Reporter.log("User clicked the About Interiors link its redirecting to About Interiors page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the About Interiors link its not redirecting to About Interiors page");
			Reporter.log("User clicked the About Interiors link its not redirecting to About Interiors page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	

	@Test(priority=22,enabled=true)
	private void aboutESAG() throws InterruptedException {

		WebElement aboutESAG = driver.findElement(By.xpath("//a[text()='About ESAG']"));
		aboutESAG.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("About ESAG")) {
			
			System.out.println("User clicked the About ESAG link its redirecting to About ESAG page");
			Reporter.log("User clicked the About ESAG link its redirecting to About ESAG page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the About ESAG link its not redirecting to About ESAG page");
			Reporter.log("User clicked the About ESAG link its not redirecting to About ESAG page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=23,enabled=true)
	private void careers() throws InterruptedException {

		WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));
		careers.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Careers")) {
			
			System.out.println("User clicked the Careers link its redirecting to Careers page");
			Reporter.log("User clicked the Careers link its redirecting to Careers page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Careers link its not redirecting to Careers page");
			Reporter.log("User clicked the Careers link its not redirecting to Careers page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=24,enabled=true)
	private void newsCenter() throws InterruptedException {

		WebElement newsCenter = driver.findElement(By.xpath("//a[text()='News Center']"));
		newsCenter.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("news")) {
			
			System.out.println("User clicked the News Center link its redirecting to News Center page");
			Reporter.log("User clicked the News Center link its redirecting to News Center page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the News Center link its not redirecting to News Center page");
			Reporter.log("User clicked the News Center link its not redirecting to News Center page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=25,enabled=true)
	private void blog() throws InterruptedException {

		WebElement blog = driver.findElement(By.xpath("(//a[text()='Blog'])[2]"));
		blog.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Blog")) {
			
			System.out.println("User clicked the Blog link its redirecting to Blog page");
			Reporter.log("User clicked the Blog link its redirecting to Blog page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Blog link its not redirecting to Blog page");
			Reporter.log("User clicked the Blog link its not redirecting to Blog page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=26,enabled=true)
	private void trackingOrders() throws InterruptedException {

		WebElement trackingOrders = driver.findElement(By.xpath("//a[text()='Tracking Orders']"));
		trackingOrders.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Track Your Order")) {
			
			System.out.println("User clicked the Tracking Orders link its redirecting to Tracking Orders page");
			Reporter.log("User clicked the Tracking Orders link its redirecting to Tracking Orders page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Tracking Orders link its not redirecting to Tracking Orders page");
			Reporter.log("User clicked the Tracking Orders link its not redirecting to Tracking Orders page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=27,enabled=true)
	private void termsAndCondition() throws InterruptedException {

		WebElement termsAndCondition = driver.findElement(By.xpath("//a[text()='Terms & Conditions']"));
		termsAndCondition.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Terms & Conditions")) {
			
			System.out.println("User clicked the Terms & Conditions link its redirecting to Terms & Conditions page");
			Reporter.log("User clicked the Terms & Conditions link its redirecting to Terms & Conditions page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Terms & Conditions link its not redirecting to Terms & Conditions page");
			Reporter.log("User clicked the Terms & Conditions link its not redirecting to Terms & Conditions page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=28,enabled=true)
	private void returnAndRefunds() throws InterruptedException {

		WebElement returnAndRefunds = driver.findElement(By.xpath("//a[text()='Return and Refunds']"));
		returnAndRefunds.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Terms & Conditions")) {
			
			System.out.println("User clicked the Return and Refunds link its redirecting to Terms & Conditions page");
			Reporter.log("User clicked the Return and Refunds link its redirecting to Terms & Conditions page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Return and Refunds link its not redirecting to Terms & Conditions page");
			Reporter.log("User clicked the Return and Refunds link its not redirecting to Terms & Conditions page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=29,enabled=true)
	private void deliveryterms() throws InterruptedException {

		WebElement deliveryterms = driver.findElement(By.xpath("//a[text()='Delivery Terms']"));
		deliveryterms.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Terms & Conditions")) {
			
			System.out.println("User clicked the Delivery Terms link its redirecting to Terms & Conditions page");
			Reporter.log("User clicked the Delivery Terms link its redirecting to Terms & Conditions page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Delivery Terms link its not redirecting to Terms & Conditions page");
			Reporter.log("User clicked the Delivery Terms link its not redirecting to Terms & Conditions page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=30,enabled=true)
	private void easyPayment() throws InterruptedException {

		WebElement easyPayment = driver.findElement(By.xpath("//a[text()='Easy Payment']"));
		easyPayment.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Easy Payment")) {
			
			System.out.println("User clicked the Easy Payment link its redirecting to Easy Payment page");
			Reporter.log("User clicked the Easy Payment link its redirecting to Easy Payment page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Easy Payment link its not redirecting to Easy Payment page");
			Reporter.log("User clicked the Easy Payment link its not redirecting to Easy Payment page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=31,enabled=true)
	private void privacyPolicy() throws InterruptedException {

		WebElement privacyPolicy = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		privacyPolicy.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Privacy and Cookie Policy")) {
			
			System.out.println("User clicked the Privacy Policy link its redirecting to Privacy Policy page");
			Reporter.log("User clicked the Privacy Policy link its redirecting to Privacy Policy page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Privacy Policylink its not redirecting to Privacy Policy page");
			Reporter.log("User clicked the Privacy Policy link its not redirecting to Privacy Policy page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=32,enabled=true)
	private void sitemap() throws InterruptedException {

		WebElement sitemap = driver.findElement(By.xpath("//a[text()='Sitemap']"));
		sitemap.click();
		
		Thread.sleep(3000);
		
		String url = driver.getCurrentUrl();	
		
		if (url.equals("https://dev.interiorsfurniture.com/en/sitemap.html/")) {
			
			System.out.println("User clicked the Sitemap link its redirecting to Sitemap page");
			Reporter.log("User clicked the Sitemap link its redirecting to Sitemap page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Sitemap link its not redirecting to Sitemap page");
			Reporter.log("User clicked the Sitemap link its not redirecting to Sitemap page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=33,enabled=true)
	private void UAE() throws InterruptedException {

		WebElement UAE = driver.findElement(By.xpath("//a[text()='UAE Consumer Rights']"));
		UAE.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Customer Right")) {
			
			System.out.println("User clicked the UAE Consumer Rights link its redirecting to Customer Right page");
			Reporter.log("User clicked the UAE Consumer Rights link its redirecting to Customer Right page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the UAE Consumer Rights link its not redirecting to Customer Right page");
			Reporter.log("User clicked the UAE Consumer Rights link its not redirecting to Customer Right page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	@Test(priority=34,enabled=true)
	private void register() throws InterruptedException {

		WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
		register.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Create New Customer Account")) {
			
			System.out.println("User clicked the Register link its redirecting to Register page");
			Reporter.log("User clicked the UAE Register link its redirecting to Register page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Register link its not redirecting to Register page");
			Reporter.log("User clicked the Register link its not redirecting to Register page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=35,enabled=true)
	private void login() throws InterruptedException {

		WebElement login = driver.findElement(By.xpath("(//a[text()='Log In'])[3]"));
		login.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Customer Login")) {
			
			System.out.println("User clicked the Log In link its redirecting to Log In page");
			Reporter.log("User clicked the UAE Log In link its redirecting to Log In page");
			Assert.assertTrue(true);
			
			WebElement email = driver.findElement(By.xpath("//input[@name='login[username]']"));
			email.sendKeys("balaji.p@sysfore.com");
			
			Thread.sleep(2000);
			
			WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
			password.sendKeys("Balaji@123");
			
			Thread.sleep(2000);
			
			WebElement signIn = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
			signIn.click();
			
		} else {

			System.out.println("User clicked the Log In link its not redirecting to Log In page");
			Reporter.log("User clicked the Log In link its not redirecting to Log In page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=36,enabled=true)
	private void myOrders() throws InterruptedException {

		WebElement myOrders = driver.findElement(By.xpath("(//a[text()='My Orders'])[2]"));
		myOrders.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("My Orders")) {
			
			System.out.println("User clicked the My Orders link its redirecting to My Orders page");
			Reporter.log("User clicked the UAE My Orders link its redirecting to My Orders page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the My Orders link its not redirecting to My Orders page");
			Reporter.log("User clicked the My Orders link its not redirecting to My Orders page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=37,enabled=true)
	private void myAddresses() throws InterruptedException {

		WebElement myAddresses = driver.findElement(By.xpath("//a[text()='My Addresses']"));
		myAddresses.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("Add New Address")) {
			
			System.out.println("User clicked the My Addresses link its redirecting to Address Book page");
			Reporter.log("User clicked the UAE My Addresses link its redirecting to Address Book page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the My Addresses link its not redirecting to Address Book page");
			Reporter.log("User clicked the My Addresses link its not redirecting to Address Book page");
			Assert.assertTrue(false);			
			
		}
		
	}
	
	
	@Test(priority=38,enabled=true)
	private void accountSettings() throws InterruptedException {

		WebElement accountSettings = driver.findElement(By.xpath("//a[text()='Account Settings']"));
		accountSettings.click();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		if (title.equals("My Account")) {
			
			System.out.println("User clicked the Account Settings link its redirecting to My Account page");
			Reporter.log("User clicked the UAE Account Settings link its redirecting to My Account page");
			Assert.assertTrue(true);
			
		} else {

			System.out.println("User clicked the Account Settings link its not redirecting to My Account page");
			Reporter.log("User clicked the Account Settings link its not redirecting to My Account page");
			Assert.assertTrue(false);			
			
		}
		
	}
	

	@Test(priority=39,enabled=true)
	private void stayUptoDate() throws InterruptedException {
    
		
		WebElement newsLetter = driver.findElement(By.xpath("//input[@id='newsletter']"));
		newsLetter.sendKeys("balaji.p@sysfore.com");
		
		Thread.sleep(2000);
		
		WebElement newsLetterSubmit = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", newsLetterSubmit);
		
		try {
			
			WebElement newsletterPopup = driver.findElement(By.xpath("//div[@class='This email address is already subscribed.']"));
			
			if (newsletterPopup.isDisplayed()) {
				
				System.out.println("user entered existing email address in to news letter subscription its throwsing throwing in the err msg");
				Assert.assertTrue(false);
				Reporter.log("user entered existing email address in to news letter subscription its throwing in the err msg");
				
			}
			
		} catch (Exception e) {
			
			System.out.println("user entered new email address in to news letter subscription, it not throwing in the err msg");
			Assert.assertTrue(true);
			Reporter.log("user entered new email address in to news letter subscription, it not throwing in the err msg");
			
		}
		

		Thread.sleep(10000);
		
	}
	
	
	
}

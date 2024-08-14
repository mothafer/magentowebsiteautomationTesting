package thirdproject;

import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertAll;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.security.PublicKey;
import java.util.List;
import java.util.Random;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tesemag {
	WebDriver driver = new ChromeDriver();
	String mywebsite ="https://magento.softwaretestingboard.com/collections/yoga-new.html";
	String logoutPage = "https://magento.softwaretestingboard.com/customer/account/logout/";
	Random rand = new Random();
	String password = "Ilovemome@1";
	String emailaddressTologin ="";
	String fairstnametoreview = "";
	@BeforeTest
	public void mysetup() {
		
		driver.manage().window().maximize();
		driver.get(mywebsite);

	}
	@Test(priority = 1)
	public void CreateAnAccount() {
		WebElement createaccount = driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		createaccount.click();
		String[] first_Names = { "Alice", "Bob", "Charlie", "David", "Eve", "Fay", "Grace" };
		String[] Last_Names = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia" };
		int randomindxfirstname = rand.nextInt(first_Names.length);
		int randomindxlastmame = rand.nextInt(Last_Names.length);
		 WebElement fiestnameinput = driver.findElement(By.id("firstname"));
		 WebElement lastnameinput = driver.findElement(By.id("lastname"));
		 WebElement emailadeess= driver.findElement(By.id("email_address"));
         WebElement passwordinput = driver.findElement(By.id("password"));
         WebElement confarmpassword =driver.findElement(By.id("password-confirmation"));
         WebElement createAccountbotton = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));

         String fairstname = first_Names [randomindxfirstname];
         String lastname = Last_Names [randomindxlastmame];
         int randomnumber = rand.nextInt(3534);
         String domainname ="@gmail.com";
         
         
         fiestnameinput.sendKeys(fairstname);
         lastnameinput.sendKeys(lastname);
         emailadeess.sendKeys(fairstname+lastname+randomnumber+domainname);
         passwordinput.sendKeys(password);
         confarmpassword.sendKeys(password);
         createAccountbotton.click();  
         emailaddressTologin = fairstname+lastname+randomnumber+domainname;
         fairstnametoreview = fairstname;
         
         WebElement massage = driver.findElement(By.cssSelector(".page.messages"));
         String theactualmassage = massage.getText();
         String expectedmassage = "Thank you for registering with Main Website Store.";
         org.testng.Assert.assertEquals(theactualmassage, expectedmassage);

	}
        @Test(priority = 2 )
        public void logOut() {
    		driver.get(logoutPage);
    		
   		WebElement logoutmass = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
   		String actmass = logoutmass.getText();
   		String expmass = "You are signed out";
org.testng.Assert.assertEquals(actmass, expmass);        	 
        	 
//        	 Thread.sleep(6000);
        	 
         }
		@Test(priority = 3)
		public void loginTest() throws InterruptedException {
	WebElement login =	driver.findElement(By.className("authorization-link"));
		login.click();
		WebElement email = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement signinbutton= driver.findElement(By.id("send2"));
		email.sendKeys(emailaddressTologin);
		pass.sendKeys(password);
		signinbutton.click();
		
		
      	Thread.sleep(3000);
		
		String loginVerify = driver.findElement(By.className("logged-in")).getText();
        boolean actual = loginVerify.contains("Welcome");
        boolean expected = true;
        org.testng.Assert.assertEquals(actual, expected);
		
	}
		
		@Test(priority = 4 , enabled = false)
		public void addmenItem() throws InterruptedException {
			WebElement Menbutton = driver.findElement(By.id("ui-id-5"));
			Menbutton.click();
			 WebElement productitemcontainer =driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
			System.out.println(productitemcontainer.findElements(By.className("product-items")).size());
			List<WebElement> allitem = productitemcontainer.findElements(By.tagName("li"));
			int totalnumitem = allitem.size();
			int randomitem = rand.nextInt(totalnumitem);
			allitem.get(randomitem).click();
			
			WebElement sizecontainer = driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));
			List<WebElement> allsize = sizecontainer.findElements(By.tagName("div"));
			int allsizenum = allsize.size();
			int randomsize = rand.nextInt(allsizenum);
			allsize.get(randomsize).click();
			
			WebElement colorscontainer = driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
			List<WebElement> allcolors = colorscontainer.findElements(By.tagName("div"));
			int allcolorsnum = allcolors.size();
			int randomcolores = rand.nextInt(allcolorsnum);
			allcolors.get(randomcolores).click();
			 
			WebElement addbutton = driver.findElement(By.id("product-addtocart-button"));
			addbutton.click();
			Thread.sleep(3000);
			
			WebElement massages = driver.findElement(By.className("messages"));
//			String actualmassage = massages.getText();
//			String expectedmassage = "You added Hero Hoodie to your shopping cart.";
			org.testng.Assert.assertEquals(massages.getText().contains("You added"),true);
			
			
			
		}
		
		@Test(priority = 5)
		public void addwomenItem() throws InterruptedException {
			WebElement womenbutton = driver.findElement(By.id("ui-id-4"));
			womenbutton.click();
			 WebElement productitemcontainer =driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
			System.out.println(productitemcontainer.findElements(By.className("product-items")).size());
			List<WebElement> allitem = productitemcontainer.findElements(By.tagName("li"));
			int totalnumitem = allitem.size();
			int randomitem = rand.nextInt(totalnumitem);
			allitem.get(randomitem).click();
			
			WebElement sizecontainer = driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));
			List<WebElement> allsize = sizecontainer.findElements(By.tagName("div"));
			int allsizenum = allsize.size();
			int randomsize = rand.nextInt(allsizenum);
			allsize.get(randomsize).click();
			
			WebElement colorscontainer = driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
			List<WebElement> allcolors = colorscontainer.findElements(By.tagName("div"));
			int allcolorsnum = allcolors.size();
			int randomcolores = rand.nextInt(allcolorsnum);
			allcolors.get(randomcolores).click();
			 
			WebElement addbutton = driver.findElement(By.id("product-addtocart-button"));
			addbutton.click();
			Thread.sleep(3000);
			
			WebElement massages = driver.findElement(By.className("messages"));
//			String actualmassage = massages.getText();
//			String expectedmassage = "You added Hero Hoodie to your shopping cart.";
			org.testng.Assert.assertEquals(massages.getText().contains("You added"),true);
		
	
			driver.navigate().refresh();
			WebElement reviewsection = driver.findElement(By.id("tab-label-reviews-title"));
			reviewsection.click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,1200)");
			
			Thread.sleep(3000);
			
			String[] ids = { "Rating_1", "Rating_2", "Rating_3", "Rating_4", "Rating_5" };
			int randomIndex = rand.nextInt(ids.length);
			WebElement element = driver.findElement(By.id(ids[randomIndex]));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			
			WebElement nickname = driver.findElement(By.id("nickname_field"));
			WebElement summary = driver.findElement(By.id("summary_field"));
			WebElement review = driver.findElement(By.id("review_field"));
			WebElement submitreview = driver.findElement(By.cssSelector(".action.submit.primary"));
			nickname.sendKeys(fairstnametoreview);
			summary.sendKeys("hello");
		 review.sendKeys("good");
		 submitreview.click();
		 
		 WebElement massagesreview = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
			org.testng.Assert.assertEquals(massagesreview.getText().contains("You submitted your review for moderation."),true);
		}
		
		

}

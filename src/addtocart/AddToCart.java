package addtocart;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {

	WebDriver driver = new ChromeDriver();

	@BeforeTest

	public void MyBeforTest() {

		driver.manage().window().maximize();

	}

//	@Test(invocationCount = 5)

//	public void myfirstTest() throws InterruptedException   {
//	// id , class , name , linkText , partialLinkText , tagname 
//
//	driver.get("https://magento.softwaretestingboard.com/");
//
//driver.findElement(By.partialLinkText("Create")).click();
//
//Thread.sleep(3000); 
//
//WebElement theforrrrrmmmmm = driver.findElement(By.id("form-validate")); 
//List<WebElement> myinputFields = theforrrrrmmmmm.findElements(By.tagName("input"));
//
//System.out.println("this is the number of input"+myinputFields.size());
//
//for(int i = 0 ; i < myinputFields.size() ;i++ ) {
//
//if(myinputFields.get(i).getAttribute("type").equals("hidden")) {
//	break ; 
//}else {
//	myinputFields.get(i).sendKeys("ahmad"); 
//
//}
//}

//
//}
	
	@Test

	public void MyTest() throws InterruptedException {

		driver.get("https://magento.softwaretestingboard.com/");

//		driver.findElement(By.linkText("Sign In")).click();

//		driver.findElement(By.partialLinkText("Create")).click();
//
//		Thread.sleep(1500);

//		driver.findElement(By.tagName("input")).sendKeys("Test");

//		List<WebElement> myinputlist = driver.findElements(By.tagName("input"));
//
//		for (int i = 0; i < myinputlist.size(); i++) {
//			myinputlist.get(i).sendKeys("Test");
//
//		}
		
		
	WebElement Items = driver.findElement(By.className("product-items"));
	 
	List<WebElement> AllItems = Items.findElements(By.tagName("li"));
	
	Random rand = new Random();
	
	int RandomIndex = rand.nextInt(AllItems.size());
	
	AllItems.get(RandomIndex).click();
	
	if(driver.getCurrentUrl().contains("fusion")|| driver.getCurrentUrl().contains("push")) {
		
		WebElement AddToCart = driver.findElement(By.id("product-addtocart-button"));
		
		AddToCart.click();
		
	}else {
		
		WebElement SizeContainer = driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
		
		List<WebElement> ListSize = SizeContainer.findElements(By.tagName("div"));
		
		int RandomSize =rand.nextInt(ListSize.size());
		
		ListSize.get(RandomSize).click();
		
		WebElement ColorContainer = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
		
		List<WebElement> ListColor =ColorContainer.findElements(By.tagName("div"));
		
		int RandomColor = rand.nextInt(ListColor.size());
		
		ListColor.get(RandomColor).click();
		
		WebElement addToCart = driver.findElement(By.id("product-addtocart-button"));
		
		addToCart.click();
	}

	
	}

	@AfterTest

	public void MyAfterTest() {
	}

}


package tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class profile_test {
	
	// Setting variable for the OS name to be used for multi OS compatibility
	String os = System.getProperty("os.name").toLowerCase();
	
	// Creating object of WebDriver
	WebDriver driver;

//	profile_test obj = new profile_test();
//	
//	public void hover(WebElement ele) {
//		builder.moveToElement(ele).perform();
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		System.out.println("hover school");
//	}
	
	
	// Creating method that will execute task   
	public void runTest() {
		// Determines if OS is Mac or Windows and sets property to correct location
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"\\chromedriver.exe");
		}
		
		// Launch browser and navigate to page
		driver = new ChromeDriver();
		driver.get("http://ajjernigan.com/");
		
		
		// Click Bio Link in Nav Bar, and highlight tabs
		driver.findElement(By.id("navBio")).click();
		
		Actions builder = new Actions(driver);
		WebElement tech = driver.findElement(By.className("shwTech"));
		WebElement school = driver.findElement(By.className("shwSchool"));
		WebElement stmt = driver.findElement(By.className("shwStatement"));
		
//		obj.hover(tech);
		
		builder.moveToElement(school).perform();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		System.out.println("hover school");
		
		builder.moveToElement(stmt).perform();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		System.out.println("hover stmt");
		
		
	}
	
	// Calling method to run test
	public static void main(String[] args) {
		profile_test obj = new profile_test();
		obj.runTest();

	}
}
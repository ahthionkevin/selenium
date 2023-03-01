package selenium_course;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization_Assignement {
	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Set Implicit Wait of 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
		
		// Get the URL
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		// Login Scenario
		String username = "rahulshettyacademy";
		String password = "learning";
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='user']")).click();
		
		/// Explicit Wait
		Wait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(5L));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		driver.findElement(By.id("okayBtn")).click();
		driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("okayBtn")));
		
		/// Manage Dropdowns
		Select select = new Select(driver.findElement(By.tagName("select")));
		select.selectByVisibleText("Consultant");
		
		/// Agree CGV
		driver.findElement(By.id("terms")).click();
		
		/// Click on login
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		/// Explicit Wait
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navbar-brand")));
		
		/// Add to Cart
		List<WebElement> products = driver.findElements(By.cssSelector(".card-footer button"));
		
		for(WebElement p : products) {
			p.click();
		}
		
		/// Go to checkout
		driver.findElement(By.xpath("//*[contains(text(),'Checkout')]")).click();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[last()-1]//strong")));
		
		System.out.println("\n===========================");
		System.out.println("Total Purchase : " + driver.findElement(By.xpath("//tbody/tr[last()-1]//strong")).getText().split(" ")[1].trim() + " YAN");
		System.out.println("===========================\n");
	}
}

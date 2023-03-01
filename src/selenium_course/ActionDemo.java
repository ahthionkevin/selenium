package selenium_course;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.fr/");
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
				.click()
				.keyDown(Keys.SHIFT)
				.sendKeys("hello")
				.doubleClick()
				.build()
				.perform();
		
		actions.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		
		// Opening new window with new link
		
		WebElement body = driver.findElement(By.tagName("body"));
		
		actions
		.sendKeys(Keys.SHIFT+"t")
		.build()
		.perform();

		driver.navigate().to("https://yahoo.fr");
		System.out.println(driver.getCurrentUrl());
		
		// Handling child windows
		
		
		
		
	}
}

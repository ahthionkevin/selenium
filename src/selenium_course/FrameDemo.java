package selenium_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		// Get the URL
		driver.get("https://the-internet.herokuapp.com/");

		// Go to the desire location
		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
//		
//		driver
//			.switchTo()
//			.frame(driver.findElement(By.xpath("//frame[contains(@name,'top')]")));
//	
//		System.out.println(driver.findElements(By.tagName("frame")).size());
//		
//		driver
//			.switchTo()
//			.frame(driver.findElement(By.xpath("//frame[contains(@name,'middle')]")));
		
		driver
			.switchTo()
			.frame(driver.findElement(By.xpath("//frame[contains(@name,'top')]")))
			.switchTo()
			.frame(driver.findElement(By.xpath("//frame[contains(@name,'middle')]")));
		
		System.out.println(driver.findElement(By.tagName("div")).getText());
		
		driver.switchTo().defaultContent();
				
		driver.quit();
						
	}

}

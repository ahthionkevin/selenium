package selenium_course;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowHandlingDemo {

	public static void main(String[] args) {

//		WebDriver driver = new ChromeDriver();
//		
//		// Get the URL
//		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
//		
//		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
//		
//		System.out.println(driver.getCurrentUrl());
//		
//		/***
//		 *  the following returns a set of window id
//		 *  
//		 */
//		Set<String> windows = driver.getWindowHandles();
//		
//		for(String w : windows) {
//			System.out.println(w);
//		}
//		
//		Iterator<String> it = windows.iterator();
//		
//		String parentID = it.next();
//		String childID = it.next();
//		
//		driver.switchTo().window(childID);
//		System.out.println(driver.getCurrentUrl());
//		
//		String email_address = driver.findElement(By.xpath("//strong/a[contains(@href,\"@\")]")).getText();
//		System.out.printf("This is the email address: %s \n", email_address);
//		
//		String p = driver.findElement(By.xpath("//*[@id=\"interview-material-container\"]/div/div[2]/p[2]")).getText() ;
//		String regex = "[^ ][A-Za-z0-9]*@[A-Za-z]{3,}.[A-Za-z]{2,7}";
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(p);
//		
//		System.out.println(p);
//		
//		if(matcher.find())
//			System.out.println(matcher.group());
//		
//		driver.switchTo().window(childID);
//		System.out.println(driver.getCurrentUrl());
//		
//		driver.findElement(By.id("username")).sendKeys(email_address);

		// ==========================================
		// ASSIGNEMENT
		// ==========================================

		WebDriver driver = new ChromeDriver();

		// Get the URL
		driver.get("https://the-internet.herokuapp.com/");

		// Go to the desire location
		driver.findElement(By.linkText("Multiple Windows")).click();
		System.out.println(driver.getCurrentUrl());

		driver.findElement(By.linkText("Click Here")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentID = it.next();
		String childID = it.next();

		driver.switchTo().window(childID);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.switchTo().window(parentID);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.quit();
	}
}

package selenium_course;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Introduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
//		Thread.sleep(Duration.ofSeconds(5L));
		
		String[] vegetables = {"CUCUMBER", "TOMATO"};
		
		List<WebElement> veg_labels = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int l = veg_labels.size();
		
		List<String> veg_list = Arrays.asList(vegetables);
		int count = 0;

		for(int i=0;i<l;i++) {
			String veg_name = veg_labels.get(i).getText().split("-")[0].trim();
			System.out.println(veg_name);
			
			if (veg_list.contains(veg_name.toUpperCase())) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// driver.findElements(By.xpath("//button[contains(text(),\"ADD TO CART\")]")).get(i).click();
				count++;
				
				if(count>=vegetables.length) break;
			}
		}
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		// Explicit Wait
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10L));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		String promo_text = driver.findElement(By.className("promoInfo")).getText();
		Assert.assertEquals(promo_text, "Code applied ..!");
		
		System.out.println("\n==================\n   " + promo_text + "\n==================\n");
		
		driver.quit();

	}

}

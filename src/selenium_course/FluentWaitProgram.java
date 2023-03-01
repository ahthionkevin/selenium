package selenium_course;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(30L))
									.pollingEvery(Duration.ofSeconds(3L));
//									.pollingEvery(Duration.of(2L, ChronoUnit.SECONDS )); // Deprecated
		
		
		WebElement p = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				if (driver.findElement(By.xpath("//p[1]")).isDisplayed())
					return driver.findElement(By.xpath("//p[1]"));
				return null;
			}
		});
		
		
	}

}

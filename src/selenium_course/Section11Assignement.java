package selenium_course;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Section11Assignement {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		Random random = new Random();
		int randomIndex = random.nextInt(3);
		
		WebElement checkboxSection = driver.findElement(By.id("checkbox-example"));
		checkboxSection.findElements(By.tagName("input")).get(randomIndex).click();
		String chosenLabel = checkboxSection.findElements(By.tagName("label")).get(randomIndex).getText();
		System.out.println(chosenLabel);
		
		Select dropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropDown.selectByVisibleText(chosenLabel);
		
		driver.findElement(By.id("name")).sendKeys(chosenLabel);
		driver.findElement(By.id("alertbtn")).click();
		
		Alert popUp = driver.switchTo().alert();
		String popUpText = popUp.getText();
		
		System.out.println(popUpText);
		System.out.println(popUpText.contains(chosenLabel));
		
		popUp.accept();
		
		driver.quit();
		
	}

}


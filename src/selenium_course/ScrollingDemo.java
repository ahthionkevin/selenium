package selenium_course;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ScrollingDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        /**
         * COURSE
         * We can't scroll in Selenium with the WebDriver
         * TO Scroll we need to use Javascript
         */

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("window.scrollBy(0,500)");
//
//        Thread.sleep(2000L);
//
//        jsExecutor.executeScript("document.querySelector(\".tableFixHead\").scrollTop = 500");
//
//        /**
//         *  ASSIGNEMENT 1
//         */
//
//        int l = driver.findElements(By.xpath("(//*[@class='left-align']//*[@id='product'])//tr")).size();
//        System.out.println("Number of line = " + l);
//
//        List<WebElement> columnsOfSecondRow = driver.findElements(By.xpath("(//*[@class='left-align']//*[@id='product'])//tr"))
//                .get(2)
//                .findElements(By.tagName("td"));
//
//        System.out.println("Number of column = " + columnsOfSecondRow.size());
//
//        String text = driver.findElements(By.xpath("(//*[@class='left-align']//*[@id='product'])//tr"))
//                .get(2)
//                .getText();
//
//        System.out.println(text);

        /**
         *  ASSIGNEMENT 2
         */

        driver.findElement(By.id("autocomplete")).sendKeys("ind");

        WebElement dropDown = driver.findElement(By.id("ui-id-1"));
        List<WebElement> li = dropDown.findElements(By.tagName("li"));

        for(WebElement e : li){
            System.out.println(e.getText());

            if(e.getText().equalsIgnoreCase("india")){
                System.out.println(true);
                e.click();
                break;
            }
        }

        // IMPROVED WAY

        driver.findElement(By.id("autocomplete")).clear();
        driver.findElement(By.id("autocomplete")).sendKeys("ind");

        Thread.sleep(2000L);
        while (!driver.findElement(By.id("autocomplete")).getAttribute("value").equalsIgnoreCase("india")){
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
            System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

            if(driver.findElement(By.id("autocomplete")).getAttribute("value").equalsIgnoreCase("ind"))
                break;
        }

        if(driver.findElement(By.id("autocomplete")).getAttribute("value").equalsIgnoreCase("india"))
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
        else
            System.out.println("ELEMENT DOESN T EXIST");


    }
}

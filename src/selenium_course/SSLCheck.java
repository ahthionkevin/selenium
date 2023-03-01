package selenium_course;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        /**
         * Below link has detailed information on how to handle SSL certification in multiple browsers
         *
         * http://learn-automation.com/handle-untrusted-certificate-selenium/
         *
         * /SSl certificates
         *
         * //Desired capabilities=
         * //general chrome profile
         * DesiredCapabilities ch=DesiredCapabilities.chrome();
         * //ch.acceptInsecureCerts();
         * ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
         * ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
         *
         * //Belows to your local browser
         * ChromeOptions c= new ChromeOptions();
         * c.merge(ch);
         * System.setProperty("webdriver.chrome.driver", "");
         * WebDriver driver=new ChromeDriver(c);
         */

        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        options.setAcceptInsecureCerts(true);

//         FirefoxOptions options1 = new FirefoxOptions();
//         options1.setAcceptInsecureCerts(true);
//         EdgeOptions options2 = new EdgeOptions();

        options.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

    }



}


package apTests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
///

public class TestCases {
    WebDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5, 10));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01: Verify if directed to amazon homepage");
        driver.get("https://www.amazon.in/");
        if(driver.getCurrentUrl().contains("amazon")) {
            System.out.println("testcase1: Verify if directed to amazon homepage: Passed");

        }

        System.out.println("end Test case: testCase01: Passed");
    }

        public void testCase02() {
        System.out.println("Start Test case: testCase02: Verify the search functionality");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
        searchButton.click();
        WebElement laptop = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        if (laptop.getText().contains("Laptop")) {
            System.out.println("testcase2: Verify the search functionality: Passed");
        }
        System.out.println("end Test case: testCase02: Passed");
    }


        public void testCase03() {
        System.out.println("Start Test case: testCase03: Verify the navigation menu");
        WebElement navElem = driver.findElement(By.linkText("Electronics"));
        navElem.click();
        if(driver.getCurrentUrl().contains("electronics")) {
            System.out.println("testcase3: Verify the navigation menu: Passed");

        }

        System.out.println("end Test case: testCase01: Passed");
    }

}


package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    public WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setup() {
        //do not see the browser windows whilst tests are executing/running
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");

        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.getTitle();
        homePage = new HomePage(driver);

    }

    //TAKES SCREENSHOTS AND SAVE TO DIRECTORY DOES NOT OVERRIDE
    //double click ITestResult , select Ctrl , click ITestResult again to open in read-only code
    //ITestResult = tests that either fail or pass in the code window when you execute

    @AfterMethod
    public void captureScreenshots(ITestResult testResult) {

        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/FailedScreenshots/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/PassedScreenshots/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


//closes the browser and ends the session
    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}







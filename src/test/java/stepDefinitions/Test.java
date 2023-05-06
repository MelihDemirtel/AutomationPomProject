package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.time.Duration;

public class Test {
    private static final Logger logger = Logger.getLogger(Test.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private ChromeOptions options;
    private HomePage homePage;

    private String baseUrl = "https://demoqa.com";

    @BeforeClass
    public void setUp(){
        options.addArguments("--enable-features=Cookies");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);

        logger.info("Driver is getting maximize...");
        driver.manage().window().maximize();
        logger.info("Opening  " + baseUrl + "  Website...");
        driver.get(baseUrl);
    }
    @org.testng.annotations.Test(priority = 1)
    public void testHomePage() {
        logger.info("Verifying User is on Home Page...");
        homePage.verifyHomePageIsOpened();
    }
    @AfterClass
    public void tearDown() {
        logger.info("Tests are Ending...");
        if (driver != null) {
            driver.quit();
        }
        if (wait != null) {
            wait = null;
        }
}
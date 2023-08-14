package stepDefinitions;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private ChromeOptions options;
    private Date currentDate;
    private File file;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;
    private CheckBoxPage checkBoxPage;

    private final String baseUrl = "https://demoqa.com";
    private final String screenShotFilePath = "C:\\Projeler\\AutomationPomProject\\src\\test\\screenShots\\";

    @BeforeClass
    public void setUp() {
        options = new ChromeOptions();
        options.addArguments("--enable-features=Cookies");
        options.setExperimentalOption("w3c", true);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        currentDate = new Date();
        file = new File("C:\\Projeler\\AutomationPomProject\\src\\test\\");
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
        checkBoxPage = new CheckBoxPage(driver);

        logger.info("Driver is getting maximize...");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeAllTests() {
        logger.info("Opening  " + baseUrl + "  Website...");
        driver.get(baseUrl);
        homePage.verifyHomePageIsOpened();
    }

    @org.testng.annotations.Test(priority = 1)
    public void testHomePage() throws IOException {
        try {
            homePage.checkPagesButtons();
            logger.info("********** TEST END **********");
        } catch (AssertionError e) {
            logger.error("An exception occurred while running testHomePage: " + e.getMessage());
            takeScreenShot();
            throw e;
        }

    }

    @org.testng.annotations.Test(priority = 2)
    public void testElementsPage() throws IOException {
        try {
            homePage.goToElementsPage();
            elementsPage.verifyElementsPageIsOpened();
            logger.info("********** TEST END **********");
        } catch (AssertionError e) {
            logger.error("An exception occurred while running testHomePage: " + e.getMessage());
            takeScreenShot();
            throw e;
        }

    }

    @org.testng.annotations.Test(priority = 3)
    public void testTextBoxPage() throws IOException {
        try {
            homePage.goToElementsPage();
            elementsPage.goToTextBoxPage();
            textBoxPage.verifyTextBoxPageIsOpened();
            textBoxPage.sendFullName();
            textBoxPage.sendEmail();
            textBoxPage.sendCurrentAddress();
            textBoxPage.sendPermanentAddress();
            textBoxPage.clickSubmitButton();
            textBoxPage.checkSubmitResult();
            logger.info("********** TEST END **********");

        } catch (AssertionError e) {
            logger.error("An exception occurred while running testHomePage: " + e.getMessage());
            takeScreenShot();
            throw e;
        }

    }

    @org.testng.annotations.Test(priority = 4)
    public void testCheckBoxPage() throws IOException {
        try {
            homePage.goToElementsPage();
            elementsPage.goToCheckBoxPage();
            checkBoxPage.verifyCheckBoxPageIsOpened();
            checkBoxPage.clickHomeCheckBoxBtn();
            checkBoxPage.HomeCheckBoxResult();
            checkBoxPage.ClickExpandAllBtn();
            checkBoxPage.ExpandResult();
            checkBoxPage.ClickCollapseAllBtn();
            checkBoxPage.CollapseResult();
            logger.info("********** TEST END **********");

        } catch (AssertionError e) {
            logger.error("An exception occurred while running testHomePage: " + e.getMessage());
            takeScreenShot();
            throw e;
        }

    }

    @AfterClass
    public void tearDown() {
        logger.info("Tests are ending...");
        if (driver != null) {
            driver.quit();
        }
        if (wait != null) {
            wait = null;
        }
    }

    public void takeScreenShot() throws IOException {
        if (!file.exists()) {
            file.mkdir();
        } else {
            String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShotFile, new File(screenShotFilePath + screenShotFileName + ".png"));
            logger.info("System Taked ScreenShot...");
        }
    }
}
package pages.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.alertsFrameWindows.AlertsFrameWindowsPage;
import pages.elements.ElementsPage;
import pages.forms.FormsPage;
import pages.interactions.InteractionsPage;
import pages.widgets.WidgetsPage;
import stepDefinitions.Test;

import java.time.Duration;

public class HomePage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;
    private Actions actions;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsPageBtn;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsPageBtn;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsBtn;

    @FindBy(xpath = "//h5[text()='Widgets']")
    private WebElement widgetsBtn;

    @FindBy(xpath = "//h5[text()='Interactions']")
    private WebElement interactionsBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jsx = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyHomePageIsOpened() {
        logger.info("Verifying User is on Home Page...");
        String expectedUrl = "https://demoqa.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        jsx.executeScript("window.scrollBy(0,300)");
    }

    public ElementsPage goToElementsPage() {
        logger.info("Going to Elements Page...");
        elementsPageBtn.click();
        return new ElementsPage(driver);
    }

    public FormsPage goToFormsPage() {
        logger.info("Going to Forms Page...");
        formsPageBtn.click();
        return new FormsPage(driver);
    }

    public AlertsFrameWindowsPage goToAlertsFrameWindowsPage() {
        logger.info("Going to Alerts Frame Windows Page...");
        alertsFrameWindowsBtn.click();
        return new AlertsFrameWindowsPage(driver);
    }

    public WidgetsPage goToWidgetsPage() {
        logger.info("Going to Widgets Page...");
        widgetsBtn.click();
        return new WidgetsPage(driver);
    }

    public InteractionsPage goToInteractionsPage() {
        logger.info("Going to Interactions Page...");
        interactionsBtn.click();
        return new InteractionsPage(driver);
    }

    public void checkPagesButtons() {
        logger.info("Checking All Buttons of Pages...");
        wait.until(ExpectedConditions.visibilityOf(elementsPageBtn));
        Assert.assertTrue(elementsPageBtn.isDisplayed());
        Assert.assertTrue(formsPageBtn.isDisplayed());
        Assert.assertTrue(alertsFrameWindowsBtn.isDisplayed());
        Assert.assertTrue(widgetsBtn.isDisplayed());
        Assert.assertTrue(interactionsBtn.isDisplayed());
    }
}

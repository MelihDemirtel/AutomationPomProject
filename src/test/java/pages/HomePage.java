package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
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
        String expectedUrl = "https://demoqa.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        jsx.executeScript("window.scrollBy(0,300)");
    }

    public ElementsPage goToElementsPage() {
        elementsPageBtn.click();
        return new ElementsPage(driver);
    }

    public FormsPage goToFormsPage() {
        formsPageBtn.click();
        return new FormsPage(driver);
    }

    public AlertsFrameWindowsPage goToAlertsFrameWindowsPage() {
        alertsFrameWindowsBtn.click();
        return new AlertsFrameWindowsPage(driver);
    }

    public WidgetsPage goToWidgetsPage() {
        widgetsBtn.click();
        return new WidgetsPage(driver);
    }

    public InteractionsPage goToInteractionsPage() {
        interactionsBtn.click();
        return new InteractionsPage(driver);
    }

    public void checkPagesButtons() {
        wait.until(ExpectedConditions.visibilityOf(elementsPageBtn));
        Assert.assertTrue(elementsPageBtn.isDisplayed());
        Assert.assertTrue(formsPageBtn.isDisplayed());
        Assert.assertTrue(alertsFrameWindowsBtn.isDisplayed());
        Assert.assertTrue(widgetsBtn.isDisplayed());
        Assert.assertTrue(interactionsBtn.isDisplayed());
    }
}

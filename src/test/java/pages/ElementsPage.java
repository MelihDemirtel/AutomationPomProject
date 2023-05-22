package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;
    private Actions actions;

    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBoxPageBtn;

    @FindBy(xpath = "//span[text()='Check Box']")
    private WebElement checkBoxPageBtn;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jsx = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyElementsPageIsOpened() {
        String expectedUrl = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public TextBoxPage goToTextBoxPage() {
        textBoxPageBtn.click();
        return new TextBoxPage(driver);
    }
}

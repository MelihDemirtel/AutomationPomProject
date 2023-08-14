package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.Test;

import java.time.Duration;

public class ElementsPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;
    private Actions actions;

    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBoxPageBtn;

    @FindBy(xpath = "//span[text()='Check Box']")
    private WebElement checkBoxPageBtn;

    @FindBy(xpath = "//span[text()='Radio Button']")
    private WebElement radioButtonPageBtn;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jsx = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyElementsPageIsOpened() {
        logger.info("Verifying User is on Elements Page...");
        String expectedUrl = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public TextBoxPage goToTextBoxPage() {
        logger.info("Going to Text Box Page...");
        textBoxPageBtn.click();
        return new TextBoxPage(driver);
    }

    public CheckBoxPage goToCheckBoxPage() {
        logger.info("Going to Check Box Page...");
        checkBoxPageBtn.click();
        return new CheckBoxPage(driver);
    }

    public RadioButtonPage goToRadioButtonPage() {
        logger.info("Going to Radio Button Page...");
        radioButtonPageBtn.click();
        return new RadioButtonPage(driver);
    }
}

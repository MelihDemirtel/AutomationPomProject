package pages.elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.Test;

import java.time.Duration;

public class RadioButtonPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private static final String expectedYesRadioButtonMessage = "Yes";

    private static final String expectedImpressiveRadioButtonMessage = "Impressive";

    private static final String expectedNoRadioButtonMessage = "No";

    private static boolean stateBtn;

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;

    @FindBy(xpath = "//label[text()='Yes']")
    private WebElement yesRadioBtn;

    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement btnMessages;

    @FindBy(xpath = "//label[text()='Impressive']")
    private WebElement impressiveBtn;

    @FindBy(xpath = "//label[text()='No']")
    private WebElement noBtn;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.jsx = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyRadioButtonPageIsOpened() {
        logger.info("Verifying User is on Radio Button Page...");
        String expectedUrl = "https://demoqa.com/radio-button";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public void clickYesRadioButton(){
        logger.info("Clicking Yes Radio Button...");
        wait.until(ExpectedConditions.elementToBeClickable(yesRadioBtn)).click();
        logger.info("Checking Message of Yes Radio Button...");
        Assert.assertEquals(btnMessages.getText(), expectedYesRadioButtonMessage);

    }

    public void clickImpressiveRadioButton(){
        logger.info("Clicking Impressive Radio Button...");
        wait.until(ExpectedConditions.elementToBeClickable(impressiveBtn)).click();
        logger.info("Checking Message of Impressive Radio Button...");
        Assert.assertEquals(btnMessages.getText(), expectedImpressiveRadioButtonMessage);

    }

    public void clickNoRadioButton(){
        logger.info("Checking State of No Radio Button...");
        stateBtn = noBtn.isEnabled();
        if (stateBtn){
            logger.info("Not clickable No Radio Button...");
        }else {
            noBtn.click();
            logger.info("Checking Message of No Radio Button...");
            Assert.assertEquals(btnMessages.getText(), expectedNoRadioButtonMessage);
        }
    }
}

package pages;

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

public class TextBoxPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;

    private static final String fullName = "Test Deneme";
    private static final String email = "test@deneme.com";
    private static final String currentAddress = "Test Mahallesi, Deneme Caddesi";
    private static final String permanentAddress = "Permanent Test";

    @FindBy(id = "userName")
    private WebElement userNameInput;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressTextArea;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressTextArea;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']")
    private WebElement informationArea;

    @FindBy(id = "name")
    private WebElement resultName;

    @FindBy(id = "email")
    private WebElement resultEmail;

    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement resultCurrentAddress;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement resultPermanentAddress;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.jsx = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTextBoxPageIsOpened() {
        logger.info("Verifying User is on Text Box Page...");
        String expectedUrl = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public void sendFullName() {
        logger.info("Sending User Full Name...");
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.sendKeys(fullName);
        jsx.executeScript("window.scrollBy(0,100)");
    }

    public void sendEmail() {
        logger.info("Sending User Email...");
        userEmailInput.sendKeys(email);
    }

    public void sendCurrentAddress() {
        logger.info("Sending User Current Address...");
        currentAddressTextArea.sendKeys(currentAddress);
    }

    public void sendPermanentAddress() {
        logger.info("Sending User Permanent Address...");
        permanentAddressTextArea.sendKeys(permanentAddress);
        jsx.executeScript("window.scrollBy(0,400)");
    }

    public void clickSubmitButton() {
        logger.info("Clicking Submit Button...");
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        submitBtn.click();
    }

    public void checkSubmitResult() {
        logger.info("Checking User Information...");
        wait.until(ExpectedConditions.visibilityOf(informationArea));
        Assert.assertEquals(resultName.getText(), "Name:" + fullName);
        Assert.assertEquals(resultEmail.getText(), "Email:" + email);
        Assert.assertEquals(resultCurrentAddress.getText(), "Current Address :" + currentAddress);
        Assert.assertEquals(resultPermanentAddress.getText(), "Permananet Address :" + permanentAddress);
    }
}

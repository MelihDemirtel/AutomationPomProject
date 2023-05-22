package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TextBoxPage {
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

    @FindBy(id = "currentAddress")
    private WebElement resultCurrentAddress;

    @FindBy(id = "permanentAddress")
    private WebElement resultPermanentAddress;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.jsx = (JavascriptExecutor) driver;
    }

    public void verifyTextBoxPageIsOpened() {
        String expectedUrl = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public void sendFullName() {
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.sendKeys(fullName);
        jsx.executeScript("window.scrollBy(0,100)");
    }

    public void sendEmail() {
        userEmailInput.sendKeys(email);
    }

    public void sendCurrentAddress() {
        currentAddressTextArea.sendKeys(currentAddress);
    }

    public void sendPermanentAddress() {
        permanentAddressTextArea.sendKeys(permanentAddress);
        jsx.executeScript("window.scrollBy(0,400)");
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        submitBtn.click();
    }

    public void checkSubmitResult() {
        wait.until(ExpectedConditions.visibilityOf(informationArea));
        Assert.assertEquals(resultName.getText(), "Name:" + fullName);
        Assert.assertEquals(resultEmail.getText(), "Email:" + email);
        Assert.assertEquals(resultCurrentAddress, "Current Address :" + currentAddress);
        Assert.assertEquals(resultPermanentAddress, "Permananet Address :" + permanentAddress);
    }
}

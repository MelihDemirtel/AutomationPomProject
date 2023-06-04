package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;

    @FindBy(xpath = "//span[@class='rct-checkbox']")
    private WebElement homeCheckBoxBtn;

    @FindBy(id = "result")
    private WebElement homeCheckBoxResult;

    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement expandAllBtn;

    @FindBy(xpath = "//button[@title='Collapse all']")
    private WebElement collapseAllBtn;

    @FindBy(xpath = "(//ol)[2]")
    private WebElement expandResult;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.jsx = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCheckBoxPageIsOpened() {
        String expectedUrl = "https://demoqa.com/checkbox";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public void clickHomeCheckBoxBtn(){
        wait.until(ExpectedConditions.visibilityOf(homeCheckBoxBtn));
        homeCheckBoxBtn.click();
    }

    public void HomeCheckBoxResult(){
        Assert.assertTrue(homeCheckBoxResult.isDisplayed());
    }

    public void ClickExpandAllBtn(){
        expandAllBtn.click();
    }

    public void ExpandResult(){
        Assert.assertTrue(expandResult.isDisplayed());
    }

    public void ClickCollapseAllBtn(){
        Assert.assertFalse(expandResult.isDisplayed());
    }
}

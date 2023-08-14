package pages.elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
import java.util.List;

public class CheckBoxPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;
    private int second = 1;

    @FindBy(xpath = "//span[@class='rct-checkbox']")
    private WebElement homeCheckBoxBtn;

    @FindBy(id = "result")
    private WebElement homeCheckBoxResult;

    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement expandAllBtn;

    @FindBy(xpath = "//button[@title='Collapse all']")
    private WebElement collapseAllBtn;

    @FindBy(tagName = "ol")
    private List<WebElement> expandResult;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.jsx = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCheckBoxPageIsOpened() {
        logger.info("Verifying User is on Check Box Page...");
        String expectedUrl = "https://demoqa.com/checkbox";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public void clickHomeCheckBoxBtn(){
        logger.info("Clicking Home Check Box Button...");
        wait.until(ExpectedConditions.elementToBeClickable(homeCheckBoxBtn));
        homeCheckBoxBtn.click();
    }

    public void HomeCheckBoxResult(){
        logger.info("Checking Result...");
        wait.withTimeout(Duration.ofSeconds(second));
        Assert.assertTrue(homeCheckBoxResult.isDisplayed());
    }

    public void ClickExpandAllBtn(){
        logger.info("Clicking Expand Button...");
        expandAllBtn.click();
    }

    public void ExpandResult(){
        logger.info("Checking Expand Result...");
        wait.withTimeout(Duration.ofSeconds(second));
        if (expandResult.size() == 7){
            logger.info("Selected Item Size: " + expandResult.size());
        }else {
            logger.info("Selected Item Size Must be 7 Not " + expandResult.size());
        }
    }

    public void ClickCollapseAllBtn(){
        logger.info("Clicking Collapse Button...");
        collapseAllBtn.click();
    }

    public void CollapseResult(){
        logger.info("Checking Collapse Result...");
        wait.withTimeout(Duration.ofSeconds(second));
        if (expandResult.size() == 1){
            logger.info("Selected Item Size: " + expandResult.size());
        }else {
            logger.info("Selected Item Size Must be 1 Not " + expandResult.size());
        }
    }
}

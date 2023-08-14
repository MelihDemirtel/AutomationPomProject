package pages.elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.Test;

import java.time.Duration;

public class WebTablesPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.jsx = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyWebTablesPageIsOpened() {
        logger.info("Verifying User is on Web Tables Page...");
        String expectedUrl = "https://demoqa.com/webtables";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }


}

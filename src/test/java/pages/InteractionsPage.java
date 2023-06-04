package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefinitions.Test;

public class InteractionsPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;

    public InteractionsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyInteractionsPageIsOpened() {
        logger.info("Verifying User is on Interactions Page...");
        String expectedUrl = "https://demoqa.com/interaction";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

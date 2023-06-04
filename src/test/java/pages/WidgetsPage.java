package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefinitions.Test;

public class WidgetsPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;

    public WidgetsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyWidgetsPageIsOpened() {
        logger.info("Verifying User is on Widgets Page...");
        String expectedUrl = "https://demoqa.com/widgets";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

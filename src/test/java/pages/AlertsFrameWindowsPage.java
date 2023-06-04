package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefinitions.Test;

public class AlertsFrameWindowsPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;

    public AlertsFrameWindowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyAlertsFrameWindowsPageIsOpened() {
        logger.info("Verifying User is on Alerts Frame Windows Page...");
        String expectedUrl = "https://demoqa.com/alertsWindows";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

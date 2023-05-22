package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertsFrameWindowsPage {
    private WebDriver driver;

    public AlertsFrameWindowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyAlertsFrameWindowsPageIsOpened() {
        String expectedUrl = "https://demoqa.com/alertsWindows";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

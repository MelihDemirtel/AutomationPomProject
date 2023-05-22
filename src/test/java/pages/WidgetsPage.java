package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WidgetsPage {
    private WebDriver driver;

    public WidgetsPage(WebDriver driver){
        this.driver = driver;
    }
    public void verifyWidgetsPageIsOpened() {
        String expectedUrl = "https://demoqa.com/widgets";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

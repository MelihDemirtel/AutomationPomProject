package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WidgetsPage {
    private WebDriver driver;

    public WidgetsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyWidgetsPageIsOpened() {
        String expectedUrl = "https://demoqa.com/widgets";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

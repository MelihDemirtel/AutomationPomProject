package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FormsPage {
    private WebDriver driver;

    public FormsPage(WebDriver driver){
        this.driver = driver;
    }
    public void verifyFormsPageIsOpened() {
        String expectedUrl = "https://demoqa.com/forms";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
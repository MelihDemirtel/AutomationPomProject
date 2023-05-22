package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InteractionsPage {
    private WebDriver driver;

    public InteractionsPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyInteractionsPageIsOpened() {
        String expectedUrl = "https://demoqa.com/interaction";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

package pages.elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

public class WebTablesPage {
    private static final Logger logger = LogManager.getLogger(Test.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsx;

    private static String[] expectedDefaultData = {
            "Cierra", "Vega", "39", "cierra@example.com", "10000", "Insurance", "",
            "Alden", "Cantrell", "45", "alden@example.com", "12000", "Compliance", "",
            "Kierra", "Gentry", "29", "kierra@example.com", "2000", "Legal"
    };

    @FindBy(xpath = "//div[@class='rt-td']")
    private List<WebElement> gridCells;

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

    public void checkDefaultData() {
        wait.until(ExpectedConditions.visibilityOfAllElements(gridCells));
        for (int i = 0; i < expectedDefaultData.length; i++) {
            logger.info("Checking " + (i + 1) + " data...");
            Assert.assertEquals(gridCells.get(i).getText(), expectedDefaultData[i]);
        }
    }
}

package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Product1Page{

    private final By CartText = By.linkText("Cart");
    private final By LimitText = By.xpath("//*[@id='content']/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div[5]/span[1]/span[1]");
    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public CartPage waitForPageToLoad() {
        LOGGER.debug("Wait for the Cart Page to Load");
        ActOn.wait(driver, CartText).waitForElementToBeVisible();
        return this;
    }

    public CartPage validateLimit(String value) {
        LOGGER.debug("Validating the Limit is: " + value);
        String actualLimit = ActOn.element(driver, LimitText).getTextValue();
        Assert.assertEquals(value, actualLimit);
        return this;
    }
}

package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Product1Page {

    private final By AboutThisProduct1 = By.linkText("About this product");
    private final By Quantity = By.name("custom-input-number");
    private final By AddToBag = By.xpath("//button[@data-test-id='add-to-bag-button']");
    private final By BagIcon = By.xpath("//div[@aria-label='Shopping bag']");
    public WebDriver driver;
    public Product1Page(WebDriver driver) {
        this.driver = driver;
    }
    private static final Logger LOGGER = LogManager.getLogger(Product1Page.class);

    public Product1Page waitForPageToLoad() {
        LOGGER.debug("Wait for the Product1 Page to Load");
        ActOn.wait(driver, AboutThisProduct1).waitForElementToBeVisible();
        return this;
    }

    public Product1Page enterValue(String value) {
        LOGGER.debug("Enter Value: " + value);
        ActOn.element(driver, Quantity).setValue(value);
        return this;
    }

    public Product1Page clickOnAddToBag() {
        LOGGER.debug("Click on add to bag button");
        ActOn.element(driver, AddToBag).click();
        return this;
    }

    public Product1Page clickOnBagIcon() {
        LOGGER.debug("Click on bag icon");
        ActOn.element(driver, BagIcon).click();
        return this;
    }

}

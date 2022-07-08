package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.CartPage;
import page_objects.Product1Page;
import utilities.ReadConfigFiles;

public class PurchaseSteps {
    WebDriver driver = Hooks.driver;
    private static final Logger LOGGER = LogManager.getLogger(PurchaseSteps.class);

    @Given("a user is on product1 page")
    public void a_user_is_on_product1_page() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("LeaflyURL"));
        LOGGER.info("User is on Leafly Product1 Page");
    }
    @When("user clicks on add to bag button upon entering \"(.+?)\" in the Quantity field")
    public void user_clicks_on_add_to_bag_button_upon_entering_in_the_quantity_field(String value) {
        new Product1Page(driver)
                .waitForPageToLoad()
                .enterValue(value)
                .clickOnAddToBag();
        LOGGER.info("Entered the data");
    }
    @When("clicks on bag icon")
    public void clicks_on_bag_icon() {
        new Product1Page(driver)
                .clickOnBagIcon();
        LOGGER.info("Clicked on Bag Icon");
    }
    @Then("quantity displays \"(.+?)\" items in the cart")
    public void quantity_displays_items(String value) {
        new CartPage(driver)
                .waitForPageToLoad()
                .validateLimit(value);
        LOGGER.info("Quantity Limit is validated");
    }
}

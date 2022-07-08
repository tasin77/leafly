package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private DriverFactory() {

    }

    private static final DriverFactory instance = new DriverFactory();
    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        String environment = System.getProperty("environment") == null ? "local" : System.getProperty("environment");
        String browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        URL LeaflyURL = null;

        try {
            LeaflyURL = new URL(ReadConfigFiles.getPropertyValues("LeaflyURL"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (environment.equals("remote") && browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            return new RemoteWebDriver(LeaflyURL, chromeOptions);
        } else if (environment.equals("remote") && browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            return new RemoteWebDriver(LeaflyURL, firefoxOptions);
        } else if (environment.equals("remote") && browser.equals("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            return new RemoteWebDriver(LeaflyURL, edgeOptions);
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    });

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

public class AdminCities extends BasePage {

    @FindBy

    public AdminCities (WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePage extends BasePage {
//    @FindBy(xpath = "/html/body/div/div/main/div/div[2]/div/div[2]/div[1]/a/span")
//    private WebElement buyMeACoffeButton;
//
//    @FindBy(xpath = "/html/body/div/div/div/header/div/div[3]/div[1]/div/div/div/div[1]/div/div[1]")
//    private WebElement lightToDark;
//
//    @FindBy(xpath = "/html/body/div/div/div/header/div/div[3]/div[1]/div/div/div/div[1]/div/div[1]")
//    private WebElement darkToLight;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement signUpMessage;

    //When signed in:
    @FindBy(xpath = "/html/body/div/div[1]/div/header/div/div[3]/button[1]")
    private WebElement adminOption;



    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void logout() {
        logoutButton.click();
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSignUpMessage() {
        return signUpMessage;
    }
}

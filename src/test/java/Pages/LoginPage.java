package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{


    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "/html/body/div/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")
    private WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void login(String email, String password){
        this.email.clear();
        this.password.clear();

        this.email.sendKeys(email);
        this.password.sendKeys(password);

        loginButton.click();
    }


}

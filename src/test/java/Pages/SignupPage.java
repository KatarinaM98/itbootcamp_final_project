package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "/html/body/div/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement signupButton;

    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void signup(String name, String email, String password, String confirmPassword){
        this.name.clear();
        this.email.clear();
        this.password.clear();
        this.confirmPassword.clear();

        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);

        signupButton.click();
    }



}

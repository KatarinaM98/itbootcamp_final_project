package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"confirmPassword\"]")
    private WebElement confirmPassword;

    @FindBy(xpath = "/html/body/div/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement signupButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement message;


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

    public void openSignupPage () {

        driver.get("https://vue-demo.daniel-avellaneda.com/signup");

    }
    public WebElement getName() {
        return name;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public WebElement getMessage() {
        return message;
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement loginButtonPage;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    //*[@id="app"]/div/div/header/div/div[3]/a[3]
    @FindBy(xpath = "/html/body/div/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")
    private WebElement loginButton;

     @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
     private WebElement message;

     @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
     private WebElement message2; 


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void login(String email, String password){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        this.email.clear();
        this.password.clear();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void openLoginPage () {
        loginButtonPage.click();
        driverWait.until(ExpectedConditions.urlContains("/login"));
    }

    public WebElement getEmail() {

        return email;
    }

    public WebElement getPassword() {

        return password;
    }

    public WebElement getMessage() {

        return message;
    }

    public WebElement getLoginButton() {

        return loginButton;
    }
}

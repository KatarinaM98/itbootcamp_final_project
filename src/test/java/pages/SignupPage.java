package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]")
    private WebElement signupPageButton;

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

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[3]/button")
    private WebElement closeMessage;


    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void openSignupPage() {
        signupPageButton.click();
        driverWait.until(ExpectedConditions.urlContains("/signup"));
    }

    public void signup(String name, String email, String password, String confirmPassword) {
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

    public void closeMessage() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button")));
        closeMessage.click();
    }

    public void driverWaitForEmailFieldPresence() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"email\"]")));
    }

    public void driverWaitForMessage() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")));
    }

    public void driverWaitForVerificationMessage() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")));
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

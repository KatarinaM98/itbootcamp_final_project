package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement signUpMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button/span")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"list-item-75\"]/div")
    private WebElement languageES;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement headerText;

    @FindBy(xpath = "//*[@id=\"list-item-73\"]/div")
    private WebElement languageEN;

    @FindBy(xpath = "//*[@id=\"list-item-77\"]/div")
    private WebElement languageFR;


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void login() {
        loginButton.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")));
    }

    public void logout() {
        logoutButton.click();
    }

    public void openHomePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
    }

    public void changeLanguage(String language) {
        languageButton.click();
        if (language.equals("ES")) {
            languageES.click();
        } else if (language.equals("EN")) {
            languageEN.click();
        } else if (language.equals("FR")) {
            languageFR.click();
        } else {
            System.out.println("Nevalidan unos");
        }
    }

    public void driverWaitForHeading() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")));
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSignUpMessage() {
        return signUpMessage;
    }

    public WebElement getHeaderText() {
        return headerText;
    }

}

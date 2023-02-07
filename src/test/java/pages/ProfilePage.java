package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")
    private WebElement myProfileButton;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button")
    private WebElement phoneXbutton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div")
    private WebElement selectCityButton;

    @FindBy(xpath = "//*[@id=\"list-146\"]")
    private WebElement selectCity;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button")
    private WebElement clearCityX;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement urlTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement urlGitHub;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button/span")
    private WebElement saveChangeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")
    private WebElement messageSaved;


    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void openProfileChangePage() {
        driverWait.until(ExpectedConditions.urlContains("/home"));
        myProfileButton.click();
        driverWait.until(ExpectedConditions.urlContains("/profile"));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
    }

    public void clearText() {
        myProfileButton.click();
        driverWait.until(ExpectedConditions.urlContains("/profile"));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        phoneXbutton.click();
        clearCityX.click();
        this.country.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        urlTwitter.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        urlGitHub.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        this.name.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

    public void changeProfile(String newPassword, String name, String phone, String country, String city, String twitter, String gitHub) {
        this.name.sendKeys(name);
        this.phone.sendKeys(phone);
        this.country.sendKeys(country);
        urlTwitter.sendKeys(twitter);
        urlGitHub.sendKeys(gitHub);
        this.city.sendKeys(city, Keys.ENTER);
        saveChangeButton.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")));
    }

    public void driverWaitForMyProfileButtonPresence() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")));
    }

    public void driverWaitForMessage() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")));
    }

    public WebElement getMessageSaved() {
        return messageSaved;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getSelectCityEnterText() {
        return city;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getUrlTwitter() {
        return urlTwitter;
    }

    public WebElement getUrlGitHub() {
        return urlGitHub;
    }
}

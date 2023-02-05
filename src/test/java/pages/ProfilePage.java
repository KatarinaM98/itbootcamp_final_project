package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ProfilePage extends BasePage {



    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/div[1]/button/span")
    private WebElement changePasswordButton ;

    @FindBy(xpath = "//*[@id=\"oldPassword\"]")
    private WebElement currentPassword;

    @FindBy(xpath = "//*[@id=\"newPassword\"]")
    private WebElement newPassword;

    @FindBy(xpath = "//*[@id=\"confirmPassword\"]")
    private WebElement confirmNewPassword;

    @FindBy(xpath = "//*[@id=\"updatePassword\"]/span")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement changedPasswordMessage;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phone;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div")
    private WebElement selectCityButton;

    @FindBy(xpath = "//*[@id=\"list-146\"]")
    private WebElement selectCity;

    //*[@id="city"]

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement selectCityEnterText;

    //int random = (int) (Math.random() * ((5 - 1) + 1));


    @FindBy(xpath = "//*[@id=\"list-item-202-0\"]/div/div")
    private WebElement listItem;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button")
    private WebElement clearListButtonX;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement urlTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement urlGitHub;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button/span")
    private WebElement saveChangeButton;



    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageSaved;


    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {

        super(driver, driverWait);

    }

    public void openProfilePage () {

        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/profile");
    }

    public void changeProfile () {

        Faker faker = new Faker();
        driverWait.until(ExpectedConditions.urlContains("/profile"));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/div[1]/button/span")));
        changePasswordButton.click();
        currentPassword.sendKeys("12345");
        String newPasswordString = faker.internet().password();
        newPassword.sendKeys(newPasswordString);
        confirmNewPassword.sendKeys(newPasswordString);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"updatePassword\"]/span")));
        saveButton.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        name.click();
        name.clear();
        phone.clear();
        country.clear();
        urlTwitter.clear();
        urlGitHub.clear();
        name.sendKeys(faker.name().firstName());
        phone.sendKeys(faker.phoneNumber().phoneNumber());

        //Ne mogu da promenim city ni sa selectom, ni sa -click().

        country.sendKeys(faker.address().country());

        urlTwitter.sendKeys("https://twitter.com/" + faker.name().username());

        urlGitHub.sendKeys("https://github.com/" + faker.name().username());

        //clearListButtonX.click();
        selectCityEnterText.sendKeys("New York");

       // selectCityButton.click();


        //listItem.click();


        //       WebElement selectCategory = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div"));
//        Select category = new Select(selectCategory);
//        category.selectByVisibleText(language);

        saveChangeButton.click();



    }

    public WebElement getMessageSaved() {
        return messageSaved;
    }

    public WebElement getChangePasswordButton() {
        return changePasswordButton;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getSelectCityEnterText() {
        return selectCityEnterText;
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

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(name = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[2]/div/i")
    private WebElement selectCityButton;

    @FindBy(name = "//*[@id=\"list-146\"]")
    private WebElement selectCity;



    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement urlTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement urlGitHub;


    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {

        super(driver, driverWait);

    }



}

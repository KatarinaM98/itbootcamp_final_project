package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
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

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[2]")
    private WebElement name2;



    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button")
    private WebElement phoneXbutton;


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



    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")
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

        //OVO ODKOMENTARIŠI KADA SE LOGOVANJE ZA ADMINA ODBLOKIRA, ZA SIGNUP JE VEĆ PRAZNO


//        name.clear();
//        phoneXbutton.click();
//        clearListButtonX.click();
//        for (int i = 0; i < 20; i++) {
//            country.sendKeys(Keys.BACK_SPACE);
//        }
//
//        for (int i = 0; i < 35; i++) {
//            urlTwitter.sendKeys(Keys.BACK_SPACE);
//        }
//
//        for (int i = 0; i < 35; i++) {
//            urlGitHub.sendKeys(Keys.BACK_SPACE);
//        }

//        for (int i = 0; i < 20; i++) {
//            name.sendKeys(Keys.BACK_SPACE);
//      }


        name.sendKeys(faker.name().firstName());
        phone.sendKeys(faker.phoneNumber().phoneNumber());

        //Ne mogu da promenim city ni sa selectom, ni sa -click().

        country.sendKeys(faker.address().country());

        urlTwitter.sendKeys("https://twitter.com/" + faker.name().username());

        urlGitHub.sendKeys("https://github.com/" + faker.name().username());

       selectCityEnterText.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//        selectCityEnterText.sendKeys("New York");
//        selectCityEnterText.sendKeys(Keys.ENTER);


       // selectCityButton.click();
        //listItem.click();

        //       WebElement selectCategory = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div"));
//        Select category = new Select(selectCategory);
//        category.selectByVisibleText(language);

        saveChangeButton.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")));



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

    public WebElement getName2() {
        return name2;
    }
}

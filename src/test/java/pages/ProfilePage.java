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


    @FindBy(name = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[2]/div/i")
    private WebElement selectCityButton;

    @FindBy(name = "//*[@id=\"list-146\"]")
    private WebElement selectCity;

    //*[@id="city"]

    @FindBy(name = "//*[@id=\"city\"]")
    private WebElement selectCityEnterText;


    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement urlTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement urlGitHub;


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
        name.sendKeys(faker.name().firstName());
        phone.sendKeys(faker.phoneNumber().phoneNumber());
        //selectCityButton.click();
//        WebElement selectCategory = driver.findElement(By.xpath("//*[@id=\"list-146\"]"));
//     Select category = new Select(selectCategory);
        //ne radi selecr
        //todo nadji način da selektuješ grad
        selectCityEnterText.click();

    // int random = (int) (Math.random() * ((5 - 1) + 1));
       //category.selectByIndex(random);




    }



}

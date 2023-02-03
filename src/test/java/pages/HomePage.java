package pages;


import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePage extends BasePage {
//    @FindBy(xpath = "/html/body/div/div/main/div/div[2]/div/div[2]/div[1]/a/span")
//    private WebElement buyMeACoffeButton;
//
//    @FindBy(xpath = "/html/body/div/div/div/header/div/div[3]/div[1]/div/div/div/div[1]/div/div[1]")
//    private WebElement lightToDark;
//
//    @FindBy(xpath = "/html/body/div/div/div/header/div/div[3]/div[1]/div/div/div/div[1]/div/div[1]")
//    private WebElement darkToLight;
//*[@id="app"]/div[1]/div/header/div/div[3]/button[2]
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span")
    private WebElement logoutButton;

    @FindBy(xpath = "")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement signUpMessage;

    //When signed in:
    @FindBy(xpath = "/html/body/div/div[1]/div/header/div/div[3]/button[1]")
    private WebElement adminOption;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button/span")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"list-item-75\"]/div")
    private WebElement languageES;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement headerTextES;

    @FindBy(xpath = "//*[@id=\"list-item-73\"]/div")
   private WebElement languageEN;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement headerTextEN;


  @FindBy(xpath = "//*[@id=\"list-item-77\"]/div")
   private WebElement languageFR;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement headerTextFR;



    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void logout() {
        logoutButton.click();
    }

    public void openHomePage ()
    {
    driver.get("https://vue-demo.daniel-avellaneda.com/home");
    }

    public void changeLanguage(String language) {
        languageButton.click();
//        WebElement selectCategory = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div"));
//        Select category = new Select(selectCategory);
//        category.selectByVisibleText(language);

//        languageES.click();
       if (language.equals("ES")) {
           languageES.click();
       } else if (language.equals("EN")) {
           languageEN.click();
       } else if (language.equals("FR")) {
           languageFR.click();
       } else {
           System.out.println("Nevalidan unos");
       }



        //languageButton.click();
    }


    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSignUpMessage() {
        return signUpMessage;
    }

    public WebElement getHeaderTextES() {
        return headerTextES;
    }

    public WebElement getHeaderTextEN() {
        return headerTextEN;
    }

    public WebElement getHeaderTextFR() {
        return headerTextFR;
    }
}

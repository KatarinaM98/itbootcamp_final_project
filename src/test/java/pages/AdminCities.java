package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

public class AdminCities extends BasePage {


   // @FindBy
   @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
   private WebElement logoutButton;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span")
    private WebElement newItemButton;

    @FindBy(id = "name")
    private WebElement cityName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div[3]/button[2]/span")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"edit\"]/span/i")
    private WebElement edit;

    @FindBy(id = "search")
    private WebElement searchText;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement editedCityInTable;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement searchedCityInTable;

    @FindBy(xpath = "//*[@id=\"delete\"]/span/i")
    private WebElement delete;

    @FindBy(xpath = "//*[@id=\"app\"]/div[6]/div/div")
    private WebElement deleteDialog;
    //*[@id="app"]/div[6]

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]")
    private WebElement delete2;



    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[2]/div/div/div/div/div[1]/ul/li")
    private WebElement message2;





    public AdminCities (WebDriver driver, WebDriverWait driverWait) {

        super(driver, driverWait);

    }

    public void openCitiesPage () {


        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");

    }

    public void addNewCity (String city) {

        newItemButton.click();
        cityName.sendKeys(city);
        saveButton.click();

    }

    public void editCity () {

        edit.click();
        //Ako se stavi "+-edited" onda test 4 fejluje jer ne može da pretražuje "+-" karaktere
        cityName.sendKeys(" edited");
        saveButton.click();

    }

    public void searchCity () {

        searchText.sendKeys(editedCityInTable.getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteCity () {

        delete.click();
        //Ako se stavi "+-edited" onda test 4 fejluje jer ne može da pretražuje "+-" karaktere
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[6]/div/div/div[2]/button[2]/span")));
        delete2.click();




    }




    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getNewItemButton() {
        return newItemButton;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getEditedCityInTable() {
        return editedCityInTable;
    }

    public WebElement getSearchedCityInTable() {
        return searchedCityInTable;
    }

    public WebElement getSearchText() {
        return searchText;
    }

    public WebElement getMessage2() {
        return message2;
    }
}


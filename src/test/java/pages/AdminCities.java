package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCities extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span")
    private WebElement adminOption;

    @FindBy(className = "btnAdminCities")
    private WebElement citiesOption;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
   private WebElement logoutButton;
    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span")
    private WebElement newItemButton;
    @FindBy(id = "name")
    private WebElement cityName;
    @FindBy(className = "btnSave")
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

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement deleteDialogButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement message2;


    public AdminCities (WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void openCitiesPage () {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span")));
        adminOption.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnAdminCities")));
       citiesOption.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search\"]")));
    }


    public void addNewCity (String city) {
        newItemButton.click();
        cityName.sendKeys(city);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnSave")));
        saveButton.click();
    }

    public void editCity () {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"edit\"]/span/i")));
        edit.click();
        cityName.sendKeys(" edited");
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnSave")));
        saveButton.click();
    }

    public void searchCity () {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        searchText.sendKeys(editedCityInTable.getText());
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"edit\"]")));
    }

    public void deleteCity () {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"delete\"]/span/i")));
        delete.click();
         driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")));
        deleteDialogButton.click();
    }



    public void driverWaitForHomePage () {
        driverWait.until(ExpectedConditions.urlContains("/home"));
        }

    public void driverWaitForMessage () {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
    }



    public WebElement getLogoutButton() {
        return logoutButton;
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


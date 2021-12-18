package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsersPage {
    private final WebDriver driver;


    @FindBy(id="btnAdd")
    private WebElement btnAdd;
    @FindBy(id="searchBtn")
    private WebElement searchBtn;
    @FindBy(id="resetBtn")
    private WebElement resetBtn;
    @FindBy(id="btnDelete")
    private WebElement deleteBtn;
    @FindBy(id="dialogDeleteBtn")
    private WebElement okBtn;
    @FindBy(id="searchSystemUser_userName")
    private WebElement searchUsername;
    @FindBy(id="searchSystemUser_userType")
    private WebElement searchType;
    @FindBy(id="searchSystemUser_employeeName_empName")
    private WebElement searchName;
    @FindBy(id="searchSystemUser_status")
    private WebElement searchStatus;
    @FindBy(name="chkSelectRow[]")
    private WebElement checkbox;

    public UsersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickAddUserBtn(){
        btnAdd.click();
    }
    public void clickSearchUserBtn(){
        searchBtn.click();
    }
    public void clickResetBtn(){
        resetBtn.click();
    }
    public void inputUsername(String value){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(searchUsername));
        searchUsername.sendKeys(value);
    }
    public void inputName(String value){
        searchName.sendKeys(value);
    }
    public void selectRole(String value){
        WebElement option=driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']/option[text()='"+value+"']"));
        option.click();

    }
    public void selectStatus(String value){
        WebElement option=driver.findElement(By.xpath("//select[@id='searchSystemUser_status']/option[text()='"+value+"']"));
        option.click();
    }
    public boolean isUserDisplayed(){
        return driver.findElements(By.xpath("//*[text()='No Records Found']")).isEmpty();
    }
    public String findUserId(){
        return checkbox.getAttribute("defaultValue");
    }

    public boolean searchUserById(String id) {
        return !driver.findElements(By.xpath("//a[@href= 'saveSystemUser?userId="+id+"']")).isEmpty();
    }

    public void selectCheckboxById(String id) {
        WebElement checkboxById = driver.findElement(By.id("ohrmList_chkSelectRecord_"+id));
        checkboxById.click();
    }

    public void clickDeleteBtn() {
        deleteBtn.click();
    }

    public void clickOkBtn() {
        okBtn.click();
    }
}

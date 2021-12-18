package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SaveSystemUserPage {
    private final WebDriver driver;


    @FindBy(id="systemUser_employeeName_empName")
    private WebElement nameField;
    @FindBy(id="systemUser_userName")
    private WebElement usernameField;
    @FindBy(id="systemUser_password")
    private WebElement passwordField;
    @FindBy(id="systemUser_confirmPassword")
    private WebElement confirmPasswordField;
    @FindBy(id="btnSave")
    private WebElement btnSave;

    public SaveSystemUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickSaveUserBtn(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(btnSave));
        btnSave.click();
    }
    public void inputName(String name){
        nameField.sendKeys(name);
    }
    public void inputUsername(String username){
        usernameField.sendKeys(username);
    }
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }
    public void confirmPassword(String password){
        confirmPasswordField.sendKeys(password);
    }
}

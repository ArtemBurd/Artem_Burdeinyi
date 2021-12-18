package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    @FindBy(id="menu_admin_viewSystemUsers")
    private WebElement usersMenu;

    @FindBy(id="menu_admin_viewAdminModule")
    private WebElement adminMenu;

    @FindBy(id="menu_admin_UserManagement")
    private WebElement userManageMenu;


    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void goToUsers(){
        new Actions(driver).moveToElement(adminMenu).perform();
        new Actions(driver).moveToElement(userManageMenu).perform();
        usersMenu.click();
    }

}

package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
    private final WebDriver driver;

    private static final String PAGE_URL="https://opensource-demo.orangehrmlive.com/";

    @FindBy(id="txtUsername")
    private WebElement username;

    @FindBy(id="txtPassword")
    private WebElement password;

    public AuthenticationPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    public void inputUsername(){
        this.username.sendKeys("Admin" );
    }
    public void inputPassword(){
        this.password.sendKeys("admin123" + Keys.ENTER);
    }
}

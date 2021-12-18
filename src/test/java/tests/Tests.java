package tests;

import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.SaveSystemUserPage;
import pages.UsersPage;

public class Tests {
    private static ChromeDriver driver;
    private static String name;
    private static String username;
    private static String id;
    HomePage home;
    UsersPage users;
    SaveSystemUserPage save;

    @BeforeAll
    public static void before(){
        System.setProperty("webdriver.chrome.driver", "D:\\КПІ\\5 семестр\\Розробка і тестування програм\\chromedriver.exe");
        driver = new ChromeDriver();
        AuthenticationPage authPage = new AuthenticationPage(driver);
        authPage.inputUsername();
        authPage.inputPassword();
    }
    @Given("User on {string} page")
    public void user_on_page(String page) {
        switch (page) {
            case ("home"): home = new HomePage(driver); break;
            case ("saveUser"): save = new SaveSystemUserPage(driver); break;
            case ("users"): users = new UsersPage(driver); break;
        }
    }
    @When("User selects Users")
    public void user_selects_users() {
        home.goToUsers();
        users = new UsersPage(driver);
    }
    @When("User clicks {string}")
    public void user_clicks_button(String btn) {
        switch(btn){
            case("addBtn"): users.clickAddUserBtn(); break;
            case("saveBtn"): save.clickSaveUserBtn(); break;
            case ("searchUserBtn"): users.clickSearchUserBtn(); break;
            case("resetBtn"): users.clickResetBtn(); break;
            case("deleteBtn"): users.clickDeleteBtn();
        }

    }
    @Then("User go to {string} page")
    public void user_go_to_page(String page) {
        switch (page) {
            case ("saveUser"): save=new SaveSystemUserPage(driver); break;
            case ("users"): users=new UsersPage(driver); break;
        }

    }
    @When("User inputs {string} in {string}")
    public void user_inputs_in(String value, String field) {
        switch (field) {
            case ("nameField"): save.inputName(value); name=value; break;
            case ("usernameField"): save.inputUsername(value); username=value; break;
            case ("passwordField"): save.inputPassword(value); break;
            case ("confirmField"): save.confirmPassword(value); break;
            case ("searchUsername"): users.inputUsername(username); break;
            case ("searchName"): users.inputName(name); break;

        }
    }
    @When("User selects {string} in {string}")
    public void user_selects_in(String value, String field) {
        switch (field){
            case ("searchRole"): users.selectRole(value); break;
            case("searchStatus"): users.selectStatus(value); break;
        }
    }
    @Then("User sees created user")
    public void user_sees_created_user() {
        if (!users.isUserDisplayed()) throw new CucumberException("User is`t displayed");
        id = users.findUserId();
    }
    @Then("Created user is in the grid")
    public void created_user_is_in_the_grid() {
        if (!users.searchUserById(id)) throw new CucumberException("User is`t displayed in the grid");
    }
    @When("User selects checkbox")
    public void user_selects_checkbox() {
        users.selectCheckboxById(id);
    }
    @When("User confirms deletion")
    public void user_confirms_deletion() {
        users.clickOkBtn();
    }
    @Then("Created user is not in the grid")
    public void created_user_is_not_in_the_grid() {
        if (users.searchUserById(id)) throw new CucumberException("User is displayed in the grid but should`t");
    }

}

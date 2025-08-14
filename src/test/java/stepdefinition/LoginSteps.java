package stepdefinition;

import Utils.Util;
import io.cucumber.java.en.And;
import org.junit.Assert;
import pageobject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginSteps {

    LoginPage loginPage;

    @When("executing story {string}")
    public void executing_story(String featureFileName) {
        Util.setSenarioData("featureName", featureFileName);
        Util.setScreenPath();
    }

    @And("User Open Url")
    public void and_user_open_url() {
        loginPage=new LoginPage();
        loginPage.userOpenUrl();
    }
    @When("User Enters Username {string}")
    public void user_enters_username(String username) {
        loginPage.userEnterUsername(username);
    }
    @When("User Enter Password {string}")
    public void user_enter_password(String password) {
        loginPage.userEnterPassword(password);
    }
    @When("User Clicks on Checkbox")
    public void user_clicks_on_checkbox() {
        loginPage.userClickOnCheckbox();
    }
    @When("User Clicks on Login Button")
    public void user_clicks_on_login_button() {
        loginPage.userClickOnLoginBtn();
        Util.takeScreenShot("login");
    }
    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedtitle) throws InterruptedException {
        Thread.sleep(3000);
        String actualtitle = loginPage.getActualTitle();
        Assert.assertEquals(expectedtitle, actualtitle);

    }

}

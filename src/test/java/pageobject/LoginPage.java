package pageobject;

import Utils.BaseClass;
import Utils.Util;
import hooks.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends BaseClass {
    public static final Logger log = LogManager.getLogger(LoginPage.class);

    WebDriver driver;

    public LoginPage(){
        driver=getDriver();
    }

    public void userOpenUrl(){

        driver.get(Util.getXpath("GenericData","url"));
        log.info("user opening url");
    }

    public void userEnterUsername(String uname){
        driver.findElement(By.xpath(Util.getXpath("Login","username"))).sendKeys(uname);
        log.info("user entering username");
    }

    public void userEnterPassword(String pass){
        driver.findElement(By.xpath(Util.getXpath("Login","password"))).sendKeys(pass);
        log.info("user entering password");
    }

    public void userClickOnCheckbox() {

        driver.findElement(By.xpath(Util.getXpath("login","checkbox"))).click();
        log.info("user clicked on checkbox");
    }

    public void userClickOnLoginBtn(){

        driver.findElement(By.xpath(Util.getXpath("login","loginbtn"))).click();
        log.info("user clicked on login button");
    }

    public String getActualTitle(){
        String title= driver.getTitle();
        log.info("checking title");
        return title;

    }
}

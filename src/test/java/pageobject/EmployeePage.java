package pageobject;

import Utils.BaseClass;
import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class EmployeePage extends BaseClass {
    // Logger log = LogManager.getLogger(EmployeePage.class);
    WebDriver driver;

    public EmployeePage() {
        driver=getDriver();
    }

    public void userClickOnEmployeeListBtn() throws InterruptedException {
        driver.findElement(By.xpath(Util.getXpath("Employee","employeeListBtn"))).click();
        Thread.sleep(4000);
    }

    public void userClickOnEmployeeAddBtn() {
        driver.findElement(By.xpath(Util.getXpath("Employee","addEmployeeBtn"))).click();
    }

    public void userFillsEmployeeData() throws InterruptedException {

        for(String key : Util.testData.keySet()) {

            switch (key){
                case "firstname":
                    driver.findElement(By.xpath(Util.getXpath("Employee","firstName"))).sendKeys(Util.getTestData("firstName"));
                    break;
                case "middlename":
                    driver.findElement(By.xpath(Util.getXpath("Employee","middleName"))).sendKeys(Util.getTestData("middleName"));
                    break;
                case "lastname":
                    driver.findElement(By.xpath(Util.getXpath("Employee","lastName"))).sendKeys(Util.getTestData("lastName"));
                    break;
                case "joineddate":
                    driver.findElement(By.xpath(Util.getXpath("Employee","joinedDate"))).clear();
                    driver.findElement(By.xpath(Util.getXpath("Employee","joinedDate"))).sendKeys(Util.getTestData("joinedDate"));
                    break;
                case "location":
                    driver.findElement(By.xpath(Util.getXpath("Employee", "locationBtn"))).click();
                    String xpath = Util.getXpath("Employee","location").replace("''","'" + Util.getTestData("location") + "'");
                    driver.findElement(By.xpath(xpath)).click();
                    break;
                case "firstsavebutton":
                    driver.findElement(By.xpath(Util.getXpath("Employee", "firstSaveButton"))).click();
                    Util.takeScreenShot("FirstSaveButton");
                    break;
                case "dateofbirth":
                    driver.findElement(By.xpath(Util.getXpath("Employee","dateOfBirth"))).sendKeys(Util.getTestData("dateOfBirth"));
                    break;
                case "maritialstatus":
                    driver.findElement(By.xpath(Util.getXpath("Employee","maritialStatusBtn"))).click();
                    String xpath2 = Util.getXpath("Employee","maritialStatus").replace("''","'" + Util.getTestData("maritialStatus") + "'");
                    driver.findElement(By.xpath(xpath2)).click();
                    break;
                case "gender":
                    driver.findElement(By.xpath(Util.getXpath("Employee","genderBtn"))).click();
                    String xpath3 = Util.getXpath("Employee","gender").replace("''","'" + Util.getTestData("gender") + "'");
                    driver.findElement(By.xpath(xpath3)).click();
                    break;
                case "nationality":
                    driver.findElement(By.xpath(Util.getXpath("Employee","nationalityBtn"))).click();
                    String xpath4 = Util.getXpath("Employee","nationality").replace("''","'" + Util.getTestData("nationality") + "'");
                    driver.findElement(By.xpath(xpath4)).click();
                    break;
                case "secondsavebtn":
                    if(Util.getTestData("secondSaveBtn").equalsIgnoreCase("Y")) {
                        driver.findElement(By.xpath(Util.getXpath("Employee", "SeconfSaveBtn"))).click();
                    }
                    Util.takeScreenShot("SECONDSaveButton");
                    break;
                case "jobtitle":
                    driver.findElement(By.xpath(Util.getXpath("Employee","jobTitleBtn"))).click();
                    String xpath5 = Util.getXpath("Employee","jobTitle").replace("''","'" + Util.getTestData("jobTitle") + "'");
                    driver.findElement(By.xpath(xpath5)).click();
                    break;
                case "thirdsavebtn":
                    if(Util.getTestData("thirdSaveBtn").equalsIgnoreCase("Y")) {
                        driver.findElement(By.xpath(Util.getXpath("Employee", "thirdSaveBtn"))).click();
                        Util.takeScreenShot("ThirdSaveButton");
                    }
                    break;
                case "eventtemplate":
                    driver.findElement(By.xpath(Util.getXpath("Employee","eventTemplateBtn"))).click();
                    String xpath6 = Util.getXpath("Employee","eventTemplate").replace("''","'" + Util.getTestData("eventTemplate") + "'");
                    driver.findElement(By.xpath(xpath6)).click();
                    break;
                case "fouthsavebtn":
                    if(Util.getTestData("fouthSaveBtn").equalsIgnoreCase("Y")) {
                        driver.findElement(By.xpath(Util.getXpath("Employee", "fourthSaveBtn"))).click();
                        Util.takeScreenShot("FourthSaveButton");
                    }
                    break;

            }
        }

    }

}
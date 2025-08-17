package stepdefinition;

import Utils.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.EmployeePage;

public class EmployeeSteps {
    EmployeePage emp = new EmployeePage();

    @And("User Sets Data for {string} from {string}")
    public void user_sets_data_for_from(String dataID, String fileName) {
        Util.setSenarioData("DataID",dataID);
        Util.setSenarioData("FileName",fileName);
        Util.setColumnWiseDataFromCsvFile();

    }

    @When("User Clicks on Employee List")
    public void user_clicks_on_employee_list() throws InterruptedException {
        emp.userClickOnEmployeeListBtn();
    }

    @When("User Clicks on Employee Add Button")
    public void user_clicks_on_employee_add_button() {
        emp.userClickOnEmployeeAddBtn();
    }

    @When("User Fills Employee Data")
    public void user_fills_employee_data() throws InterruptedException {
        emp.userFillsEmployeeData();

    }


}

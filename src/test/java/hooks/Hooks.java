package hooks;

import Utils.Util;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {



    @Before
    public void openBrowser(){
        try {
            if(Util.driver == null){
                String browser = Util.getXpath("GenericData" , "browser");
                if(browser.equalsIgnoreCase("chrome")){
                    WebDriverManager.chromedriver().setup();
                    Util.driver=new ChromeDriver();
                    Util.driver.manage().window().maximize();
                    Util.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @After
    public void closeBrowser(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Util.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        Util.driver.quit();
    }
}

package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

public class Util {

    public static WebDriver driver;

    public static final String getXpath(final String pagename, final String elementlocator) {

        Properties properties = new Properties();
        String propertyFile = pagename + ".properties";
        try (InputStream fis = Util.class.getClassLoader().getResourceAsStream(propertyFile)) {

            if(null != fis) {
                properties.load(fis);
            } else {
                throw new FileNotFoundException("File Not Found " + propertyFile);
            }
            return properties.getProperty(elementlocator);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void getScreenShot() throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String trg="E:\\Qspider\\StepScreenShot.jpg";
        Files.copy(src.toPath(),new File(trg).toPath());
    }

}

package Utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static WebDriver driver;

    public static HashMap<String,String> senarioData;

    public static LinkedHashMap<String,String> testData;

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

    public static void takeScreenShot(String screenShotFileName)  {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String trg=Util.getScenarioData("screenPath") + "\\" + screenShotFileName + ".png";
        try {
            FileUtils.copyFile(src, new File(trg));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setScreenPath() {
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String date = formatter.format(Calendar.getInstance().getTime());
        String screenShotPath = Util.getXpath("GenericData","screenshotPath") + "\\"
                + Util.getScenarioData("featureName") + "\\" + date + "\\";

        File file = new File(screenShotPath);
        if(!file.exists()) {
            file.mkdirs();
        }

        int count = 0, max = 0;
        File files[] = file.listFiles();
        if(files != null) {
            for(File file1:files) {
                if(file1.isDirectory()) {
                    count++;
                }
            }
        }
        max = count+1;

        Util.setSenarioData("screenPath", screenShotPath + "run " + max);
    }

    public static void setSenarioData(String name,String value){
        if(senarioData==null){
            senarioData=new HashMap();
        }
        senarioData.put(name.toLowerCase().trim(), value);
    }

    public static void setTestData(String name,String value){
        if(testData==null){
            testData= new LinkedHashMap<>();
        }
        testData.put(name.toLowerCase().trim(), value);
    }

    public static String getScenarioData(String name){
        return senarioData.get(name.toLowerCase().trim());
    }

    public static String getTestData(String name){
        return testData.get(name.toLowerCase().trim());
    }

    public static void setColumnWiseDataFromCsvFile() {
        if(testData!=null){
            testData.clear();
        }else {
            testData=new LinkedHashMap<>();
        }
        String fileName = "src/test/resources/data/" + getScenarioData("FileName") + ".csv";

        try {
            Reader inputFile = new FileReader(fileName);
            CSVParser rowRecords = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(inputFile);
            Map<String , Integer> headerMap = rowRecords.getHeaderMap();

            for(CSVRecord record: rowRecords) {

                if(record.get(0).trim().equalsIgnoreCase(getScenarioData("DataID"))) {

                    for(String key: headerMap.keySet()) {
                        if(StringUtils.isNotBlank(record.get(key))) {
                            setTestData(key.trim(), record.get(key).trim());
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}

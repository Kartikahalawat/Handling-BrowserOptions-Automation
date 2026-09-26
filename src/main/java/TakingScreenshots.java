import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakingScreenshots {
    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://the-internet.herokuapp.com/");

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src, new File(
                    "F://Study//Working Professional//SDET Journey//Selenium Web Driver Course Rahul Shetty Udemy//Codes//Handling BrowserOptions Automation//screenshot.png"
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

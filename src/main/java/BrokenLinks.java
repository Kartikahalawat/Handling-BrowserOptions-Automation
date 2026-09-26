import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    static void main(String[] args) throws IOException, URISyntaxException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert  softAssert = new SoftAssert();

        for(WebElement link : links){
            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println("Response Code : " + respCode);

            softAssert.assertTrue(respCode < 400, "The link with Text " + link.getText() + " is broken with code " + respCode);

        }

        softAssert.assertAll();
    }
}

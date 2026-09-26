import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingSSLChecks {
    static void main(String[] args) {
        /*
         * ChromeOptions is used to customize ChromeDriver behavior
         * before the browser session starts.
         */

        ChromeOptions options = new ChromeOptions();

        /*
         * Accept insecure SSL certificates.
         *
         * Useful when:
         * - Application is running in QA/UAT
         * - Self-signed certificate is used
         * - Certificate is expired/untrusted
         * - Internal enterprise application has certificate issues
         */
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);

        /*
         * Example SSL/certificate test URL.
         *
         * This site intentionally uses an invalid certificate.
         */
        driver.get("https://expired.badssl.com/");

        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}

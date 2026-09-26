import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HandlingChromeOptions {
    static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        // ============================================================
        // 1. ADD CHROME EXTENSION
        // ============================================================

        /*
         * Chrome extension must be downloaded as a .crx file.
         *
         * Example:
         * options.addExtensions(
         *     new File("C:\\selenium\\extensions\\extension.crx")
         * );
         *
         * Useful when your automation requires a browser extension.
         */

        // options.addExtensions(
        //         new File("C:\\selenium\\extensions\\extension.crx")
        // );


        // ============================================================
        // 2. PROXY CONFIGURATION
        // ============================================================

        /*
         * Proxy should NOT simply be passed as a String.
         *
         * Selenium provides the Proxy class for proxy configuration.
         */

        Proxy proxy = new Proxy();

        /*
         * Example proxy:
         *
         * IP   = 192.168.1.100
         * Port = 8080
         */

        // proxy.setHttpProxy("192.168.1.100:8080");

        /*
         * Attach Proxy object to ChromeOptions.
         */

        // options.setProxy(proxy);


        // ============================================================
        // 3. BLOCK POPUPS
        // ============================================================

        /*
         * Prevent unnecessary popup blocking behavior.
         *
         * Useful when popups interfere with automation.
         */

        options.setExperimentalOption(
                "excludeSwitches",
                new String[]{"disable-popup-blocking"}
        );


        // ============================================================
        // 4. DISABLE NOTIFICATIONS
        // ============================================================

        /*
         * Websites may ask:
         *
         * "Allow notifications?"
         *
         * Disable browser notification prompts.
         */

        Map<String, Object> preferences = new HashMap<>();

        preferences.put(
                "profile.default_content_setting_values.notifications",
                2
        );


        // ============================================================
        // 5. SET DOWNLOAD DIRECTORY
        // ============================================================

        /*
         * Files downloaded by Chrome will be stored
         * in this directory.
         *
         * Change this path according to your machine.
         */

        String downloadPath = System.getProperty("user.dir")
                + File.separator + "downloads";

        preferences.put("download.default_directory", downloadPath);

        /*
         * Do not show download popup.
         */

        preferences.put("download.prompt_for_download", false);

        /*
         * Automatically download files instead of asking
         * where to save them.
         */

        preferences.put("download.directory_upgrade", true);

        /*
         * Allow Chrome to download files automatically.
         */

        preferences.put("safebrowsing.enabled", true);


        // ============================================================
        // 6. SET CHROME PREFERENCES
        // ============================================================

        /*
         * Add all preferences to ChromeOptions.
         */

        options.setExperimentalOption(
                "prefs",
                preferences
        );


        // ============================================================
        // 7. DISABLE AUTOMATION INFO BAR
        // ============================================================

        /*
         * Chrome may display an automation-related notification.
         *
         * This excludes the "enable-automation" switch.
         */

        options.setExperimentalOption(
                "excludeSwitches",
                new String[]{"enable-automation"}
        );


        // ============================================================
        // 8. DISABLE EXTENSIONS
        // ============================================================

        /*
         * Start Chrome without extensions.
         */

        options.addArguments("--disable-extensions");


        // ============================================================
        // 9. START MAXIMIZED
        // ============================================================

        options.addArguments("--start-maximized");


        // ============================================================
        // 10. INCOGNITO MODE
        // ============================================================

        /*
         * Open Chrome in Incognito mode.
         */

        // options.addArguments("--incognito");


        // ============================================================
        // 11. HEADLESS MODE
        // ============================================================

        /*
         * Browser runs without opening the visible UI.
         *
         * Very useful in CI/CD environments.
         */

        // options.addArguments("--headless=new");


        // ============================================================
        // 12. WINDOW SIZE
        // ============================================================

        /*
         * Set browser window dimensions.
         */

        // options.addArguments("--window-size=1920,1080");


        // ============================================================
        // 13. DISABLE GPU
        // ============================================================

        /*
         * Sometimes used in headless/CI environments.
         */

        // options.addArguments("--disable-gpu");


        // ============================================================
        // 14. DISABLE DEV SHM
        // ============================================================

        /*
         * Commonly useful when running Chrome inside Docker/Linux
         * environments.
         */

        // options.addArguments("--disable-dev-shm-usage");


        // ============================================================
        // 15. IGNORE CERTIFICATE ERRORS
        // ============================================================

        /*
         * Alternative Chrome argument for certificate errors.
         *
         * Prefer Selenium's:
         *
         * options.setAcceptInsecureCerts(true);
         *
         * when possible.
         */

        // options.addArguments("--ignore-certificate-errors");


        // ============================================================
        // 16. ACCEPT INSECURE SSL CERTIFICATES
        // ============================================================

        /*
         * This can also be configured here.
         *
         * Kept commented because SSL has its own dedicated class.
         */

        // options.setAcceptInsecureCerts(true);


        // ============================================================
        // CREATE CHROME DRIVER
        // ============================================================

        WebDriver driver = new ChromeDriver(options);


        // ============================================================
        // TEST URL
        // ============================================================

        driver.get("https://the-internet.herokuapp.com/");

        System.out.println("Title: " + driver.getTitle());

        System.out.println("Current URL: " + driver.getCurrentUrl());

    }
}

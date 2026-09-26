import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMiscellaneousExamples {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // ============================================================
        // 1. MAXIMIZE BROWSER WINDOW
        // ============================================================

        /*
         * Maximizes the browser window before test execution.
         *
         * Commonly used in UI automation so that elements are
         * displayed consistently within the available viewport.
         */

        driver.manage().window().maximize();


        // ============================================================
        // 2. SET CUSTOM WINDOW SIZE
        // ============================================================

        /*
         * Instead of maximizing, you can specify an exact
         * browser window size.
         *
         * Useful when testing a specific viewport.
         */

        // driver.manage().window().setSize(
        //         new Dimension(1920, 1080)
        // );


        // ============================================================
        // 3. GET CURRENT WINDOW SIZE
        // ============================================================

        Dimension windowSize = driver.manage().window().getSize();

        System.out.println("Window Width  : " + windowSize.getWidth());
        System.out.println("Window Height : " + windowSize.getHeight());


        // ============================================================
        // 4. OPEN APPLICATION
        // ============================================================

        driver.get("https://the-internet.herokuapp.com/");


        // ============================================================
        // 5. DELETE ALL COOKIES
        // ============================================================

        /*
         * Deletes all cookies associated with the current
         * browsing context/domain.
         *
         * Common use cases:
         *
         * - Reset session state
         * - Test first-time user behavior
         * - Remove authentication/session information
         * - Start a test with a clean cookie state
         */

        driver.manage().deleteAllCookies();


        // ============================================================
        // 6. ADD A COOKIE
        // ============================================================

        /*
         * Cookies can be added at runtime.
         *
         * The browser should already be on a page belonging
         * to the cookie's domain.
         */

        Cookie testCookie = new Cookie(
                "automationCookie",
                "selenium123"
        );

        driver.manage().addCookie(testCookie);


        // ============================================================
        // 7. GET A SPECIFIC COOKIE
        // ============================================================

        /*
         * Retrieves a cookie using its name.
         */

        Cookie cookie = driver.manage().getCookieNamed(
                "automationCookie"
        );

        if (cookie != null) {

            System.out.println("Cookie Name  : " + cookie.getName());
            System.out.println("Cookie Value : " + cookie.getValue());
        }


        // ============================================================
        // 8. GET ALL COOKIES
        // ============================================================

        /*
         * Returns all cookies available in the current
         * browsing context.
         */

        Set<Cookie> allCookies = driver.manage().getCookies();

        System.out.println("Total Cookies: " + allCookies.size());

        for (Cookie currentCookie : allCookies) {

            System.out.println(
                    currentCookie.getName()
                            + " = "
                            + currentCookie.getValue()
            );
        }


        // ============================================================
        // 9. DELETE COOKIE BY NAME
        // ============================================================

        /*
         * Deletes a specific cookie when its name is known.
         */

        driver.manage().deleteCookieNamed(
                "automationCookie"
        );


        // ============================================================
        // 10. DELETE COOKIE OBJECT
        // ============================================================

        /*
         * You can also delete a Cookie object directly.
         */

        Cookie temporaryCookie = new Cookie(
                "deleteMe",
                "temporaryValue"
        );

        driver.manage().addCookie(temporaryCookie);

        driver.manage().deleteCookie(temporaryCookie);


        // ============================================================
        // 11. PAGE LOAD TIMEOUT
        // ============================================================

        /*
         * Defines how long Selenium waits for a page to finish
         * loading before throwing a timeout exception.
         */

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(30)
        );


        // ============================================================
        // 12. SCRIPT TIMEOUT
        // ============================================================

        /*
         * Defines how long Selenium waits for an asynchronous
         * JavaScript execution to complete.
         */

        driver.manage().timeouts().scriptTimeout(
                Duration.ofSeconds(20)
        );


        // ============================================================
        // INTERVIEW / REAL-TIME SCENARIO
        // ============================================================

        /*
         * QUESTION:
         *
         * How would you verify that deleting a session cookie
         * logs the user out of an application?
         *
         * SCENARIO:
         *
         * 1. User logs into the application.
         * 2. Application creates a session cookie.
         * 3. Automation deletes the session cookie.
         * 4. Automation tries to access a protected page.
         * 5. Application should redirect the user to the login page.
         *
         * Example:
         *
         * driver.get("https://your-application.com");
         *
         * // Delete authentication/session cookie
         * driver.manage().deleteCookieNamed("sessionId");
         *
         * // Try accessing a protected page
         * driver.get("https://your-application.com/home");
         *
         * // Verify redirect to login page
         * String currentUrl = driver.getCurrentUrl();
         *
         * if (currentUrl.contains("login")) {
         *     System.out.println("User successfully logged out");
         * } else {
         *     System.out.println("Logout validation failed");
         * }
         */


        // ============================================================
        // IMPORTANT COOKIE METHODS
        // ============================================================

        /*
         * Add Cookie
         *
         * driver.manage().addCookie(cookie);
         *
         *
         * Get Cookie
         *
         * driver.manage().getCookieNamed("cookieName");
         *
         *
         * Get All Cookies
         *
         * driver.manage().getCookies();
         *
         *
         * Delete Specific Cookie
         *
         * driver.manage().deleteCookieNamed("cookieName");
         *
         *
         * Delete Cookie Object
         *
         * driver.manage().deleteCookie(cookie);
         *
         *
         * Delete All Cookies
         *
         * driver.manage().deleteAllCookies();
         */


        // ============================================================
        // CLEANUP
        // ============================================================

        driver.quit();
    }
}


package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class ChromeTest {

    WebDriver driver;


    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    void setupTest() {
        driver = new ChromeDriver();
    }


    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    void test() {
        // Your test logic here
    }

}
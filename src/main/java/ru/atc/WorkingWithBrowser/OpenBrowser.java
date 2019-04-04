package ru.atc.WorkingWithBrowser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.atc.GetProperties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    public static WebDriver OpenBrowser(String r_object_id, String user) {

        System.out.println();
        System.out.println("Браузер открывается под пользователем " + user);

        System.setProperty("webdriver.chrome.driver", "Data/ChromeDriver_win32/ChromeDriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //если страница не загружается за это время, то падает по таймауту
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);

        try {
            driver.get(GetProperties.GetUrlOpenInBrowser() + "drl/objectId/" + r_object_id + "/currentVersion/true/format/pdf");

            driver.switchTo().alert().accept();
            ((ChromeDriver) driver).findElementById("LoginUsername").sendKeys(user);
            ((ChromeDriver) driver).findElementById("LoginPassword").sendKeys("doc2");
            ((ChromeDriver) driver).findElementByName("Login_loginButton_0").click();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

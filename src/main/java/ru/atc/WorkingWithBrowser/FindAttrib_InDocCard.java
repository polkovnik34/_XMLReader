package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FindAttrib_InDocCard {
    public static String GetStateNo (WebDriver driver){
        String stateNo = ((ChromeDriver) driver).findElementById("attrlist_c_info_a_state_no_value").getText();
        return stateNo;
    }
}

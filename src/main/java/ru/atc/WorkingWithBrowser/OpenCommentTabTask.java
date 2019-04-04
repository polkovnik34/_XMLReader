package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class OpenCommentTabTask {
    //нажать на вкладку комментарии
    public static void OpenCommentTabTask(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_allcomments_0").click();
    }

    //нажать на кнопку "Добавить комментарий"
    public static void ClickOnCommentButton(WebDriver driver){
        if (AvailableIsTheCommentButton(driver) == true){
            ((ChromeDriver) driver).findElementByName("allcomments_contents_createnewcomment_0").click();

        }
    }

    //проверяем доступна ли кнопка "Добавить комментарий"
    public static Boolean AvailableIsTheCommentButton(WebDriver driver){
        Boolean valid = ((ChromeDriver) driver).findElementByName("allcomments_contents_createnewcomment_0").isEnabled();
        return valid;
    }
}

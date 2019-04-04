package ru.atc.WorkingWithBrowser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpertRequestInformationWork {
    //нажать открыть задачу
    public static void OpenTaskCard(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
    }

    //нажать "Готово"
    public static void ForwardReturnWorkflowTask(WebDriver driver){
        //driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_finishworkflowtask_button_0").click();
    }

    //нажать "Ок" в окне подтверждения
    public static void PressOkInWarningWindow(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("TaskComponentContainer_ok_0").click();
    }
}

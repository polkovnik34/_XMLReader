package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpertRework {
    //открыть задачу
    public static void OpenTaskCard(WebDriver driver){
        try {
            ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
        }
    }

    //нажать "Перенаправить"
    public static void ForwardWorkflowTask(WebDriver driver){
        try {
            ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_forwardworkflowtask_button_0").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_forwardworkflowtask_button_0").click();
        }
    }

    //выбрать чекбокс "на корректировку"
    public static void SelectTaskOnCorrection(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde4e4_0").click();
    }

    //выбрать чекбокс "Вернуть предыдущему исполнителю"
    public static void SelectPreviousPerformer(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde4ec_0").click();
    }

    //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");
    }

    //нажать ок в картточке выбора действия
    public static void PressButtonOKSelectionOFTasks(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("TaskComponentContainer_ok_0").click();
    }

}

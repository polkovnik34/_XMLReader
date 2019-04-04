package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sii_2PerfоrmerWork {
    //принять задачу
    public static void TakeTheTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_2").click();
    }

    //открыть карточку задачи
    public static void OpenTheTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
    }

    //нажать отмена в карточке документа
    public static void PressButtonCancel(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_cancel_0").click();
    }

    //нажать "Перенаправить"
    public static void ForwardWorkflowTask(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_forwardworkflowtask_button_0").click();
    }

    //нажать ок в окне выбора действия
    public static void PressButtonOK(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("TaskComponentContainer_ok_0").click();
    }

    //выбрать чекбокс "Завершить обработку (в архив)"
    public static void NextStageTask(WebDriver driver){
        driver.switchTo().frame(0);
        try {
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc6141800126f2_0").click();
        } catch (NoSuchElementException e){
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc6141800126eb_0").click();
        }
    }

    //выбрать чекбокс "Вернуть предыдущему исполнителю "
    public static void NextPreviousPerformer(WebDriver driver){
        driver.switchTo().frame(0);
        try {
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc6141800126ce_0").click();
        } catch (NoSuchElementException e){
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc6141800126ce_0").click();
        }
    }

    //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");
    }

    //выбрать чекбокс "отложить задачу"
    public static void SelectPostponeTheTask(WebDriver driver) {
        driver.switchTo().frame(0);
        try {
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614180190f89_0").click();
        } catch (NoSuchElementException e){
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614180190f89_0").click();
        }

    }

    //выбрать чекбокс "Скорректировать процесс / группу обработки "
    public static void SelectSendToManager(WebDriver driver) {
        driver.switchTo().frame(0);
        try {
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc6141800126cf_0").click();
        } catch (NoSuchElementException e){
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc6141800126cf_0").click();
        }
    }

    //открыть узел "Отложенные"
    public static void OpenTheNodePostpone(WebDriver driver){
        driver.switchTo().frame("view").switchTo().frame("browser");
        ((ChromeDriver) driver).findElementById("docbrowser2").click();
    }

    //открыть задачу на в узле "отложенные"
    public static void OpenTaskInPostpone(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("view").switchTo().frame("workarea").switchTo().frame("content");

        //Double click
        Actions action = new Actions(driver);
        action.doubleClick(((ChromeDriver) driver).findElementById("WaitWorkflows___DATAGRID_CONTROL_NAME___0_0")).perform();
    }

    //нажать кнопку "Вернуть в обработку" в узле "отложенные"
    public static void PressButtonReturnToProcessing(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("MainEx_view_0");
        driver.switchTo().frame("Classic_workarea_0");
        driver.switchTo().frame("Form_content_0");
        driver.switchTo().frame(0);

        ((ChromeDriver) driver).findElementByName("WorkflowManagerContainer_sendworkflowevent_0").click();
    }

}

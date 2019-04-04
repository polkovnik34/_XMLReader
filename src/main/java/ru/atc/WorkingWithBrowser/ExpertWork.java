package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpertWork {
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

    //выбрать чекбокс "перевести на корректировку
    public static void SelectTaskOnCorrection(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde597_0").click();
    }

    //выбрать чекбокс "перевести на следущий этап"
    public static void NextStageTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde59a_0").click();
    }

    //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");
    }

    //нажать ок в картточке выбора действия
    public static void PressButtonOKSelectionOFTasks(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("TaskComponentContainer_ok_0").click();
    }

    //поиск сообщения о валидации комментария
    public static void FindValidationText(WebDriver driver){
        Boolean a1;
        a1 = ((ChromeDriver) driver).findElementByXPath("//*[@id=\"scrollingcontent\"]/div/table/tbody/tr/td/table/tbody/tr[7]/td/span").isDisplayed();
        System.out.print(a1);
    }

    //нажать подтвердить зп
    public static void PressConfirmPO(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_confirmpurchaseorder_0").click();
    }

    //нажать чекбокс с определенной зп
    public static void SelectConfirmPO(WebDriver driver, String po_num){
        try {
            ((ChromeDriver) driver).findElementByName("body___CHECKBOX_NAME_PREFIX___" + po_num + "_0").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("body___CHECKBOX_NAME_PREFIX___" + po_num + "_0").click();
        }
    }

    //нажать ок в выборе зп
    public static void PressOKSelectConfirmPOCard(WebDriver driver){
        try {
            ((ChromeDriver) driver).findElementByName("MultiArgDialogContainer_ok_0").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("MultiArgDialogContainer_ok_0").click();
        }
    }

    //отправка на корректировку в задаче "На доработке у эксперта"
    public static void SelectTaskOnCorrection2(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde4e4_0").click();
    }

    //выбрать чекбокс "Вернуть предыдущему исполнителю" в задаче "На доработке у эксперта"
    public static void CheckReturnToPreviousPerformer(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde4ec_0").click();
    }

}

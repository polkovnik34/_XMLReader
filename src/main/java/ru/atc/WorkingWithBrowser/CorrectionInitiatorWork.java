package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class CorrectionInitiatorWork {
    //принять задачу
    public static void TakeTheTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_2").click();
    }

    //нажать "Перенаправить"
    public static void ForwardWorkflowTask(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_forwardworkflowtask_button_0").click();
    }

    //нажать ок в окне выбора действия
    public static void PressButtonOK(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("TaskComponentContainer_ok_0").click();
    }

    //нажать подтвердить зп
    public static void PressConfirmPO(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_confirmpurchaseorder_0").click();
    }

    //нажать "перевести документы на следующий этап
    public static void CheckNextStageTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda445_0").click();
    }

    //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");
    }

    //выбрать чекбокс "Перевести документы на ожидание корректировки поставщиком"
    //поскольку в каждой задаче на корректировке название чекбокса "Перевести документы на ожидание корректировки поставщиком" отличается, то мы ищем нужное название чекбокса из списка чекбоксов
    public static void CheckSupplierCorrection(WebDriver driver){
        ArrayList listNameCheckbox = new ArrayList();
        List<WebElement> element;
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda470_0"); //название чекбокса в задаче пришедшей с создания/подтверждения ЗП
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda453_0"); //название чекбокса в задаче пришедшей с акцептования
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde59f_0"); //название чекбокса в задаче пришедшей с одобрения экспертом
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda43b_0"); //название чекбокса в задаче пришедшей с контроля лимита
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda44f_0"); //название чекбокса в задаче пришедшей с контроля наличия поступления
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda45a_0"); //название чекбокса в задаче пришедшей с подписания
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda36e_0"); //название чекбокса в задаче пришедшей с На доработке у эксперта

        driver.switchTo().frame(0);

        for(int i = 0; i<listNameCheckbox.size(); i++){
            //смотрим найден ли такой эдемент
            element = ((ChromeDriver) driver).findElementsByName(String.valueOf(listNameCheckbox.get(i)));
            //если элемент не найден, размер i1 будет равен нулю => условие не будет выполнено
            if (element.size() == 1){
                ((ChromeDriver) driver).findElementByName(String.valueOf(listNameCheckbox.get(i))).click();
                break;
            }
        }
    }

    //открыть задачу на в узле "на корректировке поставщика"
    public static void OpenTaskInSupplierCorrection(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("view").switchTo().frame("workarea").switchTo().frame("content");

        //Double click
        Actions action = new Actions(driver);
        action.doubleClick(((ChromeDriver) driver).findElementById("WaitWorkflows___DATAGRID_CONTROL_NAME___0_0")).perform();
    }

    //нажать кнопку "Вернуть в обработку" в узле "На корректировке поставщика"
    public static void PressButtonReturnToProcessingInNodeSupplierCorrection(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("WorkflowManagerContainer_sendworkflowevent_0").click();
    }

    //открыть узел "На корректировке поставщика"
    public static void OpenTheNodeSupplierCorrection(WebDriver driver){
        driver.switchTo().frame("view").switchTo().frame("browser");
        ((ChromeDriver) driver).findElementById("docbrowser4").click();
    }

    //открыть узел "На корректировке поставщика"
    public static void PressButtonCancel(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_cancel_0").click();
    }

    //выбрать чекбокс "	Вернуть предыдущему исполнителю"
    //поскольку в каждой задаче на корректировке название чекбокса "Вернуть предыдущему исполнителю" отличается, то мы ищем нужное название чекбокса из списка чекбоксов
    public static void CheckReturnToPreviousPerformer(WebDriver driver){
        ArrayList listNameCheckbox = new ArrayList();
        List<WebElement> element;
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda403_0"); //название чекбокса в задаче пришедшей с создания/подтверждения ЗП
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda442_0"); //название чекбокса в задаче пришедшей с акцептования
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde571_0"); //название чекбокса в задаче пришедшей с одобрения экспертов
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda465_0"); //название чекбокса в задаче пришедшей с контроля лимита
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda401_0"); //название чекбокса в задаче пришедшей с контроля наличия поступления
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda3fd_0"); //название чекбокса в задаче пришедшей с подписания
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614185343b19_0"); //название чекбокса в задаче пришедшей с На доработке у эксперта

        driver.switchTo().frame(0);

        for(int i = 0; i<listNameCheckbox.size(); i++){
            //смотрим найден ли такой эдемент
            element = ((ChromeDriver) driver).findElementsByName(String.valueOf(listNameCheckbox.get(i)));
            //если элемент не найден, размер i1 будет равен нулю => условие не будет выполнено
            if (element.size() == 1){
                ((ChromeDriver) driver).findElementByName(String.valueOf(listNameCheckbox.get(i))).click();
                break;
            }
        }
    }
    //открыть задачу
    public static void OpenTaskCard(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
    }

}

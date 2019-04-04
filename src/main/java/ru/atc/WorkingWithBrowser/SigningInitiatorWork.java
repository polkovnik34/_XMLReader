package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SigningInitiatorWork {
        //принять задачу
    public static void TakeTheTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_2").click();
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

    //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");
    }


    //нажать ок в окне выбора действия
    public static void PressButtonOK(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("TaskComponentContainer_ok_0").click();
    }

    //выбрать поставить галочку напротив атрибута "подпись"
    public static void SelectSignOK(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("attributes_contents_attributes_contents_attributes_contents_attrlist_info_is_signature_bs_doc_fin_external_0_value_0_0").click();
    }

    //открыть карточку свойства документа
    public static void OpenDocumentProperties(WebDriver driver){
        //driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("__ATTACHMENT_COMPONENT_INCLUDE_CONTROL_NAME_propact_0").click();
    }

    //нажать ок в карточке свойств документа
    public static void PressOkInDocumentProperties(WebDriver driver){
        //driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ok_0").click();
    }

    //открыть задачу
    public static void OpenTaskCard(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
    }

    //выбрать чекбокс "перевести на следущий этап"
    public static void NextStageTask(WebDriver driver){
        try {
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda46f_0").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda46f_0").click();
        }
    }

    //выбрать чекбокс "перевести на корректировку
    public static void SelectTaskOnCorrection(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda426_0").click();
    }


}

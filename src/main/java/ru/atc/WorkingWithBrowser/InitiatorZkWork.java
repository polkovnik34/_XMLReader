package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class InitiatorZkWork {
    //принять задачу
    public static void TakeTheTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_2").click();
    }

    //нажать "Перенаправить"
    public static void ForwardWorkflowTask(WebDriver driver){
        driver.switchTo().frame(0);
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

    //нажать ок в выборе зп
    public static void PressOKSelectConfirmPOCard(WebDriver driver){
        //driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("MultiArgDialogContainer_ok_0").click();
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

    //нажать радиобокс с определенной зп
    public static void SelectConfirmPORadio(WebDriver driver, String po_num){
        driver.switchTo().frame(0);

        List<WebElement> elements = ((ChromeDriver) driver).findElementsByName("poNumber");
        for(WebElement element : elements){
            if(element.getAttribute("value").equals("body___RADIO_NAME_PREFIX___" + po_num + "_0")){
                element.click();
            }
        }
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

    //нажать чекбокс "оставить номер ЗП пустым"
    public static void SelectEmptyPoNumber (WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0).switchTo().frame(0);
        ((ChromeDriver) driver).findElementByXPath("//*[@id=\"scrollingcontent\"]/div/table[2]/tbody/tr[1]/td/label/input").click();
    }

    //нажать открыть задачу
    public static void OpenTaskCard(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
    }

    //нажать "перевести документы на корректировку
    public static void CheckTaskOnCorrection(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda445_0").click();
    }

    public static void SpecifyAmount(WebDriver driver, String po_num, String sum){
        try {
            ((ChromeDriver) driver).findElementByName("__SUM_INPUT_CONTROL_PREFIX___" + po_num).clear();
            ((ChromeDriver) driver).findElementByName("__SUM_INPUT_CONTROL_PREFIX___" + po_num).sendKeys(sum);
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("__SUM_INPUT_CONTROL_PREFIX___" + po_num).clear();
            ((ChromeDriver) driver).findElementByName("__SUM_INPUT_CONTROL_PREFIX___" + po_num).sendKeys(sum);
        }
    }

}

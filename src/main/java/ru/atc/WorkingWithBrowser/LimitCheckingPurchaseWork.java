package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class LimitCheckingPurchaseWork {
    //принять задачу
    public static void TakeTheTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_2").click();
    }

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

    //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");
    }

    //нажать ок в окне выбора действия
    public static void PressButtonOK(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("TaskComponentContainer_ok_0").click();
    }

    //нажать подтвердить зп
    public static void PressConfirmPO(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_confirmpurchaseorder_0").click();
    }

    //нажать чекбокс с зп
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

    //выбрать в окне выбора ЗП радиобокс "Указать новый "Номер ЗП" и ввести его
    public static void CheckRadioNewPoNum(WebDriver driver, String po_num) {
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByXPath("//*[@id=\"scrollingcontent\"]/div/table[2]/tbody/tr[1]/td/label/input").click();
        ((ChromeDriver) driver).findElementByName("body___NEW_PO_NUMBER_TEXT_CONTROL_NAME___0").sendKeys(po_num);
    }

    //прописать разбиение сумм в ЗП
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





/*    //выбрать чекбокс "перевести на следущий этап"
    public static void NextStageTask(WebDriver driver){
        try {
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda468_0").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda468_0").click();
        }
    }*/

    //выбрать чекбокс "чекбокс "перевести на следущий этап"
    //поскольку в каждой задаче на корректировке название чекбокса "Вернуть предыдущему исполнителю" отличается, то мы ищем нужное название чекбокса из списка чекбоксов
    public static void NextStageTask(WebDriver driver){
        ArrayList listNameCheckbox = new ArrayList();
        List<WebElement> element;
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda468_0"); //название чекбокса в задаче по профилю Внешние документы
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda44a_0"); //название чекбокса в задаче по профилю Эдо_внешние_документы

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





/*    //выбрать чекбокс "перевести на корректировку
    public static void SelectTaskOnCorrection(WebDriver driver){
        try {
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda430_0").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda430_0").click();
        }
    }*/
    //выбрать чекбокс "перевести на корректировку"
    //поскольку в каждой задаче на корректировке название чекбокса "Вернуть предыдущему исполнителю" отличается, то мы ищем нужное название чекбокса из списка чекбоксов
    public static void SelectTaskOnCorrection(WebDriver driver){
        ArrayList listNameCheckbox = new ArrayList();
        List<WebElement> element;
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda430_0"); //название чекбокса в задаче по профилю Внешние документы
        listNameCheckbox.add("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181dc0547_0"); //название чекбокса в задаче по профилю Эдо_внешние_документы

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

}

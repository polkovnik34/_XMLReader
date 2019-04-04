package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//работа исполнителя закупок
public class PerformerZkWork {

    //принять задачу
    public static void TakeTheTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_2").click();
    }

    //нажать "Перенаправить"
    public static void PressForwardWorkflowTask(WebDriver driver){
        try {
            ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_forwardworkflowtask_button_0").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_forwardworkflowtask_button_0").click();
        }
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
        try {
            ((ChromeDriver) driver).findElementByName("MultiArgDialogContainer_ok_0").click();
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("MultiArgDialogContainer_ok_0").click();
        }
    }

    //нажать чекбокс с определенной зп
    public static void SelectConfirmPO(WebDriver driver, String po_num){
        try {
            if (((ChromeDriver) driver).findElementByName("body___CHECKBOX_NAME_PREFIX___" + po_num + "_0").isSelected() == false){
                ((ChromeDriver) driver).findElementByName("body___CHECKBOX_NAME_PREFIX___" + po_num + "_0").click();
            }
        } catch (NoSuchFrameException e){
            driver.switchTo().frame(0);
            if (((ChromeDriver) driver).findElementByName("body___CHECKBOX_NAME_PREFIX___" + po_num + "_0").isSelected() == false){
                ((ChromeDriver) driver).findElementByName("body___CHECKBOX_NAME_PREFIX___" + po_num + "_0").click();
            }
        } catch (NoSuchElementException e){
            driver.switchTo().frame(0);
            if (((ChromeDriver) driver).findElementByName("body___CHECKBOX_NAME_PREFIX___" + po_num + "_0").isSelected() == false){
                ((ChromeDriver) driver).findElementByName("body___CHECKBOX_NAME_PREFIX___" + po_num + "_0").click();
            }
        }
    }

    //нажать "перевести документы на следующий этап
    public static void CheckNextStageTask(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda434_0").click();
    }

    //нажать "перевести документы на корректировку
    public static void CheckSendToCorrection(WebDriver driver) {
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda455_0").click();
    }

        //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        //driver.switchTo().frame(0);
        //((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");

        try {
            ((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");
        } catch (NoSuchElementException e){
            driver.switchTo().defaultContent();
            driver.switchTo().frame(0);
            ((ChromeDriver) driver).findElementByName("body__COMMENT_CONTROL__0").sendKeys("текст для проверки");
        }
    }

/*
    //нажать чекбокс "оставить номер ЗП пустым"
    public static void SelectEmptyPoNumber (WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0).switchTo().frame(0);
        ((ChromeDriver) driver).findElementByXPath("//*[@id=\"scrollingcontent\"]/div/table[2]/tbody/tr[1]/td/label/input").click();
    }
*/

    //нажать открыть задачу
    public static void OpenTaskCard(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
    }

    //добавление эксперта
    public static void chooseAnExpert(WebDriver driver, String user){
        CheckSendToRequestInformation(driver);

        ((ChromeDriver) driver).findElementByName("body_body___SELECT_INFORMATOR_CONTROL_NAME___editlink_0_0").click();
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("useronlylocator_contents__name_fiterstring_0").sendKeys(user);
        ((ChromeDriver) driver).findElementByName("useronlylocator_contents_useronlylocator_contents__name_fiterstring_0_enterbtn_0").click();

        //выбираем второго пользака в окне результата поиска, скорее всего это нужно будет переделать
        ((ChromeDriver) driver).findElementById("useronlylocator_contents__add_objects_0_1").click();

        ((ChromeDriver) driver).findElementByName("LocatorContainer_ok_0").click();
    }

    //нажать запрос информации
    public static void CheckSendToRequestInformation(WebDriver driver) {
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614183fde576_0").click();
    }

    //нажать "перевести документы на корректировку
    public static void CheckSendToManager(WebDriver driver) {
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___NEXT_TASKS_CHECKBOX_CONTROL_NAME4cbc614181cda42c_0").click();
    }

    //выбрать в окне выбора ЗП радиобокс "Указать новый "Номер ЗП"
    public static void CheckRadioNewPoNum(WebDriver driver) {
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByXPath("//*[@id=\"scrollingcontent\"]/div/table[2]/tbody/tr[1]/td/label/input").click();
    }

    //ввести новый номер ЗП
    public static void EnterNewPoNum(WebDriver driver, String newPoNumber) {
        ((ChromeDriver) driver).findElementByName("body___NEW_PO_NUMBER_TEXT_CONTROL_NAME___0").sendKeys(newPoNumber);
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

    //нажать радиобокс с определенной зп
    public static void SelectConfirmPORadio(WebDriver driver, String po_num){
        driver.switchTo().frame(0);

        List<WebElement> elements = ((ChromeDriver) driver).findElementsByName("poNumber");
        for(WebElement element : elements){
            if(element.getAttribute("value").equals("body___RADIO_NAME_PREFIX___" + po_num + "_0")){
                if(element.isSelected() == false){
                    element.click();
                } else {
                    break;
                }
            }
        }

    }
}

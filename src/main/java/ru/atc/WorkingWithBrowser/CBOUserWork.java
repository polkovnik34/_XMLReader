package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CBOUserWork {
    //открыть задачу
    public static void OpenTaskCard(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
    }

    //нажать принять решение
    public static void PressButtonDecision(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_putvisaacceptance_0").click();
    }

    //получаем выпадающий список и выбираем выбрать то, что передано в selection (1 - акцепт, 2 - отклонить, 3  отложить решение
    public static void MakeDecision(WebDriver driver, String  selection){

        driver.switchTo().frame(0);
        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        select.selectByValue(selection);
    }

    //нажать ок в окне выбора действия
    public static void PressOk(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("DialogContainer_ok_0").click();
    }

    //нажать отмена в окне выбора действия
    public static void PressCancel(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("DialogContainer_cancel_0").click();
    }


    //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        //driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("body___COMMENT_CONTROL___0").sendKeys("текст для проверки");
    }

    //добавление опционального эксперта
    public static void chooseAnExpert(WebDriver driver, String user){
        MakeDecision(driver, "3");
        ((ChromeDriver) driver).findElementByName("body_body___USER_NAME_SEARCH_CONTROL_NAME___editlink_0_0").click();
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("useronlylocator_contents__name_fiterstring_0").sendKeys(user);
        ((ChromeDriver) driver).findElementByName("useronlylocator_contents_useronlylocator_contents__name_fiterstring_0_enterbtn_0").click();

        //двойной клик мышью
        Actions action = new Actions(driver);
        action.doubleClick(((ChromeDriver) driver).findElementByXPath("//*[@id=\"useronlylocator_contents__add_objects_0_0\"]/td[5]/span")).perform();

        ((ChromeDriver) driver).findElementByName("LocatorContainer_ok_0").click();
    }

    //нажать в карточке задачи на кнопку "Закрыть"
    public static void PressButtonCancel(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_cancel_0").click();
    }

}

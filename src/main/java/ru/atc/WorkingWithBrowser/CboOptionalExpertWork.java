package ru.atc.WorkingWithBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.ui.Select;

public class CboOptionalExpertWork {
    //открыть задачу
    public static void OpenTaskCard(WebDriver driver){
        driver.switchTo().frame(0);
        ((ChromeDriver) driver).findElementByName("BsDocFilialProperties_ActionButton_1").click();
    }

    //нажать принять решение
    public static void PressButtonDecision(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("CustomTaskMgrContainer_putvisaoptionalacceptance_0").click();
    }

    //получаем выпадающий список и выбираем выбрать то, что передано в selection (1 - акцепт, 2 - отклонить
    public static void MakeDecision(WebDriver driver, String  selection){
        driver.switchTo().frame(0);
        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        select.selectByValue(selection);
    }

    //ввести текст в поле для комментария
    public static void EnterText(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("body___COMMENT_CONTROL___0").sendKeys("текст для проверки");
    }

    //нажать ок в окне выбора действия
    public static void PressOk(WebDriver driver){
        ((ChromeDriver) driver).findElementByName("DialogContainer_ok_0").click();
    }


}

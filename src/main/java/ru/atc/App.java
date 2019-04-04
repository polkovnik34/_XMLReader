package ru.atc;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.atc.Test.CasesForUsers.GettingCase;
import ru.atc.Test.ParsInBD;
import ru.atc.WorkingWithBrowser.OpenBrowser;
import ru.atc.WorkingWithBrowser.PerformerZkWork;
import ru.atc.WorkingWithBrowser.Si_1PerformerWork;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static ru.atc.GetProperties.*;
import static ru.atc.GetProperties.GetStateRequestVerifyingCreating;

public class App {
    public static void main(String args[]) throws IOException, InterruptedException, SQLException {
        WebDriver driver;

        /* driver = OpenBrowser.OpenBrowser("09bc614187255e1f", GetUserPerfZk());

       PerformerZkWork.OpenTaskCard(driver);
        PerformerZkWork.PressConfirmPO(driver);
        PerformerZkWork.SelectConfirmPORadio(driver, "18074089");
        PerformerZkWork.PressOKSelectConfirmPOCard(driver);
        PerformerZkWork.PressForwardWorkflowTask(driver);*/

    }
}
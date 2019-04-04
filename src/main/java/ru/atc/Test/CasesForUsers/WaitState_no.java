package ru.atc.Test.CasesForUsers;

import org.testng.Assert;
import ru.atc.Test.ParsInBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class WaitState_no {
    /**
     * Проверка того пришла ли задача в ожидаемый статус с ожидаемым исполнителем + смотрим чтобы задача не упада dmadmin
     * @param r_object_id_doc id документа
     * @param state_no ожидаемый статус документа
     * @param expectedUser ожидаемый исполнитель (если исполнителя нет, то прописывать null)
     */
    public static void WaitState_no(String r_object_id_doc, String state_no, String expectedUser) throws SQLException, InterruptedException, IOException {
        ArrayList Wf_temp = ParsInBD.WaitState_no(r_object_id_doc, state_no, expectedUser);
        Assert.assertEquals(state_no,Wf_temp.get(0));
        Assert.assertEquals(expectedUser,Wf_temp.get(1));
    }

}

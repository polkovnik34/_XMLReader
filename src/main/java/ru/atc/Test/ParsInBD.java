package ru.atc.Test;

import ru.atc.GetProperties;
import ru.atc.ReadInDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ParsInBD {
    public static String WaitFirstWF(String r_object_id) throws InterruptedException, SQLException, IOException {
        String wf = ReadInDB.GetSql_WF(r_object_id);
        System.out.println(r_object_id);
        System.out.println(GetProperties.GetUrlOpenInBrowser() + "drl/objectId/" + r_object_id + "/currentVersion/true/format/pdf");
        while (wf == null)  {
            sleep(15000);
            wf = ReadInDB.GetSql_WF(r_object_id);
        }
        System.out.println("Документ пришел в " + wf);
        return wf;
    }

    /**
     * ждем у задачи появится ожидаемый исполнитель
     * @param WF на вход подается предыдущий исполнитель задачи, а внутри цикла обновляется исполнитель задачи куда придет задача
     * @param r_object_id r_object_id документа
     * @return массив со статусом и исполнителем задачи, 0 позиию занимает статус документа, а 1 пользак/ГО которому пришла задача
     */
    public static ArrayList WaitNewFW_and_StateNo(String WF,String r_object_id) throws SQLException, InterruptedException, IOException {
        ArrayList result = new ArrayList();
        String state_no = null;
        String wf_old = WF;
        while ((WF == null) || (WF.equals(wf_old)))  {
            sleep(15000);
            state_no = ReadInDB.GetSql_DocSateNo(r_object_id);
            WF = ReadInDB.GetSql_WF(r_object_id);
            System.out.println(GetProperties.StateMapping(state_no) + " " + WF);
        }
        System.out.println("Документ со статусом " + GetProperties.StateMapping(state_no) + " пришел к " + WF);
        result.add(state_no);
        result.add(WF);
        return result;
    }

    /**
     * ожидаем когда статус документа изменится до ожидамемого
     * @param r_object_id id документа
     * @param wait_state_no ожидаемый статус
     * @param waitUser ожидаемый пользак
     * @return лист со статусом и пользаком/го. Под индексом 0 пишется статус документа, а под 1 пользак
     */
    public static ArrayList WaitState_no(String r_object_id, String wait_state_no, String waitUser) throws SQLException, InterruptedException, IOException {
        ArrayList statusDoc = new ArrayList();
        String old_state_no = ReadInDB.GetSql_DocSateNo(r_object_id);
        String old_user = ReadInDB.GetSql_WF(r_object_id);

        while (!(old_state_no.equals(wait_state_no) && waitUser.equals(old_user)) /* || !old_user.equals("dmadmin")*/){
            sleep(15000);
            old_state_no = ReadInDB.GetSql_DocSateNo(r_object_id);
            old_user = ReadInDB.GetSql_WF(r_object_id);
            System.out.println(old_user + " " + GetProperties.StateMapping(old_state_no));

        }
        System.out.println("Статус документа: " + GetProperties.StateMapping(old_state_no));
        statusDoc.add(old_state_no);
        statusDoc.add(old_user);
        return statusDoc;
    }

    //ожидание чтобы документ пришел на хранение
    public static ArrayList WaitArchivedStateNo(String r_object_id) throws SQLException, InterruptedException, IOException {
        ArrayList resultParsing = new ArrayList();
        String archiveStateNo = GetProperties.GetStateArchivedDoc();
        String docStatus = ReadInDB.GetSql_DocSateNo(r_object_id);
        String wf = ReadInDB.GetSql_WF(r_object_id);
        //пока статус не будет равен 6 и исполнитель равен "ничему"
        while (!(archiveStateNo.equals(docStatus) && wf == null)){
            sleep(10000);
            docStatus = ReadInDB.GetSql_DocSateNo(r_object_id);
            wf = ReadInDB.GetSql_WF(r_object_id);
            System.out.println(docStatus + " " + wf);
            //если задача упала дмадмину - возвращаем null где тест упадет при проверке значений
            if (wf.equals("dmadmin")){
                System.out.println("----------------------------------------------------");
                System.out.println("ЗАДАЧА УПАЛА ДМАДМИНУ");
                System.out.println("----------------------------------------------------");
                return null;
            }
        }
        resultParsing.add(docStatus);
        resultParsing.add(wf);

        System.out.println("Документ ушел на хранение");
        return resultParsing;
    }
}

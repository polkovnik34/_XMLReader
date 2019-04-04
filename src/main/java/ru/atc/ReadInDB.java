package ru.atc;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.sql.*;

import static ru.atc.GetProperties.*;

public class ReadInDB {

    private static final org.apache.log4j.Logger log = Logger.getLogger(ReadInDB.class);
    private static String log4jConfPath = "log4j.properties";

    public static Connection conn;

    // ПОДКЛЮЧЕНИЕ К БД
    public static void ConnectionBD() {
            conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(GetDBHost(), GetDBLogin(), GetDBPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Закрытие
    public static void CloseDB() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//Принимаем R_OBJECT_ID документа и делаем запров в бд на поиск ГО куда пришел документ
/*
select all dmi_queue_item.name from dmi_queue_item_sp  dmi_queue_item
where (dmi_queue_item.router_id in
(select all dmi_package.r_workflow_id from dmi_package_sp  dmi_package
where (dmi_package.r_object_id in
(select r_object_id from dmi_package_r where r_component_id='09bc61418627227f')) )) order by dmi_queue_item.date_sent desc
 */
    public static String GetSql_WF(String r_object_id) throws SQLException {
        PropertyConfigurator.configure(log4jConfPath);
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery("select all dmi_queue_item.name from dmi_queue_item_sp  dmi_queue_item \n" +
                "where (dmi_queue_item.router_id in \n" +
                "(select all dmi_package.r_workflow_id from dmi_package_sp  dmi_package \n" +
                "where (dmi_package.r_object_id in \n" +
                "(select r_object_id from dmi_package_r where r_component_id='" + r_object_id + "')) ))order by dmi_queue_item.date_sent DESC, dmi_queue_item.TASK_STATE DESC");

        r.next();
        //проверяем пустой ли ответ запроса
        if (r.getRow() == 0){
            String falseObject = null;
            return falseObject;
        }

        String count = r.getString("NAME");
        r.close();
        return count;
    }

//принимаем номер документа, по которому будем искать его R_OBJECT_ID в системе
/*
select R_OBJECT_ID from bs_doc_fin_sp
where DOC_NUMBER = '736900008'
and INITIATOR_NUMBER = 'bobkov1'
*/
    public static String GetSql_DocRobjectID(String docNumber, String IniciatorNumber) throws SQLException {
        try {
            String docNumber_temp = String.valueOf(docNumber);
            String query = "select R_OBJECT_ID from bs_doc_fin_sp" +
                    " where DOC_NUMBER = '" + docNumber_temp + "' " +
                    "and INITIATOR_NUMBER = '" +  IniciatorNumber + "'";
            PropertyConfigurator.configure(log4jConfPath);

            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(query);
            r.next();
            //проверяем пустой ли ответ запроса
            if (r.getRow() == 0){
                String falseObject = null;
                log.error("По документу с номером " + docNumber + " и инициатором " + IniciatorNumber + " не найден R_OBJECT_ID");
                log.error(query);
                return falseObject;
            }
            String object = r.getString("R_OBJECT_ID");
            r.close();
            return object;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.close();
        }
        return null;
    }

    //получаем статус у документа
    public static String GetSql_DocSateNo (String r_object_id) throws SQLException {
        try {
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("select STATE_NO from bs_doc_fin_sp" +
                    " where r_object_id = '" + r_object_id + "'");
            r.next();
            String state_no = r.getString("STATE_NO");
            r.close();
            return state_no;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.close();
        }
        return null;
    }
}



//омут знаний на будущее
/*        //скл запрос и вывод из него значения из нужного столбца
        Connection conn = null;
        String a1 = "R_OBJECT_TYPE";
        String a2 = "OBJECT_NAME";
        String a3 = "STATE_NO";

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(GetDBHost(), GetDBLogin(), GetDBPassword());

            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("select * from bs_doc_fin_sp" +
                    " where DOC_NUMBER = '" + 16529810 + "' " +
                    "and INITIATOR_NUMBER = '" +  207725 + "'");
            r.next();
            System.out.println(r.getString(a1));
            System.out.println(r.getString(a2));
            System.out.println(r.getString(a3));


            while (r.next()){
                for (int i = 1; i < r.getMetaData().getColumnCount(); i++){
                    //System.out.print(r.getMetaData().getColumnLabel(i) + ": ");
                    //System.out.println(r.getString(i));
                }
            }

            //проверяем пустой ли ответ запроса
            //String object = r.getString("R_OBJECT_ID");
            r.close();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.close();
        }
        conn.close();*/

  /*  //скл запрос и вывод из него несколько строк и поиск нужного значения
    Connection conn = null;
    String a1 = "R_OBJECT_TYPE";
    String a2 = "OBJECT_NAME";
    String a3 = "NAME";
        try {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(GetDBHost(), GetDBLogin(), GetDBPassword());

                Statement s = conn.createStatement();
                ResultSet r = s.executeQuery("select all dmi_queue_item.r_object_id,dmi_queue_item.name,dmi_queue_item.stamp,dmi_queue_item.sent_by,dmi_queue_item.date_sent,dmi_queue_item.due_date,dmi_queue_item.event,dmi_queue_item.item_name,dmi_queue_item.item_id,dmi_queue_item.item_type,dmi_queue_item.content_type,dmi_queue_item.message,dmi_queue_item.router_id,dmi_queue_item.supervisor_name,dmi_queue_item.task_number,dmi_queue_item.task_name,dmi_queue_item.task_type,dmi_queue_item.task_state,dmi_queue_item.dependency_type,dmi_queue_item.next_tasks_type,dmi_queue_item.instruction_page,dmi_queue_item.plan_start_date,dmi_queue_item.actual_start_date,dmi_queue_item.read_flag,dmi_queue_item.delete_flag,dmi_queue_item.priority,dmi_queue_item.position,dmi_queue_item.dequeued_by,dmi_queue_item.dequeued_date,dmi_queue_item.sign_off_required,dmi_queue_item.sign_off_user,dmi_queue_item.sign_off_date,dmi_queue_item.source_docbase,dmi_queue_item.target_docbase,dmi_queue_item.remote_pending,dmi_queue_item.source_event,dmi_queue_item.source_stamp,dmi_queue_item.task_subject,dmi_queue_item.event_detail from dmi_queue_item_sp  dmi_queue_item where (dmi_queue_item.router_id in (select all dmi_package.r_workflow_id from dmi_package_sp  dmi_package where (dmi_package.r_object_id in (select r_object_id from dmi_package_r where r_component_id='09bc614186286ada')) )) order by dmi_queue_item.date_sent desc");

                r.next();
                System.out.println(r.getString(a3));
                r.next();
                System.out.println(r.getString(a3));
                System.out.println();

                while (r.next()){
                for (int i = 1; i < r.getMetaData().getColumnCount(); i++){
        System.out.print(r.getMetaData().getColumnLabel(i) + ": ");
        System.out.println(r.getString(a3));
        }
        }

        //проверяем пустой ли ответ запроса
        //String object = r.getString("R_OBJECT_ID");
        r.close();
        } catch (SQLException e) {
        e.printStackTrace();
        conn.close();
        }
        conn.close();*/
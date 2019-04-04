package ru.atc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class GetProperties {
    private static FileInputStream fis;
    private static Properties property = new Properties();
    private static String pathToConfigProperties = "Config/config.properties";

    //получение полного названия статуса по переданному буквенному обозначению
    public static String StateMapping(String state) throws IOException {
        String pathToConfigStateMapping = "Config/stateMapping.txt";

        String a1 = null;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(pathToConfigStateMapping))) {
            //читаем файл с маппингом статусов
            while ((pathToConfigStateMapping = br.readLine()) != null) {
                //если строка начинающаяся с переданного нам статуса найдена - разбиваем строку и берем второе значение строки - название статуса
                if (pathToConfigStateMapping.startsWith(state)){
                    String[] pathToPackage = pathToConfigStateMapping.split("=");
                    //a1.add(pathToPackage[1]);
                    a1 = pathToPackage[1];
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //если такой статус не найден - пишем про это и возвращаем буквенный статус
        if (a1 == null){
            System.out.println();
            System.out.println("=========НЕ НАЙДЕН МАППИНГ СТАТУСОВ, ПЕРЕДАН СТАТУС " + state);
            System.out.println();
            return state;
        } else {
            return a1;
        }
    }


    public static String GetDBHost() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("db.host");
    }

    public static String GetDBLogin() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("db.login");
    }

    public static String GetDBPassword() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("db.password");
    }

    public static String GetServerFolderPath() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("server.folder_path");
    }

    public static String GetServerLogin() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("server.login");
    }

    public static String GetServerHost() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("server.host");
    }

    public static String GetServerPassword() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("server.password");
    }

    public static Integer GetServerPort() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        String port_temp = property.getProperty("server.port");
        Integer port = Integer.valueOf(port_temp);
        return port;
    }

    public static String GetPathCasePackage() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("path.casePackage");
    }

    public static String GetPathResult() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("path.result");
    }

    public static String GetUrlOpenInBrowser() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("webtop.url");
    }

    public static String GetUserExpert() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("expert.user");
    }

    public static String GetUserCbo() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("cbo.user");
    }

    public static String GetUserLogist() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("logist.user");
    }

    public static String GetStateExpertDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateExpert.doc");
    }

    public static String GetStateCBODoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateCBO.doc");
    }

    public static String GetUserSigning() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("signing.user");
    }

    public static String GetStateSigningDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateSigning.doc");
    }

    public static String GetUserSi_1() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("si_1.user");
    }

    public static String GetUserSii_2() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("sii_2.user");
    }

    public static String GetStateArchivedDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateArchived.doc");
    }

    public static String GetStateSi_1PerformerDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateSi_1Performer.doc");
    }

    public static String GetUserInitZk() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("init_zk_rr.user");
    }

    public static String GetStateRequest_VerifyingDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateRequest_Verifying.doc");
    }

    public static String GetStateReceiptAvailabilityControlDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateReceiptAvailability.doc");
    }

    public static String GetInitiatorGroupExternal() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupInitiatorWork.external");
    }

    public static String GetReceiptAvailabilityGroupExternal() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupReceiptAvailabilityWork.external");
    }

    public static String GetStateCorrectionDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateCorrection.doc");
    }

    public static String GetUserCorrection() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("correction.user");
    }

    public static String GetStateSupplierCorrectionDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateSupplierCorrection.doc");
    }

    public static String GetUserExpertChooseAnCBO() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("expertChooseAnCBO.user");
    }

    public static String GetUserPerfZk() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("performer_zk_rr.user");
    }

    public static String GetStateRequestVerifyingCreating() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateRequest_Verifying_Creating.doc");
    }

    public static String GetPerformerGroupExternal() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupPerformerWork.external");
    }

    public static String GetLimitCheckingGroupExternal() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupLimitCheckingWork.external");
    }

    public static String GetStateLimitChecking() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateLimitChecking.doc");
    }

    public static String GetUserLimitChecking() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("limitChecking.user");
    }

    public static String GetStateExpertRework() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateExpertRework.doc");
    }

    public static String GetStateSi_CorrectionDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateSiCorrection.doc");
    }

    public static String GetInitiatorGroupDealer() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupInitiatorWork.dealer");
    }

    public static String GetPerformerGroupDealer() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupPerformerWork.dealer");
    }

    public static String GetStateRequestInformationDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateRequestInformation.doc");
    }

    public static String GetManagerGroupExternal() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupManagerWork.external");
    }

    public static String GetManagerGroupDealer() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupManagerWork.dealer");
    }

    public static String GetUserExpertRequestInformation() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("expertRequestInformation.user");
    }

    public static String GetStateWaitApprovalPoDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateWaitApproval.doc");
    }

    public static String GetSi1PerformerWorkExternal() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("processingGroupSi1PerformerWork.external");
    }

    public static String GetStatePostponeDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("statePostpone.doc");
    }

    public static String GetStateSi_2PerformerDoc() throws IOException {
        fis = new FileInputStream(pathToConfigProperties);
        property.load(fis);
        return property.getProperty("stateSi_2Performer.doc");
    }
}
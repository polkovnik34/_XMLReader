package ru.atc.WorkWithFile;

import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import ru.atc.GetProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static ru.atc.GetProperties.*;

public class Filetranfer {
    public static Session session;
    static Channel channel;
    static ChannelSftp sftpChannel;

    public static void ConnectionSFTP() throws IOException {
        JSch jsch = new JSch();
        try {
            session = jsch.getSession(GetServerLogin(), GetServerHost(), GetServerPort());
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(GetServerPassword());
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public static void DisconnectSFTP(){
        session.disconnect();
        sftpChannel.exit();
    }

    //принимаем путь, где лежат файлы для их отправки на сервак и отправляем их на сервак
    public static void sendFile(String path) throws IOException {
        try {
            sftpChannel = (ChannelSftp) channel;
            sftpChannel.put(path + "*.xml", GetProperties.GetServerFolderPath());
            sftpChannel.put(path + "*.pdf", GetProperties.GetServerFolderPath());

        } catch (SftpException e) {
            e.printStackTrace();
            DisconnectSFTP();

        }
    }
}
package ru.atc.util.ChangeXML;

import java.io.File;

public class RenameFile {
    static public void rename(String OldName, String NewName, String TypeFile){
        File file = new File(OldName);
        File newFile = new File(NewName + "." + TypeFile);
        file.renameTo(newFile);
    }
}

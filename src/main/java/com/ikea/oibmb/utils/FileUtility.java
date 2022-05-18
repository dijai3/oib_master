package com.ikea.oibmb.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtility {

    public static File getTempFileFromString(String fileContent){
        File file=null;
        try {
            file = File.createTempFile("temp", ".csv");
            FileUtils.writeStringToFile(file, fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    
}

package com.jarry.chat.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description:
 * User: Jarry
 * Date: 2018-03-08
 * Time: 22:42
 */
public class FileUtil {
    static Logger logger = Logger.getLogger(FileUtil.class);

    public static boolean uploadFile(byte[] file, String filePath, String fileName) {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        logger.info("---->targetFile=" + targetFile.getAbsolutePath());
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath + File.separator + fileName);
            fileOutputStream.write(file);
            fileOutputStream.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}

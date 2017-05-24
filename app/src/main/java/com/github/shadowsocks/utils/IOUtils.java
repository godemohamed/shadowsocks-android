package com.github.shadowsocks.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by terry on 2017/5/20.
 */

public class IOUtils {
    private static final int BUFFER_SIZE = 32 * 1024;

    public static void writeString(File file, String content) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
        } catch (IOException e) {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

    public static void writeString(String file, String content) {
        writeString(new File(file), content);
    }

    public static void copy(InputStream is, OutputStream os) {
        byte[] buffer = new byte[BUFFER_SIZE];
        Arrays.fill(buffer, (byte)0);

        try {
            while (is.read(buffer) > 0) {
                os.write(buffer);
                Arrays.fill(buffer, (byte)0);
            }
        } catch (Exception e) {

        }
    }

    public static void deletedRecursively(File file) {
        if (file.isDirectory()) {
            File[]  subFiles = file.listFiles();
            for (File subFile : subFiles) {
                deletedRecursively(subFile);
            }
        }

        file.delete();
    }
}

package com.upuphone.runasone.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtils {
    public static void copy(File file, File file2) throws Exception {
        if (file.isFile()) {
            copyFile(file, file2);
        } else if (file.isDirectory()) {
            copyDir(file, file2);
        }
    }

    public static void copyDir(File file, File file2) throws Exception {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file3 : listFiles) {
                File file4 = new File(file2, file3.getName());
                if (file3.isDirectory()) {
                    file4.mkdir();
                    copyDir(file3, file4);
                } else {
                    copyFile(file3, file4);
                }
            }
        }
    }

    public static void copyFile(File file, File file2) throws Exception {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel channel;
        FileChannel channel2;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            channel = fileInputStream.getChannel();
            channel2 = fileOutputStream.getChannel();
            channel2.transferFrom(channel, 0, channel.size());
            channel2.close();
            channel.close();
            fileOutputStream.close();
            fileInputStream.close();
            return;
            throw th;
            throw th;
            throw th;
            throw th;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
    }
}

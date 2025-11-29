package com.upuphone.xr.interconnect.util;

import java.io.File;

public final class FileUtil {
    private FileUtil() {
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File deleteFile : listFiles) {
                deleteFile(deleteFile);
            }
            file.delete();
        }
    }
}

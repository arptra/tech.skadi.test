package com.upuphone.runasone.utils.log.file;

import com.honey.account.o6.a;
import com.upuphone.runasone.utils.log.LogManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public interface ILogWrite {
    public static final int SAVE_LOG_COUNT = 7;
    public static final String TAG_PREFIX = "[CoreLog]";

    void close();

    void deleteCacheLog(File file) {
        File[] listFiles;
        if (file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0 && listFiles.length > 7) {
            Arrays.sort(listFiles, Comparator.comparing(new a()));
            for (int i = 0; i < listFiles.length - 7; i++) {
                try {
                    Files.delete(Paths.get(listFiles[i].toURI()));
                } catch (IOException unused) {
                    LogManager.e("file delete fail:" + listFiles[i].getName());
                }
            }
        }
    }

    void flush();

    void write(String str);
}

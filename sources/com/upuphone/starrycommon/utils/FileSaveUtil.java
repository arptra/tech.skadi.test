package com.upuphone.starrycommon.utils;

import android.text.TextUtils;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileSaveUtil {
    public static boolean a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Files.delete(Paths.get(str, new String[0]));
                return true;
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (DirectoryNotEmptyException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return false;
    }
}

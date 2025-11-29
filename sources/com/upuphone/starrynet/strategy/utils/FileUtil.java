package com.upuphone.starrynet.strategy.utils;

import android.content.Context;
import android.util.Log;
import com.upuphone.starrynet.common.StLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {
    private static final String TAG = "FileUtil";

    public static String readAssetFile2String(Context context, String str) {
        try {
            return readInputStream(context.getAssets().open(str));
        } catch (IOException e) {
            StLog.d(TAG, "readAssetFile2String error:" + Log.getStackTraceString(e));
            return null;
        }
    }

    public static String readFile(Context context, String str) {
        File file = new File(context.getFilesDir() + File.separator + str);
        if (!file.exists()) {
            return null;
        }
        try {
            return readInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            StLog.e(TAG, "readFile error:" + Log.getStackTraceString(e));
            return null;
        }
    }

    private static String readInputStream(InputStream inputStream) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            StLog.d(TAG, "readFile error:" + Log.getStackTraceString(e));
            return null;
        }
    }

    public static boolean saveFile(Context context, String str, String str2) {
        try {
            String str3 = context.getFilesDir() + File.separator + str;
            StLog.d(TAG, "saveFile path:" + str3);
            File file = new File(str3);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            StLog.e(TAG, "save file error:" + Log.getStackTraceString(e));
            return false;
        }
    }
}

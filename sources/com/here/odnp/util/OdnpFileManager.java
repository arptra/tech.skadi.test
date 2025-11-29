package com.here.odnp.util;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class OdnpFileManager {
    private static final String EXTERNALDATA_DIR = ".here-positioning";
    private static final String PRIVATE_DATA_DIR = "data";
    private static final String TAG = "odnp.util.FileManager";
    private static final String TRACE_DIR = "trace";

    public static boolean copy(File file, File file2) {
        File[] listFiles;
        if (!file.isDirectory()) {
            copyData(file, file2);
            return true;
        } else if ((!file2.isDirectory() && !file2.mkdirs()) || (listFiles = file.listFiles()) == null) {
            return false;
        } else {
            for (File file3 : listFiles) {
                if (!copy(file3, new File(file2, file3.getName()))) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean copyData(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Exception unused) {
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                OdnpIOUtils.close((InputStream) bufferedInputStream);
                OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                OdnpIOUtils.close((InputStream) bufferedInputStream);
                OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                throw th;
            }
            try {
                OdnpIOUtils.copy(bufferedInputStream2, bufferedOutputStream);
                return OdnpIOUtils.close((OutputStream) bufferedOutputStream) & OdnpIOUtils.close((InputStream) bufferedInputStream2);
            } catch (Exception unused2) {
                bufferedInputStream = bufferedInputStream2;
                OdnpIOUtils.close((InputStream) bufferedInputStream);
                OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                OdnpIOUtils.close((InputStream) bufferedInputStream);
                OdnpIOUtils.close((OutputStream) bufferedOutputStream);
                throw th;
            }
        } catch (Exception unused3) {
            bufferedOutputStream = null;
            OdnpIOUtils.close((InputStream) bufferedInputStream);
            OdnpIOUtils.close((OutputStream) bufferedOutputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            OdnpIOUtils.close((InputStream) bufferedInputStream);
            OdnpIOUtils.close((OutputStream) bufferedOutputStream);
            throw th;
        }
    }

    public static File getDataDir(Context context) {
        return Environment.isExternalStorageRemovable() ? getPrivateDir(context) : new File(Environment.getExternalStorageDirectory(), EXTERNALDATA_DIR);
    }

    public static File getLogDir(Context context) {
        return !"mounted".equals(Environment.getExternalStorageState()) ? new File(context.getFilesDir(), TRACE_DIR) : new File(context.getExternalFilesDir((String) null), TRACE_DIR);
    }

    public static File getPrivateDir(Context context) {
        File dir = context.getDir("data", 0);
        Log.v(TAG, "getPrivateDir: %s", dir);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
}

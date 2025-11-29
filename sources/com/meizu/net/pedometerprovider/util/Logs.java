package com.meizu.net.pedometerprovider.util;

import android.os.Environment;
import android.os.SystemClock;
import android.text.format.DateFormat;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import org.apache.commons.lang3.StringUtils;

public class Logs {
    public static final String DEFAULT_TAG = "Pedometer.";
    private static final String ERROR_LOG_FILE_PATH = (Environment.getExternalStorageDirectory() + "/Android/data/com.meizu.net.pedometer/error.txt");
    private static final long MAX_LOG_FILE_SIZE = 4194304;
    private static final String NETWORK_LOG_FILE_PATH = (Environment.getExternalStorageDirectory() + "/Android/data/com.meizu.net.pedometer/network.txt");
    private static boolean isInit = false;
    private static boolean mLogOn = false;
    private static long mLogtime;

    private static String addTimeMsg(String str) {
        return str + " T:" + (SystemClock.elapsedRealtime() - mLogtime);
    }

    private static String currentTimeToString() {
        return DateFormat.format("yyyy-MM-dd kk:mm", System.currentTimeMillis()).toString();
    }

    public static void d(String str) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.d(DEFAULT_TAG, str);
        }
    }

    public static void e(String str) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.e(DEFAULT_TAG, str);
        }
    }

    public static void i(String str) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.i(DEFAULT_TAG, str);
        }
    }

    private static void initLog() {
        isInit = true;
    }

    public static void resetTime() {
        mLogtime = SystemClock.elapsedRealtime();
    }

    public static void setLogOn(boolean z) {
        mLogOn = z;
    }

    public static void time_d(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.d(DEFAULT_TAG + str, addTimeMsg(str2));
        }
    }

    public static void time_e(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.e(DEFAULT_TAG + str, addTimeMsg(str2));
        }
    }

    public static void time_i(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.i(DEFAULT_TAG + str, addTimeMsg(str2));
        }
    }

    public static void time_v(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.v(DEFAULT_TAG + str, addTimeMsg(str2));
        }
    }

    public static void time_w(String str, String str2) {
        KLog.w(DEFAULT_TAG + str, addTimeMsg(str2));
        writeLogFile(DEFAULT_TAG + str, addTimeMsg(str2));
    }

    public static void v(String str) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.v(DEFAULT_TAG, str);
        }
    }

    public static void w(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.w(DEFAULT_TAG + str, str2);
        }
    }

    public static void writeLogFile(String str, String str2) {
        e(str, str2);
        writeSingleLog(str, str2, ERROR_LOG_FILE_PATH, MAX_LOG_FILE_SIZE);
    }

    private static void writeLogToFile(String str, String str2, long j) {
        try {
            File file = new File(str2);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists() && file.length() >= j) {
                file.delete();
            }
            if (file.exists() || file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(str);
                outputStreamWriter.flush();
                fileOutputStream.flush();
                outputStreamWriter.close();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeNetworkLogFile(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            d(str, str2);
            writeSingleLog(str, str2, NETWORK_LOG_FILE_PATH, MAX_LOG_FILE_SIZE);
        }
    }

    private static void writeSingleLog(String str, String str2, String str3, long j) {
        writeLogToFile("" + currentTimeToString() + FastRecordHistoryDetailActivity.TAG_SPLIT + str + " : " + str2 + StringUtils.LF, str3, j);
    }

    public static void d(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.d(DEFAULT_TAG + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.e(DEFAULT_TAG + str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (!isInit) {
            initLog();
        }
        if (mLogOn) {
            KLog.i(DEFAULT_TAG + str, str2);
        }
    }
}

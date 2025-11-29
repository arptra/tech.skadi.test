package com.upuphone.runasone.utils.log;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.p0.b;
import com.upuphone.runasone.utils.FileUtils;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class LogManager {
    private static final String CORE_LOG = "CoreLog";
    private static final String DEFAULT_TAG = "[IOT]";
    private static final String DEST_LOG_DIR = "data/misc/logreport/starrynetlog";
    private static final Holder INSTANCE = new Holder();
    public static final byte LOG_ALL = 15;
    public static final byte LOG_TO_FILE = 2;
    public static final byte LOG_TO_LOGCAT = 1;
    private static final String STARRYNET_LOG = "com.upuphone.starrynet.log";

    public static class Holder {
        private FilePrint filePrinter;
        private final Handler handler;
        private boolean is3rdDevice;
        private boolean isInit;
        private LogConfig logConfig;
        private ILogPrinter logcatPrinter;

        public Holder() {
            HandlerThread handlerThread = new HandlerThread(LogManager.CORE_LOG);
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper());
        }

        private void copyByStream(InputStream inputStream, OutputStream outputStream) {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        inputStream.close();
                        outputStream.close();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: private */
        public void initLog(final Context context, int i) {
            if (!this.isInit) {
                this.logConfig = new LogConfig().setLogLevel(i).setTag(LogManager.DEFAULT_TAG);
                this.logcatPrinter = new LogcatPrint();
                this.filePrinter = new FilePrint(context);
                dumpProcessExitReasons(context);
                context.getContentResolver().registerContentObserver(Settings.System.getUriFor("com.upuphone.starrynet.log"), false, new ContentObserver(this.handler) {
                    public void onChange(boolean z) {
                        super.onChange(z);
                        Holder.this.onLogChange(context);
                    }
                });
                this.isInit = true;
            }
        }

        /* access modifiers changed from: private */
        public void printLog(int i, byte b, String str, String str2) {
            LogConfig logConfig2 = this.logConfig;
            if (logConfig2 != null && i >= logConfig2.getLogLevel()) {
                if ((b & 1) != 0) {
                    printLogPrimary(i, str, str2);
                }
                if (!this.is3rdDevice && (b & 2) != 0) {
                    printLogFile(i, str, str2);
                }
            }
        }

        private void printLogFile(int i, String str, String str2) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int min = Math.min(stackTrace.length - 1, 7);
            String fileName = stackTrace[min].getFileName();
            String methodName = stackTrace[min].getMethodName();
            int lineNumber = stackTrace[min].getLineNumber();
            if (str == null) {
                str = this.logConfig.getTag();
            }
            this.filePrinter.println(i, str, "[(" + fileName + AccountConstantKt.CODE_SEPARTOR + lineNumber + ")#" + (methodName.substring(0, 1).toUpperCase() + methodName.substring(1)) + "] " + str2);
        }

        private void printLogPrimary(int i, String str, String str2) {
            if (this.logcatPrinter != null) {
                if (str == null) {
                    str = this.logConfig.getTag();
                }
                this.logcatPrinter.println(i, str, str2);
            }
        }

        /* access modifiers changed from: private */
        public void setIs3rdDevice(boolean z) {
            this.is3rdDevice = z;
        }

        public void dumpProcessExitReasons(Context context) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (Build.VERSION.SDK_INT >= 30) {
                    List a2 = activityManager.getHistoricalProcessExitReasons(context.getPackageName(), 0, 1);
                    if (!a2.isEmpty()) {
                        ApplicationExitInfo a3 = b.a(a2.get(a2.size() - 1));
                        LogManager.d(a3.toString());
                        InputStream a4 = a3.getTraceInputStream();
                        if (a4 != null) {
                            String format = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss").format(LocalDateTime.now());
                            File file = new File(context.getFilesDir(), LogManager.CORE_LOG);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            copyByStream(a4, Files.newOutputStream(new File(file, "trace-" + format).toPath(), new OpenOption[0]));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onLogChange(Context context) {
            if (context != null) {
                try {
                    int i = Settings.System.getInt(context.getContentResolver(), "com.upuphone.starrynet.log");
                    LogManager.d("anInt : " + i);
                    FilePrint filePrint = this.filePrinter;
                    if (filePrint != null) {
                        filePrint.flush();
                    }
                    if (i == 2) {
                        File file = new File(context.getFilesDir(), LogManager.CORE_LOG);
                        File file2 = new File(LogManager.DEST_LOG_DIR);
                        if (!file2.exists()) {
                            boolean mkdirs = file2.mkdirs();
                            LogManager.d("dest mkdirs: " + mkdirs);
                        }
                        LogManager.d("copy log start");
                        FileUtils.copyDir(file, file2);
                        LogManager.d("copy log end");
                        Settings.System.putInt(context.getContentResolver(), "com.upuphone.starrynet.log", 3);
                    }
                } catch (Exception e) {
                    LogManager.d("copy log error");
                    Settings.System.putInt(context.getContentResolver(), "com.upuphone.starrynet.log", -1);
                    e.printStackTrace();
                }
            }
        }
    }

    private LogManager() {
    }

    public static void d(String str, byte b, String str2) {
        INSTANCE.printLog(3, b, str, str2);
    }

    public static void e(String str, byte b, String str2) {
        INSTANCE.printLog(6, b, str, str2);
    }

    public static void i(String str, byte b, String str2) {
        INSTANCE.printLog(4, b, str, str2);
    }

    public static void init(Context context, int i) {
        INSTANCE.initLog(context, i);
    }

    public static void setIs3rdDevice(boolean z) {
        INSTANCE.setIs3rdDevice(z);
    }

    public static void v(String str, byte b, String str2) {
        INSTANCE.printLog(2, b, str, str2);
    }

    public static void w(String str, byte b, String str2) {
        INSTANCE.printLog(5, b, str, str2);
    }

    public static void d(String str, byte b, String str2, Object... objArr) {
        INSTANCE.printLog(3, b, str, String.format(str2, objArr));
    }

    public static void e(String str, byte b, String str2, Object... objArr) {
        INSTANCE.printLog(6, b, str, String.format(str2, objArr));
    }

    public static void i(String str, byte b, String str2, Object... objArr) {
        INSTANCE.printLog(4, b, str, String.format(str2, objArr));
    }

    public static void v(String str, byte b, String str2, Object... objArr) {
        INSTANCE.printLog(2, b, str, String.format(str2, objArr));
    }

    public static void w(String str, byte b, String str2, Object... objArr) {
        INSTANCE.printLog(5, b, str, String.format(str2, objArr));
    }

    public static void d(String str, byte b, String str2, Throwable th) {
        Holder holder = INSTANCE;
        holder.printLog(3, b, str, str2 + 10 + Log.getStackTraceString(th));
    }

    public static void e(String str, byte b, String str2, Throwable th) {
        Holder holder = INSTANCE;
        holder.printLog(6, b, str, str2 + 10 + Log.getStackTraceString(th));
    }

    public static void i(String str, byte b, String str2, Throwable th) {
        Holder holder = INSTANCE;
        holder.printLog(4, b, str, str2 + 10 + Log.getStackTraceString(th));
    }

    public static void w(String str, byte b, String str2, Throwable th) {
        Holder holder = INSTANCE;
        holder.printLog(5, b, str, str2 + 10 + Log.getStackTraceString(th));
    }

    public static void d(String str) {
        INSTANCE.printLog(3, (byte) 15, DEFAULT_TAG, str);
    }

    public static void e(String str) {
        INSTANCE.printLog(6, (byte) 15, DEFAULT_TAG, str);
    }
}

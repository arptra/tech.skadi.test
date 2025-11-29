package com.xjmz.myvu.crash;

import android.content.Context;
import android.os.Process;
import com.geetest.sdk.t;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/crash/DefaultCrashHandler;", "", "a", "Companion", "DefaultUncaughtExceptionHandler", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DefaultCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8232a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjmz/myvu/crash/DefaultCrashHandler$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "ctx", "", "a", "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "ctx");
            Thread.setDefaultUncaughtExceptionHandler(new DefaultUncaughtExceptionHandler(context));
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/xjmz/myvu/crash/DefaultCrashHandler$DefaultUncaughtExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "Ljava/lang/Thread;", "t", "", "e", "", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "context", "throwable", "", "a", "(Landroid/content/Context;Ljava/lang/Throwable;)Z", "", "b", "(Landroid/content/Context;Ljava/lang/Throwable;)Ljava/lang/String;", "Landroid/content/Context;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "mDefaultHandler", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class DefaultUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public final Context f8233a;
        public final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

        public DefaultUncaughtExceptionHandler(Context context) {
            Intrinsics.checkNotNullParameter(context, "ctx");
            this.f8233a = context;
        }

        public final boolean a(Context context, Throwable th) {
            DataTrackUtil.f7875a.j(th);
            b(context, th);
            return true;
        }

        public final String b(Context context, Throwable th) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            String obj = stringWriter.toString();
            ILog.e("DefaultCrashHandler", "********************捕获应用崩溃信息，开始纪录********************");
            ILog.e("DefaultCrashHandler", obj);
            ILog.e("DefaultCrashHandler", "********************捕获应用崩溃信息，结束纪录********************");
            String str = "crash-" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())) + ".log";
            String str2 = null;
            File externalFilesDir = context.getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                str2 = externalFilesDir.getAbsolutePath();
            }
            String str3 = str2 + "/crash/";
            File file = new File(str3);
            if (!file.exists()) {
                ILog.i("DefaultCrashHandler", "创建文件夹：" + str3 + "，" + file.mkdirs());
            }
            File file2 = new File(file, str);
            boolean createNewFile = file2.createNewFile();
            ILog.i("DefaultCrashHandler", "创建崩溃日志文件：" + file2.getAbsolutePath() + "，" + createNewFile);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2), "UTF-8"));
            bufferedWriter.write(obj);
            bufferedWriter.flush();
            bufferedWriter.close();
            ILog.i("DefaultCrashHandler", "崩溃日志写入文件成功");
            return str;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            Intrinsics.checkNotNullParameter(thread, t.f);
            Intrinsics.checkNotNullParameter(th, "e");
            a(this.f8233a, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
            Process.killProcess(Process.myPid());
            System.exit(1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }
}

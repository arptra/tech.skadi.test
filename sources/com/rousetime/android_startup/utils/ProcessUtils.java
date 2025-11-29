package com.rousetime.android_startup.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/rousetime/android_startup/utils/ProcessUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "", "processName", "", "b", "(Landroid/content/Context;[Ljava/lang/String;)Z", "a", "(Landroid/content/Context;)Ljava/lang/String;", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class ProcessUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ProcessUtils f9835a = new ProcessUtils();

    public final String a(Context context) {
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            Intrinsics.checkExpressionValueIsNotNull(runningAppProcesses, "am.runningAppProcesses");
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    Intrinsics.checkExpressionValueIsNotNull(str, "it.processName");
                    return str;
                }
            }
            return "";
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final boolean b(Context context, String[] strArr) {
        for (String str : strArr) {
            if (Intrinsics.areEqual((Object) f9835a.a(context), (Object) context.getPackageName() + str)) {
                return true;
            }
        }
        return false;
    }
}

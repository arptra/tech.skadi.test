package com.upuphone.xr.sapp.vu.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.honey.account.e9.a;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.vu.ArSpaceService;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u0003J\u001f\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0003J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/ArSpaceUtil;", "", "<init>", "()V", "", "i", "()Z", "j", "Landroid/content/Context;", "context", "h", "(Landroid/content/Context;)Z", "", "b", "Ljava/io/File;", "dir", "isDeleteDir", "d", "(Ljava/io/File;Z)V", "e", "c", "g", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nArSpaceUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceUtil.kt\ncom/upuphone/xr/sapp/vu/utils/ArSpaceUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1855#2,2:113\n*S KotlinDebug\n*F\n+ 1 ArSpaceUtil.kt\ncom/upuphone/xr/sapp/vu/utils/ArSpaceUtil\n*L\n62#1:113,2\n*E\n"})
public final class ArSpaceUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final ArSpaceUtil f8089a = new ArSpaceUtil();

    public static final void f() {
        VuGlassControlModel.f8109a.E();
    }

    public final void b() {
        MainApplication.Companion companion = MainApplication.k;
        String path = companion.f().getFilesDir().getPath();
        d(new File(path + "/home/root"), false);
        String path2 = companion.f().getFilesDir().getPath();
        d(new File(path2 + "/system"), false);
        String path3 = companion.f().getDataDir().getPath();
        d(new File(path3 + "/app_content_shell"), false);
    }

    public final void c() {
        GlassDataStoreHelper glassDataStoreHelper = GlassDataStoreHelper.f8091a;
        glassDataStoreHelper.i(false);
        glassDataStoreHelper.j(false);
        glassDataStoreHelper.n(false);
    }

    public final void d(File file, boolean z) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles(...)");
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    d(file2, true);
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public final void e() {
        if (h(MainApplication.k.f())) {
            ArSpaceService a2 = ArSpaceService.j.a();
            if (a2 != null) {
                a2.u(true);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new a(), AssistantConstants.TIMEOUT_VAD_MUTE);
            return;
        }
        VuGlassControlModel.f8109a.E();
    }

    public final boolean g(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityManager.class)).getRunningAppProcesses();
            ULog.f6446a.a("VuGlassFragment", "All running process: ");
            Intrinsics.checkNotNull(runningAppProcesses);
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                ULog.f6446a.a("VuGlassFragment", "precessName: " + runningAppProcessInfo.processName);
            }
            String str = context.getPackageName() + ":ServiceManagerProvider";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                if (Intrinsics.areEqual((Object) runningAppProcessInfo2.processName, (Object) str)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final boolean h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean g = g(context);
        boolean z = ArSpaceService.j.a() != null;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassFragment", "isArSpaceRunning: isArSpaceProcessRunning: " + g + ", arSpaceServiceRunning: " + z);
        return g && z;
    }

    public final boolean i() {
        return PhoneTypeUtils.f7912a.h();
    }

    public final boolean j() {
        if (!BuildConfig.f6575a.booleanValue()) {
            PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
            if (phoneTypeUtils.l() || phoneTypeUtils.j() || phoneTypeUtils.h()) {
                return true;
            }
        }
        return false;
    }
}

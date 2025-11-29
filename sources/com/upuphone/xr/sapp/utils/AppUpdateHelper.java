package com.upuphone.xr.sapp.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.CircleProgressBar;
import com.tencent.mmkv.MMKV;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.download.manager.DownloadManager;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.star.download.manager.Utils;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.entity.AppUpdateDialogShownConfig;
import com.upuphone.xr.sapp.entity.AppUpdateInfo;
import com.upuphone.xr.sapp.entity.AppUpdateInfoKt;
import com.upuphone.xr.sapp.receiver.AppUpdateReceiver;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0002Z^\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH@¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0003J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0003J\u0019\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H@¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b&\u0010$J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b'\u0010$J\u0019\u0010)\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010-\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\u0003R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u00105R&\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b0<8\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R)\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b0@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\f0F8\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\f0J8\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u00105R\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u00105R\u0014\u0010]\u001a\u00020Z8\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R(\u0010h\u001a\u0004\u0018\u00010b2\b\u0010c\u001a\u0004\u0018\u00010b8B@BX\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR(\u0010n\u001a\u0004\u0018\u00010i2\b\u0010c\u001a\u0004\u0018\u00010i8B@BX\u000e¢\u0006\f\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006o"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AppUpdateHelper;", "", "<init>", "()V", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "", "s", "(Landroidx/appcompat/app/AppCompatActivity;)V", "Landroid/app/Activity;", "r", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "u", "()Z", "L", "E", "t", "P", "F", "D", "", "delay", "v", "(J)V", "Landroid/content/Context;", "context", "Lcom/upuphone/star/httplib/HttpResult;", "Lcom/upuphone/xr/sapp/entity/BasicResponse;", "Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;", "y", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInfo", "M", "(Landroid/app/Activity;Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;)V", "R", "(Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;)V", "K", "Q", "J", "silent", "N", "(Z)V", "Ljava/io/File;", "downloadFile", "x", "(Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;Ljava/io/File;)V", "G", "Ljava/lang/ref/WeakReference;", "b", "Ljava/lang/ref/WeakReference;", "activityReference", "c", "Z", "isAppInitialized", "d", "Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;", "appUpdateInfo", "e", "needCheckUpdate", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "f", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_appUpdateInfoEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "g", "Lkotlinx/coroutines/flow/SharedFlow;", "z", "()Lkotlinx/coroutines/flow/SharedFlow;", "appUpdateInfoEvent", "Landroidx/lifecycle/MutableLiveData;", "h", "Landroidx/lifecycle/MutableLiveData;", "_showUpdateBadge", "Landroidx/lifecycle/LiveData;", "i", "Landroidx/lifecycle/LiveData;", "B", "()Landroidx/lifecycle/LiveData;", "showUpdateBadge", "Lcom/upuphone/star/download/manager/DownloadTask;", "j", "Lcom/upuphone/star/download/manager/DownloadTask;", "downloadTask", "k", "Ljava/io/File;", "l", "needResumeDownload", "m", "showDownloadByNotification", "com/upuphone/xr/sapp/utils/AppUpdateHelper$networkCallback$1", "n", "Lcom/upuphone/xr/sapp/utils/AppUpdateHelper$networkCallback$1;", "networkCallback", "com/upuphone/xr/sapp/utils/AppUpdateHelper$downloadListener$1", "o", "Lcom/upuphone/xr/sapp/utils/AppUpdateHelper$downloadListener$1;", "downloadListener", "Lcom/upuphone/xr/sapp/entity/AppUpdateDialogShownConfig;", "value", "C", "()Lcom/upuphone/xr/sapp/entity/AppUpdateDialogShownConfig;", "I", "(Lcom/upuphone/xr/sapp/entity/AppUpdateDialogShownConfig;)V", "updateDialogShownConfig", "", "A", "()Ljava/lang/String;", "H", "(Ljava/lang/String;)V", "ignoredUpdateVersion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAppUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppUpdateHelper.kt\ncom/upuphone/xr/sapp/utils/AppUpdateHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 HttpUtils.kt\ncom/upuphone/star/httplib/HttpUtils\n+ 4 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,626:1\n1#2:627\n253#3:628\n29#4,5:629\n*S KotlinDebug\n*F\n+ 1 AppUpdateHelper.kt\ncom/upuphone/xr/sapp/utils/AppUpdateHelper\n*L\n245#1:628\n373#1:629,5\n*E\n"})
public final class AppUpdateHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AppUpdateHelper f7841a = new AppUpdateHelper();
    public static WeakReference b;
    public static boolean c;
    public static AppUpdateInfo d;
    public static boolean e;
    public static final MutableSharedFlow f;
    public static final SharedFlow g;
    public static final MutableLiveData h;
    public static final LiveData i;
    public static DownloadTask j;
    public static File k;
    public static boolean l;
    public static boolean m = true;
    public static final AppUpdateHelper$networkCallback$1 n = new AppUpdateHelper$networkCallback$1();
    public static final AppUpdateHelper$downloadListener$1 o = new AppUpdateHelper$downloadListener$1();

    static {
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        f = b2;
        g = FlowKt.b(b2);
        MutableLiveData mutableLiveData = new MutableLiveData();
        h = mutableLiveData;
        i = mutableLiveData;
    }

    public static /* synthetic */ void O(AppUpdateHelper appUpdateHelper, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        appUpdateHelper.N(z);
    }

    public static /* synthetic */ void w(AppUpdateHelper appUpdateHelper, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 0;
        }
        appUpdateHelper.v(j2);
    }

    public final String A() {
        return MMKV.n().j("app_update_ignored_version");
    }

    public final LiveData B() {
        return i;
    }

    public final AppUpdateDialogShownConfig C() {
        Object obj;
        String j2 = MMKV.n().j("app_update_dialog_shown_config");
        if (j2 == null) {
            return null;
        }
        JsonUtils jsonUtils = JsonUtils.f7893a;
        Type type = new AppUpdateHelper$_get_updateDialogShownConfig_$lambda$9$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(j2, type);
        }
        return (AppUpdateDialogShownConfig) obj;
    }

    public final void D() {
        AppUpdateInfo appUpdateInfo = d;
        if (appUpdateInfo == null) {
            ULog.f6446a.c("AppUpdateHelper", "hideUpdateBadge, appUpdateInfo is null");
            return;
        }
        String latestVersion = appUpdateInfo.getLatestVersion();
        if (latestVersion == null || latestVersion.length() == 0) {
            ULog.f6446a.c("AppUpdateHelper", "hideUpdateBadge, latestVersion is null");
            return;
        }
        H(latestVersion);
        G();
    }

    public final void E() {
        ULog.f6446a.a("AppUpdateHelper", "onAppInitialized");
        c = true;
        w(this, 0, 1, (Object) null);
    }

    public final void F() {
        boolean canRequestPackageInstalls = GlobalExtKt.f().getPackageManager().canRequestPackageInstalls();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUpdateHelper", "onManageUnknownAppSourceResult, canRequestPackageInstalls: " + canRequestPackageInstalls);
        File file = k;
        if (file == null) {
            delegate.c("AppUpdateHelper", "onManageUnknownAppSourceResult, downloadFile is null");
        } else if (canRequestPackageInstalls) {
            AppUtils appUtils = AppUtils.f7842a;
            appUtils.o(GlobalExtKt.f(), appUtils.f(GlobalExtKt.f(), file));
        }
    }

    public final void G() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new AppUpdateHelper$refreshUpdateBadge$1((Continuation<? super AppUpdateHelper$refreshUpdateBadge$1>) null), 3, (Object) null);
    }

    public final void H(String str) {
        MMKV.n().u("app_update_ignored_version", str);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUpdateHelper", "save ignoredUpdateVersion success: " + str);
    }

    public final void I(AppUpdateDialogShownConfig appUpdateDialogShownConfig) {
        String d2 = JsonUtils.f7893a.d(appUpdateDialogShownConfig);
        MMKV.n().u("app_update_dialog_shown_config", d2);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUpdateHelper", "save updateDialogShownConfig success: " + d2);
    }

    public final void J(AppUpdateInfo appUpdateInfo) {
        String str;
        Long apkSize = appUpdateInfo.getApkSize();
        String a2 = FileSizeExtKt.a(apkSize != null ? apkSize.longValue() : 0);
        if (appUpdateInfo.getDownloadProgress() >= 1.0f) {
            str = GlobalExtKt.h(R.string.download_completed) + " " + a2;
        } else {
            str = GlobalExtKt.h(R.string.downloading) + " " + a2;
        }
        String str2 = str;
        PendingIntent broadcast = PendingIntent.getBroadcast(GlobalExtKt.f(), 0, new Intent(GlobalExtKt.f(), AppUpdateReceiver.class), CircleProgressBar.RIM_COLOR_DEF);
        NotificationUtils.j(NotificationUtils.f7900a, 512, "channel_app_update", GlobalExtKt.h(R.string.app_name) + " " + appUpdateInfo.getLatestVersion(), str2, 0, 0, broadcast, Integer.valueOf((int) (appUpdateInfo.getDownloadProgress() * ((float) 100))), false, false, false, 816, (Object) null);
    }

    public final void K(AppUpdateInfo appUpdateInfo) {
        NotificationUtils notificationUtils = NotificationUtils.f7900a;
        m = notificationUtils.d() && Intrinsics.areEqual((Object) notificationUtils.g("channel_app_update"), (Object) Boolean.TRUE);
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = m;
        delegate.a("AppUpdateHelper", "showDownloadProgressUI, showDownloadByNotification: " + z);
        if (m) {
            J(appUpdateInfo);
            ContextExtKt.e(R.string.download_started, 0, 2, (Object) null);
            return;
        }
        L();
    }

    public final boolean L() {
        AppCompatActivity appCompatActivity;
        WeakReference weakReference = b;
        if (weakReference == null || (appCompatActivity = (AppCompatActivity) weakReference.get()) == null) {
            ULog.f6446a.c("AppUpdateHelper", "showDownloadingDialogIfNecessary, activity is null");
            return false;
        }
        AppUpdateInfo appUpdateInfo = d;
        if (appUpdateInfo == null) {
            ULog.f6446a.c("AppUpdateHelper", "showDownloadingDialogIfNecessary, appUpdateInfo is null");
            return false;
        } else if (StaticMethodUtilsKt.n(186)) {
            ULog.f6446a.a("AppUpdateHelper", "showDownloadingDialogIfNecessary, already showing");
            return false;
        } else {
            StaticMethodUtilsKt.E(appCompatActivity, 186, appUpdateInfo, false, false, (SuperGenericWindowView.IActionCallback) null, 28, (Object) null);
            ULog.f6446a.a("AppUpdateHelper", "showDownloadingDialogIfNecessary, success");
            return true;
        }
    }

    public final void M(Activity activity, AppUpdateInfo appUpdateInfo) {
        StaticMethodUtilsKt.E(activity, Opcodes.INVOKEVIRTUAL, appUpdateInfo, true, false, (SuperGenericWindowView.IActionCallback) null, 24, (Object) null);
        ULog.f6446a.a("AppUpdateHelper", "showUpdateDialog, success");
    }

    public final void N(boolean z) {
        AppCompatActivity appCompatActivity;
        WeakReference weakReference = b;
        if (weakReference == null || (appCompatActivity = (AppCompatActivity) weakReference.get()) == null) {
            ULog.f6446a.c("AppUpdateHelper", "startDownload, activity is null");
        } else if (!NetworkUtils.f7898a.g()) {
            ULog.f6446a.c("AppUpdateHelper", "startDownload, hasNetwork=false");
            if (!z) {
                StaticMethodUtilsKt.E(appCompatActivity, 120, (Object) null, false, false, (SuperGenericWindowView.IActionCallback) null, 30, (Object) null);
            }
        } else {
            AppUpdateInfo appUpdateInfo = d;
            if (appUpdateInfo == null) {
                ULog.f6446a.c("AppUpdateHelper", "startDownload, appUpdateInfo is null");
                ContextExtKt.e(R.string.update_info_invalid, 0, 2, (Object) null);
                return;
            }
            String downloadLink = appUpdateInfo.getDownloadLink();
            if (downloadLink == null || downloadLink.length() == 0) {
                ULog.f6446a.c("AppUpdateHelper", "startDownload, downloadLink is null");
                ContextExtKt.e(R.string.update_info_invalid, 0, 2, (Object) null);
                return;
            }
            String digest = appUpdateInfo.getDigest();
            if (digest == null || digest.length() == 0) {
                ULog.f6446a.c("AppUpdateHelper", "startDownload, digest is null");
                ContextExtKt.e(R.string.update_info_invalid, 0, 2, (Object) null);
                return;
            }
            Utils utils = Utils.f6462a;
            Context f2 = GlobalExtKt.f();
            j = DownloadManager.t(DownloadManager.b, downloadLink, utils.a(f2, "app_download", digest + ".apk"), false, 3, 0, o, 16, (Object) null);
            if (!z) {
                f7841a.K(appUpdateInfo);
            }
            ULog.f6446a.a("AppUpdateHelper", "startDownload");
        }
    }

    public final void P() {
        AppCompatActivity appCompatActivity;
        WeakReference weakReference = b;
        if (weakReference == null || (appCompatActivity = (AppCompatActivity) weakReference.get()) == null) {
            ULog.f6446a.c("AppUpdateHelper", "startUpdate, activity is null");
            return;
        }
        AppUpdateInfo appUpdateInfo = d;
        if (appUpdateInfo == null) {
            ULog.f6446a.c("AppUpdateHelper", "startUpdate, appUpdateInfo is null");
            ContextExtKt.e(R.string.update_info_invalid, 0, 2, (Object) null);
            return;
        }
        String downloadLink = appUpdateInfo.getDownloadLink();
        if (downloadLink == null || downloadLink.length() == 0) {
            ULog.f6446a.c("AppUpdateHelper", "startUpdate, downloadLink is null");
            ContextExtKt.e(R.string.update_info_invalid, 0, 2, (Object) null);
            return;
        }
        String digest = appUpdateInfo.getDigest();
        if (digest == null || digest.length() == 0) {
            ULog.f6446a.c("AppUpdateHelper", "startUpdate, digest is null");
            ContextExtKt.e(R.string.update_info_invalid, 0, 2, (Object) null);
            return;
        }
        Utils utils = Utils.f6462a;
        Context f2 = GlobalExtKt.f();
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(appCompatActivity), (CoroutineContext) null, (CoroutineStart) null, new AppUpdateHelper$startUpdate$1(downloadLink, utils.a(f2, "app_download", digest + ".apk"), appUpdateInfo, (Continuation<? super AppUpdateHelper$startUpdate$1>) null), 3, (Object) null);
    }

    public final void Q(AppUpdateInfo appUpdateInfo) {
        if (m) {
            J(appUpdateInfo);
        }
        R(appUpdateInfo);
    }

    public final void R(AppUpdateInfo appUpdateInfo) {
        StaticMethodUtilsKt.Z(186, appUpdateInfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
        r8 = r8.getUpgradeModelCount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r(android.app.Activity r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            r0 = 0
            e = r0
            com.upuphone.xr.sapp.entity.AppUpdateInfo r1 = d
            java.lang.String r2 = "AppUpdateHelper"
            if (r1 != 0) goto L_0x0013
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r7 = "checkUpdate, appUpdateInfo is null"
            r6.c(r2, r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0013:
            r3 = 0
            if (r1 == 0) goto L_0x003a
            boolean r1 = r1.getExistsUpdate()
            if (r1 != 0) goto L_0x003a
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r7 = "checkUpdate, existsUpdate=false, clear files"
            r6.a(r2, r7)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.utils.AppUpdateHelper$appUpdate$2 r7 = new com.upuphone.xr.sapp.utils.AppUpdateHelper$appUpdate$2
            r7.<init>(r3)
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r7, r8)
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r7) goto L_0x0037
            return r6
        L_0x0037:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x003a:
            com.upuphone.xr.sapp.entity.AppUpdateInfo r8 = d
            if (r8 == 0) goto L_0x004e
            boolean r8 = com.upuphone.xr.sapp.entity.AppUpdateInfoKt.getShouldShowDialog(r8)
            if (r8 != 0) goto L_0x004e
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r7 = "checkUpdate, shouldShowDialog=false"
            r6.a(r2, r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x004e:
            com.upuphone.xr.sapp.context.SdkContext r8 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.AppContext r8 = r8.c()
            boolean r8 = r8.e()
            if (r8 == 0) goto L_0x0064
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r7 = "checkUpdate, isIntlVersion=true"
            r6.a(r2, r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0064:
            com.upuphone.xr.sapp.entity.AppUpdateInfo r8 = d
            r1 = 1
            if (r8 == 0) goto L_0x007b
            boolean r8 = com.upuphone.xr.sapp.entity.AppUpdateInfoKt.isForceUpdate(r8)
            if (r8 != r1) goto L_0x007b
            com.upuphone.xr.sapp.entity.AppUpdateInfo r6 = d
            if (r6 == 0) goto L_0x0078
            com.upuphone.xr.sapp.utils.AppUpdateHelper r8 = f7841a
            r8.M(r7, r6)
        L_0x0078:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x007b:
            com.upuphone.xr.sapp.entity.AppUpdateInfo r8 = d
            if (r8 == 0) goto L_0x0083
            java.lang.String r3 = r8.getLatestVersion()
        L_0x0083:
            if (r3 == 0) goto L_0x00e6
            int r8 = r3.length()
            if (r8 != 0) goto L_0x008c
            goto L_0x00e6
        L_0x008c:
            com.upuphone.xr.sapp.entity.AppUpdateInfo r8 = d
            if (r8 == 0) goto L_0x009b
            java.lang.Integer r8 = r8.getUpgradeModelCount()
            if (r8 == 0) goto L_0x009b
            int r8 = r8.intValue()
            goto L_0x009c
        L_0x009b:
            r8 = 3
        L_0x009c:
            com.upuphone.xr.sapp.entity.AppUpdateDialogShownConfig r4 = r6.C()
            if (r4 == 0) goto L_0x00cb
            java.lang.String r5 = r4.getVersion()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r3)
            if (r5 == 0) goto L_0x00cb
            int r5 = r4.getCount()
            if (r5 < r8) goto L_0x00cb
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "checkUpdate, showDialogCount reach max: "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.a(r2, r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00cb:
            if (r4 == 0) goto L_0x00d1
            int r0 = r4.getCount()
        L_0x00d1:
            int r0 = r0 + r1
            com.upuphone.xr.sapp.entity.AppUpdateDialogShownConfig r8 = new com.upuphone.xr.sapp.entity.AppUpdateDialogShownConfig
            r8.<init>(r3, r0)
            r6.I(r8)
            com.upuphone.xr.sapp.entity.AppUpdateInfo r6 = d
            if (r6 == 0) goto L_0x00e3
            com.upuphone.xr.sapp.utils.AppUpdateHelper r8 = f7841a
            r8.M(r7, r6)
        L_0x00e3:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00e6:
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r7 = "checkUpdate, latestVersion is null"
            r6.c(r2, r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.AppUpdateHelper.r(android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void s(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        b = new WeakReference(appCompatActivity);
        NetworkUtils.f7898a.o(appCompatActivity, n);
    }

    public final void t() {
        DownloadTask downloadTask = j;
        if (downloadTask == null) {
            ULog.f6446a.c("AppUpdateHelper", "cancelDownload, downloadTask is null");
            return;
        }
        DownloadManager.b.j(downloadTask, false);
        ULog.f6446a.a("AppUpdateHelper", "cancelDownload, success");
        j = null;
        l = false;
    }

    public final boolean u() {
        AppCompatActivity appCompatActivity;
        WeakReference weakReference = b;
        if (weakReference == null || (appCompatActivity = (AppCompatActivity) weakReference.get()) == null) {
            ULog.f6446a.c("AppUpdateHelper", "checkIfShowUpdateDialog, activity is null");
            return false;
        }
        AppUpdateInfo appUpdateInfo = d;
        if (appUpdateInfo == null || !AppUpdateInfoKt.isForceUpdate(appUpdateInfo)) {
            return false;
        }
        DownloadTask downloadTask = j;
        if (downloadTask == null || !DownloadManager.b.m(downloadTask)) {
            f7841a.M(appCompatActivity, appUpdateInfo);
            return true;
        }
        ContextExtKt.e(R.string.pls_complete_app_update, 0, 2, (Object) null);
        return true;
    }

    public final void v(long j2) {
        AppCompatActivity appCompatActivity;
        WeakReference weakReference = b;
        if (weakReference == null || (appCompatActivity = (AppCompatActivity) weakReference.get()) == null) {
            ULog.f6446a.c("AppUpdateHelper", "checkUpdate, activity is null");
        } else if (!c) {
            ULog.f6446a.a("AppUpdateHelper", "checkUpdate, isAppInitialized=false");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(appCompatActivity), (CoroutineContext) null, (CoroutineStart) null, new AppUpdateHelper$checkUpdate$1(j2, appCompatActivity, (Continuation<? super AppUpdateHelper$checkUpdate$1>) null), 3, (Object) null);
        }
    }

    public final void x(AppUpdateInfo appUpdateInfo, File file) {
        if (!file.exists()) {
            ULog.f6446a.c("AppUpdateHelper", "downloadComplete, file not exists");
            ContextExtKt.e(R.string.update_file_not_exist, 0, 2, (Object) null);
            return;
        }
        String digest = appUpdateInfo.getDigest();
        if (digest == null || digest.length() == 0) {
            ULog.f6446a.c("AppUpdateHelper", "downloadComplete, digest is null");
            ContextExtKt.e(R.string.update_info_invalid, 0, 2, (Object) null);
            return;
        }
        WeakReference weakReference = b;
        AppCompatActivity appCompatActivity = weakReference != null ? (AppCompatActivity) weakReference.get() : null;
        if (appCompatActivity == null) {
            ULog.f6446a.c("AppUpdateHelper", "downloadComplete, activity is null");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(appCompatActivity), (CoroutineContext) null, (CoroutineStart) null, new AppUpdateHelper$downloadComplete$1(digest, file, appCompatActivity, (Continuation<? super AppUpdateHelper$downloadComplete$1>) null), 3, (Object) null);
        }
    }

    public final Object y(Context context, Continuation continuation) {
        Context context2 = context;
        String string = context2.getString(context.getApplicationInfo().labelRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        AppUtils appUtils = AppUtils.f7842a;
        Pair g2 = appUtils.g(context2);
        String str = (String) g2.component1();
        String str2 = (String) g2.component2();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUpdateHelper", "getAppUpdateInfo, lang: " + str + ", country: " + str2);
        String str3 = Build.BRAND;
        String str4 = Build.MODEL;
        delegate.a("AppUpdateHelper", "getAppUpdateInfo, brand: " + str3 + ", model: " + str4 + ", version: " + "2.40.51");
        Map mapOf = MapsKt.mapOf(TuplesKt.to("appName", string), TuplesKt.to(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, "com.upuphone.star.launcher.intl"), TuplesKt.to("version", "2.40.51"), TuplesKt.to("brandName", str3), TuplesKt.to("modelName", str4), TuplesKt.to("lang", str + AccountConstantKt.DEFAULT_SEGMENT + str2), TuplesKt.to("uuid", appUtils.e()));
        HttpUtils httpUtils = HttpUtils.f6479a;
        String str5 = NetConfig.f6666a.v("sArOta") + "/client/v1/super-app/latest-version/v2";
        Type type = new AppUpdateHelper$getAppUpdateInfo$$inlined$post$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<T>() {}.type");
        return httpUtils.o(str5, mapOf, type, continuation);
    }

    public final SharedFlow z() {
        return g;
    }
}

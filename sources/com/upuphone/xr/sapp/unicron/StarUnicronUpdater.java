package com.upuphone.xr.sapp.unicron;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.v8.b;
import com.tencent.mmkv.MMKV;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.starrynetsdk.StarryNet;
import com.upuphone.starrynetsdk.ability.share.ShareAbility;
import com.upuphone.xr.sapp.entity.CheckUpdateFileReq;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.glass.FilterShareListener;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.xjmz.myvu.bridge.ActivityExtKt;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u0015\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0007¢\u0006\u0004\b'\u0010\u0004J\u001a\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020(H@¢\u0006\u0004\b+\u0010,J'\u0010/\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u001d\u00104\u001a\u00020\u00072\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201¢\u0006\u0004\b4\u00105J!\u00108\u001a\u00020\u00072\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001506¢\u0006\u0004\b8\u00109J'\u0010>\u001a\u00020\u00072\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010\u0004R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001b\u0010P\u001a\u00020K8BX\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010WR(\u0010^\u001a\u0004\u0018\u00010\u00052\b\u0010[\u001a\u0004\u0018\u00010\u00058B@BX\u000e¢\u0006\f\u001a\u0004\b\\\u0010]\"\u0004\bI\u0010\tR\u0014\u0010b\u001a\u00020_8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b`\u0010a¨\u0006c"}, d2 = {"Lcom/upuphone/xr/sapp/unicron/StarUnicronUpdater;", "Lcom/upuphone/xr/sapp/unicron/IUnicronUpdater;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "msg", "", "w", "(Ljava/lang/String;)V", "x", "Ljava/io/File;", "file", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "D", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "", "delayTime", "F", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;J)V", "", "isFirstTime", "L", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Z)V", "N", "(J)V", "taskId", "downloadFile", "H", "(Ljava/lang/String;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/io/File;)V", "v", "p", "K", "r", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "n", "(Landroidx/appcompat/app/AppCompatActivity;)V", "E", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;", "req", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileResp;", "c", "(Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "unicronInfo", "a", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Lcom/upuphone/xr/sapp/entity/UnicronInfo;)V", "", "windowType", "actionType", "A", "(II)V", "", "result", "B", "(Ljava/util/Map;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "y", "(IILandroid/content/Intent;)V", "q", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mainActivity", "Lcom/upuphone/xr/sapp/unicron/UnicronUpdateConfig;", "d", "Lcom/upuphone/xr/sapp/unicron/UnicronUpdateConfig;", "pendingUpdateConfig", "e", "I", "transferCount", "Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "f", "Lkotlin/Lazy;", "t", "()Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "shareAbility", "Lcom/upuphone/xr/sapp/glass/FilterShareListener;", "g", "Lcom/upuphone/xr/sapp/glass/FilterShareListener;", "filterShareListener", "Lkotlinx/coroutines/Job;", "h", "Lkotlinx/coroutines/Job;", "restartTransferFileJob", "i", "transferFileJob", "value", "s", "()Ljava/lang/String;", "requestPermissionVersion", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StarUnicronUpdater implements IUnicronUpdater, CoroutineScope {
    public static final StarUnicronUpdater b = new StarUnicronUpdater();
    public static WeakReference c;
    public static UnicronUpdateConfig d;
    public static int e;
    public static final Lazy f = LazyKt.lazy(StarUnicronUpdater$shareAbility$2.INSTANCE);
    public static final FilterShareListener g = new FilterShareListener();
    public static Job h;
    public static Job i;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7831a = CoroutineScopeKt.b();

    static {
        StarryNet.getInstance().registerInstallListener(new b());
    }

    private final void F(File file, GlassUpdateInfo glassUpdateInfo, long j) {
        int i2 = e;
        if (i2 > 3) {
            w("restartTransferFile, reach max count: " + i2);
            return;
        }
        Job job = h;
        if (job == null || !job.isActive()) {
            h = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarUnicronUpdater$restartTransferFile$1(j, glassUpdateInfo, file, (Continuation<? super StarUnicronUpdater$restartTransferFile$1>) null), 3, (Object) null);
        } else {
            w("restartTransferFileJob.isActive, return");
        }
    }

    public static /* synthetic */ void G(StarUnicronUpdater starUnicronUpdater, File file, GlassUpdateInfo glassUpdateInfo, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = 60000;
        }
        starUnicronUpdater.F(file, glassUpdateInfo, j);
    }

    public static /* synthetic */ void M(StarUnicronUpdater starUnicronUpdater, File file, GlassUpdateInfo glassUpdateInfo, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        starUnicronUpdater.L(file, glassUpdateInfo, z);
    }

    private final void N(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarUnicronUpdater$tryReleaseP2p$1(j, (Continuation<? super StarUnicronUpdater$tryReleaseP2p$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void O(StarUnicronUpdater starUnicronUpdater, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 1000;
        }
        starUnicronUpdater.N(j);
    }

    /* access modifiers changed from: private */
    public static final void e() {
        StarUnicronUpdater starUnicronUpdater = b;
        int registerSendListener = starUnicronUpdater.t().registerSendListener(g);
        starUnicronUpdater.w("registerSendListener code: " + registerSendListener);
    }

    /* access modifiers changed from: private */
    public final ShareAbility t() {
        return (ShareAbility) f.getValue();
    }

    /* access modifiers changed from: private */
    public final void w(String str) {
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("StarUnicronUpdater|" + str);
    }

    /* access modifiers changed from: private */
    public final void x(String str) {
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.M("StarUnicronUpdater|" + str);
    }

    public final void A(int i2, int i3) {
        AppCompatActivity appCompatActivity;
        AppCompatActivity appCompatActivity2;
        AppCompatActivity appCompatActivity3;
        AppCompatActivity appCompatActivity4;
        AppCompatActivity appCompatActivity5;
        if (d == null) {
            x("onDialogEvent, windowType: " + i2 + ", pendingUpdateConfig is null");
        } else if (i2 != 153) {
            if (i2 != 157) {
                if (i2 != 170) {
                    switch (i2) {
                        case 172:
                            if (i3 == 1101) {
                                w("onDialogEvent, openNetworkSetting");
                                WeakReference weakReference = c;
                                if (weakReference != null && (appCompatActivity3 = (AppCompatActivity) weakReference.get()) != null) {
                                    AppUtils.f7842a.p(appCompatActivity3, i2);
                                    return;
                                }
                                return;
                            }
                            w("onDialogEvent, wifi dialog cancel");
                            return;
                        case 173:
                            if (i3 == 1101) {
                                w("onDialogEvent, openHotspotSetting");
                                WeakReference weakReference2 = c;
                                if (weakReference2 != null && (appCompatActivity4 = (AppCompatActivity) weakReference2.get()) != null) {
                                    AppUtils.f7842a.m(appCompatActivity4, i2);
                                    return;
                                }
                                return;
                            }
                            w("onDialogEvent, hotspot dialog cancel");
                            return;
                        case 174:
                            if (i3 == 1101) {
                                w("onDialogEvent, goToAppDetailForResult");
                                WeakReference weakReference3 = c;
                                if (weakReference3 != null && (appCompatActivity5 = (AppCompatActivity) weakReference3.get()) != null) {
                                    StaticMethodUtilsKt.k(appCompatActivity5, i2);
                                    return;
                                }
                                return;
                            }
                            w("onDialogEvent, nearby devices dialog cancel");
                            return;
                        default:
                            return;
                    }
                } else if (i3 == 1101) {
                    r();
                } else if (i3 == 1102) {
                    v();
                }
            } else if (i3 == 1101) {
                w("onDialogEvent, goToAppDetailForResult");
                WeakReference weakReference4 = c;
                if (weakReference4 != null && (appCompatActivity2 = (AppCompatActivity) weakReference4.get()) != null) {
                    StaticMethodUtilsKt.k(appCompatActivity2, i2);
                }
            } else {
                w("onDialogEvent, location permission dialog cancel");
            }
        } else if (i3 == 1101) {
            w("onDialogEvent, openGpsSetting");
            WeakReference weakReference5 = c;
            if (weakReference5 != null && (appCompatActivity = (AppCompatActivity) weakReference5.get()) != null) {
                AppUtils.f7842a.k(appCompatActivity, i2);
            }
        } else {
            w("onDialogEvent, GPS dialog cancel");
        }
    }

    public final void B(Map map) {
        AppCompatActivity appCompatActivity;
        Intrinsics.checkNotNullParameter(map, "result");
        Boolean bool = (Boolean) map.get("android.permission.ACCESS_FINE_LOCATION");
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            StarUnicronUpdater starUnicronUpdater = b;
            starUnicronUpdater.w("onPermissionResult, has location permission: " + booleanValue);
            if (booleanValue) {
                starUnicronUpdater.r();
                return;
            }
            starUnicronUpdater.w("onPermissionResult, show location permission dialog");
            WeakReference weakReference = c;
            if (weakReference != null && (appCompatActivity = (AppCompatActivity) weakReference.get()) != null) {
                Intrinsics.checkNotNull(appCompatActivity);
                StaticMethodUtilsKt.z(appCompatActivity, CollectionsKt.arrayListOf(157), (HashMap) null, false, false);
            }
        }
    }

    public final void D(File file, GlassUpdateInfo glassUpdateInfo) {
        String latestVersion = glassUpdateInfo.getLatestVersion();
        if (latestVersion == null) {
            b.x("prepareTransferFile, latestVersion is null");
            return;
        }
        NetworkUtils networkUtils = NetworkUtils.f7898a;
        if (networkUtils.l() && !networkUtils.k()) {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            if (permissionAndStateCheckUtils.w() && !Intrinsics.areEqual((Object) permissionAndStateCheckUtils.x(), (Object) Boolean.FALSE) && permissionAndStateCheckUtils.B()) {
                w("prepareTransferFile, transferFile");
                L(file, glassUpdateInfo, true);
                return;
            }
        }
        if (Intrinsics.areEqual((Object) s(), (Object) latestVersion)) {
            w("prepareTransferFile, requestPermissionVersion is same with latestVersion");
            return;
        }
        WeakReference weakReference = c;
        AppCompatActivity appCompatActivity = weakReference != null ? (AppCompatActivity) weakReference.get() : null;
        if (appCompatActivity == null) {
            x("prepareTransferFile, currentActivity is null");
        } else if (GenericWindowManger.c.a().s()) {
            w("prepareTransferFile, windowShowing, return");
        } else {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            d = new UnicronUpdateConfig(absolutePath, glassUpdateInfo);
            w("prepareTransferFile, show permission dialog");
            StaticMethodUtilsKt.z(appCompatActivity, CollectionsKt.arrayListOf(170), (HashMap) null, false, false);
        }
    }

    public final void E() {
        w("release");
        c = null;
    }

    public final void H(String str, GlassUpdateInfo glassUpdateInfo, File file) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarUnicronUpdater$sendReceiveUpdateFileCmd$1(glassUpdateInfo, str, file, (Continuation<? super StarUnicronUpdater$sendReceiveUpdateFileCmd$1>) null), 3, (Object) null);
    }

    public final void I(String str) {
        MMKV.n().u("unicron._request_permission_version", str);
    }

    public final void K() {
        AppCompatActivity appCompatActivity;
        w("showUpdateTransferringDialog");
        WeakReference weakReference = c;
        if (weakReference != null && (appCompatActivity = (AppCompatActivity) weakReference.get()) != null) {
            StaticMethodUtilsKt.z(appCompatActivity, CollectionsKt.arrayListOf(171), (HashMap) null, false, false);
        }
    }

    public final void L(File file, GlassUpdateInfo glassUpdateInfo, boolean z) {
        Job job = i;
        if (job == null || !job.isActive()) {
            i = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarUnicronUpdater$transferFile$1(z, file, glassUpdateInfo, (Continuation<? super StarUnicronUpdater$transferFile$1>) null), 3, (Object) null);
            return;
        }
        w("transferFileJob.isActive, return");
    }

    public void a(File file, GlassUpdateInfo glassUpdateInfo, UnicronInfo unicronInfo) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        Intrinsics.checkNotNullParameter(unicronInfo, "unicronInfo");
        D(file, glassUpdateInfo);
    }

    public Object c(CheckUpdateFileReq checkUpdateFileReq, Continuation continuation) {
        return UnicronHelper.f(UnicronHelper.f7834a, checkUpdateFileReq, 0, continuation, 2, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7831a.getCoroutineContext();
    }

    public final void n(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        c = new WeakReference(appCompatActivity);
    }

    public final void p() {
        d = null;
    }

    public void q() {
        Job job = h;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = i;
        if (job2 != null) {
            Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
        }
        p();
    }

    public final void r() {
        GlassUpdateInfo updateInfo;
        String latestVersion;
        AppCompatActivity appCompatActivity;
        AppCompatActivity appCompatActivity2;
        AppCompatActivity appCompatActivity3;
        AppCompatActivity appCompatActivity4;
        AppCompatActivity appCompatActivity5;
        UnicronUpdateConfig unicronUpdateConfig = d;
        if (unicronUpdateConfig == null || (updateInfo = unicronUpdateConfig.getUpdateInfo()) == null || (latestVersion = updateInfo.getLatestVersion()) == null) {
            b.x("continuePermissionRequest, latestVersion is null");
            return;
        }
        w("continuePermissionRequest, latestVersion: " + latestVersion);
        I(latestVersion);
        NetworkUtils networkUtils = NetworkUtils.f7898a;
        if (!networkUtils.l()) {
            w("continuePermissionRequest, show wifi dialog");
            WeakReference weakReference = c;
            if (weakReference != null && (appCompatActivity5 = (AppCompatActivity) weakReference.get()) != null) {
                StaticMethodUtilsKt.z(appCompatActivity5, CollectionsKt.arrayListOf(172), (HashMap) null, false, false);
            }
        } else if (networkUtils.k()) {
            w("continuePermissionRequest, show hotspot dialog");
            WeakReference weakReference2 = c;
            if (weakReference2 != null && (appCompatActivity4 = (AppCompatActivity) weakReference2.get()) != null) {
                StaticMethodUtilsKt.z(appCompatActivity4, CollectionsKt.arrayListOf(173), (HashMap) null, false, false);
            }
        } else {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            if (!permissionAndStateCheckUtils.w()) {
                w("continuePermissionRequest, request location permission");
                WeakReference weakReference3 = c;
                if (weakReference3 != null && (appCompatActivity3 = (AppCompatActivity) weakReference3.get()) != null) {
                    ActivityExtKt.a(appCompatActivity3, StarUnicronUpdater$continuePermissionRequest$1.INSTANCE);
                }
            } else if (Intrinsics.areEqual((Object) permissionAndStateCheckUtils.x(), (Object) Boolean.FALSE)) {
                w("continuePermissionRequest, show nearby devices dialog");
                WeakReference weakReference4 = c;
                if (weakReference4 != null && (appCompatActivity2 = (AppCompatActivity) weakReference4.get()) != null) {
                    StaticMethodUtilsKt.z(appCompatActivity2, CollectionsKt.arrayListOf(174), (HashMap) null, false, false);
                }
            } else if (!permissionAndStateCheckUtils.B()) {
                w("continuePermissionRequest, show GPS dialog");
                WeakReference weakReference5 = c;
                if (weakReference5 != null && (appCompatActivity = (AppCompatActivity) weakReference5.get()) != null) {
                    StaticMethodUtilsKt.z(appCompatActivity, CollectionsKt.arrayListOf(Integer.valueOf(Opcodes.IFEQ)), (HashMap) null, false, false);
                }
            } else {
                UnicronUpdateConfig unicronUpdateConfig2 = d;
                if (unicronUpdateConfig2 == null) {
                    b.x("continuePermissionRequest, pendingUpdateConfig is null");
                    return;
                }
                K();
                M(this, new File(unicronUpdateConfig2.getFilePath()), unicronUpdateConfig2.getUpdateInfo(), false, 4, (Object) null);
                p();
            }
        }
    }

    public final String s() {
        return MMKV.n().j("unicron._request_permission_version");
    }

    public final void v() {
        GlassUpdateInfo updateInfo;
        String latestVersion;
        UnicronUpdateConfig unicronUpdateConfig = d;
        if (unicronUpdateConfig == null || (updateInfo = unicronUpdateConfig.getUpdateInfo()) == null || (latestVersion = updateInfo.getLatestVersion()) == null) {
            b.x("ignorePermissionRequest, latestVersion is null");
            return;
        }
        w("ignorePermissionRequest, latestVersion: " + latestVersion);
        I(latestVersion);
        p();
    }

    public final void y(int i2, int i3, Intent intent) {
        if (d == null) {
            x("onActivityResult, pendingUpdateConfig is null");
            return;
        }
        w("onActivityResult, requestCode: " + i2);
        if (i2 != 153) {
            if (i2 != 157) {
                switch (i2) {
                    case 172:
                        if (NetworkUtils.f7898a.l()) {
                            r();
                            return;
                        }
                        w("onActivityResult, isWifiEnabled=false");
                        p();
                        return;
                    case 173:
                        if (!NetworkUtils.f7898a.k()) {
                            r();
                            return;
                        }
                        w("onActivityResult, isWifiEnabled=true");
                        p();
                        return;
                    case 174:
                        if (Intrinsics.areEqual((Object) PermissionAndStateCheckUtils.f7907a.x(), (Object) Boolean.TRUE)) {
                            r();
                            return;
                        }
                        w("onActivityResult, hasNearbyWifiDevicesPermission!=true");
                        p();
                        return;
                    default:
                        return;
                }
            } else if (PermissionAndStateCheckUtils.f7907a.w()) {
                r();
            } else {
                w("onActivityResult, hasFineLocationPermission=false");
                p();
            }
        } else if (PermissionAndStateCheckUtils.f7907a.B()) {
            r();
        } else {
            w("onActivityResult, isGPSEnabled=false");
            p();
        }
    }
}

package com.upuphone.xr.sapp.unicron;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mmkv.MMKV;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.download.manager.DownloadManager;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.star.download.manager.Utils;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.common.ActivityLifecycleManager;
import com.upuphone.xr.sapp.common.ApplicationVisibilityCallback;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.entity.DownloadingUpdateConfig;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import java.io.File;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\f\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003Pfr\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH@¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J)\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0006\u0010\u001e\u001a\u00020\u001dH@¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010\u0003J\u0017\u0010)\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b)\u0010\u0016J\u0015\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\f2\u0006\u0010.\u001a\u00020$¢\u0006\u0004\b/\u0010'J\r\u00100\u001a\u00020\f¢\u0006\u0004\b0\u0010\u0003J\r\u00101\u001a\u00020\f¢\u0006\u0004\b1\u0010\u0003J\u001f\u00102\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020$¢\u0006\u0004\b5\u0010'J\u0015\u00106\u001a\u00020\f2\u0006\u00104\u001a\u00020$¢\u0006\u0004\b6\u0010'J\r\u00107\u001a\u00020\f¢\u0006\u0004\b7\u0010\u0003J\u001d\u0010;\u001a\u00020\f2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208¢\u0006\u0004\b;\u0010<J!\u0010?\u001a\u00020\f2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060=¢\u0006\u0004\b?\u0010@J'\u0010E\u001a\u00020\f2\u0006\u0010A\u001a\u0002082\u0006\u0010B\u001a\u0002082\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FR\u0016\u0010H\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u00100R\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0017\u0010O\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\bL\u0010J\u001a\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010JR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u001e\u0010e\u001a\f\u0012\b\u0012\u00060aj\u0002`b0`8\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010\\R\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010u\u001a\u00020r8\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010w\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bv\u0010\\R0\u0010~\u001a\b\u0012\u0004\u0012\u00020$0x2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020$0x8B@BX\u000e¢\u0006\f\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0017\u0010\u0001\u001a\u000208\u0016X\u0005¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/unicron/UnicronUpdateHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "", "y", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Z", "", "delayTime", "isForcible", "", "A", "(JZ)V", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "unicronInfo", "D", "(Lcom/upuphone/xr/sapp/entity/UnicronInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "a0", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "G", "Landroid/content/Context;", "context", "isFirstTime", "Y", "(Landroid/content/Context;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Z)V", "Ljava/io/File;", "file", "F", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "", "R", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "path", "v", "(Ljava/lang/String;)V", "E", "x", "Landroidx/appcompat/app/AppCompatActivity;", "lifecycleOwner", "w", "(Landroidx/appcompat/app/AppCompatActivity;)V", "bluetooth", "S", "I", "U", "V", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;J)V", "msg", "L", "M", "O", "", "windowType", "actionType", "P", "(II)V", "", "result", "Q", "(Ljava/util/Map;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "N", "(IILandroid/content/Intent;)V", "c", "downloadCount", "d", "Z", "needCheckUpdate", "e", "K", "()Z", "isFeatureEnable", "com/upuphone/xr/sapp/unicron/UnicronUpdateHelper$connectListener$1", "f", "Lcom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$connectListener$1;", "connectListener", "Lcom/upuphone/xr/sapp/entity/DownloadingUpdateConfig;", "g", "Lcom/upuphone/xr/sapp/entity/DownloadingUpdateConfig;", "downloadingUpdateConfig", "h", "isAppInitialized", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "checkUpdateJob", "j", "getRingVersiondateJob", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "k", "Ljava/util/concurrent/CopyOnWriteArraySet;", "networkPendingTasks", "com/upuphone/xr/sapp/unicron/UnicronUpdateHelper$networkCallback$1", "l", "Lcom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$networkCallback$1;", "networkCallback", "m", "checkUpdateAndSyncJob", "n", "J", "checkUpdateTime", "o", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "currentUnicronInfo", "com/upuphone/xr/sapp/unicron/UnicronUpdateHelper$innerDownloadListener$1", "p", "Lcom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$innerDownloadListener$1;", "innerDownloadListener", "q", "restartDownloadJob", "", "value", "H", "()Ljava/util/Set;", "X", "(Ljava/util/Set;)V", "downloadUpdateFiles", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUnicronUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 3 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,760:1\n17#2:761\n29#3,5:762\n29#3,5:767\n*S KotlinDebug\n*F\n+ 1 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper\n*L\n542#1:761\n658#1:762,5\n754#1:767,5\n*E\n"})
public final class UnicronUpdateHelper implements CoroutineScope {
    public static final UnicronUpdateHelper b;
    public static int c;
    public static volatile boolean d;
    public static final boolean e = (!SdkContext.f6675a.c().e());
    public static final UnicronUpdateHelper$connectListener$1 f;
    public static DownloadingUpdateConfig g;
    public static boolean h;
    public static Job i;
    public static Job j;
    public static final CopyOnWriteArraySet k = new CopyOnWriteArraySet();
    public static final UnicronUpdateHelper$networkCallback$1 l;
    public static Job m;
    public static long n;
    public static UnicronInfo o;
    public static final UnicronUpdateHelper$innerDownloadListener$1 p = new UnicronUpdateHelper$innerDownloadListener$1();
    public static Job q;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7836a = CoroutineScopeKt.b();

    static {
        UnicronUpdateHelper unicronUpdateHelper = new UnicronUpdateHelper();
        b = unicronUpdateHelper;
        UnicronUpdateHelper$connectListener$1 unicronUpdateHelper$connectListener$1 = new UnicronUpdateHelper$connectListener$1();
        f = unicronUpdateHelper$connectListener$1;
        UnicronUpdateHelper$networkCallback$1 unicronUpdateHelper$networkCallback$1 = new UnicronUpdateHelper$networkCallback$1();
        l = unicronUpdateHelper$networkCallback$1;
        unicronUpdateHelper.L("UnicronUpdateHelper#init");
        ActivityLifecycleManager.f6654a.e(new ApplicationVisibilityCallback() {
            public void a() {
                ULog.f6446a.a("UnicronUpdateHelper", "onApplicationVisible");
                UnicronUpdateHelper.B(UnicronUpdateHelper.b, 0, false, 3, (Object) null);
            }

            public void b() {
                ULog.f6446a.a("UnicronUpdateHelper", "onApplicationInvisible");
            }
        });
        GlassHelper.f7049a.l(unicronUpdateHelper$connectListener$1);
        UnicronHelper.f7834a.c(AnonymousClass2.INSTANCE);
        NetworkUtils.f7898a.o((LifecycleOwner) null, unicronUpdateHelper$networkCallback$1);
    }

    private final void A(long j2, boolean z) {
        if (!e) {
            L("checkUpdate, isFeatureEnable=false");
        } else if (h || z) {
            Job job = i;
            if (job == null || !job.isActive()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - n < 60000) {
                    d = true;
                    L("checkUpdate, time is not ready, return");
                    return;
                }
                n = elapsedRealtime;
                i = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new UnicronUpdateHelper$checkUpdate$1(j2, (Continuation<? super UnicronUpdateHelper$checkUpdate$1>) null), 3, (Object) null);
                return;
            }
            L("checkUpdateJob isActive, return");
        } else {
            L("checkUpdate, isAppInitialized=false, return");
        }
    }

    public static /* synthetic */ void B(UnicronUpdateHelper unicronUpdateHelper, long j2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 1000;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        unicronUpdateHelper.A(j2, z);
    }

    private final void E() {
        Job job = q;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.b(), (CoroutineStart) null, new UnicronUpdateHelper$clearUpdateData$1((Continuation<? super UnicronUpdateHelper$clearUpdateData$1>) null), 2, (Object) null);
        UnicronUpdateAdapter.f7835a.b();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object R(java.io.File r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$processUpdateFile$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$processUpdateFile$1 r0 = (com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$processUpdateFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$processUpdateFile$1 r0 = new com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$processUpdateFile$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$processUpdateFile$files$1 r1 = new com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$processUpdateFile$files$1
            r3 = 0
            r1.<init>(r5, r3)
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.g(r4, r1, r0)
            if (r4 != r6) goto L_0x0047
            return r6
        L_0x0047:
            java.util.List r4 = (java.util.List) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.R(java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void W(UnicronUpdateHelper unicronUpdateHelper, GlassUpdateInfo glassUpdateInfo, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 60000;
        }
        unicronUpdateHelper.V(glassUpdateInfo, j2);
    }

    public static /* synthetic */ void Z(UnicronUpdateHelper unicronUpdateHelper, Context context, GlassUpdateInfo glassUpdateInfo, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        unicronUpdateHelper.Y(context, glassUpdateInfo, z);
    }

    private final void x(GlassUpdateInfo glassUpdateInfo) {
        DownloadingUpdateConfig downloadingUpdateConfig = g;
        if (downloadingUpdateConfig == null) {
            return;
        }
        if (!Intrinsics.areEqual((Object) downloadingUpdateConfig.getGlassUpdateInfo().getLatestVersion(), (Object) glassUpdateInfo.getLatestVersion()) || !Intrinsics.areEqual((Object) downloadingUpdateConfig.getGlassUpdateInfo().getDigest(), (Object) glassUpdateInfo.getDigest())) {
            UnicronUpdateHelper unicronUpdateHelper = b;
            DownloadTask downloadTask = downloadingUpdateConfig.getDownloadTask();
            unicronUpdateHelper.L("cancelDownloadIfNotMatch, cancelDownload: " + downloadTask);
            DownloadManager.b.j(downloadingUpdateConfig.getDownloadTask(), true);
            g = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(com.upuphone.xr.sapp.entity.UnicronInfo r27, kotlin.coroutines.Continuation r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r2 = r28
            boolean r3 = r2 instanceof com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$checkUpdateAndSync$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$checkUpdateAndSync$1 r3 = (com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$checkUpdateAndSync$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$checkUpdateAndSync$1 r3 = new com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$checkUpdateAndSync$1
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x0052
            if (r5 == r7) goto L_0x0043
            if (r5 != r6) goto L_0x003b
            java.lang.Object r0 = r3.L$1
            com.upuphone.xr.sapp.entity.UnicronInfo r0 = (com.upuphone.xr.sapp.entity.UnicronInfo) r0
            java.lang.Object r1 = r3.L$0
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r1 = (com.upuphone.xr.sapp.unicron.UnicronUpdateHelper) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x011d
        L_0x003b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0043:
            java.lang.Object r0 = r3.L$1
            com.upuphone.xr.sapp.entity.UnicronInfo r0 = (com.upuphone.xr.sapp.entity.UnicronInfo) r0
            java.lang.Object r1 = r3.L$0
            com.upuphone.xr.sapp.unicron.UnicronUpdateHelper r1 = (com.upuphone.xr.sapp.unicron.UnicronUpdateHelper) r1
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ Exception -> 0x004f }
            goto L_0x009f
        L_0x004f:
            r0 = move-exception
            goto L_0x0156
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r2)
            com.upuphone.xr.sapp.utils.ControlUtils r2 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            r2.f0(r0)
            boolean r2 = e
            if (r2 != 0) goto L_0x0066
            java.lang.String r0 = "checkUpdateAndSync, isFeatureEnable=false"
            r1.L(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0066:
            boolean r2 = h
            if (r2 != 0) goto L_0x0072
            java.lang.String r0 = "checkUpdateAndSync, isAppInitialized=false, return"
            r1.L(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0072:
            com.upuphone.xr.sapp.glass.GlassHelper r2 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r2 = r2.y()
            if (r2 != 0) goto L_0x0082
            java.lang.String r0 = "checkUpdateAndSync, connectedGlass is null"
            r1.L(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0082:
            boolean r2 = r1.y(r2)
            if (r2 != 0) goto L_0x0090
            java.lang.String r0 = "checkUpdateAndSync, isGlassSupportUnicronUpdate=false"
            r1.L(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0090:
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r2 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b     // Catch:{ Exception -> 0x004f }
            r3.L$0 = r1     // Catch:{ Exception -> 0x004f }
            r3.L$1 = r0     // Catch:{ Exception -> 0x004f }
            r3.label = r7     // Catch:{ Exception -> 0x004f }
            java.lang.Object r2 = r2.s0(r3)     // Catch:{ Exception -> 0x004f }
            if (r2 != r4) goto L_0x009f
            return r4
        L_0x009f:
            com.upuphone.xr.sapp.entity.BasicGlassInfo r2 = (com.upuphone.xr.sapp.entity.BasicGlassInfo) r2     // Catch:{ Exception -> 0x004f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "checkUpdateAndSync, glassInfo: "
            r5.append(r8)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r1.L(r5)
            if (r2 != 0) goto L_0x00ba
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00ba:
            com.upuphone.xr.sapp.utils.DataTrackUtil r5 = com.upuphone.xr.sapp.utils.DataTrackUtil.f7875a
            java.lang.String r8 = r0.getDeviceId()
            java.lang.String r5 = r5.f(r8)
            r11 = r5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "checkUpdateAndSync, deviceIdEncrypted: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = ", deviceId: "
            r8.append(r7)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r1.L(r5)
            com.upuphone.star.fota.phone.GlassUpdateApiManager r5 = com.upuphone.star.fota.phone.GlassUpdateApiManager.f6471a
            java.lang.String r12 = r0.getVersion()
            java.lang.String r13 = r0.getModel()
            long r16 = java.lang.System.currentTimeMillis()
            java.lang.String r21 = r2.getRomVersion()
            java.lang.String r20 = r2.getModel()
            com.upuphone.star.fota.phone.CheckGlassUpdateParamV2 r2 = new com.upuphone.star.fota.phone.CheckGlassUpdateParamV2
            r9 = r2
            r24 = 4096(0x1000, float:5.74E-42)
            r25 = 0
            java.lang.String r10 = "Ring"
            java.lang.String r14 = "user"
            java.lang.String r15 = "release"
            r18 = 0
            java.lang.String r19 = "2.40.51"
            r22 = 1
            r23 = 0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25)
            r3.L$0 = r1
            r3.L$1 = r0
            r3.label = r6
            java.lang.Object r2 = r5.d(r2, r3)
            if (r2 != r4) goto L_0x011d
            return r4
        L_0x011d:
            com.upuphone.star.fota.phone.GlassCheckUpdateResult r2 = (com.upuphone.star.fota.phone.GlassCheckUpdateResult) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "checkUpdateAndSync, updateResult: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r1.L(r3)
            com.upuphone.star.fota.phone.GlassUpdateInfo r2 = com.upuphone.star.fota.phone.GlassCheckUpdateResultKt.a(r2)
            if (r2 != 0) goto L_0x0141
            java.lang.String r0 = "checkUpdateAndSync, updateInfo is null"
            r1.M(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0141:
            o = r0
            boolean r0 = r2.getExistsUpdate()
            if (r0 == 0) goto L_0x014d
            r1.G(r2)
            goto L_0x0153
        L_0x014d:
            r1.a0(r2)
            r1.E()
        L_0x0153:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0156:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "checkUpdateAndSync, getGlassInfo error: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.M(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.unicron.UnicronUpdateHelper.D(com.upuphone.xr.sapp.entity.UnicronInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void F(File file, GlassUpdateInfo glassUpdateInfo) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new UnicronUpdateHelper$downloadCompleted$1(file, glassUpdateInfo, (Continuation<? super UnicronUpdateHelper$downloadCompleted$1>) null), 3, (Object) null);
    }

    public final void G(GlassUpdateInfo glassUpdateInfo) {
        if (!e) {
            L("downloadPreCheck, isFeatureEnable=false");
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new UnicronUpdateHelper$downloadPreCheck$1(glassUpdateInfo, (Continuation<? super UnicronUpdateHelper$downloadPreCheck$1>) null), 3, (Object) null);
    }

    public final Set H() {
        Object obj;
        JsonUtils jsonUtils = JsonUtils.f7893a;
        String j2 = MMKV.n().j("unicron._update_files");
        Type type = new UnicronUpdateHelper$special$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(j2, type);
        }
        Set set = (Set) obj;
        return set == null ? SetsKt.emptySet() : set;
    }

    public final void I() {
        if (!e) {
            L("getRingVersion, isFeatureEnable=false");
            return;
        }
        Job job = j;
        if (job == null || !job.isActive()) {
            j = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new UnicronUpdateHelper$getRingVersion$1((Continuation<? super UnicronUpdateHelper$getRingVersion$1>) null), 3, (Object) null);
            return;
        }
        L("getRingVersiondateJob.isActive=true, return");
    }

    public final boolean K() {
        return e;
    }

    public final void L(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ULog.f6446a.a("UnicronUpdateHelper", str);
    }

    public final void M(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ULog.f6446a.c("UnicronUpdateHelper", str);
    }

    public final void N(int i2, int i3, Intent intent) {
        StarUnicronUpdater.b.y(i2, i3, intent);
    }

    public final void O() {
        L("onAppInitialized");
        h = true;
        B(this, 0, false, 3, (Object) null);
    }

    public final void P(int i2, int i3) {
        StarUnicronUpdater.b.A(i2, i3);
    }

    public final void Q(Map map) {
        Intrinsics.checkNotNullParameter(map, "result");
        StarUnicronUpdater.b.B(map);
    }

    public final void S(String str) {
        Intrinsics.checkNotNullParameter(str, "bluetooth");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new UnicronUpdateHelper$refreshUnicronInfo$1(str, (Continuation<? super UnicronUpdateHelper$refreshUnicronInfo$1>) null), 3, (Object) null);
    }

    public final void U() {
        ULog.f6446a.a("UnicronUpdateHelper", "release");
        StarUnicronUpdater.b.E();
    }

    public final void V(GlassUpdateInfo glassUpdateInfo, long j2) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        int i2 = c;
        if (i2 > 3) {
            L("restartDownload, reach max count: " + i2);
            return;
        }
        Job job = q;
        if (job == null || !job.isActive()) {
            q = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new UnicronUpdateHelper$restartDownload$1(j2, glassUpdateInfo, (Continuation<? super UnicronUpdateHelper$restartDownload$1>) null), 3, (Object) null);
            return;
        }
        L("restartDownloadJob.isActive, return");
    }

    public final void X(Set set) {
        MMKV.n().u("unicron._update_files", JsonUtils.f7893a.d(set));
    }

    public final void Y(Context context, GlassUpdateInfo glassUpdateInfo, boolean z) {
        boolean z2;
        if (z) {
            c = 0;
        }
        String packLink = glassUpdateInfo.getPackLink();
        String digest = glassUpdateInfo.getDigest();
        if (packLink == null || packLink.length() == 0 || digest == null || digest.length() == 0) {
            M("startDownload, GlassUpdateInfo.packLink is empty");
            return;
        }
        int i2 = c;
        if (i2 > 3) {
            L("startDownload, reach max count: " + i2);
        } else if (!NetworkUtils.f7898a.g()) {
            M("startDownload, hasNetwork = false, retry later");
            k.add(new UnicronUpdateHelper$startDownload$$inlined$Runnable$1(glassUpdateInfo));
        } else {
            Long fileSize = glassUpdateInfo.getFileSize();
            if (fileSize != null) {
                z2 = fileSize.longValue() > 10485760;
            } else {
                z2 = false;
            }
            if (z2) {
                L("startDownload, update file too big: " + glassUpdateInfo.getFileSize());
            }
            int i3 = c + 1;
            c = i3;
            L("startDownload, downloadCount: " + i3);
            x(glassUpdateInfo);
            g = new DownloadingUpdateConfig(DownloadManager.t(DownloadManager.b, packLink, Utils.f6462a.a(context, "unicron_ota", digest + ".zip"), z2, 0, 0, p, 24, (Object) null), glassUpdateInfo, false, true);
        }
    }

    public final void a0(GlassUpdateInfo glassUpdateInfo) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new UnicronUpdateHelper$syncUnicronUpdateInfo$1(glassUpdateInfo, (Continuation<? super UnicronUpdateHelper$syncUnicronUpdateInfo$1>) null), 3, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7836a.getCoroutineContext();
    }

    public final void v(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(H());
        linkedHashSet.add(str);
        X(linkedHashSet);
    }

    public final void w(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "lifecycleOwner");
        StarUnicronUpdater.b.n(appCompatActivity);
        appCompatActivity.getLifecycle().a(new UnicronUpdateHelper$bindLifecycle$1());
    }

    public final boolean y(StarryNetDevice starryNetDevice) {
        Integer num = (Integer) SdkContext.f6675a.e().c().getValue();
        boolean I = AirHelper.b.I(starryNetDevice);
        L("checkGlassSupportUnicronUpdate, peerVersion: " + num + ", isAirGlass: " + I);
        return num != null && num.intValue() >= (I ? 5 : 1);
    }
}

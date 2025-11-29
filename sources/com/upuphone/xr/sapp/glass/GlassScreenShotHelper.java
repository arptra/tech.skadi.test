package com.upuphone.xr.sapp.glass;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.honey.account.i8.d;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.StarryNet;
import com.upuphone.starrynetsdk.ability.share.ShareAbility;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.GlassScreenShotState;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.joor.Reflect;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002LP\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0003J#\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH@¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\b¢\u0006\u0004\b&\u0010\u0003R\u0018\u0010)\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u000204088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040B8\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001b\u0010K\u001a\u00020F8BX\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0011\u0010Z\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bX\u0010Y¨\u0006["}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassScreenShotHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "taskId", "", "progress", "", "G", "(Ljava/lang/String;I)V", "D", "w", "errorCode", "H", "Landroid/net/Uri;", "srcUri", "L", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "useEncoding", "K", "(Landroid/net/Uri;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "x", "B", "(I)V", "", "input", "I", "([B)[B", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "v", "(Landroidx/appcompat/app/AppCompatActivity;)V", "", "timeout", "M", "(J)V", "O", "c", "Landroid/net/Uri;", "latestUri", "d", "Ljava/lang/String;", "pendingTaskId", "e", "Ljava/lang/Boolean;", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "screenshotJob", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/xr/sapp/entity/GlassScreenShotState;", "g", "Landroidx/lifecycle/MutableLiveData;", "_screenShotState", "Landroidx/lifecycle/LiveData;", "h", "Landroidx/lifecycle/LiveData;", "y", "()Landroidx/lifecycle/LiveData;", "screenShotState", "Ljava/lang/ref/WeakReference;", "i", "Ljava/lang/ref/WeakReference;", "activityReference", "Ljava/util/concurrent/CopyOnWriteArraySet;", "j", "Ljava/util/concurrent/CopyOnWriteArraySet;", "pendingTaskIdSet", "Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "k", "Lkotlin/Lazy;", "A", "()Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "shareAbility", "com/upuphone/xr/sapp/glass/GlassScreenShotHelper$filterShareListener$1", "l", "Lcom/upuphone/xr/sapp/glass/GlassScreenShotHelper$filterShareListener$1;", "filterShareListener", "com/upuphone/xr/sapp/glass/GlassScreenShotHelper$deviceConnectListener$1", "m", "Lcom/upuphone/xr/sapp/glass/GlassScreenShotHelper$deviceConnectListener$1;", "deviceConnectListener", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "F", "()Z", "isRunning", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassScreenShotHelper implements CoroutineScope {
    public static final GlassScreenShotHelper b;
    public static volatile Uri c;
    public static String d;
    public static Boolean e;
    public static Job f;
    public static final MutableLiveData g;
    public static final LiveData h;
    public static WeakReference i;
    public static final CopyOnWriteArraySet j = new CopyOnWriteArraySet();
    public static final Lazy k = LazyKt.lazy(GlassScreenShotHelper$shareAbility$2.INSTANCE);
    public static final GlassScreenShotHelper$filterShareListener$1 l = new GlassScreenShotHelper$filterShareListener$1();
    public static final GlassScreenShotHelper$deviceConnectListener$1 m;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7060a = CoroutineScopeKt.b();

    static {
        GlassScreenShotHelper glassScreenShotHelper = new GlassScreenShotHelper();
        b = glassScreenShotHelper;
        MutableLiveData mutableLiveData = new MutableLiveData(GlassScreenShotState.Idle.INSTANCE);
        g = mutableLiveData;
        h = mutableLiveData;
        GlassScreenShotHelper$deviceConnectListener$1 glassScreenShotHelper$deviceConnectListener$1 = new GlassScreenShotHelper$deviceConnectListener$1();
        m = glassScreenShotHelper$deviceConnectListener$1;
        glassScreenShotHelper.D();
        GlassHelper.f7049a.l(glassScreenShotHelper$deviceConnectListener$1);
    }

    private final ShareAbility A() {
        return (ShareAbility) k.getValue();
    }

    public static final void E() {
        String str;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "StarryNet onInstalled, initShareAbility");
        GlassScreenShotHelper glassScreenShotHelper = b;
        ShareAbility A = glassScreenShotHelper.A();
        GlassScreenShotHelper$filterShareListener$1 glassScreenShotHelper$filterShareListener$1 = l;
        int unregisterReceiveListener = A.unregisterReceiveListener(glassScreenShotHelper$filterShareListener$1);
        delegate.a("GlassScreenShotHelper", "unregisterReceiveListener code: " + unregisterReceiveListener);
        int registerReceiveListener = A.registerReceiveListener(glassScreenShotHelper$filterShareListener$1);
        delegate.a("GlassScreenShotHelper", "registerReceiveListener code: " + registerReceiveListener);
        try {
            str = (String) Reflect.p(glassScreenShotHelper.A()).l(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("GlassScreenShotHelper", "shareAbility.packageName error: " + e2);
            str = null;
        }
        ULog.Delegate delegate3 = ULog.f6446a;
        delegate3.a("GlassScreenShotHelper", "shareAbility.packageName=" + str);
    }

    public static /* synthetic */ void N(GlassScreenShotHelper glassScreenShotHelper, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 5000;
        }
        glassScreenShotHelper.M(j2);
    }

    /* access modifiers changed from: private */
    public final void x() {
        ULog.f6446a.a("GlassScreenShotHelper", "clear");
        g.postValue(GlassScreenShotState.Idle.INSTANCE);
        Job job = f;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        d = null;
        e = null;
    }

    public final void B(int i2) {
        AppCompatActivity appCompatActivity;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "handleScreenShotResult, errorCode: " + i2);
        WeakReference weakReference = i;
        if (weakReference == null || (appCompatActivity = (AppCompatActivity) weakReference.get()) == null) {
            delegate.c("GlassScreenShotHelper", "handleScreenShotResult, activity is null");
        } else if (i2 == 0) {
            if (!((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "SCREEN_SHOT_SAVED", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
                Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(appCompatActivity), (CoroutineContext) null, (CoroutineStart) null, new GlassScreenShotHelper$handleScreenShotResult$1(appCompatActivity, (Continuation<? super GlassScreenShotHelper$handleScreenShotResult$1>) null), 3, (Object) null);
            }
        } else if (i2 == -1) {
            ContextExtKt.e(R.string.screenshot_failed, 0, 2, (Object) null);
        } else if (i2 != 999) {
            switch (i2) {
                case 201:
                    ContextExtKt.e(R.string.please_light_up_glass, 0, 2, (Object) null);
                    return;
                case 202:
                    ContextExtKt.e(R.string.scence_disallow_screenshot, 0, 2, (Object) null);
                    return;
                case 203:
                    ContextExtKt.e(R.string.glass_memory_is_not_enough, 0, 2, (Object) null);
                    return;
                default:
                    ContextExtKt.e(R.string.screenshot_failed, 0, 2, (Object) null);
                    return;
            }
        } else {
            ContextExtKt.e(R.string.screenshot_failed, 0, 2, (Object) null);
        }
    }

    public final void D() {
        StarryNet.getInstance().registerInstallListener(new d());
    }

    public final boolean F() {
        return h.getValue() instanceof GlassScreenShotState.Running;
    }

    public final void G(String str, int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "notifyProgress, taskId: " + str + ", progress: " + i2);
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassScreenShotHelper$notifyProgress$1(str, i2, (Continuation<? super GlassScreenShotHelper$notifyProgress$1>) null), 3, (Object) null);
    }

    public final void H(String str, int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "notifyResult, taskId: " + str + ", code: " + i2);
        if (F()) {
            Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassScreenShotHelper$notifyResult$1(i2, (Continuation<? super GlassScreenShotHelper$notifyResult$1>) null), 3, (Object) null);
        }
    }

    public final byte[] I(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < bArr.length; i2 += 2) {
            byte b2 = bArr[i2];
            byte r3 = UByte.m38constructorimpl(bArr[i2 + 1]) & 255;
            for (int i3 = 0; i3 < r3; i3++) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    public final Object K(Uri uri, boolean z, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new GlassScreenShotHelper$saveG4ToAlbum$2(uri, z, (Continuation<? super GlassScreenShotHelper$saveG4ToAlbum$2>) null), continuation);
    }

    public final Object L(Uri uri, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new GlassScreenShotHelper$saveToAlbum$2(uri, (Continuation<? super GlassScreenShotHelper$saveToAlbum$2>) null), continuation);
    }

    public final void M(long j2) {
        Job job = f;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        f = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassScreenShotHelper$startScreenShot$1(j2, (Continuation<? super GlassScreenShotHelper$startScreenShot$1>) null), 3, (Object) null);
    }

    public final void O() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassScreenShotHelper", "stopScreenShot");
        String str = d;
        if (str != null) {
            try {
                int cancel = A().cancel(str, 3);
                delegate.a("GlassScreenShotHelper", "stopScreenShot, cancel taskId: " + str + ", result: " + cancel);
            } catch (Exception e2) {
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.d("GlassScreenShotHelper", "stopScreenShot, cancel taskId: " + str + ", error: ", e2);
            } catch (Throwable th) {
                x();
                throw th;
            }
            x();
        }
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7060a.getCoroutineContext();
    }

    public final void v(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        i = new WeakReference(appCompatActivity);
    }

    public final void w() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean F = F();
        String str = d;
        delegate.a("GlassScreenShotHelper", "checkShouldConfirmTask, isRunning: " + F + ", pendingTaskId: " + str);
        String str2 = d;
        if (str2 != null) {
            if (!F() || !j.contains(str2)) {
                delegate.a("GlassScreenShotHelper", "checkShouldConfirmTask, ignore");
                return;
            }
            int confirm = A().confirm(str2);
            delegate.a("GlassScreenShotHelper", "checkShouldConfirmTask, confirm code: " + confirm);
            if (confirm != 0) {
                H(str2, 999);
            }
        }
    }

    public final LiveData y() {
        return h;
    }
}

package com.upuphone.xr.sapp.vu.utils;

import android.os.SystemClock;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesActiveHelper;", "", "<init>", "()V", "", "h", "g", "j", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "deviceInfo", "i", "(Lcom/upuphone/xr/sapp/entity/DeviceInfo;)V", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/Job;", "c", "Lkotlinx/coroutines/Job;", "checkActiveJob", "d", "cancelActiveJob", "", "e", "J", "startCheckTime", "", "f", "Z", "reportWhenUsbOpened", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesActiveHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassesActiveHelper f8097a = new VuGlassesActiveHelper();
    public static final CoroutineScope b = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public static Job c;
    public static Job d;
    public static long e;
    public static boolean f;

    public final void g() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActiveHelper", "cancelCheckActive");
        Job job = c;
        if (job == null || !job.isActive()) {
            delegate.a("VuGlassesActiveHelper", "cancelCheckActive not active");
            return;
        }
        delegate.a("VuGlassesActiveHelper", "wait cancelCheckActive");
        d = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new VuGlassesActiveHelper$cancelCheckActive$1((Continuation<? super VuGlassesActiveHelper$cancelCheckActive$1>) null), 3, (Object) null);
    }

    public final void h() {
        Job job = d;
        if (job != null && job.isActive()) {
            Job job2 = d;
            if (job2 != null) {
                Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
            }
            d = null;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesActiveHelper", "start checkActive");
        Job job3 = c;
        if (job3 == null || !job3.isActive()) {
            c = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new VuGlassesActiveHelper$checkActive$1((Continuation<? super VuGlassesActiveHelper$checkActive$1>) null), 3, (Object) null);
        } else {
            delegate.a("VuGlassesActiveHelper", "checkActive task running");
        }
    }

    public final void i(DeviceInfo deviceInfo) {
        GlassDataStoreHelper glassDataStoreHelper = GlassDataStoreHelper.f8091a;
        String serialNo = deviceInfo.getSerialNo();
        Intrinsics.checkNotNull(serialNo);
        if (glassDataStoreHelper.g(serialNo)) {
            ULog.f6446a.a("VuGlassesActiveHelper", "already report");
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - e >= 300000) {
            ULog.f6446a.a("VuGlassesActiveHelper", "report active");
            glassDataStoreHelper.l(deviceInfo.getSerialNo());
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            if (bool.booleanValue()) {
                DataTrackUtil.f7875a.t(deviceInfo, uptimeMillis, System.currentTimeMillis());
                return;
            }
            DataTrackUtil.f7875a.v(deviceInfo, uptimeMillis, System.currentTimeMillis());
        }
    }

    public final void j() {
        if (f) {
            DeviceInfo d2 = VuGlassesDeviceInfoModel.f8112a.d();
            String serialNo = d2.getSerialNo();
            if (serialNo == null || serialNo.length() == 0) {
                ULog.f6446a.a("VuGlassesActiveHelper", "report active sn is null");
                return;
            }
            i(d2);
            f = false;
        }
    }
}

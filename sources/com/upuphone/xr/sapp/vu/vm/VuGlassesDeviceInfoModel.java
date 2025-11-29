package com.upuphone.xr.sapp.vu.vm;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.JsonUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010R\u001f\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesDeviceInfoModel;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "d", "()Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "c", "", "f", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "_deviceInfo", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "deviceInfo", "", "e", "version", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesDeviceInfoModel {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassesDeviceInfoModel f8112a = new VuGlassesDeviceInfoModel();
    public static final MutableLiveData b;
    public static final LiveData c;
    public static final LiveData d;
    public static final CoroutineScope e = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    static {
        MutableLiveData mutableLiveData = new MutableLiveData();
        b = mutableLiveData;
        c = mutableLiveData;
        d = Transformations.a(Transformations.c(mutableLiveData, VuGlassesDeviceInfoModel$version$1.INSTANCE));
    }

    public final LiveData b() {
        return c;
    }

    public final DeviceInfo c() {
        return (DeviceInfo) c.getValue();
    }

    public final DeviceInfo d() {
        DeviceInfo deviceInfo = (DeviceInfo) JsonUtils.f7893a.a((String) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_vu_device_info", "", (Context) null, 4, (Object) null), DeviceInfo.class);
        return deviceInfo == null ? new DeviceInfo("View glasses", "XJ", "", "XJ", "", "", "", "", "1.0.0.0") : deviceInfo;
    }

    public final LiveData e() {
        return d;
    }

    public final void f() {
        Job unused = BuildersKt__Builders_commonKt.d(e, (CoroutineContext) null, (CoroutineStart) null, new VuGlassesDeviceInfoModel$updateDeviceInfo$1((Continuation<? super VuGlassesDeviceInfoModel$updateDeviceInfo$1>) null), 3, (Object) null);
    }
}

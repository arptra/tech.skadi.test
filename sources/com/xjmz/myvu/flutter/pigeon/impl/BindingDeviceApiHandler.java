package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/BindingDeviceApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$BindingDeviceApi;", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Result;", "", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$BindingDeviceItem;", "result", "", "c", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Result;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$BindingDeviceType;", "type", "", "k", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$BindingDeviceType;Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Result;)V", "d", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "l", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Z", "m", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class BindingDeviceApiHandler implements AndroidBindingDeviceApi.BindingDeviceApi {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8346a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/BindingDeviceApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void c(AndroidBindingDeviceApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.f6446a.g("BindingDeviceApiHandler", "getBindingDevices");
        ArrayList arrayList = new ArrayList();
        StarryNetDevice a2 = ConnectExtKt.a();
        AndroidBindingDeviceApi.BindingDeviceItem a3 = new AndroidBindingDeviceApi.BindingDeviceItem.Builder().c(AndroidBindingDeviceApi.BindingDeviceType.MYVU_GLASS).b(l(a2) ? AndroidBindingDeviceApi.BindingDeviceStatus.BOUND : AndroidBindingDeviceApi.BindingDeviceStatus.NOT_BOUND).a();
        Intrinsics.checkNotNullExpressionValue(a3, "build(...)");
        arrayList.add(a3);
        AndroidBindingDeviceApi.BindingDeviceItem.Builder c = new AndroidBindingDeviceApi.BindingDeviceItem.Builder().c(AndroidBindingDeviceApi.BindingDeviceType.VIEW_GLASS);
        AndroidBindingDeviceApi.BindingDeviceStatus bindingDeviceStatus = AndroidBindingDeviceApi.BindingDeviceStatus.NONE;
        AndroidBindingDeviceApi.BindingDeviceItem a4 = c.b(bindingDeviceStatus).a();
        Intrinsics.checkNotNullExpressionValue(a4, "build(...)");
        arrayList.add(a4);
        AndroidBindingDeviceApi.BindingDeviceItem a5 = new AndroidBindingDeviceApi.BindingDeviceItem.Builder().c(AndroidBindingDeviceApi.BindingDeviceType.RING2).b(m(a2) ? AndroidBindingDeviceApi.BindingDeviceStatus.BOUND : AndroidBindingDeviceApi.BindingDeviceStatus.NOT_BOUND).a();
        Intrinsics.checkNotNullExpressionValue(a5, "build(...)");
        arrayList.add(a5);
        AndroidBindingDeviceApi.BindingDeviceItem a6 = new AndroidBindingDeviceApi.BindingDeviceItem.Builder().c(AndroidBindingDeviceApi.BindingDeviceType.RING1).b(bindingDeviceStatus).a();
        Intrinsics.checkNotNullExpressionValue(a6, "build(...)");
        arrayList.add(a6);
        result.success(arrayList);
    }

    public void d(AndroidBindingDeviceApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("BindingDeviceApiHandler", "checkBluetoothStateAndNecessaryPermission");
        MYVUActivity r = MainApplication.k.f().r();
        if (r == null) {
            delegate.c("BindingDeviceApiHandler", "checkBluetoothStateAndNecessaryPermission, getMYVUActivity is null");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(r), (CoroutineContext) null, (CoroutineStart) null, new BindingDeviceApiHandler$checkBluetoothStateAndNecessaryPermission$1(r, result, (Continuation<? super BindingDeviceApiHandler$checkBluetoothStateAndNecessaryPermission$1>) null), 3, (Object) null);
        }
    }

    public void k(AndroidBindingDeviceApi.BindingDeviceType bindingDeviceType, AndroidBindingDeviceApi.Result result) {
        Intrinsics.checkNotNullParameter(bindingDeviceType, "type");
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("BindingDeviceApiHandler", "checkStateAndPermission, type: " + bindingDeviceType);
        MYVUActivity r = MainApplication.k.f().r();
        if (r == null) {
            delegate.c("BindingDeviceApiHandler", "checkStateAndPermission, type: " + bindingDeviceType + ", getMYVUActivity is null");
        } else if (bindingDeviceType == AndroidBindingDeviceApi.BindingDeviceType.MYVU_GLASS) {
            if (VuGlassControlModel.f8109a.z()) {
                delegate.a("BindingDeviceApiHandler", "MYVU_GLASS checkStateAndPermission view glasses isConnect");
                UToast.Companion companion = UToast.f6444a;
                String string = r.getString(R.string.unplugin_view_tip);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(r, string);
                result.success(Boolean.FALSE);
                return;
            }
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(r), (CoroutineContext) null, (CoroutineStart) null, new BindingDeviceApiHandler$checkStateAndPermission$1(r, result, (Continuation<? super BindingDeviceApiHandler$checkStateAndPermission$1>) null), 3, (Object) null);
        } else if (bindingDeviceType == AndroidBindingDeviceApi.BindingDeviceType.RING2) {
            Job unused2 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(r), (CoroutineContext) null, (CoroutineStart) null, new BindingDeviceApiHandler$checkStateAndPermission$2(r, result, (Continuation<? super BindingDeviceApiHandler$checkStateAndPermission$2>) null), 3, (Object) null);
        } else {
            delegate.c("BindingDeviceApiHandler", "checkStateAndPermission, unsupported type: " + bindingDeviceType);
            result.success(Boolean.FALSE);
        }
    }

    public final boolean l(StarryNetDevice starryNetDevice) {
        return starryNetDevice != null && !m(starryNetDevice);
    }

    public final boolean m(StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null) {
            String modelId = starryNetDevice.getModelId();
            Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
            if (Intrinsics.areEqual((Object) ConnectExtKt.o(modelId), (Object) "ring2")) {
                return true;
            }
        }
        return false;
    }
}

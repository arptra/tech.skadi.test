package com.upuphone.xr.sapp.utils;

import android.content.Context;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00078\u0002XD¢\u0006\u0006\n\u0004\b\u0005\u0010\rR(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DeviceCaptifyHelper;", "", "<init>", "()V", "", "b", "()Z", "", "deviceId", "", "d", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "TAG", "Lkotlinx/coroutines/flow/MutableStateFlow;", "c", "Lkotlinx/coroutines/flow/MutableStateFlow;", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setCaptifyDeviceFlow", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "isCaptifyDeviceFlow", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDeviceCaptifyHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceCaptifyHelper.kt\ncom/upuphone/xr/sapp/utils/DeviceCaptifyHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n288#2,2:76\n*S KotlinDebug\n*F\n+ 1 DeviceCaptifyHelper.kt\ncom/upuphone/xr/sapp/utils/DeviceCaptifyHelper\n*L\n51#1:76,2\n*E\n"})
public final class DeviceCaptifyHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final DeviceCaptifyHelper f7877a = new DeviceCaptifyHelper();
    public static final String b = "CAPTIFY_TAG";
    public static MutableStateFlow c = StateFlowKt.a(Boolean.FALSE);

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        DataStoreUtils a2 = DataStoreUtils.e.a();
        a2.p("captify_KEY_" + str, Boolean.FALSE, true);
    }

    public final boolean b() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public final MutableStateFlow c() {
        return c;
    }

    public final void d(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Iterator it = ConnectExtKt.b().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            AndroidConnectApi.DeviceInfo deviceInfo = (AndroidConnectApi.DeviceInfo) obj;
            if (Intrinsics.areEqual((Object) deviceInfo.d(), (Object) "air_intl") && Intrinsics.areEqual((Object) str, (Object) deviceInfo.b())) {
                break;
            }
        }
        AndroidConnectApi.DeviceInfo deviceInfo2 = (AndroidConnectApi.DeviceInfo) obj;
        boolean z = false;
        if (deviceInfo2 != null) {
            if (((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "captify_KEY_" + deviceInfo2.b(), Boolean.FALSE, true, (Context) null, 8, (Object) null)).booleanValue()) {
                z = true;
            }
        }
        ULog.f6446a.a(b, "onSelectDevice DeviceFlow old:" + c.getValue() + " new" + z);
        if (((Boolean) c.getValue()).booleanValue() != z) {
            c.setValue(Boolean.valueOf(z));
        }
    }
}

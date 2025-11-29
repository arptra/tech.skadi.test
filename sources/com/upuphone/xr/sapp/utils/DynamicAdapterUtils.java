package com.upuphone.xr.sapp.utils;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DynamicAdapterUtils;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "model", "", "deviceId", "", "c", "(Lcom/upuphone/xr/sapp/vm/DeviceControlModel;Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "fileName", "b", "(Ljava/lang/String;)Ljava/lang/String;", "modelId", "d", "(Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DynamicAdapterUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final DynamicAdapterUtils f7879a = new DynamicAdapterUtils();

    public final String a() {
        return (String) DataStoreUtils.i(DataStoreUtils.e.a(), "connect_model_id", "1003", (Context) null, 4, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r0 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            android.content.res.AssetManager r0 = r0.getAssets()
            java.io.InputStream r3 = r0.open(r3)
            java.lang.String r0 = "open(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r3)
            r0.<init>(r1)
        L_0x0020:
            java.lang.String r3 = r0.readLine()     // Catch:{ all -> 0x0037 }
            if (r3 != 0) goto L_0x0039
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        L_0x0037:
            r2 = move-exception
            goto L_0x0040
        L_0x0039:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x0037 }
            r2.append(r3)     // Catch:{ all -> 0x0037 }
            goto L_0x0020
        L_0x0040:
            throw r2     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.DynamicAdapterUtils.b(java.lang.String):java.lang.String");
    }

    public final void c(DeviceControlModel deviceControlModel, String str) {
        Intrinsics.checkNotNullParameter(deviceControlModel, "model");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DynamicAdapterUtils", "deviceId: " + str);
        String deviceInfo = InterconnectManager.getInstance().getStarryNetDeviceManager().getDeviceInfo(str, 6);
        String deviceInfo2 = InterconnectManager.getInstance().getStarryNetDeviceManager().getDeviceInfo(str, 5);
        delegate.g("DynamicAdapterUtils", "modelName: " + deviceInfo + ", modelId: " + deviceInfo2);
        if (deviceInfo2 != null) {
            d(deviceInfo2);
            JSONObject jSONObject = new JSONObject(b("appAdapter.json"));
            if (Intrinsics.areEqual((Object) deviceInfo2, (Object) "1001") ? true : Intrinsics.areEqual((Object) deviceInfo2, (Object) "1002")) {
                String jSONObject2 = jSONObject.getJSONObject(Constants.GLASS_DEVICE_STAR).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                deviceControlModel.l0(jSONObject2);
            } else if (ModelIdExtKt.a(deviceInfo2)) {
                String jSONObject3 = jSONObject.getJSONObject(Constants.GLASS_DEVICE_ARI).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
                deviceControlModel.l0(jSONObject3);
            } else {
                delegate.o("DynamicAdapterUtils", "no match device modelId");
            }
        } else {
            delegate.c("DynamicAdapterUtils", "error no modelId");
        }
    }

    public final void d(String str) {
        DataStoreUtils.e.a().o("connect_model_id", str);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DynamicAdapterUtils", "setModelId: " + str);
    }
}

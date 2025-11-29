package com.upuphone.xr.sapp.utils;

import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/utils/GetRing2DeviceInfoUtils;", "", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GetRing2DeviceInfoUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7887a = new Companion((DefaultConstructorMarker) null);
    public static final String b = "GetRing2DeviceInfoUtils";
    public static AndroidBindingDeviceApi.FlutterRing2ConnectApi c;

    @SourceDebugExtension({"SMAP\nGetRing2DeviceInfoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetRing2DeviceInfoUtils.kt\ncom/upuphone/xr/sapp/utils/GetRing2DeviceInfoUtils$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,51:1\n314#2,11:52\n*S KotlinDebug\n*F\n+ 1 GetRing2DeviceInfoUtils.kt\ncom/upuphone/xr/sapp/utils/GetRing2DeviceInfoUtils$Companion\n*L\n27#1:52,11\n*E\n"})
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002XD¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/utils/GetRing2DeviceInfoUtils$Companion;", "", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$FlutterRing2ConnectApi;", "api", "", "b", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$FlutterRing2ConnectApi;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Ring2DeviceInfo;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "TAG", "Ljava/lang/String;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$FlutterRing2ConnectApi;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a(Continuation continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.x();
            AndroidBindingDeviceApi.FlutterRing2ConnectApi a2 = GetRing2DeviceInfoUtils.c;
            if (a2 != null) {
                a2.c(new GetRing2DeviceInfoUtils$Companion$getRing2DeviceInfo$2$1(cancellableContinuationImpl));
            }
            Object u = cancellableContinuationImpl.u();
            if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return u;
        }

        public final void b(AndroidBindingDeviceApi.FlutterRing2ConnectApi flutterRing2ConnectApi) {
            Intrinsics.checkNotNullParameter(flutterRing2ConnectApi, "api");
            GetRing2DeviceInfoUtils.c = flutterRing2ConnectApi;
        }

        public Companion() {
        }
    }
}

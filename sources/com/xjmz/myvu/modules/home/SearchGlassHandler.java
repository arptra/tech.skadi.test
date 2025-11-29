package com.xjmz.myvu.modules.home;

import android.os.Handler;
import android.os.Message;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.xjmz.myvu.common.ConnectVoidResult;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/xjmz/myvu/modules/home/SearchGlassHandler;", "Landroid/os/Handler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;", "connectApi", "<init>", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;)V", "Landroid/os/Message;", "msg", "", "handleMessage", "(Landroid/os/Message;)V", "a", "()V", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "connectDevice", "b", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SearchGlassHandler extends Handler {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final AndroidConnectApi.FlutterConnectApi f8367a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xjmz/myvu/modules/home/SearchGlassHandler$Companion;", "", "()V", "SEARCH_GLASS_TIMEOUT_MSG", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public SearchGlassHandler(AndroidConnectApi.FlutterConnectApi flutterConnectApi) {
        Intrinsics.checkNotNullParameter(flutterConnectApi, "connectApi");
        this.f8367a = flutterConnectApi;
    }

    public final void a() {
        ULog.f6446a.a("SearchGlassHandler", "clearTimeout");
        removeMessages(1001);
    }

    public final void b(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "connectDevice");
        ULog.f6446a.a("SearchGlassHandler", "startTimeoutCheck");
        sendMessageDelayed(Message.obtain(this, 1001, starryNetDevice), 60000);
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        boolean b2 = PermissionAndStateCheckUtils.f7907a.b(MainApplication.k.d());
        Object obj = message.obj;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.xr.interconnect.entity.StarryNetDevice");
        StarryNetDevice starryNetDevice = (StarryNetDevice) obj;
        AndroidConnectApi.FlutterConnectApi flutterConnectApi = this.f8367a;
        AndroidConnectApi.ConnectState.Builder builder = new AndroidConnectApi.ConnectState.Builder();
        String modelId = starryNetDevice.getModelId();
        Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
        flutterConnectApi.i(builder.d(ConnectExtKt.o(modelId)).b(starryNetDevice.getDeviceId()).c(starryNetDevice.getDeviceName()).e(b2 ? AndroidConnectApi.StateEnum.SCAN_TIMEOUT : AndroidConnectApi.StateEnum.SCAN_NEED_BLUETOOTH).a(), new ConnectVoidResult());
    }
}

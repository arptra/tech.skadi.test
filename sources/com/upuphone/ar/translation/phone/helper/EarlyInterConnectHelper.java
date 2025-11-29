package com.upuphone.ar.translation.phone.helper;

import com.honey.account.g5.a;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TelephoneNotification;
import com.upuphone.ar.translation.utils.JsonUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\bH\u0002J\u0006\u0010\u0011\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/EarlyInterConnectHelper;", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "()V", "mIoCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mOperatorManager", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "onDeviceConnected", "", "p0", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "sendMessage", "json", "", "sendTelephoneCallAudio", "sendTelephoneNotification", "syncMessageToLauncher", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EarlyInterConnectHelper extends DeviceConnectionListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PACKAGE_NAME = "com.upuphone.ar.translation.phone.early";
    @NotNull
    private static final String PKG_MESSAGE_RECEIVER_LAUNCHER = "com.upuphone.star.launcher";
    @NotNull
    private static final String TAG = "EarlyInterConnectHelper";
    @NotNull
    private static final String TELEPHONE_CALL_AUDIO = "telephone_call_audio";
    @NotNull
    private static final String TELEPHONE_NOTIFICATION = "telephone_notification";
    @NotNull
    private CoroutineScope mIoCoroutineScope = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    @Nullable
    private OperatorManager mOperatorManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/EarlyInterConnectHelper$Companion;", "", "()V", "PACKAGE_NAME", "", "PKG_MESSAGE_RECEIVER_LAUNCHER", "TAG", "TELEPHONE_CALL_AUDIO", "TELEPHONE_NOTIFICATION", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public EarlyInterConnectHelper() {
        SuperAppServiceManager.getInstance().init(PACKAGE_NAME, new a(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(EarlyInterConnectHelper earlyInterConnectHelper, OperatorManager operatorManager) {
        Intrinsics.checkNotNullParameter(earlyInterConnectHelper, "this$0");
        Intrinsics.checkNotNullParameter(operatorManager, "operatorManager");
        earlyInterConnectHelper.mOperatorManager = operatorManager;
        operatorManager.getDeviceOperator().registerDeviceConnectionListener(earlyInterConnectHelper);
    }

    /* access modifiers changed from: private */
    public final void sendMessage(String str) {
        StarryNetMessageOperator messageOperator;
        OperatorManager operatorManager = this.mOperatorManager;
        if (operatorManager != null && (messageOperator = operatorManager.getMessageOperator()) != null) {
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setSenderPkg(PACKAGE_NAME);
            starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
            starryNetMessage.setMessage(str);
            messageOperator.sendMessage2(starryNetMessage, (SendMessageListener) null);
        }
    }

    /* access modifiers changed from: private */
    public final void sendTelephoneNotification() {
        TelephoneNotification telephoneNotification = new TelephoneNotification((String) null, new TelephoneNotification.Data(TELEPHONE_NOTIFICATION, PreferencesUtils.j() ? 1 : 0), 1, (DefaultConstructorMarker) null);
        LogExt.j("sendTelephoneNotification notification=" + telephoneNotification, TAG);
        sendMessage(JsonUtils.d(telephoneNotification));
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        LogExt.j("互联连接成功", TAG);
        syncMessageToLauncher();
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        LogExt.j("互联连接断开", TAG);
    }

    public final void sendTelephoneCallAudio() {
        LogExt.j("sendTelephoneCallAudio", TAG);
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EarlyInterConnectHelper$sendTelephoneCallAudio$1(this, (Continuation<? super EarlyInterConnectHelper$sendTelephoneCallAudio$1>) null), 3, (Object) null);
    }

    public final void syncMessageToLauncher() {
        LogExt.j("syncMessageToLauncher", TAG);
        Job unused = BuildersKt__Builders_commonKt.d(this.mIoCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EarlyInterConnectHelper$syncMessageToLauncher$1(this, (Continuation<? super EarlyInterConnectHelper$syncMessageToLauncher$1>) null), 3, (Object) null);
    }
}

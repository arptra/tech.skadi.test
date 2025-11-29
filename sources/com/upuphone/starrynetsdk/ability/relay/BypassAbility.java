package com.upuphone.starrynetsdk.ability.relay;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.relay.api.ApiRelayBypassMsgProxy;
import com.upuphone.runasone.relay.api.BypassCallback;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J8\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0016\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/relay/BypassAbility;", "Lcom/upuphone/starrynetsdk/api/Ability;", "()V", "api", "Lcom/upuphone/runasone/relay/api/ApiRelayBypassMsgProxy;", "doRegisterBypassCallback", "", "restore", "", "onInstalled", "hub", "Lcom/upuphone/hub/Hub;", "registerBypassListener", "", "serviceUuid", "", "characterUuid", "listener", "Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;", "sendMessage", "deviceId", "msg", "", "msgType", "sendListener", "Lcom/upuphone/starrynetsdk/ability/relay/BypassSendListener;", "unregisterBypassListener", "Callback", "Companion", "relay-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BypassAbility extends Ability {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "BypassAbility";
    @NotNull
    private static BypassCallback bypassCallback = new BypassAbility$Companion$bypassCallback$1();
    /* access modifiers changed from: private */
    @Nullable
    public static Callback callback;
    @NotNull
    private final ApiRelayBypassMsgProxy api = new ApiRelayBypassMsgProxy();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/relay/BypassAbility$Callback;", "", "serviceUuid", "", "characterUuid", "listener", "Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;)V", "getCharacterUuid", "()Ljava/lang/String;", "getListener", "()Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;", "getServiceUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "relay-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Callback {
        @NotNull
        private final String characterUuid;
        @NotNull
        private final BypassListener listener;
        @NotNull
        private final String serviceUuid;

        public Callback(@NotNull String str, @NotNull String str2, @NotNull BypassListener bypassListener) {
            Intrinsics.checkNotNullParameter(str, "serviceUuid");
            Intrinsics.checkNotNullParameter(str2, "characterUuid");
            Intrinsics.checkNotNullParameter(bypassListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.serviceUuid = str;
            this.characterUuid = str2;
            this.listener = bypassListener;
        }

        public static /* synthetic */ Callback copy$default(Callback callback, String str, String str2, BypassListener bypassListener, int i, Object obj) {
            if ((i & 1) != 0) {
                str = callback.serviceUuid;
            }
            if ((i & 2) != 0) {
                str2 = callback.characterUuid;
            }
            if ((i & 4) != 0) {
                bypassListener = callback.listener;
            }
            return callback.copy(str, str2, bypassListener);
        }

        @NotNull
        public final String component1() {
            return this.serviceUuid;
        }

        @NotNull
        public final String component2() {
            return this.characterUuid;
        }

        @NotNull
        public final BypassListener component3() {
            return this.listener;
        }

        @NotNull
        public final Callback copy(@NotNull String str, @NotNull String str2, @NotNull BypassListener bypassListener) {
            Intrinsics.checkNotNullParameter(str, "serviceUuid");
            Intrinsics.checkNotNullParameter(str2, "characterUuid");
            Intrinsics.checkNotNullParameter(bypassListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            return new Callback(str, str2, bypassListener);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Callback)) {
                return false;
            }
            Callback callback = (Callback) obj;
            return Intrinsics.areEqual((Object) this.serviceUuid, (Object) callback.serviceUuid) && Intrinsics.areEqual((Object) this.characterUuid, (Object) callback.characterUuid) && Intrinsics.areEqual((Object) this.listener, (Object) callback.listener);
        }

        @NotNull
        public final String getCharacterUuid() {
            return this.characterUuid;
        }

        @NotNull
        public final BypassListener getListener() {
            return this.listener;
        }

        @NotNull
        public final String getServiceUuid() {
            return this.serviceUuid;
        }

        public int hashCode() {
            return (((this.serviceUuid.hashCode() * 31) + this.characterUuid.hashCode()) * 31) + this.listener.hashCode();
        }

        @NotNull
        public String toString() {
            return "Callback(serviceUuid=" + this.serviceUuid + ", characterUuid=" + this.characterUuid + ", listener=" + this.listener + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/relay/BypassAbility$Companion;", "", "()V", "TAG", "", "bypassCallback", "Lcom/upuphone/runasone/relay/api/BypassCallback;", "callback", "Lcom/upuphone/starrynetsdk/ability/relay/BypassAbility$Callback;", "relay-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BypassAbility() {
        Camp.getInstance().addSentry(this);
    }

    private final void doRegisterBypassCallback(boolean z) {
        SNSLog.d(TAG, "doRegisterBypassCallback from restore: " + z);
        if (callback == null) {
            SNSLog.e(TAG, "Callback is null , unnecessary doRegisterBypassCallback");
        } else if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doRegisterSystemCallback failed.");
        } else {
            try {
                ApiRelayBypassMsgProxy apiRelayBypassMsgProxy = this.api;
                Callback callback2 = callback;
                Intrinsics.checkNotNull(callback2);
                String serviceUuid = callback2.getServiceUuid();
                Callback callback3 = callback;
                Intrinsics.checkNotNull(callback3);
                String characterUuid = callback3.getCharacterUuid();
                BypassCallback bypassCallback2 = bypassCallback;
                Intrinsics.checkNotNull(bypassCallback2);
                apiRelayBypassMsgProxy.setRelayListener(serviceUuid, characterUuid, bypassCallback2);
            } catch (RuntimeException e) {
                SNSLog.e(TAG, "doRegisterBypassCallback failed.", e);
            }
        }
    }

    public void onInstalled(@NotNull Hub hub) {
        Intrinsics.checkNotNullParameter(hub, "hub");
        super.onInstalled(hub);
        this.api.setHub(hub);
        doRegisterBypassCallback(true);
    }

    public final int registerBypassListener(@NotNull String str, @NotNull String str2, @NotNull BypassListener bypassListener) {
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(str2, "characterUuid");
        Intrinsics.checkNotNullParameter(bypassListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SNSLog.e(TAG, "registerBypassListener");
        callback = new Callback(str, str2, bypassListener);
        doRegisterBypassCallback(false);
        return 0;
    }

    public final int sendMessage(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull byte[] bArr, int i, @Nullable BypassSendListener bypassSendListener) {
        byte[] bArr2 = bArr;
        String str4 = str;
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str2, "serviceUuid");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str3, "characterUuid");
        Intrinsics.checkNotNullParameter(bArr2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,sendMessage failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            SNSLog.e(TAG, "sendMessage------");
            this.api.sendMessage(str, str2, str3, i, new ArrayData(bArr2), new BypassAbility$sendMessage$1(bypassSendListener));
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "sendMessage failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "sendMessage failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public final int unregisterBypassListener(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(str2, "characterUuid");
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,unregisterBypassListener failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            SNSLog.e(TAG, "unregisterBypassListener");
            this.api.removeRelayListener(str, str2);
            callback = null;
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "unregisterBypassListener failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "unregisterBypassListener failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }
}

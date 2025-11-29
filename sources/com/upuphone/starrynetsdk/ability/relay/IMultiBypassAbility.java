package com.upuphone.starrynetsdk.ability.relay;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.relay.api.ApiRelayBypassMsgProxy;
import com.upuphone.runasone.relay.api.BypassCallback;
import com.upuphone.runasone.relay.util.PackagesUtils;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0002$%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0010J8\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!J&\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/relay/IMultiBypassAbility;", "Lcom/upuphone/starrynetsdk/api/Ability;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "api", "Lcom/upuphone/runasone/relay/api/ApiRelayBypassMsgProxy;", "bypassCallback", "Lcom/upuphone/runasone/relay/api/BypassCallback;", "sendMessageLock", "", "doRegisterBypassCallback", "", "restore", "", "getCallbackTag", "", "tag", "onInstalled", "hub", "Lcom/upuphone/hub/Hub;", "registerBypassListener", "", "serviceUuid", "characterUuid", "listener", "Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;", "sendMessage", "deviceId", "msg", "", "msgType", "sendListener", "Lcom/upuphone/starrynetsdk/ability/relay/BypassSendListener;", "unregisterBypassListener", "bypassListener", "Callback", "Companion", "relay-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IMultiBypassAbility extends Ability {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "MultiBypassAbility";
    /* access modifiers changed from: private */
    @Nullable
    public static Callback callback;
    @NotNull
    private final ApiRelayBypassMsgProxy api = new ApiRelayBypassMsgProxy();
    @NotNull
    private BypassCallback bypassCallback = new IMultiBypassAbility$bypassCallback$1();
    @NotNull
    private final Context context;
    @NotNull
    private final Object sendMessageLock = new Object();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/relay/IMultiBypassAbility$Callback;", "", "serviceUuid", "", "characterUuid", "listener", "Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;", "callbackTag", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;Ljava/lang/String;)V", "getCallbackTag", "()Ljava/lang/String;", "getCharacterUuid", "hashCode", "", "getHashCode", "()I", "setHashCode", "(I)V", "getListener", "()Lcom/upuphone/starrynetsdk/ability/relay/BypassListener;", "getServiceUuid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "toString", "relay-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Callback {
        @NotNull
        private final String callbackTag;
        @NotNull
        private final String characterUuid;
        private int hashCode;
        @NotNull
        private final BypassListener listener;
        @NotNull
        private final String serviceUuid;

        public Callback(@NotNull String str, @NotNull String str2, @NotNull BypassListener bypassListener, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "serviceUuid");
            Intrinsics.checkNotNullParameter(str2, "characterUuid");
            Intrinsics.checkNotNullParameter(bypassListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            Intrinsics.checkNotNullParameter(str3, "callbackTag");
            this.serviceUuid = str;
            this.characterUuid = str2;
            this.listener = bypassListener;
            this.callbackTag = str3;
            this.hashCode = bypassListener.hashCode();
        }

        public static /* synthetic */ Callback copy$default(Callback callback, String str, String str2, BypassListener bypassListener, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = callback.serviceUuid;
            }
            if ((i & 2) != 0) {
                str2 = callback.characterUuid;
            }
            if ((i & 4) != 0) {
                bypassListener = callback.listener;
            }
            if ((i & 8) != 0) {
                str3 = callback.callbackTag;
            }
            return callback.copy(str, str2, bypassListener, str3);
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
        public final String component4() {
            return this.callbackTag;
        }

        @NotNull
        public final Callback copy(@NotNull String str, @NotNull String str2, @NotNull BypassListener bypassListener, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "serviceUuid");
            Intrinsics.checkNotNullParameter(str2, "characterUuid");
            Intrinsics.checkNotNullParameter(bypassListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            Intrinsics.checkNotNullParameter(str3, "callbackTag");
            return new Callback(str, str2, bypassListener, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Callback)) {
                return false;
            }
            Callback callback = (Callback) obj;
            return Intrinsics.areEqual((Object) this.serviceUuid, (Object) callback.serviceUuid) && Intrinsics.areEqual((Object) this.characterUuid, (Object) callback.characterUuid) && Intrinsics.areEqual((Object) this.listener, (Object) callback.listener) && Intrinsics.areEqual((Object) this.callbackTag, (Object) callback.callbackTag);
        }

        @NotNull
        public final String getCallbackTag() {
            return this.callbackTag;
        }

        @NotNull
        public final String getCharacterUuid() {
            return this.characterUuid;
        }

        public final int getHashCode() {
            return this.hashCode;
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
            return (((((this.serviceUuid.hashCode() * 31) + this.characterUuid.hashCode()) * 31) + this.listener.hashCode()) * 31) + this.callbackTag.hashCode();
        }

        public final void setHashCode(int i) {
            this.hashCode = i;
        }

        @NotNull
        public String toString() {
            return "Callback(serviceUuid=" + this.serviceUuid + ", characterUuid=" + this.characterUuid + ", listener=" + this.listener + ", callbackTag=" + this.callbackTag + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/relay/IMultiBypassAbility$Companion;", "", "()V", "TAG", "", "callback", "Lcom/upuphone/starrynetsdk/ability/relay/IMultiBypassAbility$Callback;", "relay-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public IMultiBypassAbility(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Camp.getInstance().addSentry(this);
    }

    private final void doRegisterBypassCallback(boolean z) {
        SNSLog.d(TAG, "doRegisterBypassCallback from restore: " + z);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , doRegisterSystemCallback failed.");
            return;
        }
        try {
            if (PackagesUtils.INSTANCE.isSupportMulSendMsg(this.context)) {
                Callback callback2 = callback;
                if (callback2 != null && callback2 != null) {
                    this.api.setRelayListenerByCallback(callback2.getServiceUuid(), callback2.getCharacterUuid(), callback2.getCallbackTag(), this.bypassCallback);
                    return;
                }
                return;
            }
            Callback callback3 = callback;
            if (callback3 != null && callback3 != null) {
                this.api.setRelayListener(callback3.getServiceUuid(), callback3.getCharacterUuid(), this.bypassCallback);
            }
        } catch (RuntimeException e) {
            SNSLog.e(TAG, "doRegisterBypassCallback failed.", e);
        }
    }

    private final String getCallbackTag(String str) {
        try {
            return this.context.getPackageName() + str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public void onInstalled(@NotNull Hub hub) {
        Intrinsics.checkNotNullParameter(hub, "hub");
        super.onInstalled(hub);
        this.api.setHub(hub);
        doRegisterBypassCallback(true);
    }

    public final int registerBypassListener(@NotNull String str, @NotNull String str2, @NotNull BypassListener bypassListener, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(str2, "characterUuid");
        Intrinsics.checkNotNullParameter(bypassListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(str3, "tag");
        SNSLog.e(TAG, "registerBypassListener");
        callback = new Callback(str, str2, bypassListener, getCallbackTag(str3));
        doRegisterBypassCallback(false);
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        com.upuphone.starrynetsdk.api.SNSLog.e(TAG, "sendMessage failed.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
        return com.upuphone.starrynetsdk.api.ErrorCode.CODE_TARGET_UNAVAILABLE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        com.upuphone.starrynetsdk.api.SNSLog.e(TAG, "sendMessage failed.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        return com.upuphone.starrynetsdk.api.ErrorCode.CODE_SERVICE_UNAVAILABLE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int sendMessage(@org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull java.lang.String r14, @org.jetbrains.annotations.NotNull byte[] r15, int r16, @org.jetbrains.annotations.Nullable com.upuphone.starrynetsdk.ability.relay.BypassSendListener r17) {
        /*
            r11 = this;
            r0 = r11
            r1 = r15
            java.lang.String r2 = "deviceId"
            r4 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            java.lang.String r2 = "serviceUuid"
            r5 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r2)
            java.lang.String r2 = "characterUuid"
            r6 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            java.lang.String r2 = "msg"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            boolean r2 = r11.isEnable()
            r10 = -301000(0xfffffffffffb6838, float:NaN)
            if (r2 != 0) goto L_0x002a
            java.lang.String r0 = "MultiBypassAbility"
            java.lang.String r1 = "Service unavailable,sendMessage failed."
            com.upuphone.starrynetsdk.api.SNSLog.e(r0, r1)
            return r10
        L_0x002a:
            java.lang.Object r2 = r0.sendMessageLock     // Catch:{ HubRemoteException -> 0x0051, HubTargetException -> 0x004f }
            monitor-enter(r2)     // Catch:{ HubRemoteException -> 0x0051, HubTargetException -> 0x004f }
            java.lang.String r3 = "MultiBypassAbility"
            java.lang.String r7 = "sendMessage------"
            com.upuphone.starrynetsdk.api.SNSLog.e(r3, r7)     // Catch:{ all -> 0x0053 }
            com.upuphone.runasone.relay.api.ApiRelayBypassMsgProxy r3 = r0.api     // Catch:{ all -> 0x0053 }
            com.upuphone.runasone.ArrayData r8 = new com.upuphone.runasone.ArrayData     // Catch:{ all -> 0x0053 }
            r8.<init>((byte[]) r15)     // Catch:{ all -> 0x0053 }
            com.upuphone.starrynetsdk.ability.relay.IMultiBypassAbility$sendMessage$1$1 r9 = new com.upuphone.starrynetsdk.ability.relay.IMultiBypassAbility$sendMessage$1$1     // Catch:{ all -> 0x0053 }
            r0 = r17
            r9.<init>(r0)     // Catch:{ all -> 0x0053 }
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r16
            r3.sendMessage(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0053 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0053 }
            monitor-exit(r2)     // Catch:{ HubRemoteException -> 0x0051, HubTargetException -> 0x004f }
            r0 = 0
            return r0
        L_0x004f:
            r0 = move-exception
            goto L_0x0056
        L_0x0051:
            r0 = move-exception
            goto L_0x0061
        L_0x0053:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ HubRemoteException -> 0x0051, HubTargetException -> 0x004f }
            throw r0     // Catch:{ HubRemoteException -> 0x0051, HubTargetException -> 0x004f }
        L_0x0056:
            java.lang.String r1 = "MultiBypassAbility"
            java.lang.String r2 = "sendMessage failed."
            com.upuphone.starrynetsdk.api.SNSLog.e(r1, r2, r0)
            r0 = -300000(0xfffffffffffb6c20, float:NaN)
            return r0
        L_0x0061:
            java.lang.String r1 = "MultiBypassAbility"
            java.lang.String r2 = "sendMessage failed."
            com.upuphone.starrynetsdk.api.SNSLog.e(r1, r2, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynetsdk.ability.relay.IMultiBypassAbility.sendMessage(java.lang.String, java.lang.String, java.lang.String, byte[], int, com.upuphone.starrynetsdk.ability.relay.BypassSendListener):int");
    }

    public final int unregisterBypassListener(@NotNull String str, @NotNull String str2, @NotNull BypassListener bypassListener, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(str2, "characterUuid");
        Intrinsics.checkNotNullParameter(bypassListener, "bypassListener");
        Intrinsics.checkNotNullParameter(str3, "tag");
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,unregisterBypassListener failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            SNSLog.e(TAG, "unregisterBypassListener");
            String callbackTag = getCallbackTag(str3);
            if (PackagesUtils.INSTANCE.isSupportMulSendMsg(this.context)) {
                try {
                    Callback callback2 = callback;
                    if (callback2 == null) {
                        return 0;
                    }
                    if (!Intrinsics.areEqual((Object) callback2 != null ? callback2.getCallbackTag() : null, (Object) callbackTag)) {
                        return 0;
                    }
                    this.api.removeRelayListenerByCallback(str, str2, callbackTag, this.bypassCallback);
                    callback = null;
                    return 0;
                } catch (Exception e) {
                    SNSLog.e(TAG, "new unregisterBypassListener failed.", e);
                    return 0;
                }
            } else if (callback == null) {
                return 0;
            } else {
                this.api.removeRelayListener(str, str2);
                callback = null;
                return 0;
            }
        } catch (HubRemoteException e2) {
            SNSLog.e(TAG, "unregisterBypassListener failed.", e2);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e3) {
            SNSLog.e(TAG, "unregisterBypassListener failed.", e3);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }
}

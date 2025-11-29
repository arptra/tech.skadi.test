package com.xjsd.ai.assistant.net.ws;

import android.os.Handler;
import android.os.LocaleList;
import com.meizu.common.util.LunarCalendar;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.core.util.UrlParamsAppender;
import com.xjsd.ai.assistant.env.EnvAbility;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.ws.engine.CloudClient;
import com.xjsd.ai.assistant.net.ws.engine.CloudClientImpl;
import com.xjsd.ai.assistant.net.ws.engine.CloudClientListener;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndMetadata;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndRequest;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.net.URI;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001I\b&\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0003J-\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\nH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\tJ\u0017\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0018H&¢\u0006\u0004\b#\u0010\u001aJ\u000f\u0010$\u001a\u00020\u0010H&¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0010H&¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0007H&¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0010H\u0002¢\u0006\u0004\b+\u0010\u0003R\u001b\u00101\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010=R\u0014\u0010D\u001a\u00020C8\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "", "<init>", "()V", "", "isReady", "()Z", "", "getCloudErrorCode", "()I", "", "sessionId", "connect", "(Ljava/lang/String;)Z", "autoReconnect", "(Ljava/lang/String;Z)Z", "", "disconnect", "traceId", "", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndServiceData;", "data", "sendMsg", "(Ljava/lang/String;[Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndServiceData;)V", "", "sendData", "([B)V", "onReconnectSuccess", "getVirtualAppName", "()Ljava/lang/String;", "getFunctionType", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "response", "onMsg", "(Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;)V", "onData", "onResume", "onParse", "code", "onClose", "(I)V", "A", "(Ljava/lang/String;)V", "z", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "mCacheAbility$delegate", "Lkotlin/Lazy;", "w", "()Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "mCacheAbility", "Lcom/xjsd/ai/assistant/env/EnvAbility;", "mEnvAbility$delegate", "x", "()Lcom/xjsd/ai/assistant/env/EnvAbility;", "mEnvAbility", "Landroid/os/Handler;", "mRetryHandler$delegate", "y", "()Landroid/os/Handler;", "mRetryHandler", "isActiveDisconnect", "Z", "mConnectStatus", "I", "mSessionId", "Ljava/lang/String;", "mAutoReconnect", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndMetadata;", "mMetadata", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndMetadata;", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudClient;", "mRealWebSocket", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudClient;", "com/xjsd/ai/assistant/net/ws/VirtualWebSocket$mCloudClientListener$1", "mCloudClientListener", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket$mCloudClientListener$1;", "Companion", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public abstract class VirtualWebSocket {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "VirtualWebSocket";
    /* access modifiers changed from: private */
    public volatile boolean isActiveDisconnect;
    /* access modifiers changed from: private */
    public boolean mAutoReconnect;
    @NotNull
    private final Lazy mCacheAbility$delegate = LazyKt.lazy(VirtualWebSocket$mCacheAbility$2.INSTANCE);
    @NotNull
    private final VirtualWebSocket$mCloudClientListener$1 mCloudClientListener = new VirtualWebSocket$mCloudClientListener$1(this);
    private volatile int mConnectStatus = -1;
    @NotNull
    private final Lazy mEnvAbility$delegate = LazyKt.lazy(VirtualWebSocket$mEnvAbility$2.INSTANCE);
    @NotNull
    private final EndToEndMetadata mMetadata = new EndToEndMetadata();
    @Nullable
    private CloudClient mRealWebSocket;
    @NotNull
    private final Lazy mRetryHandler$delegate = LazyKt.lazy(VirtualWebSocket$mRetryHandler$2.INSTANCE);
    /* access modifiers changed from: private */
    @NotNull
    public String mSessionId = "";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket$Companion;", "", "()V", "TAG", "", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void A(String str) {
        int functionType = getFunctionType();
        String a2 = DeviceUtils.a();
        Locale locale = LocaleList.getDefault().get(0);
        EndToEndMetadata endToEndMetadata = this.mMetadata;
        endToEndMetadata.setSessionId(this.mSessionId);
        endToEndMetadata.setXjAccountId((String) w().getCacheWithDefault("xrUid", ""));
        endToEndMetadata.setAccountId((String) w().getCacheWithDefault("mzUid", ""));
        endToEndMetadata.setGlassDeviceId(a2);
        endToEndMetadata.setLatitude((String) w().getCacheWithDefault("latitude", "0.0"));
        endToEndMetadata.setLongitude((String) w().getCacheWithDefault("longitude", "0.0"));
        endToEndMetadata.setTerminalTraceId(str);
        endToEndMetadata.setIotDeviceId((String) w().getCacheWithDefault("IotDeviceId", ""));
        endToEndMetadata.setFunctionType(functionType);
        endToEndMetadata.setAppName(getVirtualAppName());
        String language = locale.getLanguage();
        String country = locale.getCountry();
        endToEndMetadata.setLocal(language + LunarCalendar.DATE_SEPARATOR + country);
    }

    public final boolean connect(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
        return connect(str, false);
    }

    public final void disconnect() {
        this.isActiveDisconnect = true;
        this.mConnectStatus = -1;
        z();
    }

    public final int getCloudErrorCode() {
        return this.mConnectStatus;
    }

    public abstract int getFunctionType();

    public abstract String getVirtualAppName();

    public final boolean isReady() {
        return this.mConnectStatus == 0;
    }

    public abstract void onClose(int i);

    public abstract void onData(byte[] bArr);

    public abstract void onMsg(EndToEndResponse endToEndResponse);

    public abstract void onParse();

    public void onReconnectSuccess() {
        ILog.a(TAG, "onReconnectSuccess: 重连成功");
    }

    public abstract void onResume();

    public final void sendData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        CloudClient cloudClient = this.mRealWebSocket;
        if (cloudClient != null && cloudClient.isOpen()) {
            cloudClient.b(bArr);
        }
    }

    public final void sendMsg(@NotNull String str, @NotNull EndToEndServiceData... endToEndServiceDataArr) {
        CloudClient cloudClient;
        Intrinsics.checkNotNullParameter(str, "traceId");
        Intrinsics.checkNotNullParameter(endToEndServiceDataArr, "data");
        if (endToEndServiceDataArr.length != 0 && (cloudClient = this.mRealWebSocket) != null && cloudClient.isOpen()) {
            A(str);
            EndToEndRequest endToEndRequest = new EndToEndRequest();
            endToEndRequest.setMetadata(this.mMetadata);
            for (EndToEndServiceData appendServiceData : endToEndServiceDataArr) {
                endToEndRequest.appendServiceData(appendServiceData);
            }
            cloudClient.a(GsonUtils.e(endToEndRequest));
        }
    }

    public final CacheAbility w() {
        return (CacheAbility) this.mCacheAbility$delegate.getValue();
    }

    public final EnvAbility x() {
        return (EnvAbility) this.mEnvAbility$delegate.getValue();
    }

    public final Handler y() {
        return (Handler) this.mRetryHandler$delegate.getValue();
    }

    public final void z() {
        CloudClient cloudClient = this.mRealWebSocket;
        this.mRealWebSocket = null;
        if (cloudClient != null) {
            ILog.j(TAG, "等待连接关闭");
            try {
                cloudClient.c((CloudClientListener) null);
                cloudClient.close();
                ILog.j(TAG, "连接已关闭");
            } catch (InterruptedException e) {
                ILog.n(TAG, "断开连接异常", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    public final boolean connect(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
        this.mSessionId = str;
        this.mAutoReconnect = z;
        this.isActiveDisconnect = false;
        try {
            this.mConnectStatus = -1;
            CloudClient cloudClient = this.mRealWebSocket;
            if (cloudClient != null) {
                Intrinsics.checkNotNull(cloudClient);
                if (cloudClient.isOpen()) {
                    ILog.a(TAG, "connect: 复用已连接通路");
                    this.mConnectStatus = 0;
                    return true;
                }
            }
            String asrUrl = x().getCurrentEnv().getAsrUrl();
            String a2 = UrlParamsAppender.a();
            String virtualAppName = getVirtualAppName();
            int functionType = getFunctionType();
            URI uri = new URI(asrUrl + "?" + a2 + "&module=" + virtualAppName + "&functionType=" + functionType);
            CloudClientImpl cloudClientImpl = new CloudClientImpl(uri);
            cloudClientImpl.c(this.mCloudClientListener);
            this.mRealWebSocket = cloudClientImpl;
            StringBuilder sb = new StringBuilder();
            sb.append("connect: 开始连接url->");
            sb.append(uri);
            ILog.a(TAG, sb.toString());
            CloudClient cloudClient2 = this.mRealWebSocket;
            Intrinsics.checkNotNull(cloudClient2);
            this.mConnectStatus = cloudClient2.connect();
            if (this.mConnectStatus == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            ILog.b(TAG, "connect: 连接云端出错", e);
            z();
            return false;
        }
    }
}

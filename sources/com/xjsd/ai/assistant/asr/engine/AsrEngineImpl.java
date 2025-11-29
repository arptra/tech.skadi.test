package com.xjsd.ai.assistant.asr.engine;

import android.app.Application;
import android.text.TextUtils;
import com.meizu.common.widget.MzContactsContract;
import com.xjsd.ai.assistant.asr.AsrEventListener;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrAudioInfo;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudOptions;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.core.util.UrlParamsAppender;
import com.xjsd.ai.assistant.env.EnvAbility;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Scene;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u00017\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010 \u001a\u00020\u00062\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0012H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0003R\u0014\u0010$\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/xjsd/ai/assistant/asr/engine/AsrEngineImpl;", "Lcom/xjsd/ai/assistant/asr/engine/AsrEngine;", "<init>", "()V", "Lcom/xjsd/ai/assistant/asr/AsrEventListener;", "listener", "", "setOnAsrEventListener", "(Lcom/xjsd/ai/assistant/asr/AsrEventListener;)V", "Landroid/app/Application;", "application", "init", "(Landroid/app/Application;)V", "", "isReady", "()Z", "", "sessionId", "", "hotWords", "startRecognize", "(Ljava/lang/String;Ljava/util/List;)Z", "", "data", "", "len", "feedData", "([BI)V", "flush", "stopRecognize", "getErrorCode", "()I", "d", "(Ljava/util/List;)V", "host", "Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudOptions;", "mAsrCloudOptions", "f", "(Ljava/lang/String;Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudOptions;)I", "e", "a", "Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudOptions;", "b", "I", "mConnectStatus", "c", "Z", "isVadEnd", "Ljava/lang/String;", "mRequestId", "Lcom/xjsd/ai/assistant/asr/AsrEventListener;", "mAsrEventListener", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClient;", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClient;", "mAsrWsClient", "com/xjsd/ai/assistant/asr/engine/AsrEngineImpl$mAsrWsClientListener$1", "g", "Lcom/xjsd/ai/assistant/asr/engine/AsrEngineImpl$mAsrWsClientListener$1;", "mAsrWsClientListener", "h", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AsrEngineImpl implements AsrEngine {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final AsrCloudOptions f8385a = new AsrCloudOptions();
    public volatile int b = -1;
    public volatile boolean c;
    public String d = "";
    public AsrEventListener e;
    public AsrWsClient f;
    public final AsrEngineImpl$mAsrWsClientListener$1 g = new AsrEngineImpl$mAsrWsClientListener$1(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/asr/engine/AsrEngineImpl$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void d(List list) {
        boolean z;
        AsrAudioInfo data = this.f8385a.getData();
        data.setHotWords(list);
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            Boolean bool = Boolean.FALSE;
            Boolean bool2 = (Boolean) cacheAbility.getCacheWithDefault("isAsrOnlyWakeup", bool);
            Boolean bool3 = (Boolean) cacheAbility.getCacheWithDefault("wechat_transfer", bool);
            String str = (String) cacheAbility.getCacheWithDefault("feedAudioDataType", AsrConstants.AUDIO_OPUS);
            String str2 = (String) cacheAbility.getCacheWithDefault(AssistantConstants.Key.SCENE_ID, Scene.NORMAL);
            String str3 = (String) cacheAbility.getCacheWithDefault("IotDeviceId", "");
            String a2 = DeviceUtils.a();
            String str4 = (String) cacheAbility.getCacheWithDefault("mzUid", "");
            Intrinsics.checkNotNull(bool2);
            if (!bool2.booleanValue() || !Intrinsics.areEqual((Object) str2, (Object) Scene.WECHAT_TRANSFER)) {
                Intrinsics.checkNotNull(bool3);
                if (!bool3.booleanValue()) {
                    z = false;
                    data.setEnablePunctuation(z);
                    data.setAudioType(str);
                    this.f8385a.setDeviceId(a2);
                    this.f8385a.setIotDeviceId(str3);
                    this.f8385a.setAccountId(str4);
                }
            }
            z = true;
            data.setEnablePunctuation(z);
            data.setAudioType(str);
            this.f8385a.setDeviceId(a2);
            this.f8385a.setIotDeviceId(str3);
            this.f8385a.setAccountId(str4);
        }
        this.f8385a.setRequestId(this.d);
        this.f8385a.setData(data);
        this.f8385a.setInputLanguageCode("en-GB");
    }

    public final void e() {
        AsrWsClient asrWsClient = this.f;
        if (asrWsClient != null) {
            ILog.j("AsrEngineImpl", "等待连接关闭");
            try {
                asrWsClient.c((AsrWsClientListener) null);
                asrWsClient.close();
                ILog.j("AsrEngineImpl", "连接已关闭");
            } catch (InterruptedException e2) {
                ILog.n("AsrEngineImpl", "断开连接异常", e2);
                Thread.currentThread().interrupt();
            }
            this.f = null;
        }
    }

    public final int f(String str, AsrCloudOptions asrCloudOptions) {
        try {
            URI uri = new URI(str);
            AsrWsClient asrWsClient = this.f;
            if (asrWsClient != null) {
                Intrinsics.checkNotNull(asrWsClient);
                if (asrWsClient.isOpen()) {
                    ILog.j("AsrEngineImpl", "WebSocket已连接");
                    String e2 = GsonUtils.e(asrCloudOptions);
                    ILog.j("AsrEngineImpl", "发送ASR云端参数->" + e2);
                    AsrWsClient asrWsClient2 = this.f;
                    Intrinsics.checkNotNull(asrWsClient2);
                    asrWsClient2.a(e2);
                    return 0;
                }
            }
            AsrWsClientProxy asrWsClientProxy = new AsrWsClientProxy(uri);
            asrWsClientProxy.c(this.g);
            this.f = asrWsClientProxy;
            ILog.j("AsrEngineImpl", "开始连接，url->" + uri);
            AsrWsClient asrWsClient3 = this.f;
            Intrinsics.checkNotNull(asrWsClient3);
            int connect = asrWsClient3.connect();
            if (connect == 0) {
                String e3 = GsonUtils.e(asrCloudOptions);
                ILog.j("AsrEngineImpl", "发送ASR云端参数->" + e3);
                AsrWsClient asrWsClient4 = this.f;
                Intrinsics.checkNotNull(asrWsClient4);
                asrWsClient4.a(e3);
            }
            return connect;
        } catch (URISyntaxException unused) {
            return MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_TOKENS;
        }
    }

    public void feedData(byte[] bArr, int i) {
        AsrWsClient asrWsClient;
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (isReady() && !this.c && (asrWsClient = this.f) != null) {
            Intrinsics.checkNotNull(asrWsClient);
            if (asrWsClient.isOpen()) {
                AsrWsClient asrWsClient2 = this.f;
                Intrinsics.checkNotNull(asrWsClient2);
                asrWsClient2.b(bArr);
            }
        }
    }

    public void flush() {
        this.c = true;
        if (TextUtils.isEmpty(this.d)) {
            ILog.m("AsrEngineImpl", "requestId为空，不发送end data");
            return;
        }
        AsrCloudOptions asrCloudOptions = new AsrCloudOptions();
        asrCloudOptions.setDeviceId(this.f8385a.getDeviceId());
        asrCloudOptions.setRequestId(this.d);
        asrCloudOptions.setEvent(AsrConstants.END_AUDIO);
        AsrWsClient asrWsClient = this.f;
        if (asrWsClient != null && asrWsClient.isOpen()) {
            String e2 = GsonUtils.e(asrCloudOptions);
            ILog.j("AsrEngineImpl", "sendAsrEnd: " + e2);
            asrWsClient.a(e2);
        }
    }

    public int getErrorCode() {
        return this.b;
    }

    public void init(Application application) {
        AsrAudioInfo asrAudioInfo = new AsrAudioInfo();
        asrAudioInfo.setAudioType(AsrConstants.AUDIO_OPUS);
        asrAudioInfo.setChannel(1);
        asrAudioInfo.setSampleBytes(2);
        asrAudioInfo.setSampleRate(16000);
        this.f8385a.setData(asrAudioInfo);
        this.f8385a.setEvent(AsrConstants.SYNC_AUDIO_INFO);
    }

    public boolean isReady() {
        return this.b == 0;
    }

    public void setOnAsrEventListener(AsrEventListener asrEventListener) {
        this.e = asrEventListener;
    }

    public boolean startRecognize(String str, List list) {
        Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
        ILog.j("AsrEngineImpl", "ASR cloud engine start recognize!");
        try {
            this.b = -1;
            this.c = false;
            this.d = str;
            d(list);
            EnvAbility envAbility = (EnvAbility) AbilityManager.b.b(EnvAbility.class);
            Intrinsics.checkNotNull(envAbility);
            String asrUrl = envAbility.getCurrentEnv().getAsrUrl();
            String a2 = UrlParamsAppender.a();
            this.b = f(asrUrl + "?" + a2, this.f8385a);
            if (this.b == 0) {
                ILog.j("AsrEngineImpl", "ASR cloud engine start success");
                return true;
            }
            int i = this.b;
            ILog.j("AsrEngineImpl", "ASR cloud engine start failed, error code->" + i);
            this.d = "";
            e();
            return false;
        } catch (Exception e2) {
            ILog.h("AsrEngineImpl", "ASR cloud engine start failed", e2);
        }
    }

    public void stopRecognize() {
        ILog.j("AsrEngineImpl", "ASR cloud engine stop recognize");
        this.b = -1;
        this.d = "";
        e();
        ILog.j("AsrEngineImpl", "ASR cloud engine stop over");
    }
}

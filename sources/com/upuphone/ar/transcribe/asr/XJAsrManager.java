package com.upuphone.ar.transcribe.asr;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.ext.StringExtKt;
import com.upuphone.ar.transcribe.interconnect.entity.InterConnectDevice;
import com.upuphone.ar.transcribe.interconnect.entity.StartTrans;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.utils.AccountUtils;
import com.upuphone.runasone.relay.api.IntentKey;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.callback.AsrResultCallback;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import com.xjsd.xr.sapp.asr.dao.TtsConfig;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J)\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/upuphone/ar/transcribe/asr/XJAsrManager;", "Lcom/upuphone/ar/transcribe/asr/AbsAsrImpl;", "<init>", "()V", "", "bytes", "", "n", "([B)V", "m", "", "key", "Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;", "listener", "x", "(Ljava/lang/String;Lcom/xjsd/xr/sapp/asr/callback/AsrResultCallback;)V", "B", "w", "v", "q", "Lcom/upuphone/ar/transcribe/interconnect/entity/StartTrans;", "startTrans", "y", "(Lcom/upuphone/ar/transcribe/interconnect/entity/StartTrans;)V", "r", "srcLang", "", "role", "", "newSession", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "z", "(Ljava/lang/String;IZ)Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "t", "(Ljava/lang/String;)Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "language", "u", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "s", "()Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "d", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "longAudioAsr", "e", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class XJAsrManager extends AbsAsrImpl {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final XJAsrManager f = new XJAsrManager();
    public UnifiedAsrHelper d;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/transcribe/asr/XJAsrManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/asr/XJAsrManager;", "instance", "Lcom/upuphone/ar/transcribe/asr/XJAsrManager;", "a", "()Lcom/upuphone/ar/transcribe/asr/XJAsrManager;", "", "TAG", "Ljava/lang/String;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final XJAsrManager a() {
            return XJAsrManager.f;
        }

        public Companion() {
        }
    }

    public static /* synthetic */ AsrRequestConfig A(XJAsrManager xJAsrManager, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return xJAsrManager.z(str, i, z);
    }

    public void B(String str, AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        UnifiedAsrHelper unifiedAsrHelper = this.d;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.unRegisterAsrResultCallback(str, asrResultCallback);
        }
    }

    public void m(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        int length = bArr.length;
        LogExt.c("发送近端数据到asr服务:" + length, "AsrManager", "sendRemoteData", 20, false, 8, (Object) null);
        UnifiedAsrHelper unifiedAsrHelper = this.d;
        if (unifiedAsrHelper != null) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            unifiedAsrHelper.sendProximalAudioData(copyOf);
        }
    }

    public void n(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        int length = bArr.length;
        LogExt.c("发送远端数据到asr服务:" + length, "AsrManager", "sendRemoteData", 20, false, 8, (Object) null);
        UnifiedAsrHelper unifiedAsrHelper = this.d;
        if (unifiedAsrHelper != null) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            unifiedAsrHelper.sendRemoteAudioData(copyOf);
        }
    }

    public void q() {
        UnifiedAsrHelper unifiedAsrHelper = this.d;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.release();
        }
    }

    public void r() {
        UnifiedAsrHelper unifiedAsrHelper = this.d;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.stopRequest();
        }
    }

    public final AsrRequestConfig.RecognizeData s() {
        String str;
        String a2 = AccountUtils.f6173a.a();
        if (a2 == null) {
            a2 = "";
        }
        String str2 = a2;
        InterConnectDevice c = InterConnectHelper.c.a().c();
        if (c == null || (str = c.getDeviceId()) == null) {
            str = "default-xr-12345";
        }
        String str3 = str;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return new AsrRequestConfig.RecognizeData(str2, str3, "com.upuphone.ar.transcribe", uuid, 0, 16, (DefaultConstructorMarker) null);
    }

    public final TtsConfig t(String str) {
        String str2;
        String str3 = str;
        TranscribeManager.Companion companion = TranscribeManager.j;
        if (companion.a().l() != 4) {
            return null;
        }
        if (!StringsKt.isBlank(str)) {
            String i = companion.a().i(Intrinsics.areEqual((Object) str3, (Object) "cmn-Hans-CN") ? R.string.trsb_calling_tips_cn : Intrinsics.areEqual((Object) str3, (Object) "ja-JP") ? R.string.trsb_calling_tips_ja : R.string.trsb_calling_tips_en);
            if (i != null) {
                str2 = i;
                return new TtsConfig("BV700_streaming", (String) null, str2, "ogg_opus", 2, 0, u(str), (String) null, (String) null, 418, (DefaultConstructorMarker) null);
            }
        }
        str2 = "";
        return new TtsConfig("BV700_streaming", (String) null, str2, "ogg_opus", 2, 0, u(str), (String) null, (String) null, 418, (DefaultConstructorMarker) null);
    }

    public final String u(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 96598143) {
            return hashCode != 100828572 ? (hashCode == 473739377 && str.equals("cmn-Hans-CN")) ? "cn" : "en" : !str.equals("ja-JP") ? "en" : "ja";
        }
        boolean equals = str.equals("en-GB");
        return "en";
    }

    public void v() {
        int d2 = d();
        LogExt.d("init ASR manager type: " + d2, "AsrManager");
        this.d = new UnifiedAsrHelper("com.upuphone.ar.transcribe", false, 2, (DefaultConstructorMarker) null);
    }

    public void w() {
        UnifiedAsrHelper unifiedAsrHelper = this.d;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.notifyNetworkConnected();
        }
    }

    public void x(String str, AsrResultCallback asrResultCallback) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(asrResultCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        LogExt.d("注册ASR结果回调: " + str, "AsrManager");
        UnifiedAsrHelper unifiedAsrHelper = this.d;
        if (unifiedAsrHelper != null) {
            unifiedAsrHelper.registerAsrResultCallback(str, asrResultCallback);
        }
    }

    public void y(StartTrans startTrans) {
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        AsrRequestConfig A = A(this, StringExtKt.b(startTrans.getSrc()), 1, false, 4, (Object) null);
        AsrRequestConfig z = startTrans.getTransType() == 4 ? z(StringExtKt.b(startTrans.getSrc()), 0, startTrans.isNewSession()) : null;
        UnifiedAsrHelper unifiedAsrHelper = this.d;
        if (unifiedAsrHelper != null) {
            UnifiedAsrHelper.startRequest$default(unifiedAsrHelper, A, z, true, false, 8, (Object) null);
        }
    }

    public final AsrRequestConfig z(String str, int i, boolean z) {
        String deviceId;
        String deviceId2;
        String str2 = TranscribeConstants.f6027a.m() ? AsrConstants.WEB_INTL : AsrConstants.WEB_DOM_UAT;
        InterConnectHelper.Companion companion = InterConnectHelper.c;
        InterConnectDevice c = companion.a().c();
        String str3 = (c == null || (deviceId2 = c.getDeviceId()) == null) ? "default-xr-12345" : deviceId2;
        InterConnectDevice c2 = companion.a().c();
        String str4 = (c2 == null || (deviceId = c2.getDeviceId()) == null) ? "default-xr-12345" : deviceId;
        AsrRequestConfig.RequestData requestData = new AsrRequestConfig.RequestData("pcm", 0, 0, 0, (List) null, false, 62, (DefaultConstructorMarker) null);
        TtsConfig t = (i != 0 || !z) ? null : t(str);
        AsrRequestConfig.RecognizeData s = s();
        String a2 = AccountUtils.f6173a.a();
        if (a2 == null) {
            a2 = "";
        }
        return new AsrRequestConfig(str2, str, str, str3, str4, AsrConstants.ASR_MICROSOFT, "com.upuphone.ar.transcribe", requestData, s, a2, t, Integer.valueOf(i), (Integer) null, (Long) null, (Long) null, 28672, (DefaultConstructorMarker) null);
    }
}

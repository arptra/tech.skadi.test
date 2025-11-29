package com.upuphone.ar.translation.statemachine.handler;

import android.content.Context;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.IFlyAsrHelper;
import com.upuphone.ar.translation.iflytek.entity.TransConfig;
import com.upuphone.ar.translation.interconnect.entity.StartTrans;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.helper.SwitchLangHelper;
import com.upuphone.ar.translation.phone.helper.TelephoneTransHelper;
import com.upuphone.ar.translation.phone.helper.TtsToGlassHelper;
import com.upuphone.ar.translation.phone.network.NetworkConnectManager;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.NetworkUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.oggopus.OggOpus;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0004\n\u0002\b\u0007*\u0002QU\u0018\u0000 Y2\u00020\u0001:\u0001ZB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\nJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\nJ\r\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\nJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\nJ\r\u0010&\u001a\u00020\b¢\u0006\u0004\b&\u0010\nJ\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\nJ\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\nJ\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\nJ\u0019\u0010,\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b,\u0010-J!\u0010/\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010.\u001a\u00020!H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b1\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010\u0014R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010I\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010HR\u0016\u0010P\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010HR\u0014\u0010T\u001a\u00020Q8\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lcom/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler;", "", "Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateManager;", "stateManger", "Landroid/content/Context;", "context", "<init>", "(Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateManager;Landroid/content/Context;)V", "", "z", "()V", "J", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "t", "()Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper;", "u", "()Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper;", "Lcom/upuphone/ar/translation/phone/network/NetworkConnectManager;", "manager", "I", "(Lcom/upuphone/ar/translation/phone/network/NetworkConnectManager;)V", "Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "startTrans", "H", "(Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;)V", "D", "r", "E", "s", "", "v", "()I", "", "isStart", "A", "(Z)Z", "C", "w", "p", "q", "y", "Lokhttp3/Response;", "reason", "x", "(Lokhttp3/Response;)V", "isInitStart", "F", "(Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;Z)V", "B", "a", "Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateManager;", "b", "Landroid/content/Context;", "c", "Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "mStartTrans", "d", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "mAudioAsrHelper", "e", "Lcom/upuphone/ar/translation/iflytek/IFlyAsrHelper;", "mIFlyAsrHelper", "f", "mSocketChannel", "Lcom/upuphone/oggopus/OggOpus;", "g", "Lcom/upuphone/oggopus/OggOpus;", "mRemoteOggOpus", "h", "mProximalOggOpus", "i", "Z", "mIsUserReminderTts", "j", "Lcom/upuphone/ar/translation/phone/network/NetworkConnectManager;", "mNetworkConnectManager", "k", "mIsScreenOffTeleTrans", "l", "mIsScreenOnOpenAsrChannelForLossNet", "com/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler$mAsrResultCallback$1", "m", "Lcom/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler$mAsrResultCallback$1;", "mAsrResultCallback", "com/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler$mWebSocketMsgListener$1", "n", "Lcom/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler$mWebSocketMsgListener$1;", "mWebSocketMsgListener", "o", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class XunFeiChannelHandler {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final TranslateStateManager f6354a;
    public final Context b;
    public StartTrans c;
    public UnifiedAsrHelper d;
    public IFlyAsrHelper e;
    public int f = -1;
    public OggOpus g;
    public OggOpus h;
    public boolean i;
    public NetworkConnectManager j;
    public boolean k;
    public boolean l;
    public final XunFeiChannelHandler$mAsrResultCallback$1 m = new XunFeiChannelHandler$mAsrResultCallback$1(this);
    public final XunFeiChannelHandler$mWebSocketMsgListener$1 n = new XunFeiChannelHandler$mWebSocketMsgListener$1(this);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler$Companion;", "", "()V", "OGG_AUDIO_CHANNEL", "", "OGG_AUDIO_SAMPLE", "OGG_DECODE_END", "", "OGG_DECODE_START", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public XunFeiChannelHandler(TranslateStateManager translateStateManager, Context context) {
        Intrinsics.checkNotNullParameter(translateStateManager, "stateManger");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6354a = translateStateManager;
        this.b = context;
    }

    public static /* synthetic */ void G(XunFeiChannelHandler xunFeiChannelHandler, StartTrans startTrans, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        xunFeiChannelHandler.F(startTrans, z);
    }

    public final boolean A(boolean z) {
        if (z) {
            IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
            boolean z2 = value != null && value.getCallStatus() == 2;
            int m2 = PreferencesUtils.m();
            String k2 = InterconnectMsgCodExtKt.k(m2);
            LogExt.j("isTelephoneTrans transType=" + k2 + ", isPhoneOffHook=" + z2, "XunFeiChannelHandler");
            if (m2 == 3 && z2) {
                return true;
            }
        } else {
            boolean A = TelephoneTransHelper.f6305a.A();
            boolean z3 = this.k;
            LogExt.j("isTelephoneTrans=" + A + ", mIsScreenOffTeleTrans=" + z3, "XunFeiChannelHandler");
            if (A || this.k) {
                return true;
            }
        }
        return false;
    }

    public final void B(StartTrans startTrans) {
        LogExt.j("notSelfDevAsrChannel 初始化讯飞云端Asr通道", "XunFeiChannelHandler");
        AsrServerChannelUtils asrServerChannelUtils = AsrServerChannelUtils.f6352a;
        TransConfig r = asrServerChannelUtils.r(startTrans);
        TransConfig p = asrServerChannelUtils.p(startTrans);
        boolean z = TranslatorConstants.isStar() || TranslatorConstants.isConcept();
        this.f = z ? 3 : 1;
        int transType = startTrans.getTransType();
        if (transType == 1 || transType == 2) {
            IFlyAsrHelper iFlyAsrHelper = this.e;
            if (iFlyAsrHelper != null) {
                if (!z) {
                    p = null;
                }
                iFlyAsrHelper.w0(r, p);
            }
        } else if (transType != 3) {
            String k2 = InterconnectMsgCodExtKt.k(transType);
            LogExt.j("notSelfDevAsrChannel 异常的翻译类型" + k2, "XunFeiChannelHandler");
        } else {
            LogExt.j("国内版无对话翻译", "XunFeiChannelHandler");
        }
    }

    public final void C() {
        boolean isMicroSoftAsr = TranslatorConstants.isMicroSoftAsr();
        String str = isMicroSoftAsr ? "自研云端" : "讯飞云端";
        LogExt.j("notifyNetworkConnected " + str + "有网重连", "XunFeiChannelHandler");
        if (isMicroSoftAsr) {
            UnifiedAsrHelper unifiedAsrHelper = this.d;
            if (unifiedAsrHelper != null) {
                unifiedAsrHelper.notifyNetworkConnected();
            }
        } else {
            IFlyAsrHelper iFlyAsrHelper = this.e;
            if (iFlyAsrHelper != null) {
                iFlyAsrHelper.d0();
            }
        }
        boolean z = this.l;
        LogExt.j("notifyNetworkConnected mIsScreenOnOpenAsrChannelForLossNet=" + z, "XunFeiChannelHandler");
        if (this.l) {
            E();
        }
    }

    public final void D() {
        NetworkUtils.f6368a.e(this.b, new XunFeiChannelHandler$openAsrChannel$1(this));
    }

    public final void E() {
        NetworkUtils.f6368a.e(this.b, new XunFeiChannelHandler$openAsrChannelForGlassScreenOn$1(this));
    }

    public final void F(StartTrans startTrans, boolean z) {
        LogExt.j("selfDevAsrChannel 初始化自研云端Asr通道", "XunFeiChannelHandler");
        AsrServerChannelUtils asrServerChannelUtils = AsrServerChannelUtils.f6352a;
        AsrRequestConfig.RecognizeData k2 = asrServerChannelUtils.k(this.b);
        boolean A = A(true);
        AsrRequestConfig s = asrServerChannelUtils.s(this.b, startTrans, k2, A);
        AsrRequestConfig q = asrServerChannelUtils.q(this.b, startTrans, k2, A, z);
        int transType = startTrans.getTransType();
        if (transType == 1 || transType == 2) {
            this.f = 1;
            UnifiedAsrHelper unifiedAsrHelper = this.d;
            if (unifiedAsrHelper != null) {
                UnifiedAsrHelper.startRequest$default(unifiedAsrHelper, s, (AsrRequestConfig) null, true, false, 8, (Object) null);
            }
        } else if (transType != 3) {
            String k3 = InterconnectMsgCodExtKt.k(transType);
            LogExt.j("selfDevAsrChannel 异常的翻译类型" + k3, "XunFeiChannelHandler");
        } else {
            this.i = false;
            this.k = false;
            this.f = 3;
            TelephoneTransHelper.f6305a.C(new XunFeiChannelHandler$selfDevAsrChannel$1(this, s, q, startTrans, z));
        }
    }

    public final void H(StartTrans startTrans) {
        StartTrans startTrans2;
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        if (TranslatorConstants.isAirOldLanguage()) {
            LogExt.j("setChannelConfig is air old=" + startTrans, "XunFeiChannelHandler");
            startTrans2 = AsrServerChannelUtils.f6352a.t(startTrans);
        } else {
            LogExt.j("setChannelConfig is star, concept, multi language air=" + startTrans, "XunFeiChannelHandler");
            startTrans2 = AsrServerChannelUtils.f6352a.u(startTrans);
        }
        this.c = startTrans2;
    }

    public final void I(NetworkConnectManager networkConnectManager) {
        Intrinsics.checkNotNullParameter(networkConnectManager, "manager");
        this.j = networkConnectManager;
    }

    public final void J() {
        if (TranslatorConstants.isMicroSoftAsr()) {
            LogExt.j("[unInit] 释放云端【自研】ASR服务", "XunFeiChannelHandler");
            UnifiedAsrHelper unifiedAsrHelper = this.d;
            if (unifiedAsrHelper != null) {
                unifiedAsrHelper.unRegisterAsrResultCallback("PhoneChannelInitHandlerImpl", this.m);
                unifiedAsrHelper.release();
            }
            this.d = null;
        } else {
            LogExt.j("[unInit] 释放云端【讯飞】ASR服务", "XunFeiChannelHandler");
            IFlyAsrHelper iFlyAsrHelper = this.e;
            if (iFlyAsrHelper != null) {
                iFlyAsrHelper.C0("PhoneChannelInitHandlerImpl", this.n);
                iFlyAsrHelper.p0();
            }
            this.e = null;
        }
        this.g = null;
        this.h = null;
        this.j = null;
    }

    public final void p() {
        LogExt.j("asrReconnectStart 通知弱网提示", "XunFeiChannelHandler");
        NetworkConnectManager networkConnectManager = this.j;
        if (networkConnectManager != null && !networkConnectManager.v() && networkConnectManager.t()) {
            this.f6354a.l();
        }
    }

    public final void q() {
        LogExt.j("asrReconnectSuccess 通知网络良好提示", "XunFeiChannelHandler");
        NetworkConnectManager networkConnectManager = this.j;
        if (networkConnectManager != null && !networkConnectManager.v()) {
            this.f6354a.m();
        }
    }

    public final void r() {
        IFlyAsrHelper iFlyAsrHelper;
        UnifiedAsrHelper unifiedAsrHelper;
        if (TranslatorConstants.isMicroSoftAsr()) {
            LogExt.j("closeAsrChannel 【自研Asr服务】", "XunFeiChannelHandler");
            NetworkConnectManager networkConnectManager = this.j;
            if (networkConnectManager != null && (unifiedAsrHelper = this.d) != null && unifiedAsrHelper.isAutoReconnecting() && !networkConnectManager.v()) {
                this.f6354a.m();
            }
            UnifiedAsrHelper unifiedAsrHelper2 = this.d;
            if (unifiedAsrHelper2 != null) {
                unifiedAsrHelper2.stopRequest();
            }
        } else {
            LogExt.j("closeAsrChannel 【讯飞Asr服务】", "XunFeiChannelHandler");
            NetworkConnectManager networkConnectManager2 = this.j;
            if (networkConnectManager2 != null && (iFlyAsrHelper = this.e) != null && iFlyAsrHelper.Z() && !networkConnectManager2.v()) {
                this.f6354a.m();
            }
            IFlyAsrHelper iFlyAsrHelper2 = this.e;
            if (iFlyAsrHelper2 != null) {
                iFlyAsrHelper2.B0();
            }
        }
        this.c = null;
        this.f = -1;
        this.i = false;
        this.k = false;
        this.l = false;
        TtsToGlassHelper.f6315a.o();
        TelephoneTransHelper.f6305a.D();
    }

    public final void s() {
        IFlyAsrHelper iFlyAsrHelper;
        UnifiedAsrHelper unifiedAsrHelper;
        if (TranslatorConstants.isMicroSoftAsr()) {
            LogExt.j("closeAsrChannelForGlassScreenOff 【自研Asr服务】", "XunFeiChannelHandler");
            NetworkConnectManager networkConnectManager = this.j;
            if (networkConnectManager != null && (unifiedAsrHelper = this.d) != null && unifiedAsrHelper.isAutoReconnecting() && !networkConnectManager.v()) {
                this.f6354a.m();
            }
            UnifiedAsrHelper unifiedAsrHelper2 = this.d;
            if (unifiedAsrHelper2 != null) {
                unifiedAsrHelper2.stopRequest();
            }
        } else {
            LogExt.j("closeAsrChannelForGlassScreenOff 【讯飞Asr服务】", "XunFeiChannelHandler");
            NetworkConnectManager networkConnectManager2 = this.j;
            if (networkConnectManager2 != null && (iFlyAsrHelper = this.e) != null && iFlyAsrHelper.Z() && !networkConnectManager2.v()) {
                this.f6354a.m();
            }
            IFlyAsrHelper iFlyAsrHelper2 = this.e;
            if (iFlyAsrHelper2 != null) {
                iFlyAsrHelper2.B0();
            }
        }
        this.i = false;
        TelephoneTransHelper telephoneTransHelper = TelephoneTransHelper.f6305a;
        this.k = telephoneTransHelper.A();
        TtsToGlassHelper.f6315a.o();
        telephoneTransHelper.D();
    }

    public final UnifiedAsrHelper t() {
        return this.d;
    }

    public final IFlyAsrHelper u() {
        return this.e;
    }

    public final int v() {
        return this.f;
    }

    public final void w() {
        int b2 = this.f6354a.b();
        String j2 = InterconnectMsgCodExtKt.j(b2);
        LogExt.j("handleOnClosed transState" + j2, "XunFeiChannelHandler");
        if (b2 == 2) {
            SwitchLangHelper.i(this.b);
            TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1002, null));
        }
    }

    public final void x(Response response) {
        LogExt.j("handleOnFailure reason=" + response, "XunFeiChannelHandler");
        this.f6354a.t();
        boolean z = false;
        if (response != null && response.code() == 10011) {
            z = true;
        }
        int b2 = this.f6354a.b();
        String j2 = InterconnectMsgCodExtKt.j(b2);
        LogExt.j("handleOnFailure networkError=" + z + ", transState" + j2, "XunFeiChannelHandler");
        if (!z || b2 != 4) {
            NetworkUtils.f6368a.d(this.b, 100, new XunFeiChannelHandler$handleOnFailure$1(this));
        }
    }

    public final void y() {
        LogExt.j("handleOnOpen", "XunFeiChannelHandler");
        this.f6354a.v();
        this.f6354a.t();
    }

    public final void z() {
        if (TranslatorConstants.isMicroSoftAsr()) {
            LogExt.j("[init] 初始化云端【自研】ASR服务", "XunFeiChannelHandler");
            UnifiedAsrHelper unifiedAsrHelper = new UnifiedAsrHelper(TranslatorConstants.SOCKET_ASR_APP_NAME, true);
            unifiedAsrHelper.registerAsrResultCallback("PhoneChannelInitHandlerImpl", this.m);
            this.d = unifiedAsrHelper;
        } else {
            LogExt.j("[init] 初始化云端【讯飞】ASR服务", "XunFeiChannelHandler");
            IFlyAsrHelper iFlyAsrHelper = new IFlyAsrHelper();
            iFlyAsrHelper.o0("PhoneChannelInitHandlerImpl", this.n);
            this.e = iFlyAsrHelper;
        }
        InterConnectHelper.c.a().p();
        OggOpus.Builder builder = new OggOpus.Builder();
        builder.c(1);
        builder.d(16000);
        builder.b(1);
        OggOpus a2 = builder.a();
        a2.init();
        this.g = a2;
        OggOpus.Builder builder2 = new OggOpus.Builder();
        builder2.c(1);
        builder2.d(16000);
        builder2.b(1);
        OggOpus a3 = builder2.a();
        a3.init();
        this.h = a3;
    }
}

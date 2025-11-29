package com.upuphone.ar.transcribe.statemachine.handler;

import android.content.Context;
import com.upuphone.ar.transcribe.asr.XJAsrManager;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.StartTrans;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.statemachine.machine.TranscribeStateManager;
import com.upuphone.ar.transcribe.utils.LanguageUtils;
import com.upuphone.ar.transcribe.utils.NetworkUtils;
import com.upuphone.oggopus.OggOpus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0006*\u00011\u0018\u0000 \u00152\u00020\u0001:\u00015B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\fJ\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\fJ\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020*8\u0006@BX\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/upuphone/ar/transcribe/statemachine/handler/XunFeiChannelHandler;", "", "Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;", "stateManger", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "", "l", "()V", "v", "Lcom/upuphone/ar/transcribe/interconnect/entity/StartTrans;", "startTrans", "t", "(Lcom/upuphone/ar/transcribe/interconnect/entity/StartTrans;)V", "o", "m", "p", "h", "q", "r", "u", "s", "j", "k", "i", "a", "Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;", "b", "Landroid/content/Context;", "c", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lcom/upuphone/ar/transcribe/interconnect/entity/StartTrans;", "mStartTrans", "Lcom/upuphone/oggopus/OggOpus;", "e", "Lcom/upuphone/oggopus/OggOpus;", "oggOpus", "", "<set-?>", "f", "Z", "n", "()Z", "isTelTtsReceived", "com/upuphone/ar/transcribe/statemachine/handler/XunFeiChannelHandler$mWebSocketMsgListener$1", "g", "Lcom/upuphone/ar/transcribe/statemachine/handler/XunFeiChannelHandler$mWebSocketMsgListener$1;", "mWebSocketMsgListener", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class XunFeiChannelHandler {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final TranscribeStateManager f6165a;
    public final Context b;
    public final CoroutineScope c;
    public StartTrans d;
    public OggOpus e;
    public boolean f;
    public final XunFeiChannelHandler$mWebSocketMsgListener$1 g = new XunFeiChannelHandler$mWebSocketMsgListener$1(this);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/transcribe/statemachine/handler/XunFeiChannelHandler$Companion;", "", "()V", "OGG_DECODE_END", "", "OGG_DECODE_START", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public XunFeiChannelHandler(TranscribeStateManager transcribeStateManager, Context context, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(transcribeStateManager, "stateManger");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f6165a = transcribeStateManager;
        this.b = context;
        this.c = coroutineScope;
    }

    public final void h() {
        LogExt.g("closeAsrChannelForGlassScreenOff", "XunFeiChannelHandler");
        XJAsrManager.e.a().r();
    }

    public final void i() {
        StartTrans startTrans = new StartTrans(TranscribeManager.j.a().l(), "cn", "cnen", false, 0, false, false, 120, (DefaultConstructorMarker) null);
        this.d = startTrans;
        LogExt.g("createAirOldConfigInfo mStartTrans=" + startTrans, "XunFeiChannelHandler");
    }

    public final void j() {
        if (TranscribeConstants.f6027a.h()) {
            i();
        } else {
            k();
        }
    }

    public final void k() {
        String d2 = TranscribeConstants.f6027a.d();
        StartTrans startTrans = this.d;
        LogExt.d("Start==> createNewConfigInfo " + d2 + ", mStartTrans=" + startTrans, "XunFeiChannelHandler");
        LanguageUtils.StoredLanguage c2 = LanguageUtils.c(this.b, false, false, 6, (Object) null);
        StartTrans startTrans2 = Intrinsics.areEqual((Object) "cnen", (Object) c2.a()) ? new StartTrans(TranscribeManager.j.a().l(), "en", "en", false, 0, false, false, 120, (DefaultConstructorMarker) null) : new StartTrans(TranscribeManager.j.a().l(), c2.a(), c2.a(), false, 0, false, false, 120, (DefaultConstructorMarker) null);
        this.d = startTrans2;
        LogExt.d("End==> createNewConfigInfo mStartTrans=" + startTrans2, "XunFeiChannelHandler");
    }

    public final void l() {
        String d2 = TranscribeConstants.f6027a.d();
        LogExt.g("init初始化 " + d2, "XunFeiChannelHandler");
        XJAsrManager.Companion companion = XJAsrManager.e;
        companion.a().v();
        companion.a().x("TranscribeInitHandlerImpl", this.g);
        InterConnectHelper.c.a().p();
        OggOpus.Builder builder = new OggOpus.Builder();
        builder.c(1);
        builder.d(16000);
        builder.b(1);
        OggOpus a2 = builder.a();
        a2.init();
        this.e = a2;
        this.f = false;
    }

    public final void m() {
        NetworkUtils.f6189a.b(this.b, new XunFeiChannelHandler$initTranslateChannel$1(this));
    }

    public final boolean n() {
        return this.f;
    }

    public final void o() {
        LogExt.g("notifyNetworkConnected 通知有网重连", "XunFeiChannelHandler");
        XJAsrManager.e.a().w();
    }

    public final void p() {
        NetworkUtils.f6189a.b(this.b, new XunFeiChannelHandler$openAsrChannelForGlassScreenOn$1(this));
    }

    public final void q() {
        String d2 = TranscribeConstants.f6027a.d();
        LogExt.g("releaseTranslateChannel " + d2, "XunFeiChannelHandler");
        XJAsrManager.e.a().r();
        this.d = null;
    }

    public final void r() {
        this.f6165a.z();
        Job unused = BuildersKt__Builders_commonKt.d(this.c, (CoroutineContext) null, (CoroutineStart) null, new XunFeiChannelHandler$sendIFlyConnectErrorMsg$1(this, (Continuation<? super XunFeiChannelHandler$sendIFlyConnectErrorMsg$1>) null), 3, (Object) null);
    }

    public final void s(StartTrans startTrans) {
        int i = 1;
        if (startTrans.getTransType() != 1) {
            i = startTrans.getTransType();
        }
        StartTrans startTrans2 = new StartTrans(i, "cn", "cnen", false, 0, false, false, 120, (DefaultConstructorMarker) null);
        this.d = startTrans2;
        LogExt.g("setAirOldChannelConfig mStartTrans=" + startTrans2 + ", startTrans=" + startTrans, "XunFeiChannelHandler");
    }

    public final void t(StartTrans startTrans) {
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        if (TranscribeConstants.f6027a.h()) {
            LogExt.g("setChannelConfig is air old version=" + startTrans, "XunFeiChannelHandler");
            s(startTrans);
            return;
        }
        LogExt.g("setChannelConfig is star, concept, multi language air=" + startTrans, "XunFeiChannelHandler");
        u(startTrans);
    }

    public final void u(StartTrans startTrans) {
        String d2 = TranscribeConstants.f6027a.d();
        String a2 = LanguageUtils.c(this.b, false, false, 6, (Object) null).a();
        LogExt.g("Start==> setNewChannelConfig " + d2 + ", transcribeSrc=" + a2, "XunFeiChannelHandler");
        StartTrans startTrans2 = this.d;
        LogExt.g("Start==> setNewChannelConfig mStartTrans:: " + startTrans2 + ", startTrans=" + startTrans, "XunFeiChannelHandler");
        if (Intrinsics.areEqual((Object) a2, (Object) "cnen")) {
            a2 = "en";
        }
        String str = a2;
        StartTrans startTrans3 = new StartTrans(startTrans.getTransType(), str, str, false, 0, false, false, 120, (DefaultConstructorMarker) null);
        this.d = startTrans3;
        LogExt.g("End==> setNewChannelConfig mStartTrans:: " + startTrans3, "XunFeiChannelHandler");
    }

    public final void v() {
        String c2 = TranscribeConstants.f6027a.c();
        LogExt.g("unInit反初始化 " + c2, "XunFeiChannelHandler");
        XJAsrManager.Companion companion = XJAsrManager.e;
        companion.a().B("TranscribeInitHandlerImpl", this.g);
        companion.a().q();
        this.f = false;
    }
}

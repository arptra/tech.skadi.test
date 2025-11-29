package com.upuphone.ar.transcribe.statemachine.handler;

import com.upuphone.ar.transcribe.asr.XJAsrManager;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.StartTrans;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.phone.helper.TtsDataSender;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class XunFeiChannelHandler$initTranslateChannel$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ XunFeiChannelHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public XunFeiChannelHandler$initTranslateChannel$1(XunFeiChannelHandler xunFeiChannelHandler) {
        super(1);
        this.this$0 = xunFeiChannelHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            LogExt.g("initTranslateChannel: 当前网络异常不能翻译", "XunFeiChannelHandler");
            this.this$0.f6165a.o();
            return;
        }
        StartTrans c = this.this$0.d;
        LogExt.g("initTranslateChannel mStartTrans:: " + c, "XunFeiChannelHandler");
        if (this.this$0.d == null) {
            this.this$0.j();
            StartTrans c2 = this.this$0.d;
            LogExt.g("initTranslateChannel mStartTrans createConfigInfo:: " + c2, "XunFeiChannelHandler");
        }
        StartTrans c3 = this.this$0.d;
        if (c3 != null) {
            XunFeiChannelHandler xunFeiChannelHandler = this.this$0;
            ArrayList arrayListOf = CollectionsKt.arrayListOf("cn", "en", "cnen", "ja");
            if (TranscribeManager.j.a().l() == 1 || arrayListOf.contains(c3.getSrc())) {
                XJAsrManager.e.a().y(c3);
                xunFeiChannelHandler.f6165a.A();
                InterConnectHelper.c.a().A(c3.getTransType(), c3.getSrc(), c3.getDst());
                TtsDataSender.f6112a.f();
                return;
            }
            xunFeiChannelHandler.f6165a.u();
        }
    }
}

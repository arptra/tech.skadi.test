package com.upuphone.ar.translation.statemachine.handler;

import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.interconnect.entity.StartTrans;
import com.upuphone.ar.translation.phone.helper.TtsToGlassHelper;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class XunFeiChannelHandler$selfDevAsrChannel$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ boolean $isInitStart;
    final /* synthetic */ AsrRequestConfig $proximalTransConfig;
    final /* synthetic */ AsrRequestConfig $remoteTransConfig;
    final /* synthetic */ StartTrans $startTrans;
    final /* synthetic */ XunFeiChannelHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public XunFeiChannelHandler$selfDevAsrChannel$1(XunFeiChannelHandler xunFeiChannelHandler, AsrRequestConfig asrRequestConfig, AsrRequestConfig asrRequestConfig2, StartTrans startTrans, boolean z) {
        super(1);
        this.this$0 = xunFeiChannelHandler;
        this.$remoteTransConfig = asrRequestConfig;
        this.$proximalTransConfig = asrRequestConfig2;
        this.$startTrans = startTrans;
        this.$isInitStart = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            UnifiedAsrHelper c = this.this$0.d;
            if (c != null) {
                UnifiedAsrHelper.startRequest$default(c, this.$remoteTransConfig, this.$proximalTransConfig, true, false, 8, (Object) null);
            }
        } else if (AsrServerChannelUtils.f6352a.o(this.$startTrans)) {
            TranslationApp.INSTANCE.getEarlyInterConnectHelper$ar_translator_intlRelease().sendTelephoneCallAudio();
            UnifiedAsrHelper c2 = this.this$0.d;
            if (c2 != null) {
                UnifiedAsrHelper.startRequest$default(c2, this.$remoteTransConfig, this.$proximalTransConfig, true, false, 8, (Object) null);
            }
            TtsToGlassHelper.f6315a.n();
            if (!this.$isInitStart) {
                this.this$0.i = true;
            }
        } else {
            this.this$0.f6354a.z();
        }
    }
}

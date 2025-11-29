package com.upuphone.ar.translation.statemachine.handler;

import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.StartTrans;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isAccessible", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class XunFeiChannelHandler$openAsrChannelForGlassScreenOn$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ XunFeiChannelHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public XunFeiChannelHandler$openAsrChannelForGlassScreenOn$1(XunFeiChannelHandler xunFeiChannelHandler) {
        super(1);
        this.this$0 = xunFeiChannelHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            LogExt.j("openAsrChannelForGlassScreenOn 当前网络异常不能翻译", "XunFeiChannelHandler");
            this.this$0.l = true;
            return;
        }
        this.this$0.l = false;
        StartTrans g = this.this$0.c;
        LogExt.j("openAsrChannelForGlassScreenOn mStartTrans=" + g, "XunFeiChannelHandler");
        if (this.this$0.c == null) {
            this.this$0.c = AsrServerChannelUtils.f6352a.b();
            StartTrans g2 = this.this$0.c;
            LogExt.j("openAsrChannelForGlassScreenOn createConfigInfo mStartTrans=" + g2, "XunFeiChannelHandler");
        }
        StartTrans g3 = this.this$0.c;
        if (g3 != null) {
            XunFeiChannelHandler xunFeiChannelHandler = this.this$0;
            if (TranslatorConstants.isMicroSoftAsr()) {
                xunFeiChannelHandler.F(g3, false);
            } else {
                xunFeiChannelHandler.B(g3);
            }
            LogExt.a();
        }
    }
}

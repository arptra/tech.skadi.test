package com.upuphone.ar.translation.iflytek;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.IFlyAsrHelper;
import com.upuphone.ar.translation.iflytek.entity.TransConfig;
import com.upuphone.ar.translation.iflytek.ext.TranslationReqConfigExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import okhttp3.Request;
import okhttp3.WebSocket;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "seconds", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IFlyAsrHelper$startProximalRequest$1 extends Lambda implements Function2<Long, Long, Unit> {
    final /* synthetic */ TransConfig $transConfig;
    final /* synthetic */ IFlyAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IFlyAsrHelper$startProximalRequest$1(IFlyAsrHelper iFlyAsrHelper, TransConfig transConfig) {
        super(2);
        this.this$0 = iFlyAsrHelper;
        this.$transConfig = transConfig;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j, long j2) {
        IFlyAsrHelper iFlyAsrHelper = this.this$0;
        iFlyAsrHelper.o = iFlyAsrHelper.Q();
        this.this$0.l = this.$transConfig;
        if (this.this$0.j != null) {
            LogExt.j("startProximalRequest websocket is not null", "IFlyAsrHelper");
            WebSocket l = this.this$0.j;
            if (l != null) {
                l.cancel();
            }
            this.this$0.j = null;
            this.this$0.k = null;
        }
        String a2 = TranslationReqConfigExtKt.a(this.this$0.U(this.$transConfig, j2));
        LogExt.j("startProximalRequest url is=" + a2, "IFlyAsrHelper");
        IFlyAsrHelper iFlyAsrHelper2 = this.this$0;
        IFlyAsrHelper.ProximalSocketListener proximalSocketListener = new IFlyAsrHelper.ProximalSocketListener();
        IFlyAsrHelper iFlyAsrHelper3 = this.this$0;
        iFlyAsrHelper3.j = iFlyAsrHelper3.S().newWebSocket(new Request.Builder().url(a2).build(), proximalSocketListener);
        iFlyAsrHelper2.k = proximalSocketListener;
    }
}

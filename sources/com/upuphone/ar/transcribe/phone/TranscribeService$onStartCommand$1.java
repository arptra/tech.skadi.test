package com.upuphone.ar.transcribe.phone;

import android.content.Context;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeService$onStartCommand$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TranscribeService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeService$onStartCommand$1(TranscribeService transcribeService) {
        super(0);
        this.this$0 = transcribeService;
    }

    public final void invoke() {
        if (this.this$0.f()) {
            LogExt.g("转写启动: 眼镜和手机连接成功，发送启动眼镜Scene消息", "TranscribeService");
            InterConnectHelper a2 = InterConnectHelper.c.a();
            Context applicationContext = this.this$0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            a2.B(applicationContext);
            return;
        }
        LogExt.g("转写启动: 眼镜和手机未连接成功，异常的转写服务启动", "TranscribeService");
        TranscribeApp.stopService(this.this$0);
    }
}

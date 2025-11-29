package com.upuphone.ar.translation.phone;

import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslationService$handleOnStartCommand$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TranslationService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationService$handleOnStartCommand$1(TranslationService translationService) {
        super(0);
        this.this$0 = translationService;
    }

    public final void invoke() {
        if (!this.this$0.g()) {
            LogExt.j("[ON_START_COMMAND]眼镜和手机未连接成功，异常的翻译服务启动", "TranslationService");
            TranslationApp.stopService(this.this$0);
        } else if (!TranslationApp.INSTANCE.isUserAgree$ar_translator_intlRelease()) {
            LogExt.j("[ON_START_COMMAND]用户协议未同意，异常的服务启动", "TranslationService");
            InterConnectHelper.c.a().q();
            TranslationApp.stopService(this.this$0);
        } else {
            LogExt.j("[ON_START_COMMAND]眼镜和手机连接成功，发送启动眼镜Scene消息", "TranslationService");
            InterConnectHelper.c.a().C();
        }
    }
}

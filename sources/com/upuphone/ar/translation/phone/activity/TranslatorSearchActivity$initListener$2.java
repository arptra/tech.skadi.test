package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.listener.UiUpdateCallbackAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/translation/phone/activity/TranslatorSearchActivity$initListener$2", "Lcom/upuphone/ar/translation/phone/listener/UiUpdateCallbackAdapter;", "notifyVariousMsg", "", "T", "operateMessage", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslatorSearchActivity$initListener$2 extends UiUpdateCallbackAdapter {
    final /* synthetic */ TranslatorSearchActivity this$0;

    public TranslatorSearchActivity$initListener$2(TranslatorSearchActivity translatorSearchActivity) {
        this.this$0 = translatorSearchActivity;
    }

    public <T> void notifyVariousMsg(@NotNull OperateMessage<T> operateMessage) {
        Intrinsics.checkNotNullParameter(operateMessage, "operateMessage");
        super.notifyVariousMsg(operateMessage);
        this.this$0.handleUiUpdateCallback(operateMessage);
    }
}

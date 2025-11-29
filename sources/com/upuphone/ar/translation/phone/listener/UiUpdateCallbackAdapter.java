package com.upuphone.ar.translation.phone.listener;

import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/translation/phone/listener/UiUpdateCallbackAdapter;", "Lcom/upuphone/ar/translation/phone/listener/UiUpdateCallback;", "()V", "notifyTranslateState", "", "transStateEvent", "Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "notifyVariousMsg", "T", "operateMessage", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class UiUpdateCallbackAdapter implements UiUpdateCallback {
    public void notifyTranslateState(@NotNull TransStateEvent transStateEvent) {
        Intrinsics.checkNotNullParameter(transStateEvent, "transStateEvent");
    }

    public void notifyVariousMsg(OperateMessage operateMessage) {
        Intrinsics.checkNotNullParameter(operateMessage, "operateMessage");
    }
}

package com.upuphone.ar.translation.phone.listener;

import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\tH&¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/listener/UiUpdateCallback;", "", "notifyTranslateState", "", "transStateEvent", "Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "notifyVariousMsg", "T", "operateMessage", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface UiUpdateCallback {
    void notifyTranslateState(TransStateEvent transStateEvent);

    void notifyVariousMsg(OperateMessage operateMessage);
}

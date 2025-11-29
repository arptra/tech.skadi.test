package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import com.upuphone.ar.translation.phone.listener.UiUpdateCallbackAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/ar/translation/phone/fragment/SimulTranslationFragment$mUiUpdateCallback$1", "Lcom/upuphone/ar/translation/phone/listener/UiUpdateCallbackAdapter;", "notifyTranslateState", "", "transStateEvent", "Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "notifyVariousMsg", "T", "operateMessage", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SimulTranslationFragment$mUiUpdateCallback$1 extends UiUpdateCallbackAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimulTranslationFragment f6280a;

    public SimulTranslationFragment$mUiUpdateCallback$1(SimulTranslationFragment simulTranslationFragment) {
        this.f6280a = simulTranslationFragment;
    }

    public void notifyTranslateState(TransStateEvent transStateEvent) {
        Intrinsics.checkNotNullParameter(transStateEvent, "transStateEvent");
        super.notifyTranslateState(transStateEvent);
        this.f6280a.S0(transStateEvent);
    }

    public void notifyVariousMsg(OperateMessage operateMessage) {
        Intrinsics.checkNotNullParameter(operateMessage, "operateMessage");
        super.notifyVariousMsg(operateMessage);
        this.f6280a.T0(operateMessage);
    }
}

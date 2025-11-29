package com.upuphone.ar.translation.phone;

import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslationManager$mTranslatorUiListener$1$notifyTranslateServerRunningState$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Object $obj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationManager$mTranslatorUiListener$1$notifyTranslateServerRunningState$1(Object obj) {
        super(0);
        this.$obj = obj;
    }

    public final void invoke() {
        if (this.$obj instanceof String) {
            InterConnectHelper.c.a().o((String) this.$obj);
        }
    }
}

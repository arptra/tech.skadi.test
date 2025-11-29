package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isAccessible", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SpeechTranscribeFragment$startTranscribe$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $langDst;
    final /* synthetic */ String $langSrc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechTranscribeFragment$startTranscribe$1$1(String str, String str2) {
        super(1);
        this.$langSrc = str;
        this.$langDst = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            TranslateStateManager p = TranslationManager.q.a().p();
            if (p != null) {
                p.j();
                return;
            }
            return;
        }
        InterConnectHelper.c.a().z(1, this.$langSrc, this.$langDst);
        TranslateStateManager p2 = TranslationManager.q.a().p();
        if (p2 != null) {
            p2.y();
        }
    }
}

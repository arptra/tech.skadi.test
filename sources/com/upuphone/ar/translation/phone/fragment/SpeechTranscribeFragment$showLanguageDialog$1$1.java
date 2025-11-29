package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.bean.LanguageBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "languageBean", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SpeechTranscribeFragment$showLanguageDialog$1$1 extends Lambda implements Function1<LanguageBean, Unit> {
    final /* synthetic */ SpeechTranscribeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechTranscribeFragment$showLanguageDialog$1$1(SpeechTranscribeFragment speechTranscribeFragment) {
        super(1);
        this.this$0 = speechTranscribeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LanguageBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LanguageBean languageBean) {
        Intrinsics.checkNotNullParameter(languageBean, "languageBean");
        this.this$0.b = languageBean;
        this.this$0.V0();
    }
}

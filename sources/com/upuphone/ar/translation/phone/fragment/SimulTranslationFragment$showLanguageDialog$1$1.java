package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.bean.LanguageBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "src", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "dst", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SimulTranslationFragment$showLanguageDialog$1$1 extends Lambda implements Function2<LanguageBean, LanguageBean, Unit> {
    final /* synthetic */ SimulTranslationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimulTranslationFragment$showLanguageDialog$1$1(SimulTranslationFragment simulTranslationFragment) {
        super(2);
        this.this$0 = simulTranslationFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LanguageBean) obj, (LanguageBean) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LanguageBean languageBean, @NotNull LanguageBean languageBean2) {
        Intrinsics.checkNotNullParameter(languageBean, "src");
        Intrinsics.checkNotNullParameter(languageBean2, "dst");
        this.this$0.P0().F(languageBean, languageBean2);
    }
}

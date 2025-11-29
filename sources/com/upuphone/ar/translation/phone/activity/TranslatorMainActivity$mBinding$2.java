package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorMainBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/translation/phone/databinding/ActivityTranslatorMainBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorMainActivity$mBinding$2 extends Lambda implements Function0<ActivityTranslatorMainBinding> {
    final /* synthetic */ TranslatorMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainActivity$mBinding$2(TranslatorMainActivity translatorMainActivity) {
        super(0);
        this.this$0 = translatorMainActivity;
    }

    @NotNull
    public final ActivityTranslatorMainBinding invoke() {
        ActivityTranslatorMainBinding c = ActivityTranslatorMainBinding.c(this.this$0.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        return c;
    }
}

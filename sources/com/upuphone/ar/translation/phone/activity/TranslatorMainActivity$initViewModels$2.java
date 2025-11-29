package com.upuphone.ar.translation.phone.activity;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTranslatorMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorMainActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorMainActivity$initViewModels$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,606:1\n262#2,2:607\n*S KotlinDebug\n*F\n+ 1 TranslatorMainActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorMainActivity$initViewModels$2\n*L\n231#1:607,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorMainActivity$initViewModels$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TranslatorMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainActivity$initViewModels$2(TranslatorMainActivity translatorMainActivity) {
        super(1);
        this.this$0 = translatorMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        ConstraintLayout constraintLayout = this.this$0.getMBinding().e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "clTelephoneUserTip");
        Intrinsics.checkNotNull(bool);
        constraintLayout.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}

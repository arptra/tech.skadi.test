package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.LanguageMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "Lcom/upuphone/xr/sapp/entity/LanguageMode;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class LanguageFragment$initView$4 extends Lambda implements Function1<LanguageMode, Unit> {
    final /* synthetic */ LanguageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LanguageFragment$initView$4(LanguageFragment languageFragment) {
        super(1);
        this.this$0 = languageFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LanguageMode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LanguageMode languageMode) {
        Intrinsics.checkNotNullParameter(languageMode, "data");
        if (this.this$0.t) {
            this.this$0.V0(languageMode.getLanguage());
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = this.this$0.getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }
}

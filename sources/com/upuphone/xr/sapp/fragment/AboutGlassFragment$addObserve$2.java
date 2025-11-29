package com.upuphone.xr.sapp.fragment;

import android.widget.TextView;
import com.upuphone.xr.sapp.databinding.FragmentAboutGlassBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nAboutGlassFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AboutGlassFragment.kt\ncom/upuphone/xr/sapp/fragment/AboutGlassFragment$addObserve$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,281:1\n256#2,2:282\n*S KotlinDebug\n*F\n+ 1 AboutGlassFragment.kt\ncom/upuphone/xr/sapp/fragment/AboutGlassFragment$addObserve$2\n*L\n103#1:282,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AboutGlassFragment$addObserve$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ AboutGlassFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AboutGlassFragment$addObserve$2(AboutGlassFragment aboutGlassFragment) {
        super(1);
        this.this$0 = aboutGlassFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        FragmentAboutGlassBinding O0 = this.this$0.k;
        if (O0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            O0 = null;
        }
        TextView textView = O0.o;
        Intrinsics.checkNotNullExpressionValue(textView, "tvGlassUpdateBadge");
        Intrinsics.checkNotNull(bool);
        textView.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}

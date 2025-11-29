package com.upuphone.xr.sapp.fragment;

import android.widget.ImageView;
import com.upuphone.xr.sapp.databinding.FragmentSettingBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nSettingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingFragment.kt\ncom/upuphone/xr/sapp/fragment/SettingFragment$addObserver$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,178:1\n256#2,2:179\n*S KotlinDebug\n*F\n+ 1 SettingFragment.kt\ncom/upuphone/xr/sapp/fragment/SettingFragment$addObserver$1\n*L\n56#1:179,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SettingFragment$addObserver$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ SettingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingFragment$addObserver$1(SettingFragment settingFragment) {
        super(1);
        this.this$0 = settingFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        FragmentSettingBinding L0 = this.this$0.j;
        if (L0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            L0 = null;
        }
        ImageView imageView = L0.i;
        Intrinsics.checkNotNullExpressionValue(imageView, "needUpdateVersion");
        Intrinsics.checkNotNull(bool);
        imageView.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}

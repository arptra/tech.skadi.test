package com.upuphone.xr.sapp.fragment;

import android.widget.ImageView;
import com.upuphone.xr.sapp.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nMineFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MineFragment.kt\ncom/upuphone/xr/sapp/fragment/MineFragment$addObserve$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,367:1\n256#2,2:368\n256#2,2:370\n*S KotlinDebug\n*F\n+ 1 MineFragment.kt\ncom/upuphone/xr/sapp/fragment/MineFragment$addObserve$1\n*L\n107#1:368,2\n109#1:370,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MineFragment$addObserve$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ MineFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MineFragment$addObserve$1(MineFragment mineFragment) {
        super(1);
        this.this$0 = mineFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        Boolean bool2 = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool2, "COUNTRY_INTL");
        int i = 8;
        if (bool2.booleanValue()) {
            ImageView imageView = this.this$0.I0().h;
            Intrinsics.checkNotNullExpressionValue(imageView, "checkUpdateVersion");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.this$0.I0().h;
        Intrinsics.checkNotNullExpressionValue(imageView2, "checkUpdateVersion");
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            i = 0;
        }
        imageView2.setVisibility(i);
    }
}

package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassInfoFragment$upDateDemoMode$1$1$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $glassDebugMode;
    final /* synthetic */ GlassInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassInfoFragment$upDateDemoMode$1$1$onSuccess$1(GlassInfoFragment glassInfoFragment, boolean z) {
        super(0);
        this.this$0 = glassInfoFragment;
        this.$glassDebugMode = z;
    }

    public final void invoke() {
        this.this$0.n0().S().postValue(Boolean.valueOf(this.$glassDebugMode));
        if (this.$glassDebugMode) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = this.this$0.getString(R.string.glass_debug_mode_open);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
            return;
        }
        UToast.Companion companion2 = UToast.f6444a;
        Context requireContext2 = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        String string2 = this.this$0.getString(R.string.glass_debug_mode_close);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        companion2.d(requireContext2, string2);
    }
}

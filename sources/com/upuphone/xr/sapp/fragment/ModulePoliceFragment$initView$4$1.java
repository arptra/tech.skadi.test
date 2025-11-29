package com.upuphone.xr.sapp.fragment;

import android.widget.TextView;
import com.upuphone.xr.sapp.databinding.FragmentModulePoliceBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ModulePoliceFragment$initView$4$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ModulePoliceFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModulePoliceFragment$initView$4$1(ModulePoliceFragment modulePoliceFragment) {
        super(0);
        this.this$0 = modulePoliceFragment;
    }

    public final void invoke() {
        ModulePoliceFragment modulePoliceFragment = this.this$0;
        FragmentModulePoliceBinding G0 = modulePoliceFragment.j;
        if (G0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            G0 = null;
        }
        TextView textView = G0.f;
        Intrinsics.checkNotNullExpressionValue(textView, "cancelNaviAgree");
        modulePoliceFragment.O0(textView, "privacy_argreement_key_ar_navi");
    }
}

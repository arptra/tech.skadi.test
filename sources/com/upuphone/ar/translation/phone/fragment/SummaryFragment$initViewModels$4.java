package com.upuphone.ar.translation.phone.fragment;

import android.view.ViewGroup;
import android.widget.ScrollView;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.databinding.FragmentSummaryBinding;
import com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SummaryFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SummaryFragment$initViewModels$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,678:1\n329#2,4:679\n*S KotlinDebug\n*F\n+ 1 SummaryFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SummaryFragment$initViewModels$4\n*L\n175#1:679,4\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "imeBean", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel$ImeBean;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SummaryFragment$initViewModels$4 extends Lambda implements Function1<IntelExtnShareViewModel.ImeBean, Unit> {
    final /* synthetic */ SummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryFragment$initViewModels$4(SummaryFragment summaryFragment) {
        super(1);
        this.this$0 = summaryFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntelExtnShareViewModel.ImeBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IntelExtnShareViewModel.ImeBean imeBean) {
        FragmentSummaryBinding m0 = this.this$0.f6284a;
        FragmentSummaryBinding fragmentSummaryBinding = null;
        if (m0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            m0 = null;
        }
        ScrollView scrollView = m0.h;
        Intrinsics.checkNotNullExpressionValue(scrollView, "svSummary");
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = imeBean.a();
            scrollView.setLayoutParams(marginLayoutParams);
            if (!imeBean.b()) {
                FragmentSummaryBinding m02 = this.this$0.f6284a;
                if (m02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    m02 = null;
                }
                if (m02.c.q()) {
                    LogExt.j("Summary touch keyboard outside", "SummaryFragment");
                    FragmentSummaryBinding m03 = this.this$0.f6284a;
                    if (m03 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        fragmentSummaryBinding = m03;
                    }
                    fragmentSummaryBinding.c.j();
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}

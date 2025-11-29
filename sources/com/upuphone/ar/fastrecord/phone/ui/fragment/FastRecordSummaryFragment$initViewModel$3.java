package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.star.common.phone.UToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initViewModel$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n1#2:430\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "tip", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSummaryFragment$initViewModel$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ FastRecordSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryFragment$initViewModel$3(FastRecordSummaryFragment fastRecordSummaryFragment) {
        super(1);
        this.this$0 = fastRecordSummaryFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        this.this$0.refreshViewShow(true);
        if (str != null) {
            FastRecordSummaryFragment fastRecordSummaryFragment = this.this$0;
            UToast.Companion companion = UToast.f6444a;
            FragmentActivity requireActivity = fastRecordSummaryFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            companion.d(requireActivity, str);
        }
    }
}

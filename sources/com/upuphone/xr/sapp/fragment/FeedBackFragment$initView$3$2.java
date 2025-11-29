package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.adapter.FeedBackFileAdapter;
import com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFeedBackFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment$initView$3$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,815:1\n1#2:816\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FeedBackFragment$initView$3$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ FeedBackFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackFragment$initView$3$2(FeedBackFragment feedBackFragment) {
        super(1);
        this.this$0 = feedBackFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (this.this$0.l.size() > i) {
            this.this$0.l.remove(i);
            String str = this.this$0.l.size() + "/9";
            FragmentFeedbackBinding N0 = this.this$0.j;
            if (N0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                N0 = null;
            }
            N0.t.setText(str);
            FeedBackFileAdapter R0 = this.this$0.m;
            if (R0 != null) {
                R0.notifyItemRemoved(i);
            }
        }
        this.this$0.o1();
    }
}

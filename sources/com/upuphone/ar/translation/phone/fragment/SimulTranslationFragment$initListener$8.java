package com.upuphone.ar.translation.phone.fragment;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.adapter.SimulRunningAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "isRtl", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SimulTranslationFragment$initListener$8 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ SimulTranslationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimulTranslationFragment$initListener$8(SimulTranslationFragment simulTranslationFragment) {
        super(1);
        this.this$0 = simulTranslationFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        LogExt.j("initListener recordRtl=" + bool, "SimulTranslationFragment");
        SimulRunningAdapter u0 = this.this$0.i;
        if (u0 != null) {
            Intrinsics.checkNotNull(bool);
            boolean booleanValue = bool.booleanValue();
            FragmentActivity activity = this.this$0.getActivity();
            u0.y0(booleanValue, activity != null ? ContextExtKt.f(activity) : false);
        }
    }
}

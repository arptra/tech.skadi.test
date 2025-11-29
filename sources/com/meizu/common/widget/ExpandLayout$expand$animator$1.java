package com.meizu.common.widget;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExpandLayout$expand$animator$1 extends Lambda implements Function1<Animator, Unit> {
    final /* synthetic */ ExpandLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandLayout$expand$animator$1(ExpandLayout expandLayout) {
        super(1);
        this.this$0 = expandLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Animator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "it");
        this.this$0.isRunning().compareAndSet(true, false);
    }
}

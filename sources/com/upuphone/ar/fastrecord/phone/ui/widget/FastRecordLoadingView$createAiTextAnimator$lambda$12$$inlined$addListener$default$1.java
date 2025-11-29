package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 FastRecordLoadingView.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLoadingView\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$1\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n199#2,7:137\n206#2,2:145\n96#3:144\n97#4:147\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordLoadingView$createAiTextAnimator$lambda$12$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ Ref.IntRef $executeCount$inlined;
    final /* synthetic */ Ref.IntRef $executeCount$inlined$1;
    final /* synthetic */ FastRecordLoadingView this$0;

    public FastRecordLoadingView$createAiTextAnimator$lambda$12$$inlined$addListener$default$1(Ref.IntRef intRef, FastRecordLoadingView fastRecordLoadingView, Ref.IntRef intRef2) {
        this.$executeCount$inlined = intRef;
        this.this$0 = fastRecordLoadingView;
        this.$executeCount$inlined$1 = intRef2;
    }

    public void onAnimationCancel(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.$executeCount$inlined$1.element = 0;
    }

    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    public void onAnimationRepeat(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.$executeCount$inlined.element++;
        this.this$0.mBinding.d.setAlpha(this.$executeCount$inlined.element % 2 == 0 ? 0.8f : 0.9f);
    }

    public void onAnimationStart(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }
}

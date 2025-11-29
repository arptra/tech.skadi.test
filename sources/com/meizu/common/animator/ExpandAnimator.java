package com.meizu.common.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.honey.account.r2.a;
import com.honey.account.r2.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016J*\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/meizu/common/animator/ExpandAnimator;", "", "()V", "TIME_EXPAND", "", "getTIME_EXPAND", "()J", "TIME_FOLD", "getTIME_FOLD", "expandPathInterpolator", "Landroid/view/animation/Interpolator;", "getExpandPathInterpolator", "()Landroid/view/animation/Interpolator;", "foldPathInterpolator", "getFoldPathInterpolator", "expand", "Landroid/animation/ValueAnimator;", "view", "Landroid/view/View;", "expandLen", "", "releaseCallback", "Lkotlin/Function1;", "Landroid/animation/Animator;", "", "fold", "foldLen", "updateHeight", "height", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpandAnimator {
    private final long TIME_EXPAND = 400;
    private final long TIME_FOLD = 350;
    @NotNull
    private final Interpolator expandPathInterpolator;
    @NotNull
    private final Interpolator foldPathInterpolator;

    public ExpandAnimator() {
        Interpolator a2 = PathInterpolatorCompat.a(0.2f, 0.0f, 0.2f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(a2, "create(0.2f, 0f, 0.2f, 1f)");
        this.expandPathInterpolator = a2;
        Interpolator a3 = PathInterpolatorCompat.a(0.4f, 0.0f, 0.4f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(a3, "create(0.4f, 0f, 0.4f, 1f)");
        this.foldPathInterpolator = a3;
    }

    /* access modifiers changed from: private */
    public static final void expand$lambda$0(ExpandAnimator expandAnimator, View view, int i, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(expandAnimator, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        expandAnimator.updateHeight(view, i + Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
    }

    /* access modifiers changed from: private */
    public static final void fold$lambda$1(ExpandAnimator expandAnimator, View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(expandAnimator, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        expandAnimator.updateHeight(view, Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
    }

    private final void updateHeight(View view, int i) {
        view.getLayoutParams().height = i;
        view.setLayoutParams(view.getLayoutParams());
    }

    @NotNull
    public final ValueAnimator expand(@NotNull View view, int i, @NotNull Function1<? super Animator, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function1, "releaseCallback");
        int height = view.getHeight();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, i});
        ofInt.setDuration(this.TIME_EXPAND);
        ofInt.setInterpolator(this.expandPathInterpolator);
        ofInt.addUpdateListener(new a(this, view, height));
        Intrinsics.checkNotNullExpressionValue(ofInt, "animator");
        ofInt.addListener(new ExpandAnimator$expand$$inlined$addListener$default$1(function1, function1));
        return ofInt;
    }

    @NotNull
    public final ValueAnimator fold(@NotNull View view, int i, @NotNull Function1<? super Animator, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function1, "releaseCallback");
        int height = view.getHeight();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{height, height - i});
        ofInt.setDuration(this.TIME_FOLD);
        ofInt.setInterpolator(this.foldPathInterpolator);
        ofInt.addUpdateListener(new b(this, view));
        Intrinsics.checkNotNullExpressionValue(ofInt, "animator");
        ofInt.addListener(new ExpandAnimator$fold$$inlined$addListener$default$1(function1, function1));
        return ofInt;
    }

    @NotNull
    public final Interpolator getExpandPathInterpolator() {
        return this.expandPathInterpolator;
    }

    @NotNull
    public final Interpolator getFoldPathInterpolator() {
        return this.foldPathInterpolator;
    }

    public final long getTIME_EXPAND() {
        return this.TIME_EXPAND;
    }

    public final long getTIME_FOLD() {
        return this.TIME_FOLD;
    }
}

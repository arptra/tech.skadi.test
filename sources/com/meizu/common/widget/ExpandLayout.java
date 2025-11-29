package com.meizu.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.meizu.common.animator.ExpandAnimator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\tJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\u001eJ\b\u0010#\u001a\u0004\u0018\u00010\u001eJ0\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0014R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/meizu/common/widget/ExpandLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "expandAnimator", "Lcom/meizu/common/animator/ExpandAnimator;", "getExpandAnimator", "()Lcom/meizu/common/animator/ExpandAnimator;", "expandAnimator$delegate", "Lkotlin/Lazy;", "initialHeight", "getInitialHeight", "()I", "setInitialHeight", "(I)V", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "stack", "Ljava/util/Stack;", "getStack", "()Ljava/util/Stack;", "expand", "Landroid/animation/ValueAnimator;", "expandHeight", "fold", "height", "foldAll", "foldLast", "onLayout", "", "changed", "", "left", "top", "right", "bottom", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpandLayout extends FrameLayout {
    @NotNull
    private final Lazy expandAnimator$delegate;
    private int initialHeight;
    @NotNull
    private final AtomicBoolean isRunning;
    @NotNull
    private final Stack<Integer> stack;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpandLayout(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ValueAnimator fold(int i) {
        if (this.isRunning.get()) {
            return null;
        }
        this.isRunning.compareAndSet(false, true);
        ValueAnimator fold = getExpandAnimator().fold(this, i, new ExpandLayout$fold$animator$1(this));
        fold.start();
        return fold;
    }

    @Nullable
    public final ValueAnimator expand(int i) {
        if (this.isRunning.get()) {
            return null;
        }
        this.isRunning.compareAndSet(false, true);
        this.stack.push(Integer.valueOf(i));
        ValueAnimator expand = getExpandAnimator().expand(this, i, new ExpandLayout$expand$animator$1(this));
        expand.start();
        return expand;
    }

    @Nullable
    public final ValueAnimator foldAll() {
        if (this.isRunning.get()) {
            return null;
        }
        this.stack.clear();
        return fold(getHeight() - this.initialHeight);
    }

    @Nullable
    public final ValueAnimator foldLast() {
        if (this.stack.isEmpty() || this.isRunning.get()) {
            return null;
        }
        Integer pop = this.stack.pop();
        Intrinsics.checkNotNullExpressionValue(pop, "foldHeight");
        return fold(pop.intValue());
    }

    @NotNull
    public final ExpandAnimator getExpandAnimator() {
        return (ExpandAnimator) this.expandAnimator$delegate.getValue();
    }

    public final int getInitialHeight() {
        return this.initialHeight;
    }

    @NotNull
    public final Stack<Integer> getStack() {
        return this.stack;
    }

    @NotNull
    public final AtomicBoolean isRunning() {
        return this.isRunning;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.initialHeight < 0) {
            this.initialHeight = getHeight();
        }
    }

    public final void setInitialHeight(int i) {
        this.initialHeight = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpandLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.expandAnimator$delegate = LazyKt.lazy(ExpandLayout$expandAnimator$2.INSTANCE);
        this.initialHeight = -1;
        this.stack = new Stack<>();
        this.isRunning = new AtomicBoolean(false);
    }
}

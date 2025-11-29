package com.upuphone.xr.sapp.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010$R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010&R\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010&¨\u0006,"}, d2 = {"Lcom/upuphone/xr/sapp/view/DownloadProgressView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startOffset", "endOffset", "", "d", "(II)V", "progress", "", "autoStartAnim", "c", "(IZ)V", "onDetachedFromWindow", "()V", "f", "Landroid/widget/FrameLayout$LayoutParams;", "a", "()Landroid/widget/FrameLayout$LayoutParams;", "e", "", "b", "(I)F", "Landroid/view/View;", "Landroid/view/View;", "progressView", "coverView", "maskView", "Landroid/animation/Animator;", "Landroid/animation/Animator;", "coverAnim", "I", "progressDegreeStartOffset", "progressDegreeEndOffset", "g", "h", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDownloadProgressView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadProgressView.kt\ncom/upuphone/xr/sapp/view/DownloadProgressView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,170:1\n256#2,2:171\n256#2,2:173\n256#2,2:175\n*S KotlinDebug\n*F\n+ 1 DownloadProgressView.kt\ncom/upuphone/xr/sapp/view/DownloadProgressView\n*L\n81#1:171,2\n146#1:173,2\n154#1:175,2\n*E\n"})
public final class DownloadProgressView extends FrameLayout {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public View f7954a;
    public View b;
    public View c;
    public Animator d;
    public int e;
    public int f;
    public int g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/view/DownloadProgressView$Companion;", "", "()V", "MAX_PROGRESS", "", "MAX_PROGRESS_DEGREE", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadProgressView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final FrameLayout.LayoutParams a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public final float b(int i) {
        int i2 = this.e;
        return ((((float) i) / 100.0f) * ((float) ((180 - this.f) - i2))) + ((float) i2);
    }

    public final void c(int i, boolean z) {
        this.g = i;
        if (i >= 0 && i < 101) {
            float b2 = b(i);
            View view = this.f7954a;
            if (view != null) {
                view.setRotation(b2);
            }
            View view2 = this.c;
            if (view2 != null) {
                view2.setRotation(b2);
            }
        }
        if (!z) {
            f();
        } else if (1 <= i && i < 100) {
            e();
        }
    }

    public final void d(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public final void e() {
        Animator animator = this.d;
        if ((animator == null || !animator.isRunning()) && this.g > 0 && this.f7954a != null) {
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
            Animator animator2 = this.d;
            if (animator2 != null) {
                animator2.start();
            }
        }
    }

    public final void f() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
        Animator animator = this.d;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.d;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DownloadProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DownloadProgressView, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int indexCount = obtainStyledAttributes.getIndexCount();
        Drawable drawable = null;
        Drawable drawable2 = null;
        Drawable drawable3 = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.DownloadProgressView_progressDrawable) {
                drawable = obtainStyledAttributes.getDrawable(index);
            } else if (index == R.styleable.DownloadProgressView_coverDrawable) {
                drawable3 = obtainStyledAttributes.getDrawable(index);
            } else if (index == R.styleable.DownloadProgressView_maskDrawable) {
                drawable2 = obtainStyledAttributes.getDrawable(index);
            }
        }
        obtainStyledAttributes.recycle();
        if (drawable != null) {
            View view = new View(context);
            this.f7954a = view;
            view.setBackground(drawable);
            addView(view, a());
        }
        if (drawable3 != null) {
            View view2 = new View(context);
            this.b = view2;
            view2.setBackground(drawable3);
            addView(view2, a());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "rotation", new float[]{0.0f, 360.0f});
            ofFloat.setDuration(3000);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            this.d = ofFloat;
            view2.setVisibility(8);
        }
        if (drawable2 != null) {
            View view3 = new View(context);
            this.c = view3;
            view3.setBackground(drawable2);
            addView(view3, a());
        }
    }
}

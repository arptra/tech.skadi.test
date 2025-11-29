package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.upuphone.ar.fastrecord.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0006\u0010\u001f\u001a\u00020\u0015R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/RecordDownloadProgressView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coverAnim", "Landroid/animation/Animator;", "coverView", "Landroid/view/View;", "maskView", "progress", "progressDegreeEndOffset", "progressDegreeStartOffset", "progressView", "generateChildLayoutParam", "Landroid/widget/FrameLayout$LayoutParams;", "onDetachedFromWindow", "", "progressToDegree", "", "setProgress", "autoStartAnim", "", "setProgressDegreeOffset", "startOffset", "endOffset", "startCoverAnim", "stopCoverAnim", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordDownloadProgressView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDownloadProgressView.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/RecordDownloadProgressView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,164:1\n262#2,2:165\n262#2,2:167\n262#2,2:169\n*S KotlinDebug\n*F\n+ 1 RecordDownloadProgressView.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/RecordDownloadProgressView\n*L\n75#1:165,2\n140#1:167,2\n148#1:169,2\n*E\n"})
public final class RecordDownloadProgressView extends FrameLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_PROGRESS = 100;
    private static final int MAX_PROGRESS_DEGREE = 180;
    @Nullable
    private Animator coverAnim;
    @Nullable
    private View coverView;
    @Nullable
    private View maskView;
    private int progress;
    private int progressDegreeEndOffset;
    private int progressDegreeStartOffset;
    @Nullable
    private View progressView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/RecordDownloadProgressView$Companion;", "", "()V", "MAX_PROGRESS", "", "MAX_PROGRESS_DEGREE", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecordDownloadProgressView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final FrameLayout.LayoutParams generateChildLayoutParam() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private final float progressToDegree(int i) {
        int i2 = this.progressDegreeStartOffset;
        return ((((float) i) / 100.0f) * ((float) ((180 - this.progressDegreeEndOffset) - i2))) + ((float) i2);
    }

    public static /* synthetic */ void setProgress$default(RecordDownloadProgressView recordDownloadProgressView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        recordDownloadProgressView.setProgress(i, z);
    }

    private final void startCoverAnim() {
        Animator animator = this.coverAnim;
        if ((animator == null || !animator.isRunning()) && this.progress > 0 && this.progressView != null) {
            View view = this.coverView;
            if (view != null) {
                view.setVisibility(0);
            }
            Animator animator2 = this.coverAnim;
            if (animator2 != null) {
                animator2.start();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.coverAnim;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void setProgress(int i, boolean z) {
        this.progress = i;
        if (i >= 0 && i < 101) {
            float progressToDegree = progressToDegree(i);
            View view = this.progressView;
            if (view != null) {
                view.setRotation(progressToDegree);
            }
            View view2 = this.maskView;
            if (view2 != null) {
                view2.setRotation(progressToDegree);
            }
        }
        if (!z) {
            stopCoverAnim();
        } else if (1 <= i && i < 100) {
            startCoverAnim();
        }
    }

    public final void setProgressDegreeOffset(int i, int i2) {
        this.progressDegreeStartOffset = i;
        this.progressDegreeEndOffset = i2;
    }

    public final void stopCoverAnim() {
        View view = this.coverView;
        if (view != null) {
            view.setVisibility(8);
        }
        Animator animator = this.coverAnim;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecordDownloadProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordDownloadProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecordDownloadProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecordDownloadProgressView, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int indexCount = obtainStyledAttributes.getIndexCount();
        Drawable drawable = null;
        Drawable drawable2 = null;
        Drawable drawable3 = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.RecordDownloadProgressView_progressDrawable) {
                drawable = obtainStyledAttributes.getDrawable(index);
            } else if (index == R.styleable.RecordDownloadProgressView_coverDrawable) {
                drawable3 = obtainStyledAttributes.getDrawable(index);
            } else if (index == R.styleable.RecordDownloadProgressView_maskDrawable) {
                drawable2 = obtainStyledAttributes.getDrawable(index);
            }
        }
        obtainStyledAttributes.recycle();
        if (drawable != null) {
            View view = new View(context);
            this.progressView = view;
            view.setBackground(drawable);
            addView(view, generateChildLayoutParam());
        }
        if (drawable3 != null) {
            View view2 = new View(context);
            this.coverView = view2;
            view2.setBackground(drawable3);
            addView(view2, generateChildLayoutParam());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "rotation", new float[]{0.0f, 360.0f});
            ofFloat.setDuration(3000);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            this.coverAnim = ofFloat;
            view2.setVisibility(8);
        }
        if (drawable2 != null) {
            View view3 = new View(context);
            this.maskView = view3;
            view3.setBackground(drawable2);
            addView(view3, generateChildLayoutParam());
        }
    }
}

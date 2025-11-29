package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.a4.d;
import com.honey.account.a4.e;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordSmartExtractLoadingLayoutBinding;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0014J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tH\u0014J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAiImageAnimator", "Landroid/animation/ValueAnimator;", "mAiTextAnimator", "mBinding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordSmartExtractLoadingLayoutBinding;", "mIsRunningAiLoading", "", "createAiImageAnimator", "createAiTextAnimator", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "onWindowVisibilityChanged", "setLoadingText", "text", "", "setVisibility", "startAiAnimator", "stopAiAnimator", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordLoadingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordLoadingView.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLoadingView\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,219:1\n95#2,14:220\n95#2,14:234\n*S KotlinDebug\n*F\n+ 1 FastRecordLoadingView.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLoadingView\n*L\n160#1:220,14\n198#1:234,14\n*E\n"})
public final class FastRecordLoadingView extends ConstraintLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "FastRecordLoadingView";
    @Nullable
    private ValueAnimator mAiImageAnimator;
    @Nullable
    private ValueAnimator mAiTextAnimator;
    /* access modifiers changed from: private */
    @NotNull
    public FastRecordSmartExtractLoadingLayoutBinding mBinding;
    private boolean mIsRunningAiLoading;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLoadingView$Companion;", "", "()V", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastRecordLoadingView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ValueAnimator createAiImageAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mBinding.b, "rotation", new float[]{0.0f, 180.0f});
        ofFloat.setDuration(1250);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new PathInterpolator(0.47f, 0.0f, 0.27f, 1.0f));
        Intrinsics.checkNotNull(ofFloat);
        ofFloat.addListener(new FastRecordLoadingView$createAiImageAnimator$lambda$8$$inlined$addListener$default$1(this, ofFloat, this));
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    private final ValueAnimator createAiTextAnimator() {
        int width = this.mBinding.c.getWidth();
        int width2 = this.mBinding.d.getWidth();
        ViewGroup.LayoutParams layoutParams = this.mBinding.d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        LogExt.logI("createAiTextAnimator tvWidth=" + width + ", vCoverWidth=" + width2, TAG);
        StringBuilder sb = new StringBuilder();
        sb.append("createAiTextAnimator vCoverParams=");
        sb.append(layoutParams2);
        LogExt.logI(sb.toString(), TAG);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        this.mBinding.d.setAlpha(0.9f);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-width2, width + width2});
        ofInt.setDuration(1250);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNull(ofInt);
        ofInt.addListener(new FastRecordLoadingView$createAiTextAnimator$lambda$12$$inlined$addListener$default$1(intRef, this, intRef));
        ofInt.addUpdateListener(new e(layoutParams2, this));
        Intrinsics.checkNotNull(ofInt);
        return ofInt;
    }

    /* access modifiers changed from: private */
    public static final void createAiTextAnimator$lambda$12$lambda$11(ConstraintLayout.LayoutParams layoutParams, FastRecordLoadingView fastRecordLoadingView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(layoutParams, "$vCoverParams");
        Intrinsics.checkNotNullParameter(fastRecordLoadingView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.setMarginStart(((Integer) animatedValue).intValue());
        fastRecordLoadingView.mBinding.d.setLayoutParams(layoutParams);
        fastRecordLoadingView.mBinding.d.requestLayout();
    }

    private final void startAiAnimator() {
        ValueAnimator valueAnimator = this.mAiImageAnimator;
        if (valueAnimator == null) {
            LogExt.logI("startAiAnimator image animator is null", TAG);
            ValueAnimator createAiImageAnimator = createAiImageAnimator();
            this.mAiImageAnimator = createAiImageAnimator;
            if (createAiImageAnimator != null) {
                createAiImageAnimator.start();
            }
        } else if (!valueAnimator.isRunning()) {
            LogExt.logI("startAiAnimator image animator is not null", TAG);
            valueAnimator.start();
        }
        ValueAnimator valueAnimator2 = this.mAiTextAnimator;
        if (valueAnimator2 == null) {
            LogExt.logI("startAiAnimator text animator is null", TAG);
            this.mBinding.c.post(new d(this));
        } else if (!valueAnimator2.isRunning()) {
            LogExt.logI("startAiAnimator text animator is not null", TAG);
            valueAnimator2.start();
        }
        this.mIsRunningAiLoading = true;
    }

    /* access modifiers changed from: private */
    public static final void startAiAnimator$lambda$5$lambda$4(FastRecordLoadingView fastRecordLoadingView) {
        Intrinsics.checkNotNullParameter(fastRecordLoadingView, "$this_run");
        ValueAnimator createAiTextAnimator = fastRecordLoadingView.createAiTextAnimator();
        fastRecordLoadingView.mAiTextAnimator = createAiTextAnimator;
        if (createAiTextAnimator != null) {
            createAiTextAnimator.start();
        }
    }

    private final void stopAiAnimator() {
        ValueAnimator valueAnimator = this.mAiImageAnimator;
        LogExt.logI("stopAiAnimator animator=" + valueAnimator, TAG);
        ValueAnimator valueAnimator2 = this.mAiImageAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.mAiImageAnimator = null;
        ValueAnimator valueAnimator3 = this.mAiTextAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.mAiTextAnimator = null;
    }

    public void onVisibilityChanged(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        super.onVisibilityChanged(view, i);
        if (this.mIsRunningAiLoading) {
            if (i != 0) {
                stopAiAnimator();
            } else if (isShown()) {
                startAiAnimator();
            }
        }
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.mIsRunningAiLoading) {
            if (i != 0) {
                stopAiAnimator();
            } else if (isShown()) {
                startAiAnimator();
            }
        }
    }

    public final void setLoadingText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.mBinding.c.setText(str);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            startAiAnimator();
        } else if (i == 4 || i == 8) {
            stopAiAnimator();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastRecordLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FastRecordSmartExtractLoadingLayoutBinding c = FastRecordSmartExtractLoadingLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FastRecordLoadingView);
        String string = obtainStyledAttributes.getString(R.styleable.FastRecordLoadingView_loading_text);
        string = string == null ? "" : string;
        Intrinsics.checkNotNull(string);
        setLoadingText(string);
        obtainStyledAttributes.recycle();
    }
}

package com.upuphone.ar.transcribe.phone.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.y4.f;
import com.honey.account.y4.g;
import com.upuphone.ar.transcribe.databinding.TranscribeLoadingViewBinding;
import com.upuphone.ar.transcribe.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0014\u0010\u000fJ\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010)¨\u0006/"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "visibility", "", "setVisibility", "(I)V", "Landroid/view/View;", "changedView", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "", "text", "setLoadingText", "(Ljava/lang/String;)V", "startAiAnimator", "()V", "stopAiAnimator", "Landroid/animation/ValueAnimator;", "createAiImageAnimator", "()Landroid/animation/ValueAnimator;", "createAiTextAnimator", "Lcom/upuphone/ar/transcribe/databinding/TranscribeLoadingViewBinding;", "a", "Lcom/upuphone/ar/transcribe/databinding/TranscribeLoadingViewBinding;", "binding", "", "b", "Z", "isRunningAiLoading", "c", "Landroid/animation/ValueAnimator;", "imageAnimator", "d", "textAnimator", "e", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransLoadingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransLoadingView.kt\ncom/upuphone/ar/transcribe/phone/view/TransLoadingView\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,182:1\n95#2,14:183\n95#2,14:197\n*S KotlinDebug\n*F\n+ 1 TransLoadingView.kt\ncom/upuphone/ar/transcribe/phone/view/TransLoadingView\n*L\n130#1:183,14\n161#1:197,14\n*E\n"})
public final class TransLoadingView extends ConstraintLayout {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public TranscribeLoadingViewBinding f6130a;
    public boolean b;
    public ValueAnimator c;
    public ValueAnimator d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransLoadingView$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransLoadingView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void j(ConstraintLayout.LayoutParams layoutParams, TransLoadingView transLoadingView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(layoutParams, "$vCoverParams");
        Intrinsics.checkNotNullParameter(transLoadingView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.setMarginStart(((Integer) animatedValue).intValue());
        transLoadingView.f6130a.d.setLayoutParams(layoutParams);
        transLoadingView.f6130a.d.requestLayout();
    }

    public static final void k(TransLoadingView transLoadingView) {
        Intrinsics.checkNotNullParameter(transLoadingView, "$this_run");
        ValueAnimator createAiTextAnimator = transLoadingView.createAiTextAnimator();
        transLoadingView.d = createAiTextAnimator;
        if (createAiTextAnimator != null) {
            createAiTextAnimator.start();
        }
    }

    public final ValueAnimator createAiImageAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f6130a.b, "rotation", new float[]{0.0f, 180.0f});
        ofFloat.setDuration(1250);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new PathInterpolator(0.47f, 0.0f, 0.27f, 1.0f));
        Intrinsics.checkNotNull(ofFloat);
        ofFloat.addListener(new TransLoadingView$createAiImageAnimator$lambda$7$$inlined$addListener$default$1(this, ofFloat, this));
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public final ValueAnimator createAiTextAnimator() {
        int width = this.f6130a.c.getWidth();
        int width2 = this.f6130a.d.getWidth();
        ViewGroup.LayoutParams layoutParams = this.f6130a.d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        this.f6130a.d.setAlpha(0.9f);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-width2, width + width2});
        ofInt.setDuration(1250);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNull(ofInt);
        ofInt.addListener(new TransLoadingView$createAiTextAnimator$lambda$11$$inlined$addListener$default$1(intRef, this, intRef));
        ofInt.addUpdateListener(new g((ConstraintLayout.LayoutParams) layoutParams, this));
        Intrinsics.checkNotNull(ofInt);
        return ofInt;
    }

    public void onVisibilityChanged(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        super.onVisibilityChanged(view, i);
        if (this.b) {
            if (i != 0) {
                stopAiAnimator();
            } else if (isShown()) {
                startAiAnimator();
            }
        }
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.b) {
            if (i != 0) {
                stopAiAnimator();
            } else if (isShown()) {
                startAiAnimator();
            }
        }
    }

    public final void setLoadingText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f6130a.c.setText(str);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            startAiAnimator();
        } else if (i == 4 || i == 8) {
            stopAiAnimator();
        }
    }

    public final void startAiAnimator() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator == null) {
            LogExt.g("startAiAnimator image animator is null", "TransLoadingView");
            ValueAnimator createAiImageAnimator = createAiImageAnimator();
            this.c = createAiImageAnimator;
            if (createAiImageAnimator != null) {
                createAiImageAnimator.start();
            }
        } else if (!valueAnimator.isRunning()) {
            LogExt.g("startAiAnimator image animator is not null", "TransLoadingView");
            valueAnimator.start();
        }
        ValueAnimator valueAnimator2 = this.d;
        if (valueAnimator2 == null) {
            LogExt.g("startAiAnimator text animator is null", "TransLoadingView");
            this.f6130a.c.post(new f(this));
        } else if (!valueAnimator2.isRunning()) {
            LogExt.g("startAiAnimator text animator is not null", "TransLoadingView");
            valueAnimator2.start();
        }
        this.b = true;
    }

    public final void stopAiAnimator() {
        ValueAnimator valueAnimator = this.c;
        LogExt.g("stopAiAnimator animator=" + valueAnimator, "TransLoadingView");
        ValueAnimator valueAnimator2 = this.c;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.c = null;
        ValueAnimator valueAnimator3 = this.d;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.d = null;
        this.b = false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TranscribeLoadingViewBinding c2 = TranscribeLoadingViewBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6130a = c2;
    }
}

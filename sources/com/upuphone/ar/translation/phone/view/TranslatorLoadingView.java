package com.upuphone.ar.translation.phone.view;

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
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.h5.s;
import com.honey.account.h5.t;
import com.meizu.common.widget.LoadingView;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.databinding.LayoutTranslatorLoadingViewBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 22\u00020\u0001:\u000234B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001b\u0010\u0016J\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u0016J\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010.¨\u00065"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslatorLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "startAiAnimator", "()V", "stopAiAnimator", "Landroid/animation/ValueAnimator;", "createAiImageAnimator", "()Landroid/animation/ValueAnimator;", "createAiTextAnimator", "visibility", "setVisibility", "(I)V", "Landroid/view/View;", "changedView", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "mode", "setMode", "", "text", "setLoadingText", "(Ljava/lang/String;)V", "Lcom/upuphone/ar/translation/phone/databinding/LayoutTranslatorLoadingViewBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/LayoutTranslatorLoadingViewBinding;", "mBinding", "b", "I", "mLoadingMode", "", "c", "Z", "mIsRunningAiLoading", "d", "Landroid/animation/ValueAnimator;", "mAiImageAnimator", "e", "mAiTextAnimator", "f", "Companion", "LoadingMode", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranslatorLoadingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorLoadingView.kt\ncom/upuphone/ar/translation/phone/view/TranslatorLoadingView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,293:1\n262#2,2:294\n262#2,2:296\n262#2,2:298\n262#2,2:300\n262#2,2:302\n262#2,2:304\n262#2,2:306\n262#2,2:308\n262#2,2:310\n95#3,14:312\n95#3,14:326\n*S KotlinDebug\n*F\n+ 1 TranslatorLoadingView.kt\ncom/upuphone/ar/translation/phone/view/TranslatorLoadingView\n*L\n111#1:294,2\n112#1:296,2\n113#1:298,2\n117#1:300,2\n118#1:302,2\n119#1:304,2\n123#1:306,2\n124#1:308,2\n125#1:310,2\n208#1:312,14\n248#1:326,14\n*E\n"})
public final class TranslatorLoadingView extends ConstraintLayout {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public LayoutTranslatorLoadingViewBinding f6337a;
    public int b;
    public boolean c;
    public ValueAnimator d;
    public ValueAnimator e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslatorLoadingView$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslatorLoadingView$LoadingMode;", "", "<init>", "()V", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface LoadingMode {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslatorLoadingView$LoadingMode$Companion;", "", "<init>", "()V", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6340a = new Companion();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TranslatorLoadingView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ValueAnimator createAiImageAnimator() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        boolean f2 = ContextExtKt.f(context);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f6337a.b, "rotation", new float[]{0.0f, f2 ? -180.0f : 180.0f});
        ofFloat.setDuration(1250);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new PathInterpolator(0.47f, 0.0f, 0.27f, 1.0f));
        Intrinsics.checkNotNull(ofFloat);
        ofFloat.addListener(new TranslatorLoadingView$createAiImageAnimator$lambda$8$$inlined$addListener$default$1(this, ofFloat, f2, this));
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    private final ValueAnimator createAiTextAnimator() {
        int width = this.f6337a.d.getWidth();
        int width2 = this.f6337a.e.getWidth();
        ViewGroup.LayoutParams layoutParams = this.f6337a.e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        this.f6337a.e.setAlpha(0.9f);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-width2, width + width2});
        ofInt.setDuration(1250);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNull(ofInt);
        ofInt.addListener(new TranslatorLoadingView$createAiTextAnimator$lambda$12$$inlined$addListener$default$1(intRef, this, intRef));
        ofInt.addUpdateListener(new t((ConstraintLayout.LayoutParams) layoutParams, this));
        Intrinsics.checkNotNull(ofInt);
        return ofInt;
    }

    public static final void j(ConstraintLayout.LayoutParams layoutParams, TranslatorLoadingView translatorLoadingView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(layoutParams, "$vCoverParams");
        Intrinsics.checkNotNullParameter(translatorLoadingView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.setMarginStart(((Integer) animatedValue).intValue());
        translatorLoadingView.f6337a.e.setLayoutParams(layoutParams);
        translatorLoadingView.f6337a.e.requestLayout();
    }

    public static final void k(TranslatorLoadingView translatorLoadingView) {
        Intrinsics.checkNotNullParameter(translatorLoadingView, "$this_run");
        ValueAnimator createAiTextAnimator = translatorLoadingView.createAiTextAnimator();
        translatorLoadingView.e = createAiTextAnimator;
        if (createAiTextAnimator != null) {
            createAiTextAnimator.start();
        }
    }

    private final void startAiAnimator() {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator == null) {
            LogExt.j("startAiAnimator image animator is null", "TranslatorLoadingView");
            ValueAnimator createAiImageAnimator = createAiImageAnimator();
            this.d = createAiImageAnimator;
            if (createAiImageAnimator != null) {
                createAiImageAnimator.start();
            }
        } else if (!valueAnimator.isRunning()) {
            LogExt.j("startAiAnimator image animator is not null", "TranslatorLoadingView");
            valueAnimator.start();
        }
        ValueAnimator valueAnimator2 = this.e;
        if (valueAnimator2 == null) {
            LogExt.j("startAiAnimator text animator is null", "TranslatorLoadingView");
            this.f6337a.d.post(new s(this));
        } else if (!valueAnimator2.isRunning()) {
            LogExt.j("startAiAnimator text animator is not null", "TranslatorLoadingView");
            valueAnimator2.start();
        }
        this.c = true;
    }

    private final void stopAiAnimator() {
        ValueAnimator valueAnimator = this.d;
        LogExt.j("stopAiAnimator animator=" + valueAnimator, "TranslatorLoadingView");
        ValueAnimator valueAnimator2 = this.d;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.d = null;
        ValueAnimator valueAnimator3 = this.e;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.e = null;
    }

    public void onVisibilityChanged(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        super.onVisibilityChanged(view, i);
        if (this.b != 2 || !this.c) {
            return;
        }
        if (i != 0) {
            stopAiAnimator();
        } else if (isShown()) {
            startAiAnimator();
        }
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.b != 2 || !this.c) {
            return;
        }
        if (i != 0) {
            stopAiAnimator();
        } else if (isShown()) {
            startAiAnimator();
        }
    }

    public final void setLoadingText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f6337a.d.setText(str);
    }

    public final void setMode(int i) {
        this.b = i;
        if (i == 1) {
            LoadingView loadingView = this.f6337a.c;
            Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
            loadingView.setVisibility(0);
            ImageView imageView = this.f6337a.b;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivAiLoading");
            imageView.setVisibility(8);
            View view = this.f6337a.e;
            Intrinsics.checkNotNullExpressionValue(view, "vAiCover");
            view.setVisibility(8);
        } else if (i != 2) {
            LoadingView loadingView2 = this.f6337a.c;
            Intrinsics.checkNotNullExpressionValue(loadingView2, "loadingView");
            loadingView2.setVisibility(0);
            ImageView imageView2 = this.f6337a.b;
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivAiLoading");
            imageView2.setVisibility(8);
            View view2 = this.f6337a.e;
            Intrinsics.checkNotNullExpressionValue(view2, "vAiCover");
            view2.setVisibility(8);
        } else {
            LoadingView loadingView3 = this.f6337a.c;
            Intrinsics.checkNotNullExpressionValue(loadingView3, "loadingView");
            loadingView3.setVisibility(8);
            ImageView imageView3 = this.f6337a.b;
            Intrinsics.checkNotNullExpressionValue(imageView3, "ivAiLoading");
            imageView3.setVisibility(0);
            View view3 = this.f6337a.e;
            Intrinsics.checkNotNullExpressionValue(view3, "vAiCover");
            view3.setVisibility(0);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.b == 2) {
            if (i == 0) {
                startAiAnimator();
            } else if (i == 4 || i == 8) {
                stopAiAnimator();
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TranslatorLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = 1;
        LayoutTranslatorLoadingViewBinding c2 = LayoutTranslatorLoadingViewBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6337a = c2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TranslatorLoadingView);
        String string = obtainStyledAttributes.getString(R.styleable.TranslatorLoadingView_loading_text);
        string = string == null ? "" : string;
        Intrinsics.checkNotNull(string);
        setLoadingText(string);
        setMode(obtainStyledAttributes.getInt(R.styleable.TranslatorLoadingView_loading_mode, 1));
        obtainStyledAttributes.recycle();
    }
}

package com.upuphone.ar.translation.phone.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 TranslatorLoadingView.kt\ncom/upuphone/ar/translation/phone/view/TranslatorLoadingView\n+ 3 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$1\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n210#2,10:137\n220#2,2:148\n96#3:147\n97#4:150\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslatorLoadingView$createAiImageAnimator$lambda$8$$inlined$addListener$default$1 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorLoadingView f6338a;
    public final /* synthetic */ ObjectAnimator b;
    public final /* synthetic */ boolean c;

    public TranslatorLoadingView$createAiImageAnimator$lambda$8$$inlined$addListener$default$1(TranslatorLoadingView translatorLoadingView, ObjectAnimator objectAnimator, boolean z, TranslatorLoadingView translatorLoadingView2) {
        this.f6338a = translatorLoadingView;
        this.b = objectAnimator;
        this.c = z;
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.f6338a.f6337a.b.setRotation(0.0f);
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        float rotation = this.f6338a.f6337a.b.getRotation();
        this.b.setFloatValues(new float[]{rotation, (this.c ? -180.0f : 180.0f) + rotation});
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }
}

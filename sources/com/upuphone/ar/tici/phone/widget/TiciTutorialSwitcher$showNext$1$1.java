package com.upuphone.ar.tici.phone.widget;

import android.view.View;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTiciTutorialSwitcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciTutorialSwitcher.kt\ncom/upuphone/ar/tici/phone/widget/TiciTutorialSwitcher$showNext$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,159:1\n283#2,2:160\n*S KotlinDebug\n*F\n+ 1 TiciTutorialSwitcher.kt\ncom/upuphone/ar/tici/phone/widget/TiciTutorialSwitcher$showNext$1$1\n*L\n141#1:160,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/tici/phone/widget/TiciTutorialSwitcher$showNext$1$1", "Lcom/upuphone/ar/tici/phone/widget/SimpleAnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciTutorialSwitcher$showNext$1$1 extends SimpleAnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f6010a;

    public TiciTutorialSwitcher$showNext$1$1(View view) {
        this.f6010a = view;
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.f6010a.setVisibility(4);
    }
}

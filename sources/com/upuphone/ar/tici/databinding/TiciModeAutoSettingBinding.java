package com.upuphone.ar.tici.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.meizu.common.widget.MzSeekBar;
import com.upuphone.ar.tici.phone.widget.TiciSettingCardItem;
import com.upuphone.ar.tici.phone.widget.TiciTutorialSwitcher;

public final class TiciModeAutoSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5868a;
    public final ConstraintLayout b;
    public final TiciSettingCardItem c;
    public final LottieAnimationView d;
    public final MzSeekBar e;
    public final View f;
    public final TiciTutorialSwitcher g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;

    public TiciModeAutoSettingBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TiciSettingCardItem ticiSettingCardItem, LottieAnimationView lottieAnimationView, MzSeekBar mzSeekBar, View view, TiciTutorialSwitcher ticiTutorialSwitcher, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f5868a = constraintLayout;
        this.b = constraintLayout2;
        this.c = ticiSettingCardItem;
        this.d = lottieAnimationView;
        this.e = mzSeekBar;
        this.f = view;
        this.g = ticiTutorialSwitcher;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = textView5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.upuphone.ar.tici.R.id.tici_mode_auto_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.tici.databinding.TiciModeAutoSettingBinding a(android.view.View r15) {
        /*
            int r0 = com.upuphone.ar.tici.R.id.lay_tici_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.lay_voice_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r5 = r1
            com.upuphone.ar.tici.phone.widget.TiciSettingCardItem r5 = (com.upuphone.ar.tici.phone.widget.TiciSettingCardItem) r5
            if (r5 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.lottie_speed_clock
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r6 = r1
            com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
            if (r6 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.seek_tici_speed
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r7 = r1
            com.meizu.common.widget.MzSeekBar r7 = (com.meizu.common.widget.MzSeekBar) r7
            if (r7 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.tici_mode_auto_line
            android.view.View r8 = androidx.viewbinding.ViewBindings.a(r15, r0)
            if (r8 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.tici_tutorial_switcher
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r9 = r1
            com.upuphone.ar.tici.phone.widget.TiciTutorialSwitcher r9 = (com.upuphone.ar.tici.phone.widget.TiciTutorialSwitcher) r9
            if (r9 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.tv_scroll_speed
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.tv_scroll_speed_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.tv_tici_mode_auto_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.tv_tici_speed_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0080
            int r0 = com.upuphone.ar.tici.R.id.tv_tici_speed_sub
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0080
            com.upuphone.ar.tici.databinding.TiciModeAutoSettingBinding r0 = new com.upuphone.ar.tici.databinding.TiciModeAutoSettingBinding
            r3 = r15
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x0080:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.databinding.TiciModeAutoSettingBinding.a(android.view.View):com.upuphone.ar.tici.databinding.TiciModeAutoSettingBinding");
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5868a;
    }
}

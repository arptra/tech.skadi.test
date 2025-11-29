package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.meizu.common.widget.MzButton;
import com.meizu.common.widget.MzSeekBar;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;
import com.upuphone.ar.tici.phone.widget.TouchScrollView;

public final class TiciMainActivityLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5867a;
    public final ImageView b;
    public final ImageView c;
    public final ScrollView d;
    public final TextView e;
    public final ImageView f;
    public final LinearLayout g;
    public final ProgressBar h;
    public final TextView i;
    public final LottieAnimationView j;
    public final LottieAnimationView k;
    public final ConstraintLayout l;
    public final ProgressBar m;
    public final ConstraintLayout n;
    public final MzButton o;
    public final TextView p;
    public final FrameLayout q;
    public final TextView r;
    public final ConstraintLayout s;
    public final ImageView t;
    public final MzSeekBar u;
    public final TiciTitleBar v;
    public final TouchScrollView w;
    public final TextView x;
    public final TextView y;
    public final View z;

    public TiciMainActivityLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ScrollView scrollView, TextView textView, ImageView imageView3, LinearLayout linearLayout, ProgressBar progressBar, TextView textView2, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, ConstraintLayout constraintLayout2, ProgressBar progressBar2, ConstraintLayout constraintLayout3, MzButton mzButton, TextView textView3, FrameLayout frameLayout, TextView textView4, ConstraintLayout constraintLayout4, ImageView imageView4, MzSeekBar mzSeekBar, TiciTitleBar ticiTitleBar, TouchScrollView touchScrollView, TextView textView5, TextView textView6, View view) {
        this.f5867a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = scrollView;
        this.e = textView;
        this.f = imageView3;
        this.g = linearLayout;
        this.h = progressBar;
        this.i = textView2;
        this.j = lottieAnimationView;
        this.k = lottieAnimationView2;
        this.l = constraintLayout2;
        this.m = progressBar2;
        this.n = constraintLayout3;
        this.o = mzButton;
        this.p = textView3;
        this.q = frameLayout;
        this.r = textView4;
        this.s = constraintLayout4;
        this.t = imageView4;
        this.u = mzSeekBar;
        this.v = ticiTitleBar;
        this.w = touchScrollView;
        this.x = textView5;
        this.y = textView6;
        this.z = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010f, code lost:
        r1 = com.upuphone.ar.tici.R.id.view_mask;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding a(android.view.View r30) {
        /*
            r0 = r30
            int r1 = com.upuphone.ar.tici.R.id.auto_tici_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.btn_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.content_scroll_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            android.widget.ScrollView r7 = (android.widget.ScrollView) r7
            if (r7 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.display_progress
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.icon_document
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.lay_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            android.widget.ProgressBar r11 = (android.widget.ProgressBar) r11
            if (r11 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.loading_tici_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.lottie_auto_tici
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            com.airbnb.lottie.LottieAnimationView r13 = (com.airbnb.lottie.LottieAnimationView) r13
            if (r13 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.lottie_auto_tici_pause
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            com.airbnb.lottie.LottieAnimationView r14 = (com.airbnb.lottie.LottieAnimationView) r14
            if (r14 == 0) goto L_0x011f
            r15 = r0
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            int r1 = com.upuphone.ar.tici.R.id.pb_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            android.widget.ProgressBar r16 = (android.widget.ProgressBar) r16
            if (r16 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.progress_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.ConstraintLayout r17 = (androidx.constraintlayout.widget.ConstraintLayout) r17
            if (r17 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.start_tici_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r18 = r2
            com.meizu.common.widget.MzButton r18 = (com.meizu.common.widget.MzButton) r18
            if (r18 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.tici_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.tici_content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r20 = r2
            android.widget.FrameLayout r20 = (android.widget.FrameLayout) r20
            if (r20 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.tici_file_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.tici_loading_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r22 = r2
            androidx.constraintlayout.widget.ConstraintLayout r22 = (androidx.constraintlayout.widget.ConstraintLayout) r22
            if (r22 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.tici_mode_manual_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r23 = r2
            android.widget.ImageView r23 = (android.widget.ImageView) r23
            if (r23 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.tici_progress
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r24 = r2
            com.meizu.common.widget.MzSeekBar r24 = (com.meizu.common.widget.MzSeekBar) r24
            if (r24 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.title_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r25 = r2
            com.upuphone.ar.tici.phone.widget.TiciTitleBar r25 = (com.upuphone.ar.tici.phone.widget.TiciTitleBar) r25
            if (r25 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.touch_scroll_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r26 = r2
            com.upuphone.ar.tici.phone.widget.TouchScrollView r26 = (com.upuphone.ar.tici.phone.widget.TouchScrollView) r26
            if (r26 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.tv_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.tv_loading_file
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x011f
            int r1 = com.upuphone.ar.tici.R.id.view_mask
            android.view.View r29 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r29 == 0) goto L_0x011f
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r0 = new com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding
            r3 = r0
            r4 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r0
        L_0x011f:
            android.content.res.Resources r0 = r30.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding.a(android.view.View):com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding");
    }

    public static TiciMainActivityLayoutBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static TiciMainActivityLayoutBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View inflate = layoutInflater.inflate(R.layout.tici_main_activity_layout, viewGroup, false);
        if (z2) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5867a;
    }
}

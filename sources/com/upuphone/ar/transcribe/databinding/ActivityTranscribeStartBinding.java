package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.view.TransTitleBar;

public final class ActivityTranscribeStartBinding implements ViewBinding {
    public final View A;

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6036a;
    public final ConstraintLayout b;
    public final FrameLayout c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final ImageView f;
    public final Group g;
    public final LinearLayout h;
    public final Group i;
    public final Barrier j;
    public final ImageView k;
    public final ImageView l;
    public final TextView m;
    public final LottieAnimationView n;
    public final LottieAnimationView o;
    public final TextView p;
    public final LinearLayout q;
    public final TransTitleBar r;
    public final ViewPager2 s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public ActivityTranscribeStartBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, Group group, LinearLayout linearLayout, Group group2, Barrier barrier, ImageView imageView2, ImageView imageView3, TextView textView, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, TextView textView2, LinearLayout linearLayout2, TransTitleBar transTitleBar, ViewPager2 viewPager2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view) {
        this.f6036a = constraintLayout;
        this.b = constraintLayout2;
        this.c = frameLayout;
        this.d = constraintLayout3;
        this.e = constraintLayout4;
        this.f = imageView;
        this.g = group;
        this.h = linearLayout;
        this.i = group2;
        this.j = barrier;
        this.k = imageView2;
        this.l = imageView3;
        this.m = textView;
        this.n = lottieAnimationView;
        this.o = lottieAnimationView2;
        this.p = textView2;
        this.q = linearLayout2;
        this.r = transTitleBar;
        this.s = viewPager2;
        this.t = textView3;
        this.u = textView4;
        this.v = textView5;
        this.w = textView6;
        this.x = textView7;
        this.y = textView8;
        this.z = textView9;
        this.A = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0123, code lost:
        r1 = com.upuphone.ar.transcribe.R.id.vertical_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.transcribe.databinding.ActivityTranscribeStartBinding a(android.view.View r31) {
        /*
            r0 = r31
            int r1 = com.upuphone.ar.transcribe.R.id.cl_multi_head
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.cl_transcribe_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.cl_transcribe_func
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.dial_trans_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.dial_trans_delete
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.edit_mode_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.Group r10 = (androidx.constraintlayout.widget.Group) r10
            if (r10 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.edit_model_footer
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.gp_transcribe_running
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.Group r12 = (androidx.constraintlayout.widget.Group) r12
            if (r12 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.head_barrier
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.Barrier r13 = (androidx.constraintlayout.widget.Barrier) r13
            if (r13 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.iv_multi_delete
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.iv_transcribe_mark
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.language_support_tips
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.lottie_transcribe_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            com.airbnb.lottie.LottieAnimationView r17 = (com.airbnb.lottie.LottieAnimationView) r17
            if (r17 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.lottie_transcribe_running
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r18 = r2
            com.airbnb.lottie.LottieAnimationView r18 = (com.airbnb.lottie.LottieAnimationView) r18
            if (r18 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.record_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tips_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r20 = r2
            android.widget.LinearLayout r20 = (android.widget.LinearLayout) r20
            if (r20 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.title_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r21 = r2
            com.upuphone.ar.transcribe.phone.view.TransTitleBar r21 = (com.upuphone.ar.transcribe.phone.view.TransTitleBar) r21
            if (r21 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tsb_records
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r22 = r2
            androidx.viewpager2.widget.ViewPager2 r22 = (androidx.viewpager2.widget.ViewPager2) r22
            if (r22 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tv_multi_cancel
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tv_multi_delete
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tv_multi_options
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tv_multi_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tv_transcribe_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tv_transcribe_running
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.tv_transcribe_src
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x0135
            int r1 = com.upuphone.ar.transcribe.R.id.vertical_divider
            android.view.View r30 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r30 == 0) goto L_0x0135
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeStartBinding r1 = new com.upuphone.ar.transcribe.databinding.ActivityTranscribeStartBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return r1
        L_0x0135:
            android.content.res.Resources r0 = r31.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.databinding.ActivityTranscribeStartBinding.a(android.view.View):com.upuphone.ar.transcribe.databinding.ActivityTranscribeStartBinding");
    }

    public static ActivityTranscribeStartBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranscribeStartBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View inflate = layoutInflater.inflate(R.layout.activity_transcribe_start, viewGroup, false);
        if (z2) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6036a;
    }
}

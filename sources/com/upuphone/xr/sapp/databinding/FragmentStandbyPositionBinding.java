package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.divider.MaterialDivider;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CustomRadioButton;
import com.upuphone.xr.sapp.view.CustomRadioGroup;

public final class FragmentStandbyPositionBinding implements ViewBinding {
    public final CustomRadioButton A;
    public final FrameLayout B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final View I;

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6817a;
    public final CustomRadioButton b;
    public final FrameLayout c;
    public final CustomRadioButton d;
    public final FrameLayout e;
    public final CustomRadioButton f;
    public final FrameLayout g;
    public final ConstraintLayout h;
    public final MaterialDivider i;
    public final MaterialDivider j;
    public final ImageView k;
    public final ImageView l;
    public final LinearLayout m;
    public final TextView n;
    public final CustomRadioGroup o;
    public final ConstraintLayout p;
    public final ImageView q;
    public final ImageView r;
    public final ImageView s;
    public final ImageView t;
    public final ImageView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final CustomRadioButton y;
    public final FrameLayout z;

    public FragmentStandbyPositionBinding(ConstraintLayout constraintLayout, CustomRadioButton customRadioButton, FrameLayout frameLayout, CustomRadioButton customRadioButton2, FrameLayout frameLayout2, CustomRadioButton customRadioButton3, FrameLayout frameLayout3, ConstraintLayout constraintLayout2, MaterialDivider materialDivider, MaterialDivider materialDivider2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, CustomRadioGroup customRadioGroup, ConstraintLayout constraintLayout3, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, TextView textView2, TextView textView3, TextView textView4, CustomRadioButton customRadioButton4, FrameLayout frameLayout4, CustomRadioButton customRadioButton5, FrameLayout frameLayout5, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view) {
        this.f6817a = constraintLayout;
        this.b = customRadioButton;
        this.c = frameLayout;
        this.d = customRadioButton2;
        this.e = frameLayout2;
        this.f = customRadioButton3;
        this.g = frameLayout3;
        this.h = constraintLayout2;
        this.i = materialDivider;
        this.j = materialDivider2;
        this.k = imageView;
        this.l = imageView2;
        this.m = linearLayout;
        this.n = textView;
        this.o = customRadioGroup;
        this.p = constraintLayout3;
        this.q = imageView3;
        this.r = imageView4;
        this.s = imageView5;
        this.t = imageView6;
        this.u = imageView7;
        this.v = textView2;
        this.w = textView3;
        this.x = textView4;
        this.y = customRadioButton4;
        this.z = frameLayout4;
        this.A = customRadioButton5;
        this.B = frameLayout5;
        this.C = textView5;
        this.D = textView6;
        this.E = textView7;
        this.F = textView8;
        this.G = textView9;
        this.H = textView10;
        this.I = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0183, code lost:
        r1 = com.upuphone.xr.sapp.R.id.view_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.FragmentStandbyPositionBinding a(android.view.View r39) {
        /*
            r0 = r39
            int r1 = com.upuphone.xr.sapp.R.id.bottom_center
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            com.upuphone.xr.sapp.view.CustomRadioButton r5 = (com.upuphone.xr.sapp.view.CustomRadioButton) r5
            if (r5 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.bottom_center_img
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.bottom_left
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            com.upuphone.xr.sapp.view.CustomRadioButton r7 = (com.upuphone.xr.sapp.view.CustomRadioButton) r7
            if (r7 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.bottom_left_img
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            if (r8 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.bottom_right
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            com.upuphone.xr.sapp.view.CustomRadioButton r9 = (com.upuphone.xr.sapp.view.CustomRadioButton) r9
            if (r9 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.bottom_right_img
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.FrameLayout r10 = (android.widget.FrameLayout) r10
            if (r10 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.constraintLayout_component
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            if (r11 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.divider_component
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            com.google.android.material.divider.MaterialDivider r12 = (com.google.android.material.divider.MaterialDivider) r12
            if (r12 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.divider_position
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            com.google.android.material.divider.MaterialDivider r13 = (com.google.android.material.divider.MaterialDivider) r13
            if (r13 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.image_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.image_voice
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.linear_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.position_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.position_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r18 = r2
            com.upuphone.xr.sapp.view.CustomRadioGroup r18 = (com.upuphone.xr.sapp.view.CustomRadioGroup) r18
            if (r18 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.rootView
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r19 = r2
            androidx.constraintlayout.widget.ConstraintLayout r19 = (androidx.constraintlayout.widget.ConstraintLayout) r19
            if (r19 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.standby_img_bc
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r20 = r2
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            if (r20 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.standby_img_lb
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r21 = r2
            android.widget.ImageView r21 = (android.widget.ImageView) r21
            if (r21 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.standby_img_lt
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r22 = r2
            android.widget.ImageView r22 = (android.widget.ImageView) r22
            if (r22 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.standby_img_rb
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r23 = r2
            android.widget.ImageView r23 = (android.widget.ImageView) r23
            if (r23 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.standby_img_rt
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r24 = r2
            android.widget.ImageView r24 = (android.widget.ImageView) r24
            if (r24 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.text_component
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.text_edit
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.text_position
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.top_left
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r28 = r2
            com.upuphone.xr.sapp.view.CustomRadioButton r28 = (com.upuphone.xr.sapp.view.CustomRadioButton) r28
            if (r28 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.top_left_img
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r29 = r2
            android.widget.FrameLayout r29 = (android.widget.FrameLayout) r29
            if (r29 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.top_right
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r30 = r2
            com.upuphone.xr.sapp.view.CustomRadioButton r30 = (com.upuphone.xr.sapp.view.CustomRadioButton) r30
            if (r30 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.top_right_img
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r31 = r2
            android.widget.FrameLayout r31 = (android.widget.FrameLayout) r31
            if (r31 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.tv_bottom_center
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.tv_glass_standby_desc
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r33 = r2
            android.widget.TextView r33 = (android.widget.TextView) r33
            if (r33 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.tv_left_bottom
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r34 = r2
            android.widget.TextView r34 = (android.widget.TextView) r34
            if (r34 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.tv_left_top
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r35 = r2
            android.widget.TextView r35 = (android.widget.TextView) r35
            if (r35 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.tv_right_bottom
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r36 = r2
            android.widget.TextView r36 = (android.widget.TextView) r36
            if (r36 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.tv_right_top
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r37 = r2
            android.widget.TextView r37 = (android.widget.TextView) r37
            if (r37 == 0) goto L_0x0195
            int r1 = com.upuphone.xr.sapp.R.id.view_line
            android.view.View r38 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r38 == 0) goto L_0x0195
            com.upuphone.xr.sapp.databinding.FragmentStandbyPositionBinding r1 = new com.upuphone.xr.sapp.databinding.FragmentStandbyPositionBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return r1
        L_0x0195:
            android.content.res.Resources r0 = r39.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.FragmentStandbyPositionBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.FragmentStandbyPositionBinding");
    }

    public static FragmentStandbyPositionBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View inflate = layoutInflater.inflate(R.layout.fragment_standby_position, viewGroup, false);
        if (z2) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6817a;
    }
}

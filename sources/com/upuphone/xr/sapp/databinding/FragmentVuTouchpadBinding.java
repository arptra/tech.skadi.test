package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.vu.input.VuTouchpadView;

public final class FragmentVuTouchpadBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6838a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final AppCompatImageButton e;
    public final View f;
    public final ImageView g;
    public final ConstraintLayout h;
    public final View i;
    public final ConstraintLayout j;
    public final FrameLayout k;
    public final TextView l;
    public final FrameLayout m;
    public final TextView n;
    public final LinearLayout o;
    public final VuTouchpadView p;

    public FragmentVuTouchpadBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, AppCompatImageButton appCompatImageButton, View view, ImageView imageView, ConstraintLayout constraintLayout2, View view2, ConstraintLayout constraintLayout3, FrameLayout frameLayout4, TextView textView, FrameLayout frameLayout5, TextView textView2, LinearLayout linearLayout, VuTouchpadView vuTouchpadView) {
        this.f6838a = constraintLayout;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = frameLayout3;
        this.e = appCompatImageButton;
        this.f = view;
        this.g = imageView;
        this.h = constraintLayout2;
        this.i = view2;
        this.j = constraintLayout3;
        this.k = frameLayout4;
        this.l = textView;
        this.m = frameLayout5;
        this.n = textView2;
        this.o = linearLayout;
        this.p = vuTouchpadView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        r1 = com.upuphone.xr.sapp.R.id.record_layout_bg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.upuphone.xr.sapp.R.id.mask_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding a(android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.upuphone.xr.sapp.R.id.exit_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.float_mode
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.follow_head_mode
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            if (r7 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.home_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            androidx.appcompat.widget.AppCompatImageButton r8 = (androidx.appcompat.widget.AppCompatImageButton) r8
            if (r8 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.mask_view
            android.view.View r9 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r9 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.more_function
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.more_function_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            if (r11 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.record_layout_bg
            android.view.View r12 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r12 == 0) goto L_0x00a5
            r13 = r0
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            int r1 = com.upuphone.xr.sapp.R.id.screen_record
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            android.widget.FrameLayout r14 = (android.widget.FrameLayout) r14
            if (r14 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.screen_record_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.screen_shot
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            android.widget.FrameLayout r16 = (android.widget.FrameLayout) r16
            if (r16 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.shortcut_instruction
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.title_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r18 = r2
            android.widget.LinearLayout r18 = (android.widget.LinearLayout) r18
            if (r18 == 0) goto L_0x00a5
            int r1 = com.upuphone.xr.sapp.R.id.touchpad
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r19 = r2
            com.upuphone.xr.sapp.vu.input.VuTouchpadView r19 = (com.upuphone.xr.sapp.vu.input.VuTouchpadView) r19
            if (r19 == 0) goto L_0x00a5
            com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding r0 = new com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding
            r3 = r0
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        L_0x00a5:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding");
    }

    public static FragmentVuTouchpadBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vu_touchpad, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6838a;
    }
}

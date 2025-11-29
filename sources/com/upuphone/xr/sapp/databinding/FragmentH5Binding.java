package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class FragmentH5Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6794a;
    public final TextView b;
    public final Barrier c;
    public final MzButton d;
    public final MzButton e;
    public final View f;
    public final LinearLayout g;
    public final TextView h;
    public final TextView i;
    public final MzButton j;
    public final ConstraintLayout k;
    public final SwipeRefreshLayout l;
    public final LinearLayout m;

    public FragmentH5Binding(ConstraintLayout constraintLayout, TextView textView, Barrier barrier, MzButton mzButton, MzButton mzButton2, View view, LinearLayout linearLayout, TextView textView2, TextView textView3, MzButton mzButton3, ConstraintLayout constraintLayout2, SwipeRefreshLayout swipeRefreshLayout, LinearLayout linearLayout2) {
        this.f6794a = constraintLayout;
        this.b = textView;
        this.c = barrier;
        this.d = mzButton;
        this.e = mzButton2;
        this.f = view;
        this.g = linearLayout;
        this.h = textView2;
        this.i = textView3;
        this.j = mzButton3;
        this.k = constraintLayout2;
        this.l = swipeRefreshLayout;
        this.m = linearLayout2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.upuphone.xr.sapp.R.id.cover;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.FragmentH5Binding a(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.upuphone.xr.sapp.R.id.back_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.barrier
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.Barrier r6 = (androidx.constraintlayout.widget.Barrier) r6
            if (r6 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.complete_tv
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            com.meizu.common.widget.MzButton r7 = (com.meizu.common.widget.MzButton) r7
            if (r7 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.complete_tv_long
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            com.meizu.common.widget.MzButton r8 = (com.meizu.common.widget.MzButton) r8
            if (r8 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.cover
            android.view.View r9 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r9 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.error_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.error_info_set
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.error_info_tips
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.goto_setting
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            com.meizu.common.widget.MzButton r13 = (com.meizu.common.widget.MzButton) r13
            if (r13 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.help_main
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.refreshlayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r15 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r15
            if (r15 == 0) goto L_0x008e
            int r1 = com.upuphone.xr.sapp.R.id.tip_set_ok
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x008e
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r1 = new com.upuphone.xr.sapp.databinding.FragmentH5Binding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x008e:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.FragmentH5Binding.a(android.view.View):com.upuphone.xr.sapp.databinding.FragmentH5Binding");
    }

    public static FragmentH5Binding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_h5, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6794a;
    }
}

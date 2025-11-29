package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;

public final class FragmentMiniDesktopBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6806a;
    public final ConstraintLayout b;
    public final MiniDesktopLayoutBinding c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ConstraintLayout h;
    public final TextView i;
    public final ImageView j;
    public final TextView k;
    public final ConstraintLayout l;
    public final TextView m;

    public FragmentMiniDesktopBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, MiniDesktopLayoutBinding miniDesktopLayoutBinding, ImageView imageView, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3, TextView textView4, ImageView imageView2, TextView textView5, ConstraintLayout constraintLayout4, TextView textView6) {
        this.f6806a = constraintLayout;
        this.b = constraintLayout2;
        this.c = miniDesktopLayoutBinding;
        this.d = imageView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = constraintLayout3;
        this.i = textView4;
        this.j = imageView2;
        this.k = textView5;
        this.l = constraintLayout4;
        this.m = textView6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.upuphone.xr.sapp.R.id.added_list;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.FragmentMiniDesktopBinding a(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.upuphone.xr.sapp.R.id.added_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0088
            int r1 = com.upuphone.xr.sapp.R.id.added_list
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r2 == 0) goto L_0x0088
            com.upuphone.xr.sapp.databinding.MiniDesktopLayoutBinding r6 = com.upuphone.xr.sapp.databinding.MiniDesktopLayoutBinding.a(r2)
            int r1 = com.upuphone.xr.sapp.R.id.dock_bottom
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0088
            int r1 = com.upuphone.xr.sapp.R.id.dock_note
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0088
            int r1 = com.upuphone.xr.sapp.R.id.dock_reminder
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0088
            int r1 = com.upuphone.xr.sapp.R.id.dock_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0088
            r11 = r0
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            int r1 = com.upuphone.xr.sapp.R.id.mini_desktop_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0088
            int r1 = com.upuphone.xr.sapp.R.id.mini_dock_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x0088
            int r1 = com.upuphone.xr.sapp.R.id.more
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0088
            int r1 = com.upuphone.xr.sapp.R.id.more_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x0088
            int r1 = com.upuphone.xr.sapp.R.id.save
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0088
            com.upuphone.xr.sapp.databinding.FragmentMiniDesktopBinding r0 = new com.upuphone.xr.sapp.databinding.FragmentMiniDesktopBinding
            r3 = r0
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        L_0x0088:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.FragmentMiniDesktopBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.FragmentMiniDesktopBinding");
    }

    public static FragmentMiniDesktopBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mini_desktop, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6806a;
    }
}

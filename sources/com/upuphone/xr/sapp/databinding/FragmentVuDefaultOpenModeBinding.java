package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;

public final class FragmentVuDefaultOpenModeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6832a;
    public final TextView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final View f;
    public final TextView g;
    public final ImageView h;
    public final TextView i;

    public FragmentVuDefaultOpenModeBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, View view, TextView textView4, ImageView imageView2, TextView textView5) {
        this.f6832a = constraintLayout;
        this.b = textView;
        this.c = imageView;
        this.d = textView2;
        this.e = textView3;
        this.f = view;
        this.g = textView4;
        this.h = imageView2;
        this.i = textView5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.upuphone.xr.sapp.R.id.divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.FragmentVuDefaultOpenModeBinding a(android.view.View r12) {
        /*
            int r0 = com.upuphone.xr.sapp.R.id.ar_space_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.ar_space_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.ar_space_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.back
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.divider
            android.view.View r8 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r8 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.screen_projection_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.screen_projection_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r10 = r1
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x005f
            int r0 = com.upuphone.xr.sapp.R.id.screen_projection_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005f
            com.upuphone.xr.sapp.databinding.FragmentVuDefaultOpenModeBinding r0 = new com.upuphone.xr.sapp.databinding.FragmentVuDefaultOpenModeBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x005f:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.FragmentVuDefaultOpenModeBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.FragmentVuDefaultOpenModeBinding");
    }

    public static FragmentVuDefaultOpenModeBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vu_default_open_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6832a;
    }
}

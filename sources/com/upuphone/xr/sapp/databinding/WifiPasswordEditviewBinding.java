package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;

public final class WifiPasswordEditviewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6910a;
    public final ImageView b;
    public final TextView c;
    public final View d;
    public final ImageView e;
    public final ImageView f;
    public final AppCompatEditText g;

    public WifiPasswordEditviewBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, View view, ImageView imageView2, ImageView imageView3, AppCompatEditText appCompatEditText) {
        this.f6910a = constraintLayout;
        this.b = imageView;
        this.c = textView;
        this.d = view;
        this.e = imageView2;
        this.f = imageView3;
        this.g = appCompatEditText;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.upuphone.xr.sapp.R.id.et_bg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.WifiPasswordEditviewBinding a(android.view.View r10) {
        /*
            int r0 = com.upuphone.xr.sapp.R.id.clear_iv
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0049
            int r0 = com.upuphone.xr.sapp.R.id.error_info
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0049
            int r0 = com.upuphone.xr.sapp.R.id.et_bg
            android.view.View r6 = androidx.viewbinding.ViewBindings.a(r10, r0)
            if (r6 == 0) goto L_0x0049
            int r0 = com.upuphone.xr.sapp.R.id.function_split
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0049
            int r0 = com.upuphone.xr.sapp.R.id.psd_iv
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0049
            int r0 = com.upuphone.xr.sapp.R.id.wifi_edit_input
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r9 = r1
            androidx.appcompat.widget.AppCompatEditText r9 = (androidx.appcompat.widget.AppCompatEditText) r9
            if (r9 == 0) goto L_0x0049
            com.upuphone.xr.sapp.databinding.WifiPasswordEditviewBinding r0 = new com.upuphone.xr.sapp.databinding.WifiPasswordEditviewBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0049:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.WifiPasswordEditviewBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.WifiPasswordEditviewBinding");
    }

    public static WifiPasswordEditviewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wifi_password_editview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6910a;
    }
}

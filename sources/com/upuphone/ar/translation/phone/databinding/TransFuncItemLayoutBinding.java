package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.translation.phone.R;

public final class TransFuncItemLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6264a;
    public final FrameLayout b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final View f;

    public TransFuncItemLayoutBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, View view) {
        this.f6264a = constraintLayout;
        this.b = frameLayout;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
        this.f = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.upuphone.ar.translation.phone.R.id.v_func_disable;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.translation.phone.databinding.TransFuncItemLayoutBinding a(android.view.View r9) {
        /*
            int r0 = com.upuphone.ar.translation.phone.R.id.fl_subtitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r4 = r1
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.upuphone.ar.translation.phone.R.id.iv_func_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x003e
            int r0 = com.upuphone.ar.translation.phone.R.id.tv_subtitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x003e
            int r0 = com.upuphone.ar.translation.phone.R.id.tv_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.upuphone.ar.translation.phone.R.id.v_func_disable
            android.view.View r8 = androidx.viewbinding.ViewBindings.a(r9, r0)
            if (r8 == 0) goto L_0x003e
            com.upuphone.ar.translation.phone.databinding.TransFuncItemLayoutBinding r0 = new com.upuphone.ar.translation.phone.databinding.TransFuncItemLayoutBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003e:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.databinding.TransFuncItemLayoutBinding.a(android.view.View):com.upuphone.ar.translation.phone.databinding.TransFuncItemLayoutBinding");
    }

    public static TransFuncItemLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trans_func_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6264a;
    }
}

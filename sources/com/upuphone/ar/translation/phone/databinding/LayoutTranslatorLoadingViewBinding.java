package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.LoadingView;
import com.upuphone.ar.translation.phone.R;

public final class LayoutTranslatorLoadingViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6259a;
    public final ImageView b;
    public final LoadingView c;
    public final TextView d;
    public final View e;

    public LayoutTranslatorLoadingViewBinding(ConstraintLayout constraintLayout, ImageView imageView, LoadingView loadingView, TextView textView, View view) {
        this.f6259a = constraintLayout;
        this.b = imageView;
        this.c = loadingView;
        this.d = textView;
        this.e = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.upuphone.ar.translation.phone.R.id.v_ai_cover;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.translation.phone.databinding.LayoutTranslatorLoadingViewBinding a(android.view.View r8) {
        /*
            int r0 = com.upuphone.ar.translation.phone.R.id.iv_ai_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r8, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0033
            int r0 = com.upuphone.ar.translation.phone.R.id.loading_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r8, r0)
            r5 = r1
            com.meizu.common.widget.LoadingView r5 = (com.meizu.common.widget.LoadingView) r5
            if (r5 == 0) goto L_0x0033
            int r0 = com.upuphone.ar.translation.phone.R.id.tv_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r8, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0033
            int r0 = com.upuphone.ar.translation.phone.R.id.v_ai_cover
            android.view.View r7 = androidx.viewbinding.ViewBindings.a(r8, r0)
            if (r7 == 0) goto L_0x0033
            com.upuphone.ar.translation.phone.databinding.LayoutTranslatorLoadingViewBinding r0 = new com.upuphone.ar.translation.phone.databinding.LayoutTranslatorLoadingViewBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.databinding.LayoutTranslatorLoadingViewBinding.a(android.view.View):com.upuphone.ar.translation.phone.databinding.LayoutTranslatorLoadingViewBinding");
    }

    public static LayoutTranslatorLoadingViewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_translator_loading_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6259a;
    }
}

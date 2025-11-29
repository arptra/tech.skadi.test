package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.transcribe.R;

public final class TranscribeLoadingViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6047a;
    public final ImageView b;
    public final TextView c;
    public final View d;

    public TranscribeLoadingViewBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, View view) {
        this.f6047a = constraintLayout;
        this.b = imageView;
        this.c = textView;
        this.d = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.upuphone.ar.transcribe.R.id.v_ai_cover;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.transcribe.databinding.TranscribeLoadingViewBinding a(android.view.View r4) {
        /*
            int r0 = com.upuphone.ar.transcribe.R.id.iv_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r4, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0024
            int r0 = com.upuphone.ar.transcribe.R.id.tv_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r4, r0)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0024
            int r0 = com.upuphone.ar.transcribe.R.id.v_ai_cover
            android.view.View r3 = androidx.viewbinding.ViewBindings.a(r4, r0)
            if (r3 == 0) goto L_0x0024
            com.upuphone.ar.transcribe.databinding.TranscribeLoadingViewBinding r0 = new com.upuphone.ar.transcribe.databinding.TranscribeLoadingViewBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0024:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.databinding.TranscribeLoadingViewBinding.a(android.view.View):com.upuphone.ar.transcribe.databinding.TranscribeLoadingViewBinding");
    }

    public static TranscribeLoadingViewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.transcribe_loading_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6047a;
    }
}

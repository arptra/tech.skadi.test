package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.transcribe.R;

public final class TranscribeSubtitleCardLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6050a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final View e;

    public TranscribeSubtitleCardLayoutBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, View view) {
        this.f6050a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.upuphone.ar.transcribe.R.id.v_card_bg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.transcribe.databinding.TranscribeSubtitleCardLayoutBinding a(android.view.View r8) {
        /*
            int r0 = com.upuphone.ar.transcribe.R.id.tv_card_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r8, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0033
            int r0 = com.upuphone.ar.transcribe.R.id.tv_sub_dst
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r8, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0033
            int r0 = com.upuphone.ar.transcribe.R.id.tv_sub_src
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r8, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0033
            int r0 = com.upuphone.ar.transcribe.R.id.v_card_bg
            android.view.View r7 = androidx.viewbinding.ViewBindings.a(r8, r0)
            if (r7 == 0) goto L_0x0033
            com.upuphone.ar.transcribe.databinding.TranscribeSubtitleCardLayoutBinding r0 = new com.upuphone.ar.transcribe.databinding.TranscribeSubtitleCardLayoutBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.databinding.TranscribeSubtitleCardLayoutBinding.a(android.view.View):com.upuphone.ar.transcribe.databinding.TranscribeSubtitleCardLayoutBinding");
    }

    public static TranscribeSubtitleCardLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.transcribe_subtitle_card_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6050a;
    }
}

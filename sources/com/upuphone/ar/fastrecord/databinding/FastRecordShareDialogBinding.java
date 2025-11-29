package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordShareDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5614a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final View h;

    public FastRecordShareDialogBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view) {
        this.f5614a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = textView5;
        this.g = textView6;
        this.h = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.v_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.fastrecord.databinding.FastRecordShareDialogBinding a(android.view.View r11) {
        /*
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_command_cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_share_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_share_title_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_share_type_video
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_share_type_video_word
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_share_type_word
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.fastrecord.R.id.v_line
            android.view.View r10 = androidx.viewbinding.ViewBindings.a(r11, r0)
            if (r10 == 0) goto L_0x0054
            com.upuphone.ar.fastrecord.databinding.FastRecordShareDialogBinding r0 = new com.upuphone.ar.fastrecord.databinding.FastRecordShareDialogBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0054:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.databinding.FastRecordShareDialogBinding.a(android.view.View):com.upuphone.ar.fastrecord.databinding.FastRecordShareDialogBinding");
    }

    public static FastRecordShareDialogBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordShareDialogBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_share_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5614a;
    }
}

package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

public final class FastRecordDownloadingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5588a;
    public final ProgressBar b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final View f;

    public FastRecordDownloadingBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, View view) {
        this.f5588a = constraintLayout;
        this.b = progressBar;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.v_tran_download;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.fastrecord.databinding.FastRecordDownloadingBinding a(android.view.View r9) {
        /*
            int r0 = com.upuphone.ar.fastrecord.R.id.loading_progress
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r4 = r1
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_download_doing
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x003e
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_download_progress
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x003e
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_video_sync_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.upuphone.ar.fastrecord.R.id.v_tran_download
            android.view.View r8 = androidx.viewbinding.ViewBindings.a(r9, r0)
            if (r8 == 0) goto L_0x003e
            com.upuphone.ar.fastrecord.databinding.FastRecordDownloadingBinding r0 = new com.upuphone.ar.fastrecord.databinding.FastRecordDownloadingBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.databinding.FastRecordDownloadingBinding.a(android.view.View):com.upuphone.ar.fastrecord.databinding.FastRecordDownloadingBinding");
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5588a;
    }
}

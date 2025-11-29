package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

public final class FastRecordBottomShareDeleteLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5581a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final View d;

    public FastRecordBottomShareDeleteLayoutBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, View view) {
        this.f5581a = constraintLayout;
        this.b = linearLayout;
        this.c = linearLayout2;
        this.d = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.v_un_enable;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.fastrecord.databinding.FastRecordBottomShareDeleteLayoutBinding a(android.view.View r4) {
        /*
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_del
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r4, r0)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            if (r1 == 0) goto L_0x0024
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_share
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r4, r0)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            if (r2 == 0) goto L_0x0024
            int r0 = com.upuphone.ar.fastrecord.R.id.v_un_enable
            android.view.View r3 = androidx.viewbinding.ViewBindings.a(r4, r0)
            if (r3 == 0) goto L_0x0024
            com.upuphone.ar.fastrecord.databinding.FastRecordBottomShareDeleteLayoutBinding r0 = new com.upuphone.ar.fastrecord.databinding.FastRecordBottomShareDeleteLayoutBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.databinding.FastRecordBottomShareDeleteLayoutBinding.a(android.view.View):com.upuphone.ar.fastrecord.databinding.FastRecordBottomShareDeleteLayoutBinding");
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5581a;
    }
}

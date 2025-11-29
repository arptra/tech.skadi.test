package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.CopyEditText;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView;

public final class FastRecordSummaryFragmentLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5617a;
    public final MzButton b;
    public final ConstraintLayout c;
    public final CopyEditText d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final FastRecordLoadingView j;
    public final NestedScrollView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final View q;

    public FastRecordSummaryFragmentLayoutBinding(ConstraintLayout constraintLayout, MzButton mzButton, ConstraintLayout constraintLayout2, CopyEditText copyEditText, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, FastRecordLoadingView fastRecordLoadingView, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.f5617a = constraintLayout;
        this.b = mzButton;
        this.c = constraintLayout2;
        this.d = copyEditText;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = linearLayout;
        this.i = linearLayout2;
        this.j = fastRecordLoadingView;
        this.k = nestedScrollView;
        this.l = textView;
        this.m = textView2;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
        this.q = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
        r1 = com.upuphone.ar.fastrecord.R.id.v_tran_bottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding a(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.upuphone.ar.fastrecord.R.id.bottom_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            com.meizu.common.widget.MzButton r5 = (com.meizu.common.widget.MzButton) r5
            if (r5 == 0) goto L_0x00b3
            r6 = r0
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            int r1 = com.upuphone.ar.fastrecord.R.id.edt_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            com.upuphone.ar.fastrecord.phone.ui.widget.CopyEditText r7 = (com.upuphone.ar.fastrecord.phone.ui.widget.CopyEditText) r7
            if (r7 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.iv_feedback
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.iv_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.iv_tip_icon_summary
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.ll_feed_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.summary_content_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.summary_extract_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView r13 = (com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView) r13
            if (r13 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.summary_scrollView
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            androidx.core.widget.NestedScrollView r14 = (androidx.core.widget.NestedScrollView) r14
            if (r14 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.text_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.tv_extract_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.tv_feedback
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.tv_summary_statement
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.tv_summary_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00b3
            int r1 = com.upuphone.ar.fastrecord.R.id.v_tran_bottom
            android.view.View r20 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r20 == 0) goto L_0x00b3
            com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding r0 = new com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding
            r3 = r0
            r4 = r6
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x00b3:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding.a(android.view.View):com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding");
    }

    public static FastRecordSummaryFragmentLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_summary_fragment_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5617a;
    }
}

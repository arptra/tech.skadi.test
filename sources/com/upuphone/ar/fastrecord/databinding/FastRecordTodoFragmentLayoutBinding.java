package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView;

public final class FastRecordTodoFragmentLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5623a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final LinearLayout e;
    public final MzButton f;
    public final FastRecordLoadingView g;
    public final RecyclerView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final View m;

    public FastRecordTodoFragmentLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, MzButton mzButton, FastRecordLoadingView fastRecordLoadingView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        this.f5623a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = linearLayout;
        this.f = mzButton;
        this.g = fastRecordLoadingView;
        this.h = recyclerView;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.upuphone.ar.fastrecord.R.id.v_tran_bottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding a(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.upuphone.ar.fastrecord.R.id.iv_feedback
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.iv_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.iv_tip_icon_todo
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.ll_feed_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.todo_bottom_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            com.meizu.common.widget.MzButton r9 = (com.meizu.common.widget.MzButton) r9
            if (r9 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.todo_extract_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView r10 = (com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView) r10
            if (r10 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.todo_recycler
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            if (r11 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.tv_extract_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.tv_feedback
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.tv_summary_statement
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.tv_todo_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x008d
            int r1 = com.upuphone.ar.fastrecord.R.id.v_tran_bottom
            android.view.View r16 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r16 == 0) goto L_0x008d
            com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding r1 = new com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x008d:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding.a(android.view.View):com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding");
    }

    public static FastRecordTodoFragmentLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_todo_fragment_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5623a;
    }
}

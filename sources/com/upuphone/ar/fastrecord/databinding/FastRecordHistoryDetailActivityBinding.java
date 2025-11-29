package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordHistoryDetailActivityBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5594a;
    public final ConstraintLayout b;
    public final View c;
    public final View d;
    public final FastRecordHistoryDetailBottomLayoutBinding e;
    public final FastRecordHistoryDetailEmptyLayoutBinding f;
    public final FastRecordHistoryDetailFailOrEmptyLayoutBinding g;
    public final FastRecordHistoryDetailLoadingLayoutBinding h;
    public final LinearLayout i;
    public final RecyclerView j;
    public final FastRecordDetailHistoryTitleBinding k;

    public FastRecordHistoryDetailActivityBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, View view2, FastRecordHistoryDetailBottomLayoutBinding fastRecordHistoryDetailBottomLayoutBinding, FastRecordHistoryDetailEmptyLayoutBinding fastRecordHistoryDetailEmptyLayoutBinding, FastRecordHistoryDetailFailOrEmptyLayoutBinding fastRecordHistoryDetailFailOrEmptyLayoutBinding, FastRecordHistoryDetailLoadingLayoutBinding fastRecordHistoryDetailLoadingLayoutBinding, LinearLayout linearLayout, RecyclerView recyclerView, FastRecordDetailHistoryTitleBinding fastRecordDetailHistoryTitleBinding) {
        this.f5594a = constraintLayout;
        this.b = constraintLayout2;
        this.c = view;
        this.d = view2;
        this.e = fastRecordHistoryDetailBottomLayoutBinding;
        this.f = fastRecordHistoryDetailEmptyLayoutBinding;
        this.g = fastRecordHistoryDetailFailOrEmptyLayoutBinding;
        this.h = fastRecordHistoryDetailLoadingLayoutBinding;
        this.i = linearLayout;
        this.j = recyclerView;
        this.k = fastRecordDetailHistoryTitleBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.title_layout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.iv_up_tran;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.ll_command;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailActivityBinding a(android.view.View r12) {
        /*
            r2 = r12
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            int r0 = com.upuphone.ar.fastrecord.R.id.iv_bottom_tran
            android.view.View r3 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r3 == 0) goto L_0x006d
            int r0 = com.upuphone.ar.fastrecord.R.id.iv_up_tran
            android.view.View r4 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r4 == 0) goto L_0x006d
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_command
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r1 == 0) goto L_0x006d
            com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailBottomLayoutBinding r5 = com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailBottomLayoutBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_fast_record_empty
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r1 == 0) goto L_0x006d
            com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailEmptyLayoutBinding r6 = com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailEmptyLayoutBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_fast_record_fail
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r1 == 0) goto L_0x006d
            com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailFailOrEmptyLayoutBinding r7 = com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailFailOrEmptyLayoutBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_fast_record_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r1 == 0) goto L_0x006d
            com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailLoadingLayoutBinding r8 = com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailLoadingLayoutBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_rec_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r9 = r1
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x006d
            int r0 = com.upuphone.ar.fastrecord.R.id.rec_record
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r10 = r1
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            if (r10 == 0) goto L_0x006d
            int r0 = com.upuphone.ar.fastrecord.R.id.title_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r1 == 0) goto L_0x006d
            com.upuphone.ar.fastrecord.databinding.FastRecordDetailHistoryTitleBinding r11 = com.upuphone.ar.fastrecord.databinding.FastRecordDetailHistoryTitleBinding.a(r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailActivityBinding r12 = new com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailActivityBinding
            r0 = r12
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r12
        L_0x006d:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailActivityBinding.a(android.view.View):com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailActivityBinding");
    }

    public static FastRecordHistoryDetailActivityBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordHistoryDetailActivityBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_history_detail_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5594a;
    }
}

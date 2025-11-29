package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.tabs.TabLayout;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordTitleBar;
import com.upuphone.ar.fastrecord.phone.ui.widget.RecordTabViewPager;

public final class FastRecordMainActivityBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5607a;
    public final FastRecordDownloadingBinding b;
    public final LinearLayout c;
    public final FastRecordBottomCommandLayoutBinding d;
    public final FastRecordBottomShareDeleteLayoutBinding e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final FastRecordChooseTitleBarLayoutBinding h;
    public final RecordTabViewPager i;
    public final TabLayout j;
    public final FastRecordTitleBar k;
    public final TextView l;

    public FastRecordMainActivityBinding(ConstraintLayout constraintLayout, FastRecordDownloadingBinding fastRecordDownloadingBinding, LinearLayout linearLayout, FastRecordBottomCommandLayoutBinding fastRecordBottomCommandLayoutBinding, FastRecordBottomShareDeleteLayoutBinding fastRecordBottomShareDeleteLayoutBinding, LinearLayout linearLayout2, LinearLayout linearLayout3, FastRecordChooseTitleBarLayoutBinding fastRecordChooseTitleBarLayoutBinding, RecordTabViewPager recordTabViewPager, TabLayout tabLayout, FastRecordTitleBar fastRecordTitleBar, TextView textView) {
        this.f5607a = constraintLayout;
        this.b = fastRecordDownloadingBinding;
        this.c = linearLayout;
        this.d = fastRecordBottomCommandLayoutBinding;
        this.e = fastRecordBottomShareDeleteLayoutBinding;
        this.f = linearLayout2;
        this.g = linearLayout3;
        this.h = fastRecordChooseTitleBarLayoutBinding;
        this.i = recordTabViewPager;
        this.j = tabLayout;
        this.k = fastRecordTitleBar;
        this.l = textView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.ll_title_choose;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.ll_command;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding a(android.view.View r15) {
        /*
            int r0 = com.upuphone.ar.fastrecord.R.id.cl_download
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            if (r1 == 0) goto L_0x0087
            com.upuphone.ar.fastrecord.databinding.FastRecordDownloadingBinding r4 = com.upuphone.ar.fastrecord.databinding.FastRecordDownloadingBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_bottom
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0087
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_command
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            if (r1 == 0) goto L_0x0087
            com.upuphone.ar.fastrecord.databinding.FastRecordBottomCommandLayoutBinding r6 = com.upuphone.ar.fastrecord.databinding.FastRecordBottomCommandLayoutBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_command_share_del
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            if (r1 == 0) goto L_0x0087
            com.upuphone.ar.fastrecord.databinding.FastRecordBottomShareDeleteLayoutBinding r7 = com.upuphone.ar.fastrecord.databinding.FastRecordBottomShareDeleteLayoutBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_tab_download
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r8 = r1
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x0087
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_title_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r9 = r1
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x0087
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_title_choose
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            if (r1 == 0) goto L_0x0087
            com.upuphone.ar.fastrecord.databinding.FastRecordChooseTitleBarLayoutBinding r10 = com.upuphone.ar.fastrecord.databinding.FastRecordChooseTitleBarLayoutBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.record_view_pager
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r11 = r1
            com.upuphone.ar.fastrecord.phone.ui.widget.RecordTabViewPager r11 = (com.upuphone.ar.fastrecord.phone.ui.widget.RecordTabViewPager) r11
            if (r11 == 0) goto L_0x0087
            int r0 = com.upuphone.ar.fastrecord.R.id.tabContainer
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r12 = r1
            com.google.android.material.tabs.TabLayout r12 = (com.google.android.material.tabs.TabLayout) r12
            if (r12 == 0) goto L_0x0087
            int r0 = com.upuphone.ar.fastrecord.R.id.title_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r13 = r1
            com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordTitleBar r13 = (com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordTitleBar) r13
            if (r13 == 0) goto L_0x0087
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_record_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0087
            com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding r0 = new com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding
            r3 = r15
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x0087:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding.a(android.view.View):com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding");
    }

    public static FastRecordMainActivityBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordMainActivityBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_main_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5607a;
    }
}

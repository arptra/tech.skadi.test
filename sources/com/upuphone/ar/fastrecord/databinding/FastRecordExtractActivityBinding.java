package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDetailTitleBar;

public final class FastRecordExtractActivityBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5591a;
    public final TabLayout b;
    public final ConstraintLayout c;
    public final ViewPager d;
    public final FastRecordDetailTitleBar e;

    public FastRecordExtractActivityBinding(ConstraintLayout constraintLayout, TabLayout tabLayout, ConstraintLayout constraintLayout2, ViewPager viewPager, FastRecordDetailTitleBar fastRecordDetailTitleBar) {
        this.f5591a = constraintLayout;
        this.b = tabLayout;
        this.c = constraintLayout2;
        this.d = viewPager;
        this.e = fastRecordDetailTitleBar;
    }

    public static FastRecordExtractActivityBinding a(View view) {
        int i = R.id.extractTabContainer;
        TabLayout tabLayout = (TabLayout) ViewBindings.a(view, i);
        if (tabLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.summary_view_pager;
            ViewPager viewPager = (ViewPager) ViewBindings.a(view, i);
            if (viewPager != null) {
                i = R.id.title_bar;
                FastRecordDetailTitleBar fastRecordDetailTitleBar = (FastRecordDetailTitleBar) ViewBindings.a(view, i);
                if (fastRecordDetailTitleBar != null) {
                    return new FastRecordExtractActivityBinding(constraintLayout, tabLayout, constraintLayout, viewPager, fastRecordDetailTitleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordExtractActivityBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordExtractActivityBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_extract_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5591a;
    }
}

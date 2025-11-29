package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;
import flyme.support.v7.widget.MzRecyclerView;

public final class FastRecordAllFragmentLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5579a;
    public final MzRecyclerView b;
    public final TextView c;

    public FastRecordAllFragmentLayoutBinding(ConstraintLayout constraintLayout, MzRecyclerView mzRecyclerView, TextView textView) {
        this.f5579a = constraintLayout;
        this.b = mzRecyclerView;
        this.c = textView;
    }

    public static FastRecordAllFragmentLayoutBinding a(View view) {
        int i = R.id.fast_record_recycler;
        MzRecyclerView mzRecyclerView = (MzRecyclerView) ViewBindings.a(view, i);
        if (mzRecyclerView != null) {
            i = R.id.tv_record_tip;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                return new FastRecordAllFragmentLayoutBinding((ConstraintLayout) view, mzRecyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordAllFragmentLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_all_fragment_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5579a;
    }
}

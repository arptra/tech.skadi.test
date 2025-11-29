package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import flyme.support.v7.widget.MzRecyclerView;

public abstract class FragmentStarryNetDeviceListBinding extends ViewDataBinding {
    public final MzRecyclerView A;
    public final TextView B;
    public final TextView C;
    public final ProgressBar z;

    public FragmentStarryNetDeviceListBinding(Object obj, View view, int i, ProgressBar progressBar, MzRecyclerView mzRecyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.z = progressBar;
        this.A = mzRecyclerView;
        this.B = textView;
        this.C = textView2;
    }
}

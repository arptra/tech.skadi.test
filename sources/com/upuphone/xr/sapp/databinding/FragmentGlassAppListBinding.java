package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import flyme.support.v7.widget.MzRecyclerView;

public final class FragmentGlassAppListBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6786a;
    public final TextView b;
    public final ConstraintLayout c;
    public final MzRecyclerView d;
    public final TextView e;

    public FragmentGlassAppListBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, MzRecyclerView mzRecyclerView, TextView textView2) {
        this.f6786a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = mzRecyclerView;
        this.e = textView2;
    }

    public static FragmentGlassAppListBinding a(View view) {
        int i = R.id.glass_info_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.glass_info_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
            if (constraintLayout != null) {
                i = R.id.recyclerview;
                MzRecyclerView mzRecyclerView = (MzRecyclerView) ViewBindings.a(view, i);
                if (mzRecyclerView != null) {
                    i = R.id.tips;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        return new FragmentGlassAppListBinding((ConstraintLayout) view, textView, constraintLayout, mzRecyclerView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentGlassAppListBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_glass_app_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6786a;
    }
}

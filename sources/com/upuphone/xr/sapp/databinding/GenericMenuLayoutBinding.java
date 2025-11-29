package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import flyme.support.v7.widget.MzRecyclerView;

public final class GenericMenuLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f6842a;
    public final LinearLayout b;
    public final TextView c;
    public final MzRecyclerView d;
    public final TextView e;

    public GenericMenuLayoutBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, MzRecyclerView mzRecyclerView, TextView textView2) {
        this.f6842a = relativeLayout;
        this.b = linearLayout;
        this.c = textView;
        this.d = mzRecyclerView;
        this.e = textView2;
    }

    public static GenericMenuLayoutBinding a(View view) {
        int i = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
        if (linearLayout != null) {
            i = R.id.menu_cancel_text;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.menu_recycler_view;
                MzRecyclerView mzRecyclerView = (MzRecyclerView) ViewBindings.a(view, i);
                if (mzRecyclerView != null) {
                    i = R.id.menu_top_title;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        return new GenericMenuLayoutBinding((RelativeLayout) view, linearLayout, textView, mzRecyclerView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static GenericMenuLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.generic_menu_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f6842a;
    }
}

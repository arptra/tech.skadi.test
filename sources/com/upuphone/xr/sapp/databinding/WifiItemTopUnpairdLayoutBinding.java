package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class WifiItemTopUnpairdLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6908a;
    public final ProgressBar b;
    public final TextView c;

    public WifiItemTopUnpairdLayoutBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, TextView textView) {
        this.f6908a = constraintLayout;
        this.b = progressBar;
        this.c = textView;
    }

    public static WifiItemTopUnpairdLayoutBinding a(View view) {
        int i = R.id.pb_loading;
        ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, i);
        if (progressBar != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                return new WifiItemTopUnpairdLayoutBinding((ConstraintLayout) view, progressBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static WifiItemTopUnpairdLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wifi_item_top_unpaird_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6908a;
    }
}

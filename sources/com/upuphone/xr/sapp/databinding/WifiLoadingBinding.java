package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class WifiLoadingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6909a;
    public final TextView b;

    public WifiLoadingBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.f6909a = constraintLayout;
        this.b = textView;
    }

    public static WifiLoadingBinding a(View view) {
        int i = R.id.title;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new WifiLoadingBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static WifiLoadingBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wifi_loading, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6909a;
    }
}

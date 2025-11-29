package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class WifiItemBottomConnectLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6905a;
    public final TextView b;

    public WifiItemBottomConnectLayoutBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.f6905a = constraintLayout;
        this.b = textView;
    }

    public static WifiItemBottomConnectLayoutBinding a(View view) {
        int i = R.id.connect_state;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new WifiItemBottomConnectLayoutBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static WifiItemBottomConnectLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wifi_item_bottom_connect_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6905a;
    }
}

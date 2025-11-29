package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;

public final class WifiAutoSwitchItemLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6903a;
    public final CardItemView b;

    public WifiAutoSwitchItemLayoutBinding(ConstraintLayout constraintLayout, CardItemView cardItemView) {
        this.f6903a = constraintLayout;
        this.b = cardItemView;
    }

    public static WifiAutoSwitchItemLayoutBinding a(View view) {
        int i = R.id.auto_connect;
        CardItemView cardItemView = (CardItemView) ViewBindings.a(view, i);
        if (cardItemView != null) {
            return new WifiAutoSwitchItemLayoutBinding((ConstraintLayout) view, cardItemView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static WifiAutoSwitchItemLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wifi_auto_switch_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6903a;
    }
}

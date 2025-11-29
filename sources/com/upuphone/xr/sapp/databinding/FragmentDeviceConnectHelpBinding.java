package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.ToggleCardItemView;

public final class FragmentDeviceConnectHelpBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6779a;
    public final TextView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final ToggleCardItemView f;
    public final ToggleCardItemView g;
    public final ToggleCardItemView h;
    public final NestedScrollView i;
    public final TextView j;

    public FragmentDeviceConnectHelpBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ToggleCardItemView toggleCardItemView, ToggleCardItemView toggleCardItemView2, ToggleCardItemView toggleCardItemView3, NestedScrollView nestedScrollView, TextView textView2) {
        this.f6779a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = constraintLayout3;
        this.e = constraintLayout4;
        this.f = toggleCardItemView;
        this.g = toggleCardItemView2;
        this.h = toggleCardItemView3;
        this.i = nestedScrollView;
        this.j = textView2;
    }

    public static FragmentDeviceConnectHelpBinding a(View view) {
        int i2 = R.id.back_title;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.help_autostart_main;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
            if (constraintLayout != null) {
                i2 = R.id.help_battery_main;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                if (constraintLayout2 != null) {
                    i2 = R.id.help_lock_main;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view, i2);
                    if (constraintLayout3 != null) {
                        i2 = R.id.item_autostart;
                        ToggleCardItemView toggleCardItemView = (ToggleCardItemView) ViewBindings.a(view, i2);
                        if (toggleCardItemView != null) {
                            i2 = R.id.item_battery;
                            ToggleCardItemView toggleCardItemView2 = (ToggleCardItemView) ViewBindings.a(view, i2);
                            if (toggleCardItemView2 != null) {
                                i2 = R.id.item_lock;
                                ToggleCardItemView toggleCardItemView3 = (ToggleCardItemView) ViewBindings.a(view, i2);
                                if (toggleCardItemView3 != null) {
                                    i2 = R.id.scroll_layout;
                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i2);
                                    if (nestedScrollView != null) {
                                        i2 = R.id.tv_tips;
                                        TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                        if (textView2 != null) {
                                            return new FragmentDeviceConnectHelpBinding((ConstraintLayout) view, textView, constraintLayout, constraintLayout2, constraintLayout3, toggleCardItemView, toggleCardItemView2, toggleCardItemView3, nestedScrollView, textView2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentDeviceConnectHelpBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_connect_help, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6779a;
    }
}

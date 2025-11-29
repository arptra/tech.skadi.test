package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class LayoutConnectTipWindowBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6864a;
    public final TextView b;
    public final TextView c;
    public final MzButton d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    public LayoutConnectTipWindowBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, MzButton mzButton, TextView textView3, TextView textView4, TextView textView5) {
        this.f6864a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = mzButton;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
    }

    public static LayoutConnectTipWindowBinding a(View view) {
        int i = R.id.myvu_glass_content;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.myvu_glass_title;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                i = R.id.one_confirm;
                MzButton mzButton = (MzButton) ViewBindings.a(view, i);
                if (mzButton != null) {
                    i = R.id.title;
                    TextView textView3 = (TextView) ViewBindings.a(view, i);
                    if (textView3 != null) {
                        i = R.id.view_glass_content;
                        TextView textView4 = (TextView) ViewBindings.a(view, i);
                        if (textView4 != null) {
                            i = R.id.view_glass_title;
                            TextView textView5 = (TextView) ViewBindings.a(view, i);
                            if (textView5 != null) {
                                return new LayoutConnectTipWindowBinding((ConstraintLayout) view, textView, textView2, mzButton, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutConnectTipWindowBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_connect_tip_window, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6864a;
    }
}

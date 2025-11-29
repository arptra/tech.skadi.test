package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class LayoutConnectViewWindowBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6865a;
    public final MzButton b;
    public final TextView c;
    public final CheckBox d;
    public final LinearLayout e;
    public final TextView f;
    public final MzButton g;
    public final TextView h;

    public LayoutConnectViewWindowBinding(ConstraintLayout constraintLayout, MzButton mzButton, TextView textView, CheckBox checkBox, LinearLayout linearLayout, TextView textView2, MzButton mzButton2, TextView textView3) {
        this.f6865a = constraintLayout;
        this.b = mzButton;
        this.c = textView;
        this.d = checkBox;
        this.e = linearLayout;
        this.f = textView2;
        this.g = mzButton2;
        this.h = textView3;
    }

    public static LayoutConnectViewWindowBinding a(View view) {
        int i = R.id.confirm;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i);
        if (mzButton != null) {
            i = R.id.content;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.dont_notify_cb;
                CheckBox checkBox = (CheckBox) ViewBindings.a(view, i);
                if (checkBox != null) {
                    i = R.id.dont_notify_main;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
                    if (linearLayout != null) {
                        i = R.id.dont_notify_text;
                        TextView textView2 = (TextView) ViewBindings.a(view, i);
                        if (textView2 != null) {
                            i = R.id.refuse;
                            MzButton mzButton2 = (MzButton) ViewBindings.a(view, i);
                            if (mzButton2 != null) {
                                i = R.id.title;
                                TextView textView3 = (TextView) ViewBindings.a(view, i);
                                if (textView3 != null) {
                                    return new LayoutConnectViewWindowBinding((ConstraintLayout) view, mzButton, textView, checkBox, linearLayout, textView2, mzButton2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutConnectViewWindowBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_connect_view_window, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6865a;
    }
}

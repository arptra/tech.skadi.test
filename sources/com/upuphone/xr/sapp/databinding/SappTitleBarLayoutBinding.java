package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class SappTitleBarLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6897a;
    public final Group b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;

    public SappTitleBarLayoutBinding(ConstraintLayout constraintLayout, Group group, ImageView imageView, TextView textView, TextView textView2) {
        this.f6897a = constraintLayout;
        this.b = group;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
    }

    public static SappTitleBarLayoutBinding a(View view) {
        int i = R.id.gp_back_icon;
        Group group = (Group) ViewBindings.a(view, i);
        if (group != null) {
            i = R.id.iv_back;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.tv_back;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        return new SappTitleBarLayoutBinding((ConstraintLayout) view, group, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SappTitleBarLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.sapp_title_bar_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6897a;
    }
}

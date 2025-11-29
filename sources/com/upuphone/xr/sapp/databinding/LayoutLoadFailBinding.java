package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class LayoutLoadFailBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6877a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;

    public LayoutLoadFailBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f6877a = linearLayout;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
    }

    public static LayoutLoadFailBinding a(View view) {
        int i = R.id.iv_tip;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.tv_action;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.tv_tip;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new LayoutLoadFailBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6877a;
    }
}

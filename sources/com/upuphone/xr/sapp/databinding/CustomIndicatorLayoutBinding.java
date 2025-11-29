package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class CustomIndicatorLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6742a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;

    public CustomIndicatorLayoutBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        this.f6742a = linearLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
    }

    public static CustomIndicatorLayoutBinding a(View view) {
        int i = R.id.ind_four;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.ind_one;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
            if (imageView2 != null) {
                i = R.id.ind_three;
                ImageView imageView3 = (ImageView) ViewBindings.a(view, i);
                if (imageView3 != null) {
                    i = R.id.ind_two;
                    ImageView imageView4 = (ImageView) ViewBindings.a(view, i);
                    if (imageView4 != null) {
                        return new CustomIndicatorLayoutBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6742a;
    }
}

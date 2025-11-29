package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentLargeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f6799a;
    public final ImageView b;
    public final TextView c;
    public final ImageView d;
    public final ImageView e;
    public final RelativeLayout f;

    public FragmentLargeBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2) {
        this.f6799a = relativeLayout;
        this.b = imageView;
        this.c = textView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = relativeLayout2;
    }

    public static FragmentLargeBinding a(View view) {
        int i = R.id.back_img;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.feedback_back_select;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.large_img;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
                if (imageView2 != null) {
                    i = R.id.select_img;
                    ImageView imageView3 = (ImageView) ViewBindings.a(view, i);
                    if (imageView3 != null) {
                        i = R.id.titlebar_layout;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.a(view, i);
                        if (relativeLayout != null) {
                            return new FragmentLargeBinding((RelativeLayout) view, imageView, textView, imageView2, imageView3, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentLargeBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_large, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f6799a;
    }
}

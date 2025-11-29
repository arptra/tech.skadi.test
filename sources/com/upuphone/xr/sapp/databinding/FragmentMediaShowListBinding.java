package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.upuphone.xr.sapp.R;

public final class FragmentMediaShowListBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f6804a;
    public final ImageView b;
    public final TextView c;
    public final ImageView d;
    public final RelativeLayout e;
    public final ViewPager f;

    public FragmentMediaShowListBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, ImageView imageView2, RelativeLayout relativeLayout2, ViewPager viewPager) {
        this.f6804a = relativeLayout;
        this.b = imageView;
        this.c = textView;
        this.d = imageView2;
        this.e = relativeLayout2;
        this.f = viewPager;
    }

    public static FragmentMediaShowListBinding a(View view) {
        int i = R.id.back_img;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.feedback_back_select;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.select_img;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
                if (imageView2 != null) {
                    i = R.id.titlebar_layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.a(view, i);
                    if (relativeLayout != null) {
                        i = R.id.view_pager;
                        ViewPager viewPager = (ViewPager) ViewBindings.a(view, i);
                        if (viewPager != null) {
                            return new FragmentMediaShowListBinding((RelativeLayout) view, imageView, textView, imageView2, relativeLayout, viewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMediaShowListBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_media_show_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f6804a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.upuphone.xr.sapp.R;

public final class FragmentMediaPreviewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f6802a;
    public final ImageView b;
    public final RelativeLayout c;
    public final ViewPager d;

    public FragmentMediaPreviewBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, ViewPager viewPager) {
        this.f6802a = relativeLayout;
        this.b = imageView;
        this.c = relativeLayout2;
        this.d = viewPager;
    }

    public static FragmentMediaPreviewBinding a(View view) {
        int i = R.id.back_img;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.title_bar_layout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.a(view, i);
            if (relativeLayout != null) {
                i = R.id.view_pager;
                ViewPager viewPager = (ViewPager) ViewBindings.a(view, i);
                if (viewPager != null) {
                    return new FragmentMediaPreviewBinding((RelativeLayout) view, imageView, relativeLayout, viewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMediaPreviewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_media_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f6802a;
    }
}

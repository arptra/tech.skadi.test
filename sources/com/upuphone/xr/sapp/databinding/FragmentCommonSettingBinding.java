package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentCommonSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6777a;
    public final ImageView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;

    public FragmentCommonSettingBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.f6777a = constraintLayout;
        this.b = imageView;
        this.c = constraintLayout2;
        this.d = constraintLayout3;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
        this.j = textView6;
    }

    public static FragmentCommonSettingBinding a(View view) {
        int i2 = R.id.iv_arrow_right;
        ImageView imageView = (ImageView) ViewBindings.a(view, i2);
        if (imageView != null) {
            i2 = R.id.lay_glass_update;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
            if (constraintLayout != null) {
                i2 = R.id.rootView;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                if (constraintLayout2 != null) {
                    i2 = R.id.tv_about_glass;
                    TextView textView = (TextView) ViewBindings.a(view, i2);
                    if (textView != null) {
                        i2 = R.id.tv_back_title;
                        TextView textView2 = (TextView) ViewBindings.a(view, i2);
                        if (textView2 != null) {
                            i2 = R.id.tv_factory_reset;
                            TextView textView3 = (TextView) ViewBindings.a(view, i2);
                            if (textView3 != null) {
                                i2 = R.id.tv_glass_language;
                                TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                if (textView4 != null) {
                                    i2 = R.id.tv_glass_update;
                                    TextView textView5 = (TextView) ViewBindings.a(view, i2);
                                    if (textView5 != null) {
                                        i2 = R.id.tv_new_update;
                                        TextView textView6 = (TextView) ViewBindings.a(view, i2);
                                        if (textView6 != null) {
                                            return new FragmentCommonSettingBinding((ConstraintLayout) view, imageView, constraintLayout, constraintLayout2, textView, textView2, textView3, textView4, textView5, textView6);
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

    public static FragmentCommonSettingBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_common_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6777a;
    }
}

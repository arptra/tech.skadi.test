package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.xr.sapp.R;

public final class FragmentTouchpadBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6820a;
    public final ImageView b;
    public final ConstraintLayout c;
    public final CircularProgressButton d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ConstraintLayout h;
    public final ImageView i;
    public final ImageView j;
    public final TextView k;
    public final TextView l;

    public FragmentTouchpadBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, CircularProgressButton circularProgressButton, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout3, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2) {
        this.f6820a = constraintLayout;
        this.b = imageView;
        this.c = constraintLayout2;
        this.d = circularProgressButton;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = constraintLayout3;
        this.i = imageView5;
        this.j = imageView6;
        this.k = textView;
        this.l = textView2;
    }

    public static FragmentTouchpadBinding a(View view) {
        int i2 = R.id.glass;
        ImageView imageView = (ImageView) ViewBindings.a(view, i2);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i2 = R.id.screenshot_progress_button;
            CircularProgressButton circularProgressButton = (CircularProgressButton) ViewBindings.a(view, i2);
            if (circularProgressButton != null) {
                i2 = R.id.touchpad;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i2);
                if (imageView2 != null) {
                    i2 = R.id.touchpad_bg;
                    ImageView imageView3 = (ImageView) ViewBindings.a(view, i2);
                    if (imageView3 != null) {
                        i2 = R.id.touchpad_bubble_delete;
                        ImageView imageView4 = (ImageView) ViewBindings.a(view, i2);
                        if (imageView4 != null) {
                            i2 = R.id.touchpad_bubble_layout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                            if (constraintLayout2 != null) {
                                i2 = R.id.touchpad_bubble_line;
                                ImageView imageView5 = (ImageView) ViewBindings.a(view, i2);
                                if (imageView5 != null) {
                                    i2 = R.id.touchpad_help;
                                    ImageView imageView6 = (ImageView) ViewBindings.a(view, i2);
                                    if (imageView6 != null) {
                                        i2 = R.id.touchpad_help_note;
                                        TextView textView = (TextView) ViewBindings.a(view, i2);
                                        if (textView != null) {
                                            i2 = R.id.tv_title;
                                            TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                            if (textView2 != null) {
                                                return new FragmentTouchpadBinding(constraintLayout, imageView, constraintLayout, circularProgressButton, imageView2, imageView3, imageView4, constraintLayout2, imageView5, imageView6, textView, textView2);
                                            }
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

    public static FragmentTouchpadBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_touchpad, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6820a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;

public final class LayoutCardItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f6863a;
    public final ConstraintLayout b;
    public final FrameLayout c;
    public final ImageView d;
    public final LinearLayout e;
    public final Switch f;
    public final TextView g;
    public final TextView h;
    public final TextView i;

    public LayoutCardItemBinding(View view, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, Switch switchR, TextView textView, TextView textView2, TextView textView3) {
        this.f6863a = view;
        this.b = constraintLayout;
        this.c = frameLayout;
        this.d = imageView;
        this.e = linearLayout;
        this.f = switchR;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
    }

    public static LayoutCardItemBinding a(View view) {
        int i2 = R.id.card_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
        if (constraintLayout != null) {
            i2 = R.id.fl_indicator;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i2);
            if (frameLayout != null) {
                i2 = R.id.iv_indicator;
                ImageView imageView = (ImageView) ViewBindings.a(view, i2);
                if (imageView != null) {
                    i2 = R.id.ll_indicator;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                    if (linearLayout != null) {
                        i2 = R.id.switch_indicator;
                        Switch switchR = (Switch) ViewBindings.a(view, i2);
                        if (switchR != null) {
                            i2 = R.id.tv_indicator;
                            TextView textView = (TextView) ViewBindings.a(view, i2);
                            if (textView != null) {
                                i2 = R.id.tv_subtitle;
                                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                if (textView2 != null) {
                                    i2 = R.id.tv_title;
                                    TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                    if (textView3 != null) {
                                        return new LayoutCardItemBinding(view, constraintLayout, frameLayout, imageView, linearLayout, switchR, textView, textView2, textView3);
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

    public View getRoot() {
        return this.f6863a;
    }
}

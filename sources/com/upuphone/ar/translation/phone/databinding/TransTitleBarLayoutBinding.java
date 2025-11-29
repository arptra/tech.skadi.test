package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.translation.phone.R;

public final class TransTitleBarLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6268a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final LinearLayout g;
    public final TextView h;
    public final TextView i;

    public TransTitleBarLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f6268a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = linearLayout;
        this.h = textView;
        this.i = textView2;
    }

    public static TransTitleBarLayoutBinding a(View view) {
        int i2 = R.id.ivBack;
        ImageView imageView = (ImageView) ViewBindings.a(view, i2);
        if (imageView != null) {
            i2 = R.id.ivMenu;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i2);
            if (imageView2 != null) {
                i2 = R.id.ivMenu1;
                ImageView imageView3 = (ImageView) ViewBindings.a(view, i2);
                if (imageView3 != null) {
                    i2 = R.id.ivMenu2;
                    ImageView imageView4 = (ImageView) ViewBindings.a(view, i2);
                    if (imageView4 != null) {
                        i2 = R.id.ivTip;
                        ImageView imageView5 = (ImageView) ViewBindings.a(view, i2);
                        if (imageView5 != null) {
                            i2 = R.id.ll_menu;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                            if (linearLayout != null) {
                                i2 = R.id.tvMenu;
                                TextView textView = (TextView) ViewBindings.a(view, i2);
                                if (textView != null) {
                                    i2 = R.id.tvTitle;
                                    TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                    if (textView2 != null) {
                                        return new TransTitleBarLayoutBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, linearLayout, textView, textView2);
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

    public static TransTitleBarLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trans_title_bar_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6268a;
    }
}

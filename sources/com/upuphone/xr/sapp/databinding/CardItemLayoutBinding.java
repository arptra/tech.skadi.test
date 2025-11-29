package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;

public final class CardItemLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f6739a;
    public final RelativeLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final RelativeLayout f;
    public final TextView g;
    public final TextView h;
    public final Switch i;
    public final MzButton j;
    public final ImageView k;
    public final TextView l;
    public final TextView m;

    public CardItemLayoutBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout3, TextView textView, TextView textView2, Switch switchR, MzButton mzButton, ImageView imageView4, TextView textView3, TextView textView4) {
        this.f6739a = relativeLayout;
        this.b = relativeLayout2;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = relativeLayout3;
        this.g = textView;
        this.h = textView2;
        this.i = switchR;
        this.j = mzButton;
        this.k = imageView4;
        this.l = textView3;
        this.m = textView4;
    }

    public static CardItemLayoutBinding a(View view) {
        View view2 = view;
        int i2 = R.id.card_container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.a(view2, i2);
        if (relativeLayout != null) {
            i2 = R.id.card_icon;
            ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
            if (imageView != null) {
                i2 = R.id.card_right_icon;
                ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
                if (imageView2 != null) {
                    i2 = R.id.card_right_notify_icon;
                    ImageView imageView3 = (ImageView) ViewBindings.a(view2, i2);
                    if (imageView3 != null) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) view2;
                        i2 = R.id.card_sub_title;
                        TextView textView = (TextView) ViewBindings.a(view2, i2);
                        if (textView != null) {
                            i2 = R.id.card_title;
                            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                            if (textView2 != null) {
                                i2 = R.id.item_switch;
                                Switch switchR = (Switch) ViewBindings.a(view2, i2);
                                if (switchR != null) {
                                    i2 = R.id.start_icon;
                                    MzButton mzButton = (MzButton) ViewBindings.a(view2, i2);
                                    if (mzButton != null) {
                                        i2 = R.id.status;
                                        ImageView imageView4 = (ImageView) ViewBindings.a(view2, i2);
                                        if (imageView4 != null) {
                                            i2 = R.id.tv_red_tips;
                                            TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView3 != null) {
                                                i2 = R.id.tv_right_content;
                                                TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView4 != null) {
                                                    return new CardItemLayoutBinding(relativeLayout2, relativeLayout, imageView, imageView2, imageView3, relativeLayout2, textView, textView2, switchR, mzButton, imageView4, textView3, textView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f6739a;
    }
}

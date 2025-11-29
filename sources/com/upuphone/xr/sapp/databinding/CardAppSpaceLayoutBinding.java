package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class CardAppSpaceLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6735a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;

    public CardAppSpaceLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, ConstraintLayout constraintLayout2) {
        this.f6735a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = textView2;
        this.f = constraintLayout2;
    }

    public static CardAppSpaceLayoutBinding a(View view) {
        int i = R.id.card_icon;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.card_right_icon;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
            if (imageView2 != null) {
                i = R.id.card_sub_title;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    i = R.id.card_title;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.no_disturb_model;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                        if (constraintLayout != null) {
                            return new CardAppSpaceLayoutBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6735a;
    }
}

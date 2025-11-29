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
import com.meizu.common.widget.Switch;
import com.upuphone.ar.translation.phone.R;

public final class TransSettingItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6266a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final Switch e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    public TransSettingItemBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, Switch switchR, TextView textView, TextView textView2, TextView textView3) {
        this.f6266a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = linearLayout;
        this.e = switchR;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
    }

    public static TransSettingItemBinding a(View view) {
        int i = R.id.iv_setting_next;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.iv_setting_tip;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
            if (imageView2 != null) {
                i = R.id.ll_setting_content;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
                if (linearLayout != null) {
                    i = R.id.sw_setting;
                    Switch switchR = (Switch) ViewBindings.a(view, i);
                    if (switchR != null) {
                        i = R.id.tv_content;
                        TextView textView = (TextView) ViewBindings.a(view, i);
                        if (textView != null) {
                            i = R.id.tv_setting_subtitle;
                            TextView textView2 = (TextView) ViewBindings.a(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_setting_title;
                                TextView textView3 = (TextView) ViewBindings.a(view, i);
                                if (textView3 != null) {
                                    return new TransSettingItemBinding((ConstraintLayout) view, imageView, imageView2, linearLayout, switchR, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TransSettingItemBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trans_setting_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6266a;
    }
}

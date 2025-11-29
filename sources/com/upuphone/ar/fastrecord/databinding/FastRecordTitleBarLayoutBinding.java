package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordTitleBarLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5622a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;

    public FastRecordTitleBarLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.f5622a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = textView;
    }

    public static FastRecordTitleBarLayoutBinding a(View view) {
        int i = R.id.back_img;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.search_img;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
            if (imageView2 != null) {
                i = R.id.setting_img;
                ImageView imageView3 = (ImageView) ViewBindings.a(view, i);
                if (imageView3 != null) {
                    i = R.id.title;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        return new FastRecordTitleBarLayoutBinding((ConstraintLayout) view, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordTitleBarLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_title_bar_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5622a;
    }
}

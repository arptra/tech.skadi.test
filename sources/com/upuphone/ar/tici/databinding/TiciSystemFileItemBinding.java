package com.upuphone.ar.tici.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.tici.R;

public final class TiciSystemFileItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5872a;
    public final MzButton b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    public TiciSystemFileItemBinding(ConstraintLayout constraintLayout, MzButton mzButton, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f5872a = constraintLayout;
        this.b = mzButton;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
    }

    public static TiciSystemFileItemBinding a(View view) {
        int i = R.id.btn_import;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i);
        if (mzButton != null) {
            i = R.id.iv_icon;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.tv_file_date;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    i = R.id.tv_file_name;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_file_size;
                        TextView textView3 = (TextView) ViewBindings.a(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_over_size;
                            TextView textView4 = (TextView) ViewBindings.a(view, i);
                            if (textView4 != null) {
                                return new TiciSystemFileItemBinding((ConstraintLayout) view, mzButton, imageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5872a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class LayVuGlassNoUpdateBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6861a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;

    public LayVuGlassNoUpdateBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f6861a = constraintLayout;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
    }

    public static LayVuGlassNoUpdateBinding a(View view) {
        int i = R.id.iv_glass_update;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.tv_glass_is_latest_version;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.tv_glass_version;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new LayVuGlassNoUpdateBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6861a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class CustomSnackbarBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6743a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final TextView d;

    public CustomSnackbarBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView) {
        this.f6743a = linearLayout;
        this.b = linearLayout2;
        this.c = linearLayout3;
        this.d = textView;
    }

    public static CustomSnackbarBinding a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.mc_content_toast_parent;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i);
        if (linearLayout2 != null) {
            i = 16908310;
            TextView textView = (TextView) ViewBindings.a(view, 16908310);
            if (textView != null) {
                return new CustomSnackbarBinding(linearLayout, linearLayout, linearLayout2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6743a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class LayGlassNoUpdateBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6858a;
    public final TextView b;
    public final TextView c;

    public LayGlassNoUpdateBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f6858a = linearLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static LayGlassNoUpdateBinding a(View view) {
        int i = R.id.tv_glass_is_latest_version;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.tv_glass_version;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                return new LayGlassNoUpdateBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6858a;
    }
}

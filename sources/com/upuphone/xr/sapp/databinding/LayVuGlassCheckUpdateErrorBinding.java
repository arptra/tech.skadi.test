package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class LayVuGlassCheckUpdateErrorBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6860a;
    public final Button b;
    public final Button c;
    public final ImageView d;
    public final TextView e;

    public LayVuGlassCheckUpdateErrorBinding(LinearLayout linearLayout, Button button, Button button2, ImageView imageView, TextView textView) {
        this.f6860a = linearLayout;
        this.b = button;
        this.c = button2;
        this.d = imageView;
        this.e = textView;
    }

    public static LayVuGlassCheckUpdateErrorBinding a(View view) {
        int i = R.id.btn_retry;
        Button button = (Button) ViewBindings.a(view, i);
        if (button != null) {
            i = R.id.btn_setup_network;
            Button button2 = (Button) ViewBindings.a(view, i);
            if (button2 != null) {
                i = R.id.iv_network_error;
                ImageView imageView = (ImageView) ViewBindings.a(view, i);
                if (imageView != null) {
                    i = R.id.tv_error_info;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        return new LayVuGlassCheckUpdateErrorBinding((LinearLayout) view, button, button2, imageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6860a;
    }
}

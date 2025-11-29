package com.upuphone.xr.sapp.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.common.R;

public final class CommonNetErrorBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6665a;
    public final Button b;
    public final Button c;
    public final ImageView d;
    public final TextView e;

    public CommonNetErrorBinding(LinearLayout linearLayout, Button button, Button button2, ImageView imageView, TextView textView) {
        this.f6665a = linearLayout;
        this.b = button;
        this.c = button2;
        this.d = imageView;
        this.e = textView;
    }

    public static CommonNetErrorBinding a(View view) {
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
                        return new CommonNetErrorBinding((LinearLayout) view, button, button2, imageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static CommonNetErrorBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.common_net_error, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6665a;
    }
}

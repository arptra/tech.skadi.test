package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class FragmentLoginBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f6800a;
    public final TextView b;
    public final MzButton c;
    public final MzButton d;
    public final LinearLayout e;
    public final ImageView f;
    public final TextView g;

    public FragmentLoginBinding(FrameLayout frameLayout, TextView textView, MzButton mzButton, MzButton mzButton2, LinearLayout linearLayout, ImageView imageView, TextView textView2) {
        this.f6800a = frameLayout;
        this.b = textView;
        this.c = mzButton;
        this.d = mzButton2;
        this.e = linearLayout;
        this.f = imageView;
        this.g = textView2;
    }

    public static FragmentLoginBinding a(View view) {
        int i = R.id.content;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.login_cancel;
            MzButton mzButton = (MzButton) ViewBindings.a(view, i);
            if (mzButton != null) {
                i = R.id.login_confirm;
                MzButton mzButton2 = (MzButton) ViewBindings.a(view, i);
                if (mzButton2 != null) {
                    i = R.id.login_menu_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
                    if (linearLayout != null) {
                        i = R.id.main_bg_login;
                        ImageView imageView = (ImageView) ViewBindings.a(view, i);
                        if (imageView != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.a(view, i);
                            if (textView2 != null) {
                                return new FragmentLoginBinding((FrameLayout) view, textView, mzButton, mzButton2, linearLayout, imageView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f6800a;
    }
}

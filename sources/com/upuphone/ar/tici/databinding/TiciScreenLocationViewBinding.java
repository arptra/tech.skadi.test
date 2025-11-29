package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.tici.R;

public final class TiciScreenLocationViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f5869a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    public TiciScreenLocationViewBinding(View view, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f5869a = view;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
    }

    public static TiciScreenLocationViewBinding a(View view) {
        int i = R.id.btn_screen_location_bottom;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.btn_screen_location_middle;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
            if (imageView2 != null) {
                i = R.id.btn_screen_location_top;
                ImageView imageView3 = (ImageView) ViewBindings.a(view, i);
                if (imageView3 != null) {
                    i = R.id.tv_screen_location;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        i = R.id.tv_screen_location_bottom;
                        TextView textView2 = (TextView) ViewBindings.a(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_screen_location_middle;
                            TextView textView3 = (TextView) ViewBindings.a(view, i);
                            if (textView3 != null) {
                                i = R.id.tv_screen_location_top;
                                TextView textView4 = (TextView) ViewBindings.a(view, i);
                                if (textView4 != null) {
                                    return new TiciScreenLocationViewBinding(view, imageView, imageView2, imageView3, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TiciScreenLocationViewBinding b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.tici_screen_location_view, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public View getRoot() {
        return this.f5869a;
    }
}

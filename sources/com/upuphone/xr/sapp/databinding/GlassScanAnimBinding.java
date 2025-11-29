package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.xr.sapp.R;

public final class GlassScanAnimBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f6845a;
    public final LottieAnimationView b;

    public GlassScanAnimBinding(View view, LottieAnimationView lottieAnimationView) {
        this.f6845a = view;
        this.b = lottieAnimationView;
    }

    public static GlassScanAnimBinding a(View view) {
        int i = R.id.lottie_scanning;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.a(view, i);
        if (lottieAnimationView != null) {
            return new GlassScanAnimBinding(view, lottieAnimationView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static GlassScanAnimBinding b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.glass_scan_anim, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public View getRoot() {
        return this.f6845a;
    }
}

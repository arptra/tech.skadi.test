package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;

public final class FlutterAllScreenLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f6765a;
    public final FrameLayout b;

    public FlutterAllScreenLayoutBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f6765a = frameLayout;
        this.b = frameLayout2;
    }

    public static FlutterAllScreenLayoutBinding a(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new FlutterAllScreenLayoutBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }

    public static FlutterAllScreenLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.flutter_all_screen_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f6765a;
    }
}

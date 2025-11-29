package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;

public final class FragmentEmptyBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f6782a;

    public FragmentEmptyBinding(FrameLayout frameLayout) {
        this.f6782a = frameLayout;
    }

    public static FragmentEmptyBinding a(View view) {
        if (view != null) {
            return new FragmentEmptyBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static FragmentEmptyBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentEmptyBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_empty, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f6782a;
    }
}

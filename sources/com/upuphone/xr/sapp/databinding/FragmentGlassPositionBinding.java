package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentGlassPositionBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6790a;
    public final TextView b;
    public final FrameLayout c;
    public final TextView d;
    public final FrameLayout e;
    public final TextView f;
    public final ConstraintLayout g;
    public final TextView h;
    public final ConstraintLayout i;

    public FragmentGlassPositionBinding(ConstraintLayout constraintLayout, TextView textView, FrameLayout frameLayout, TextView textView2, FrameLayout frameLayout2, TextView textView3, ConstraintLayout constraintLayout2, TextView textView4, ConstraintLayout constraintLayout3) {
        this.f6790a = constraintLayout;
        this.b = textView;
        this.c = frameLayout;
        this.d = textView2;
        this.e = frameLayout2;
        this.f = textView3;
        this.g = constraintLayout2;
        this.h = textView4;
        this.i = constraintLayout3;
    }

    public static FragmentGlassPositionBinding a(View view) {
        int i2 = R.id.position_back;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.position_default;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i2);
            if (frameLayout != null) {
                i2 = R.id.position_default_desc;
                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                if (textView2 != null) {
                    i2 = R.id.position_low;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.a(view, i2);
                    if (frameLayout2 != null) {
                        i2 = R.id.position_low_desc;
                        TextView textView3 = (TextView) ViewBindings.a(view, i2);
                        if (textView3 != null) {
                            i2 = R.id.position_select;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                            if (constraintLayout != null) {
                                i2 = R.id.position_tips;
                                TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                if (textView4 != null) {
                                    i2 = R.id.rootView;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                                    if (constraintLayout2 != null) {
                                        return new FragmentGlassPositionBinding((ConstraintLayout) view, textView, frameLayout, textView2, frameLayout2, textView3, constraintLayout, textView4, constraintLayout2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentGlassPositionBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_glass_position, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6790a;
    }
}

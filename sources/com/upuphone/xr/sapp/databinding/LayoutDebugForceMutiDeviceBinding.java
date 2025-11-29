package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class LayoutDebugForceMutiDeviceBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6866a;
    public final MzButton b;
    public final TextView c;
    public final TextView d;

    public LayoutDebugForceMutiDeviceBinding(ConstraintLayout constraintLayout, MzButton mzButton, TextView textView, TextView textView2) {
        this.f6866a = constraintLayout;
        this.b = mzButton;
        this.c = textView;
        this.d = textView2;
    }

    public static LayoutDebugForceMutiDeviceBinding a(View view) {
        int i = R.id.btn_force_multi_device;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i);
        if (mzButton != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.tv_is_open;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new LayoutDebugForceMutiDeviceBinding((ConstraintLayout) view, mzButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6866a;
    }
}

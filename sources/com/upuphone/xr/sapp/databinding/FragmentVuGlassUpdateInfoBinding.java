package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentVuGlassUpdateInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6835a;
    public final LayVuGlassCheckUpdateErrorBinding b;
    public final LayVuGlassNoUpdateBinding c;
    public final LayVuGlassUpdateInfoBinding d;
    public final TextView e;

    public FragmentVuGlassUpdateInfoBinding(ConstraintLayout constraintLayout, LayVuGlassCheckUpdateErrorBinding layVuGlassCheckUpdateErrorBinding, LayVuGlassNoUpdateBinding layVuGlassNoUpdateBinding, LayVuGlassUpdateInfoBinding layVuGlassUpdateInfoBinding, TextView textView) {
        this.f6835a = constraintLayout;
        this.b = layVuGlassCheckUpdateErrorBinding;
        this.c = layVuGlassNoUpdateBinding;
        this.d = layVuGlassUpdateInfoBinding;
        this.e = textView;
    }

    public static FragmentVuGlassUpdateInfoBinding a(View view) {
        int i = R.id.lay_glass_check_update_error;
        View a2 = ViewBindings.a(view, i);
        if (a2 != null) {
            LayVuGlassCheckUpdateErrorBinding a3 = LayVuGlassCheckUpdateErrorBinding.a(a2);
            i = R.id.lay_glass_no_update;
            View a4 = ViewBindings.a(view, i);
            if (a4 != null) {
                LayVuGlassNoUpdateBinding a5 = LayVuGlassNoUpdateBinding.a(a4);
                i = R.id.lay_glass_update_info;
                View a6 = ViewBindings.a(view, i);
                if (a6 != null) {
                    LayVuGlassUpdateInfoBinding a7 = LayVuGlassUpdateInfoBinding.a(a6);
                    i = R.id.setting_back_title;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        return new FragmentVuGlassUpdateInfoBinding((ConstraintLayout) view, a3, a5, a7, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentVuGlassUpdateInfoBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vu_glass_update_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6835a;
    }
}

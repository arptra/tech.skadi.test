package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentVuGlassPolicyBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6834a;
    public final TextView b;
    public final ConstraintLayout c;
    public final TextView d;

    public FragmentVuGlassPolicyBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2) {
        this.f6834a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = textView2;
    }

    public static FragmentVuGlassPolicyBinding a(View view) {
        int i = R.id.glass_info_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.glass_info_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
            if (constraintLayout != null) {
                i = R.id.glass_service_protocol;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new FragmentVuGlassPolicyBinding((ConstraintLayout) view, textView, constraintLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentVuGlassPolicyBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_vu_glass_policy, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6834a;
    }
}

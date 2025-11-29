package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentGlassPolicyBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6789a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final TextView g;
    public final TextView h;

    public FragmentGlassPolicyBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, TextView textView5, TextView textView6) {
        this.f6789a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = constraintLayout2;
        this.g = textView5;
        this.h = textView6;
    }

    public static FragmentGlassPolicyBinding a(View view) {
        int i = R.id.about_children_info_protect;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.account_personal_info_list;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                i = R.id.account_third_share_list;
                TextView textView3 = (TextView) ViewBindings.a(view, i);
                if (textView3 != null) {
                    i = R.id.glass_info_back;
                    TextView textView4 = (TextView) ViewBindings.a(view, i);
                    if (textView4 != null) {
                        i = R.id.glass_info_layout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                        if (constraintLayout != null) {
                            i = R.id.glass_service_protocol;
                            TextView textView5 = (TextView) ViewBindings.a(view, i);
                            if (textView5 != null) {
                                i = R.id.superapp_privacy_policy;
                                TextView textView6 = (TextView) ViewBindings.a(view, i);
                                if (textView6 != null) {
                                    return new FragmentGlassPolicyBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, constraintLayout, textView5, textView6);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentGlassPolicyBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_glass_policy, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6789a;
    }
}

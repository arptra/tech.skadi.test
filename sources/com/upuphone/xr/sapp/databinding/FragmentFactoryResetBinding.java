package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentFactoryResetBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6783a;
    public final TextView b;
    public final ConstraintLayout c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;

    public FragmentFactoryResetBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3) {
        this.f6783a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = textView2;
        this.e = textView3;
        this.f = constraintLayout3;
    }

    public static FragmentFactoryResetBinding a(View view) {
        int i = R.id.factory_reset_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.factory_reset_item;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
            if (constraintLayout != null) {
                i = R.id.factory_reset_sub_title;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    i = R.id.factory_reset_title;
                    TextView textView3 = (TextView) ViewBindings.a(view, i);
                    if (textView3 != null) {
                        i = R.id.rootView;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i);
                        if (constraintLayout2 != null) {
                            return new FragmentFactoryResetBinding((ConstraintLayout) view, textView, constraintLayout, textView2, textView3, constraintLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentFactoryResetBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_factory_reset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6783a;
    }
}

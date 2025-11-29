package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;

public final class FragmentGlassStabilizationBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6792a;
    public final TextView b;
    public final CardItemView c;
    public final CardItemView d;
    public final ConstraintLayout e;

    public FragmentGlassStabilizationBinding(ConstraintLayout constraintLayout, TextView textView, CardItemView cardItemView, CardItemView cardItemView2, ConstraintLayout constraintLayout2) {
        this.f6792a = constraintLayout;
        this.b = textView;
        this.c = cardItemView;
        this.d = cardItemView2;
        this.e = constraintLayout2;
    }

    public static FragmentGlassStabilizationBinding a(View view) {
        int i = R.id.page_stabilization_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.page_stabilization_globle;
            CardItemView cardItemView = (CardItemView) ViewBindings.a(view, i);
            if (cardItemView != null) {
                i = R.id.page_stabilization_nav;
                CardItemView cardItemView2 = (CardItemView) ViewBindings.a(view, i);
                if (cardItemView2 != null) {
                    i = R.id.rootView;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                    if (constraintLayout != null) {
                        return new FragmentGlassStabilizationBinding((ConstraintLayout) view, textView, cardItemView, cardItemView2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentGlassStabilizationBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_glass_stabilization, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6792a;
    }
}

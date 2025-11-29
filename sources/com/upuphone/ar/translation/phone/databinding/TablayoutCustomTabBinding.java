package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.translation.phone.R;

public final class TablayoutCustomTabBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6261a;
    public final TextView b;

    public TablayoutCustomTabBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.f6261a = constraintLayout;
        this.b = textView;
    }

    public static TablayoutCustomTabBinding a(View view) {
        int i = R.id.tv_tab;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new TablayoutCustomTabBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TablayoutCustomTabBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static TablayoutCustomTabBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.tablayout_custom_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6261a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzImageView;
import com.upuphone.xr.sapp.R;

public final class ItemModelBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6852a;
    public final ConstraintLayout b;
    public final MzImageView c;
    public final TextView d;
    public final TextView e;

    public ItemModelBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, MzImageView mzImageView, TextView textView, TextView textView2) {
        this.f6852a = constraintLayout;
        this.b = constraintLayout2;
        this.c = mzImageView;
        this.d = textView;
        this.e = textView2;
    }

    public static ItemModelBinding a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.model_logo;
        MzImageView mzImageView = (MzImageView) ViewBindings.a(view, i);
        if (mzImageView != null) {
            i = R.id.model_name;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.tv_red_tips;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new ItemModelBinding(constraintLayout, constraintLayout, mzImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemModelBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_model, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6852a;
    }
}

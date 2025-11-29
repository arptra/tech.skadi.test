package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class ItemLanguageCellBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6850a;
    public final ConstraintLayout b;
    public final AppCompatImageView c;
    public final TextView d;

    public ItemLanguageCellBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, TextView textView) {
        this.f6850a = constraintLayout;
        this.b = constraintLayout2;
        this.c = appCompatImageView;
        this.d = textView;
    }

    public static ItemLanguageCellBinding a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.language_select_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, i);
        if (appCompatImageView != null) {
            i = R.id.language_txt;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                return new ItemLanguageCellBinding(constraintLayout, constraintLayout, appCompatImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemLanguageCellBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_language_cell, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6850a;
    }
}

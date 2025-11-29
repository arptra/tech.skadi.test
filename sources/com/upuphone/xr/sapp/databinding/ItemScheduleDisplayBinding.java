package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.SmoothCornerView;
import com.upuphone.xr.sapp.R;

public final class ItemScheduleDisplayBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6853a;
    public final AppCompatTextView b;
    public final SmoothCornerView c;
    public final AppCompatImageView d;

    public ItemScheduleDisplayBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, SmoothCornerView smoothCornerView, AppCompatImageView appCompatImageView) {
        this.f6853a = constraintLayout;
        this.b = appCompatTextView;
        this.c = smoothCornerView;
        this.d = appCompatImageView;
    }

    public static ItemScheduleDisplayBinding a(View view) {
        int i = R.id.schedule_display_content;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view, i);
        if (appCompatTextView != null) {
            i = R.id.schedule_display_dot;
            SmoothCornerView smoothCornerView = (SmoothCornerView) ViewBindings.a(view, i);
            if (smoothCornerView != null) {
                i = R.id.schedule_display_select;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, i);
                if (appCompatImageView != null) {
                    return new ItemScheduleDisplayBinding((ConstraintLayout) view, appCompatTextView, smoothCornerView, appCompatImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemScheduleDisplayBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_schedule_display, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6853a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import flyme.support.v7.widget.MzRecyclerView;

public final class FragmentScheduleDisplayBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6814a;
    public final AppCompatImageView b;
    public final ImageView c;
    public final TextView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final AppCompatTextView g;
    public final MzRecyclerView h;
    public final ConstraintLayout i;
    public final TextView j;

    public FragmentScheduleDisplayBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, AppCompatTextView appCompatTextView, MzRecyclerView mzRecyclerView, ConstraintLayout constraintLayout3, TextView textView3) {
        this.f6814a = constraintLayout;
        this.b = appCompatImageView;
        this.c = imageView;
        this.d = textView;
        this.e = constraintLayout2;
        this.f = textView2;
        this.g = appCompatTextView;
        this.h = mzRecyclerView;
        this.i = constraintLayout3;
        this.j = textView3;
    }

    public static FragmentScheduleDisplayBinding a(View view) {
        int i2 = R.id.schedule_display_add;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, i2);
        if (appCompatImageView != null) {
            i2 = R.id.schedule_display_arrow_right;
            ImageView imageView = (ImageView) ViewBindings.a(view, i2);
            if (imageView != null) {
                i2 = R.id.schedule_display_back;
                TextView textView = (TextView) ViewBindings.a(view, i2);
                if (textView != null) {
                    i2 = R.id.schedule_display_back_lay;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                    if (constraintLayout != null) {
                        i2 = R.id.schedule_display_content;
                        TextView textView2 = (TextView) ViewBindings.a(view, i2);
                        if (textView2 != null) {
                            i2 = R.id.schedule_display_desc;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view, i2);
                            if (appCompatTextView != null) {
                                i2 = R.id.schedule_display_rv;
                                MzRecyclerView mzRecyclerView = (MzRecyclerView) ViewBindings.a(view, i2);
                                if (mzRecyclerView != null) {
                                    i2 = R.id.schedule_display_time;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view, i2);
                                    if (constraintLayout2 != null) {
                                        i2 = R.id.schedule_display_title;
                                        TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                        if (textView3 != null) {
                                            return new FragmentScheduleDisplayBinding((ConstraintLayout) view, appCompatImageView, imageView, textView, constraintLayout, textView2, appCompatTextView, mzRecyclerView, constraintLayout2, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentScheduleDisplayBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_schedule_display, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6814a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentReminderPermissionSteerBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6812a;
    public final TextView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final TextView e;

    public FragmentReminderPermissionSteerBinding(ConstraintLayout constraintLayout, TextView textView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, TextView textView2) {
        this.f6812a = constraintLayout;
        this.b = textView;
        this.c = appCompatImageView;
        this.d = appCompatTextView;
        this.e = textView2;
    }

    public static FragmentReminderPermissionSteerBinding a(View view) {
        int i = R.id.reminder_permission_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.reminder_permission_bg;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, i);
            if (appCompatImageView != null) {
                i = R.id.reminder_permission_hint_title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view, i);
                if (appCompatTextView != null) {
                    i = R.id.reminder_permission_open;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        return new FragmentReminderPermissionSteerBinding((ConstraintLayout) view, textView, appCompatImageView, appCompatTextView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentReminderPermissionSteerBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentReminderPermissionSteerBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_reminder_permission_steer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6812a;
    }
}

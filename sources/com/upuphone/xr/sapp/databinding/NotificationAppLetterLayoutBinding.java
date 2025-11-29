package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class NotificationAppLetterLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f6886a;
    public final TextView b;

    public NotificationAppLetterLayoutBinding(FrameLayout frameLayout, TextView textView) {
        this.f6886a = frameLayout;
        this.b = textView;
    }

    public static NotificationAppLetterLayoutBinding a(View view) {
        int i = R.id.main_title;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new NotificationAppLetterLayoutBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationAppLetterLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_app_letter_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f6886a;
    }
}

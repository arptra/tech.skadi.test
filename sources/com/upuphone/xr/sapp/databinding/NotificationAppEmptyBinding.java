package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class NotificationAppEmptyBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6884a;
    public final TextView b;

    public NotificationAppEmptyBinding(LinearLayout linearLayout, TextView textView) {
        this.f6884a = linearLayout;
        this.b = textView;
    }

    public static NotificationAppEmptyBinding a(View view) {
        int i = R.id.list_empty;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new NotificationAppEmptyBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationAppEmptyBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static NotificationAppEmptyBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_app_empty, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6884a;
    }
}

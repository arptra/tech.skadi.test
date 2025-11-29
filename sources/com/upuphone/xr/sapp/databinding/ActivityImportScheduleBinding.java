package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class ActivityImportScheduleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6723a;
    public final TextView b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final ConstraintLayout e;

    public ActivityImportScheduleBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout2) {
        this.f6723a = constraintLayout;
        this.b = textView;
        this.c = linearLayout;
        this.d = linearLayout2;
        this.e = constraintLayout2;
    }

    public static ActivityImportScheduleBinding a(View view) {
        int i = R.id.import_schedule_back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.import_schedule_dd;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
            if (linearLayout != null) {
                i = R.id.import_schedule_fs;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i);
                if (linearLayout2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new ActivityImportScheduleBinding(constraintLayout, textView, linearLayout, linearLayout2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityImportScheduleBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityImportScheduleBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_import_schedule, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6723a;
    }
}

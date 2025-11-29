package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.RingView;

public final class ItemEditScheduleColorBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6849a;
    public final RingView b;

    public ItemEditScheduleColorBinding(ConstraintLayout constraintLayout, RingView ringView) {
        this.f6849a = constraintLayout;
        this.b = ringView;
    }

    public static ItemEditScheduleColorBinding a(View view) {
        int i = R.id.schedule_ring_view;
        RingView ringView = (RingView) ViewBindings.a(view, i);
        if (ringView != null) {
            return new ItemEditScheduleColorBinding((ConstraintLayout) view, ringView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemEditScheduleColorBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_edit_schedule_color, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6849a;
    }
}

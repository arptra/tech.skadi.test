package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class RecyclerItemStandbyComponentBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6895a;
    public final CheckBox b;
    public final TextView c;

    public RecyclerItemStandbyComponentBinding(ConstraintLayout constraintLayout, CheckBox checkBox, TextView textView) {
        this.f6895a = constraintLayout;
        this.b = checkBox;
        this.c = textView;
    }

    public static RecyclerItemStandbyComponentBinding a(View view) {
        int i = R.id.checkBox;
        CheckBox checkBox = (CheckBox) ViewBindings.a(view, i);
        if (checkBox != null) {
            i = R.id.text;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                return new RecyclerItemStandbyComponentBinding((ConstraintLayout) view, checkBox, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static RecyclerItemStandbyComponentBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.recycler_item_standby_component, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6895a;
    }
}

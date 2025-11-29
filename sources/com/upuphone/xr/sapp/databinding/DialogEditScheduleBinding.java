package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.DrawableEditText;
import flyme.support.v7.widget.MzRecyclerView;

public final class DialogEditScheduleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6753a;
    public final DrawableEditText b;
    public final MzRecyclerView c;

    public DialogEditScheduleBinding(LinearLayout linearLayout, DrawableEditText drawableEditText, MzRecyclerView mzRecyclerView) {
        this.f6753a = linearLayout;
        this.b = drawableEditText;
        this.c = mzRecyclerView;
    }

    public static DialogEditScheduleBinding a(View view) {
        int i = R.id.edit_input;
        DrawableEditText drawableEditText = (DrawableEditText) ViewBindings.a(view, i);
        if (drawableEditText != null) {
            i = R.id.edit_schedule_rv;
            MzRecyclerView mzRecyclerView = (MzRecyclerView) ViewBindings.a(view, i);
            if (mzRecyclerView != null) {
                return new DialogEditScheduleBinding((LinearLayout) view, drawableEditText, mzRecyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogEditScheduleBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogEditScheduleBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_edit_schedule, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6753a;
    }
}

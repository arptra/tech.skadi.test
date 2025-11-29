package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class BottomSheetStandbyComponentBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6734a;
    public final TextView b;
    public final RecyclerView c;
    public final TextView d;

    public BottomSheetStandbyComponentBinding(ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, TextView textView2) {
        this.f6734a = constraintLayout;
        this.b = textView;
        this.c = recyclerView;
        this.d = textView2;
    }

    public static BottomSheetStandbyComponentBinding a(View view) {
        int i = R.id.btn_confirm;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.recyclerview;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i);
            if (recyclerView != null) {
                i = R.id.text_component;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new BottomSheetStandbyComponentBinding((ConstraintLayout) view, textView, recyclerView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BottomSheetStandbyComponentBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static BottomSheetStandbyComponentBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_standby_component, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6734a;
    }
}

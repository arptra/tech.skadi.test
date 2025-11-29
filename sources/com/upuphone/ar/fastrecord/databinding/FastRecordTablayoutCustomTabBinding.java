package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordTablayoutCustomTabBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5618a;
    public final TextView b;

    public FastRecordTablayoutCustomTabBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.f5618a = constraintLayout;
        this.b = textView;
    }

    public static FastRecordTablayoutCustomTabBinding a(View view) {
        int i = R.id.tv_tab;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            return new FastRecordTablayoutCustomTabBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordTablayoutCustomTabBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordTablayoutCustomTabBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_tablayout_custom_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5618a;
    }
}

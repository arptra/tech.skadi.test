package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText;

public final class FastRecordSearchActivityBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5610a;
    public final ConstraintLayout b;
    public final FastRecordDrawableEditText c;
    public final LinearLayout d;
    public final LinearLayout e;
    public final RecyclerView f;
    public final TextView g;

    public FastRecordSearchActivityBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FastRecordDrawableEditText fastRecordDrawableEditText, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView) {
        this.f5610a = constraintLayout;
        this.b = constraintLayout2;
        this.c = fastRecordDrawableEditText;
        this.d = linearLayout;
        this.e = linearLayout2;
        this.f = recyclerView;
        this.g = textView;
    }

    public static FastRecordSearchActivityBinding a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.edt_search;
        FastRecordDrawableEditText fastRecordDrawableEditText = (FastRecordDrawableEditText) ViewBindings.a(view, i);
        if (fastRecordDrawableEditText != null) {
            i = R.id.ll_empty;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
            if (linearLayout != null) {
                i = R.id.ll_input_search;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i);
                if (linearLayout2 != null) {
                    i = R.id.rec_record;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i);
                    if (recyclerView != null) {
                        i = R.id.tv_cancel;
                        TextView textView = (TextView) ViewBindings.a(view, i);
                        if (textView != null) {
                            return new FastRecordSearchActivityBinding(constraintLayout, constraintLayout, fastRecordDrawableEditText, linearLayout, linearLayout2, recyclerView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordSearchActivityBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordSearchActivityBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_search_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5610a;
    }
}

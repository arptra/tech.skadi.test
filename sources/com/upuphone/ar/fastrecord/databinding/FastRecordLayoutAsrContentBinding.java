package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordLayoutAsrContentBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f5603a;
    public final ScrollView b;
    public final AppCompatTextView c;

    public FastRecordLayoutAsrContentBinding(LinearLayout linearLayout, ScrollView scrollView, AppCompatTextView appCompatTextView) {
        this.f5603a = linearLayout;
        this.b = scrollView;
        this.c = appCompatTextView;
    }

    public static FastRecordLayoutAsrContentBinding a(View view) {
        int i = R.id.sv;
        ScrollView scrollView = (ScrollView) ViewBindings.a(view, i);
        if (scrollView != null) {
            i = R.id.tv;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view, i);
            if (appCompatTextView != null) {
                return new FastRecordLayoutAsrContentBinding((LinearLayout) view, scrollView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordLayoutAsrContentBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_layout_asr_content, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f5603a;
    }
}

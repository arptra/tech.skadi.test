package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;

public final class ActivityNewTiciFileBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5856a;
    public final EditText b;
    public final EditText c;
    public final ScrollView d;
    public final TiciTitleBar e;

    public ActivityNewTiciFileBinding(ConstraintLayout constraintLayout, EditText editText, EditText editText2, ScrollView scrollView, TiciTitleBar ticiTitleBar) {
        this.f5856a = constraintLayout;
        this.b = editText;
        this.c = editText2;
        this.d = scrollView;
        this.e = ticiTitleBar;
    }

    public static ActivityNewTiciFileBinding a(View view) {
        int i = R.id.et_content;
        EditText editText = (EditText) ViewBindings.a(view, i);
        if (editText != null) {
            i = R.id.et_title;
            EditText editText2 = (EditText) ViewBindings.a(view, i);
            if (editText2 != null) {
                i = R.id.lay_scroll;
                ScrollView scrollView = (ScrollView) ViewBindings.a(view, i);
                if (scrollView != null) {
                    i = R.id.title_bar;
                    TiciTitleBar ticiTitleBar = (TiciTitleBar) ViewBindings.a(view, i);
                    if (ticiTitleBar != null) {
                        return new ActivityNewTiciFileBinding((ConstraintLayout) view, editText, editText2, scrollView, ticiTitleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityNewTiciFileBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityNewTiciFileBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_new_tici_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5856a;
    }
}

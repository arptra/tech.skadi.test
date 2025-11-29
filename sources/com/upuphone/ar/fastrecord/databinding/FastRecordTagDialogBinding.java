package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordTagDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5620a;
    public final FastRecordTagPersonLayoutBinding b;
    public final FastRecordTagContentLayoutBinding c;
    public final ScrollView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    public FastRecordTagDialogBinding(ConstraintLayout constraintLayout, FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding, FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3) {
        this.f5620a = constraintLayout;
        this.b = fastRecordTagPersonLayoutBinding;
        this.c = fastRecordTagContentLayoutBinding;
        this.d = scrollView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    public static FastRecordTagDialogBinding a(View view) {
        int i = R.id.ll_person_content_container;
        View a2 = ViewBindings.a(view, i);
        if (a2 != null) {
            FastRecordTagPersonLayoutBinding a3 = FastRecordTagPersonLayoutBinding.a(a2);
            i = R.id.ll_tag_content_container;
            View a4 = ViewBindings.a(view, i);
            if (a4 != null) {
                FastRecordTagContentLayoutBinding a5 = FastRecordTagContentLayoutBinding.a(a4);
                i = R.id.scl_content;
                ScrollView scrollView = (ScrollView) ViewBindings.a(view, i);
                if (scrollView != null) {
                    i = R.id.tv_cancel;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        i = R.id.tv_ok;
                        TextView textView2 = (TextView) ViewBindings.a(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_title;
                            TextView textView3 = (TextView) ViewBindings.a(view, i);
                            if (textView3 != null) {
                                return new FastRecordTagDialogBinding((ConstraintLayout) view, a3, a5, scrollView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordTagDialogBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordTagDialogBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_tag_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5620a;
    }
}

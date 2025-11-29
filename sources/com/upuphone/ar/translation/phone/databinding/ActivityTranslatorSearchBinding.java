package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.translation.phone.R;

public final class ActivityTranslatorSearchBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6240a;
    public final ConstraintLayout b;
    public final EditText c;
    public final Group d;
    public final ImageView e;
    public final RecyclerView f;
    public final TextView g;
    public final TextView h;

    public ActivityTranslatorSearchBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, EditText editText, Group group, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f6240a = constraintLayout;
        this.b = constraintLayout2;
        this.c = editText;
        this.d = group;
        this.e = imageView;
        this.f = recyclerView;
        this.g = textView;
        this.h = textView2;
    }

    public static ActivityTranslatorSearchBinding a(View view) {
        int i = R.id.cl_title;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
        if (constraintLayout != null) {
            i = R.id.et_search;
            EditText editText = (EditText) ViewBindings.a(view, i);
            if (editText != null) {
                i = R.id.gp_no_data;
                Group group = (Group) ViewBindings.a(view, i);
                if (group != null) {
                    i = R.id.iv_empty_search;
                    ImageView imageView = (ImageView) ViewBindings.a(view, i);
                    if (imageView != null) {
                        i = R.id.rv_records;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i);
                        if (recyclerView != null) {
                            i = R.id.tv_empty_search;
                            TextView textView = (TextView) ViewBindings.a(view, i);
                            if (textView != null) {
                                i = R.id.tv_finish;
                                TextView textView2 = (TextView) ViewBindings.a(view, i);
                                if (textView2 != null) {
                                    return new ActivityTranslatorSearchBinding((ConstraintLayout) view, constraintLayout, editText, group, imageView, recyclerView, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityTranslatorSearchBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranslatorSearchBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_translator_search, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6240a;
    }
}

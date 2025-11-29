package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;
import com.upuphone.ar.translation.phone.view.TransTitleBar;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;

public final class ActivityTranslatorRecordBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6239a;
    public final ConstraintLayout b;
    public final ClipboardEditText c;
    public final ClipboardEditText d;
    public final TranslatorLoadingView e;
    public final ScrollView f;
    public final NestedScrollView g;
    public final RecyclerView h;
    public final TransTitleBar i;
    public final TextView j;

    public ActivityTranslatorRecordBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ClipboardEditText clipboardEditText, ClipboardEditText clipboardEditText2, TranslatorLoadingView translatorLoadingView, ScrollView scrollView, NestedScrollView nestedScrollView, RecyclerView recyclerView, TransTitleBar transTitleBar, TextView textView) {
        this.f6239a = constraintLayout;
        this.b = constraintLayout2;
        this.c = clipboardEditText;
        this.d = clipboardEditText2;
        this.e = translatorLoadingView;
        this.f = scrollView;
        this.g = nestedScrollView;
        this.h = recyclerView;
        this.i = transTitleBar;
        this.j = textView;
    }

    public static ActivityTranslatorRecordBinding a(View view) {
        int i2 = R.id.cl_text;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
        if (constraintLayout != null) {
            i2 = R.id.et_record;
            ClipboardEditText clipboardEditText = (ClipboardEditText) ViewBindings.a(view, i2);
            if (clipboardEditText != null) {
                i2 = R.id.et_record_title;
                ClipboardEditText clipboardEditText2 = (ClipboardEditText) ViewBindings.a(view, i2);
                if (clipboardEditText2 != null) {
                    i2 = R.id.loading_view;
                    TranslatorLoadingView translatorLoadingView = (TranslatorLoadingView) ViewBindings.a(view, i2);
                    if (translatorLoadingView != null) {
                        i2 = R.id.nsv_content;
                        ScrollView scrollView = (ScrollView) ViewBindings.a(view, i2);
                        if (scrollView != null) {
                            i2 = R.id.nsv_list;
                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i2);
                            if (nestedScrollView != null) {
                                i2 = R.id.recycler_view;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i2);
                                if (recyclerView != null) {
                                    i2 = R.id.title_bar;
                                    TransTitleBar transTitleBar = (TransTitleBar) ViewBindings.a(view, i2);
                                    if (transTitleBar != null) {
                                        i2 = R.id.tv_record_subtitle;
                                        TextView textView = (TextView) ViewBindings.a(view, i2);
                                        if (textView != null) {
                                            return new ActivityTranslatorRecordBinding((ConstraintLayout) view, constraintLayout, clipboardEditText, clipboardEditText2, translatorLoadingView, scrollView, nestedScrollView, recyclerView, transTitleBar, textView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static ActivityTranslatorRecordBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranslatorRecordBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_translator_record, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6239a;
    }
}

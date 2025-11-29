package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;

public final class FragmentSummaryBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6246a;
    public final ConstraintLayout b;
    public final ClipboardEditText c;
    public final Group d;
    public final ImageView e;
    public final TranslatorLoadingView f;
    public final MzButton g;
    public final ScrollView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;

    public FragmentSummaryBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ClipboardEditText clipboardEditText, Group group, ImageView imageView, TranslatorLoadingView translatorLoadingView, MzButton mzButton, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.f6246a = constraintLayout;
        this.b = constraintLayout2;
        this.c = clipboardEditText;
        this.d = group;
        this.e = imageView;
        this.f = translatorLoadingView;
        this.g = mzButton;
        this.h = scrollView;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = textView5;
        this.n = textView6;
    }

    public static FragmentSummaryBinding a(View view) {
        View view2 = view;
        int i2 = R.id.cl_summary;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
        if (constraintLayout != null) {
            i2 = R.id.et_summary;
            ClipboardEditText clipboardEditText = (ClipboardEditText) ViewBindings.a(view2, i2);
            if (clipboardEditText != null) {
                i2 = R.id.gp_summary_tip;
                Group group = (Group) ViewBindings.a(view2, i2);
                if (group != null) {
                    i2 = R.id.iv_summary_bg;
                    ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
                    if (imageView != null) {
                        i2 = R.id.loading_view;
                        TranslatorLoadingView translatorLoadingView = (TranslatorLoadingView) ViewBindings.a(view2, i2);
                        if (translatorLoadingView != null) {
                            i2 = R.id.mbt_summary;
                            MzButton mzButton = (MzButton) ViewBindings.a(view2, i2);
                            if (mzButton != null) {
                                i2 = R.id.sv_summary;
                                ScrollView scrollView = (ScrollView) ViewBindings.a(view2, i2);
                                if (scrollView != null) {
                                    i2 = R.id.tv_inner_ai_mark;
                                    TextView textView = (TextView) ViewBindings.a(view2, i2);
                                    if (textView != null) {
                                        i2 = R.id.tv_inner_reported;
                                        TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView2 != null) {
                                            i2 = R.id.tv_loading_background;
                                            TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView3 != null) {
                                                i2 = R.id.tv_outer_ai_mark;
                                                TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView4 != null) {
                                                    i2 = R.id.tv_outer_reported;
                                                    TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView5 != null) {
                                                        i2 = R.id.tv_summary_tip;
                                                        TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView6 != null) {
                                                            return new FragmentSummaryBinding((ConstraintLayout) view2, constraintLayout, clipboardEditText, group, imageView, translatorLoadingView, mzButton, scrollView, textView, textView2, textView3, textView4, textView5, textView6);
                                                        }
                                                    }
                                                }
                                            }
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

    public static FragmentSummaryBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSummaryBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_summary, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6246a;
    }
}

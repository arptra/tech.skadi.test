package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import com.upuphone.ar.transcribe.phone.view.TransLoadingView;

public final class FragmentTranscribeSummaryBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6038a;
    public final ClipboardEditText b;
    public final Group c;
    public final Group d;
    public final ImageView e;
    public final ImageView f;
    public final LinearLayout g;
    public final TransLoadingView h;
    public final MzButton i;
    public final ScrollView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;

    public FragmentTranscribeSummaryBinding(ConstraintLayout constraintLayout, ClipboardEditText clipboardEditText, Group group, Group group2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TransLoadingView transLoadingView, MzButton mzButton, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3) {
        this.f6038a = constraintLayout;
        this.b = clipboardEditText;
        this.c = group;
        this.d = group2;
        this.e = imageView;
        this.f = imageView2;
        this.g = linearLayout;
        this.h = transLoadingView;
        this.i = mzButton;
        this.j = scrollView;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
    }

    public static FragmentTranscribeSummaryBinding a(View view) {
        View view2 = view;
        int i2 = R.id.et_summary;
        ClipboardEditText clipboardEditText = (ClipboardEditText) ViewBindings.a(view2, i2);
        if (clipboardEditText != null) {
            i2 = R.id.gp_loading;
            Group group = (Group) ViewBindings.a(view2, i2);
            if (group != null) {
                i2 = R.id.gp_summary_tip;
                Group group2 = (Group) ViewBindings.a(view2, i2);
                if (group2 != null) {
                    i2 = R.id.iv_feedback;
                    ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
                    if (imageView != null) {
                        i2 = R.id.iv_summary_bg;
                        ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
                        if (imageView2 != null) {
                            i2 = R.id.ll_summary;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                            if (linearLayout != null) {
                                i2 = R.id.loading_view;
                                TransLoadingView transLoadingView = (TransLoadingView) ViewBindings.a(view2, i2);
                                if (transLoadingView != null) {
                                    i2 = R.id.mbt_summary;
                                    MzButton mzButton = (MzButton) ViewBindings.a(view2, i2);
                                    if (mzButton != null) {
                                        i2 = R.id.sv_summary;
                                        ScrollView scrollView = (ScrollView) ViewBindings.a(view2, i2);
                                        if (scrollView != null) {
                                            i2 = R.id.tv_feedback;
                                            TextView textView = (TextView) ViewBindings.a(view2, i2);
                                            if (textView != null) {
                                                i2 = R.id.tv_loading_tips;
                                                TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView2 != null) {
                                                    i2 = R.id.tv_summary_tip;
                                                    TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView3 != null) {
                                                        return new FragmentTranscribeSummaryBinding((ConstraintLayout) view2, clipboardEditText, group, group2, imageView, imageView2, linearLayout, transLoadingView, mzButton, scrollView, textView, textView2, textView3);
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

    public static FragmentTranscribeSummaryBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentTranscribeSummaryBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_transcribe_summary, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6038a;
    }
}

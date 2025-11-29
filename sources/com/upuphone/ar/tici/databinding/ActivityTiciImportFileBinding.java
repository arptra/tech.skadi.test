package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.widget.BubbleWidget;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;

public final class ActivityTiciImportFileBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5858a;
    public final MzButton b;
    public final RecyclerView c;
    public final ImageView d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final ConstraintLayout g;
    public final ProgressBar h;
    public final BubbleWidget i;
    public final TiciTitleBar j;
    public final TextView k;
    public final TextView l;

    public ActivityTiciImportFileBinding(ConstraintLayout constraintLayout, MzButton mzButton, RecyclerView recyclerView, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, ProgressBar progressBar, BubbleWidget bubbleWidget, TiciTitleBar ticiTitleBar, TextView textView, TextView textView2) {
        this.f5858a = constraintLayout;
        this.b = mzButton;
        this.c = recyclerView;
        this.d = imageView;
        this.e = linearLayout;
        this.f = linearLayout2;
        this.g = constraintLayout2;
        this.h = progressBar;
        this.i = bubbleWidget;
        this.j = ticiTitleBar;
        this.k = textView;
        this.l = textView2;
    }

    public static ActivityTiciImportFileBinding a(View view) {
        int i2 = R.id.btn_open_permission;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i2);
        if (mzButton != null) {
            i2 = R.id.files_recyclerview;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i2);
            if (recyclerView != null) {
                i2 = R.id.iv_no_permission;
                ImageView imageView = (ImageView) ViewBindings.a(view, i2);
                if (imageView != null) {
                    i2 = R.id.lay_empty_file;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                    if (linearLayout != null) {
                        i2 = R.id.lay_loading;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i2);
                        if (linearLayout2 != null) {
                            i2 = R.id.lay_permission_tips;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i2);
                            if (constraintLayout != null) {
                                i2 = R.id.pb_loading;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, i2);
                                if (progressBar != null) {
                                    i2 = R.id.tip_widget;
                                    BubbleWidget bubbleWidget = (BubbleWidget) ViewBindings.a(view, i2);
                                    if (bubbleWidget != null) {
                                        i2 = R.id.title_bar;
                                        TiciTitleBar ticiTitleBar = (TiciTitleBar) ViewBindings.a(view, i2);
                                        if (ticiTitleBar != null) {
                                            i2 = R.id.tv_loading_file;
                                            TextView textView = (TextView) ViewBindings.a(view, i2);
                                            if (textView != null) {
                                                i2 = R.id.tv_open_permission;
                                                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                                if (textView2 != null) {
                                                    return new ActivityTiciImportFileBinding((ConstraintLayout) view, mzButton, recyclerView, imageView, linearLayout, linearLayout2, constraintLayout, progressBar, bubbleWidget, ticiTitleBar, textView, textView2);
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

    public static ActivityTiciImportFileBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTiciImportFileBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_tici_import_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5858a;
    }
}

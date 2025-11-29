package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.view.TransTitleBar;

public final class ActivityTranscribeShareBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6035a;
    public final NestedScrollView b;
    public final MzButton c;
    public final AppCompatImageView d;
    public final TransTitleBar e;

    public ActivityTranscribeShareBinding(ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, MzButton mzButton, AppCompatImageView appCompatImageView, TransTitleBar transTitleBar) {
        this.f6035a = constraintLayout;
        this.b = nestedScrollView;
        this.c = mzButton;
        this.d = appCompatImageView;
        this.e = transTitleBar;
    }

    public static ActivityTranscribeShareBinding a(View view) {
        int i = R.id.image_container;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i);
        if (nestedScrollView != null) {
            i = R.id.share_bt;
            MzButton mzButton = (MzButton) ViewBindings.a(view, i);
            if (mzButton != null) {
                i = R.id.share_iv;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, i);
                if (appCompatImageView != null) {
                    i = R.id.title_bar;
                    TransTitleBar transTitleBar = (TransTitleBar) ViewBindings.a(view, i);
                    if (transTitleBar != null) {
                        return new ActivityTranscribeShareBinding((ConstraintLayout) view, nestedScrollView, mzButton, appCompatImageView, transTitleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityTranscribeShareBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranscribeShareBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_transcribe_share, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6035a;
    }
}

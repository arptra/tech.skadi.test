package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.view.TransTitleBar;

public final class ActivityShareImagePreviewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6235a;
    public final MzButton b;
    public final ImageView c;
    public final TransTitleBar d;

    public ActivityShareImagePreviewBinding(ConstraintLayout constraintLayout, MzButton mzButton, ImageView imageView, TransTitleBar transTitleBar) {
        this.f6235a = constraintLayout;
        this.b = mzButton;
        this.c = imageView;
        this.d = transTitleBar;
    }

    public static ActivityShareImagePreviewBinding a(View view) {
        int i = R.id.bt_share;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i);
        if (mzButton != null) {
            i = R.id.iv_share;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.title_bar;
                TransTitleBar transTitleBar = (TransTitleBar) ViewBindings.a(view, i);
                if (transTitleBar != null) {
                    return new ActivityShareImagePreviewBinding((ConstraintLayout) view, mzButton, imageView, transTitleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityShareImagePreviewBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityShareImagePreviewBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_share_image_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6235a;
    }
}

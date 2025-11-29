package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.view.TransTitleBar;

public final class ActivityTransStartBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6236a;
    public final FrameLayout b;
    public final TransTitleBar c;

    public ActivityTransStartBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, TransTitleBar transTitleBar) {
        this.f6236a = constraintLayout;
        this.b = frameLayout;
        this.c = transTitleBar;
    }

    public static ActivityTransStartBinding a(View view) {
        int i = R.id.fragment_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i);
        if (frameLayout != null) {
            i = R.id.title_bar;
            TransTitleBar transTitleBar = (TransTitleBar) ViewBindings.a(view, i);
            if (transTitleBar != null) {
                return new ActivityTransStartBinding((ConstraintLayout) view, frameLayout, transTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityTransStartBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTransStartBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_trans_start, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6236a;
    }
}

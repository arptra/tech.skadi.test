package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class WakeupRecordHomeFragmentBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6901a;
    public final AppCompatTextView b;
    public final Group c;
    public final Group d;
    public final AppCompatCheckBox e;
    public final NestedScrollView f;
    public final AppCompatTextView g;
    public final MzButton h;
    public final MzButton i;
    public final AppCompatImageView j;
    public final MzButton k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;

    public WakeupRecordHomeFragmentBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, Group group, Group group2, AppCompatCheckBox appCompatCheckBox, NestedScrollView nestedScrollView, AppCompatTextView appCompatTextView2, MzButton mzButton, MzButton mzButton2, AppCompatImageView appCompatImageView, MzButton mzButton3, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.f6901a = constraintLayout;
        this.b = appCompatTextView;
        this.c = group;
        this.d = group2;
        this.e = appCompatCheckBox;
        this.f = nestedScrollView;
        this.g = appCompatTextView2;
        this.h = mzButton;
        this.i = mzButton2;
        this.j = appCompatImageView;
        this.k = mzButton3;
        this.l = appCompatTextView3;
        this.m = appCompatTextView4;
    }

    public static WakeupRecordHomeFragmentBinding a(View view) {
        View view2 = view;
        int i2 = R.id.back;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view2, i2);
        if (appCompatTextView != null) {
            i2 = R.id.more_record_group;
            Group group = (Group) ViewBindings.a(view2, i2);
            if (group != null) {
                i2 = R.id.new_record_group;
                Group group2 = (Group) ViewBindings.a(view2, i2);
                if (group2 != null) {
                    i2 = R.id.privacy_policy_checkbox;
                    AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.a(view2, i2);
                    if (appCompatCheckBox != null) {
                        i2 = R.id.privacy_policy_container;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view2, i2);
                        if (nestedScrollView != null) {
                            i2 = R.id.privacy_policy_tips;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.a(view2, i2);
                            if (appCompatTextView2 != null) {
                                i2 = R.id.record_more;
                                MzButton mzButton = (MzButton) ViewBindings.a(view2, i2);
                                if (mzButton != null) {
                                    i2 = R.id.start_record;
                                    MzButton mzButton2 = (MzButton) ViewBindings.a(view2, i2);
                                    if (mzButton2 != null) {
                                        i2 = R.id.voice_animation;
                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view2, i2);
                                        if (appCompatImageView != null) {
                                            i2 = R.id.wakeup_record_clear;
                                            MzButton mzButton3 = (MzButton) ViewBindings.a(view2, i2);
                                            if (mzButton3 != null) {
                                                i2 = R.id.wakeup_record_quiet;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.a(view2, i2);
                                                if (appCompatTextView3 != null) {
                                                    i2 = R.id.wakeup_record_subtitle;
                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.a(view2, i2);
                                                    if (appCompatTextView4 != null) {
                                                        return new WakeupRecordHomeFragmentBinding((ConstraintLayout) view2, appCompatTextView, group, group2, appCompatCheckBox, nestedScrollView, appCompatTextView2, mzButton, mzButton2, appCompatImageView, mzButton3, appCompatTextView3, appCompatTextView4);
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

    public static WakeupRecordHomeFragmentBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static WakeupRecordHomeFragmentBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.wakeup_record_home_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6901a;
    }
}

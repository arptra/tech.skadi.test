package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class NormalTwoBtnDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f6883a;
    public final TextView b;
    public final LinearLayout c;
    public final MzButton d;
    public final MzButton e;
    public final ScrollView f;
    public final FrameLayout g;
    public final TextView h;
    public final LinearLayout i;
    public final MzButton j;
    public final MzButton k;

    public NormalTwoBtnDialogBinding(FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, MzButton mzButton, MzButton mzButton2, ScrollView scrollView, FrameLayout frameLayout2, TextView textView2, LinearLayout linearLayout2, MzButton mzButton3, MzButton mzButton4) {
        this.f6883a = frameLayout;
        this.b = textView;
        this.c = linearLayout;
        this.d = mzButton;
        this.e = mzButton2;
        this.f = scrollView;
        this.g = frameLayout2;
        this.h = textView2;
        this.i = linearLayout2;
        this.j = mzButton3;
        this.k = mzButton4;
    }

    public static NormalTwoBtnDialogBinding a(View view) {
        int i2 = R.id.content;
        TextView textView = (TextView) ViewBindings.a(view, i2);
        if (textView != null) {
            i2 = R.id.hButtonLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
            if (linearLayout != null) {
                i2 = R.id.hConfirm;
                MzButton mzButton = (MzButton) ViewBindings.a(view, i2);
                if (mzButton != null) {
                    i2 = R.id.hRefuse;
                    MzButton mzButton2 = (MzButton) ViewBindings.a(view, i2);
                    if (mzButton2 != null) {
                        i2 = R.id.lay_scroll_content;
                        ScrollView scrollView = (ScrollView) ViewBindings.a(view, i2);
                        if (scrollView != null) {
                            i2 = R.id.root_content;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i2);
                            if (frameLayout != null) {
                                i2 = R.id.title;
                                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                if (textView2 != null) {
                                    i2 = R.id.vButtonLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i2);
                                    if (linearLayout2 != null) {
                                        i2 = R.id.vConfirm;
                                        MzButton mzButton3 = (MzButton) ViewBindings.a(view, i2);
                                        if (mzButton3 != null) {
                                            i2 = R.id.vRefuse;
                                            MzButton mzButton4 = (MzButton) ViewBindings.a(view, i2);
                                            if (mzButton4 != null) {
                                                return new NormalTwoBtnDialogBinding((FrameLayout) view, textView, linearLayout, mzButton, mzButton2, scrollView, frameLayout, textView2, linearLayout2, mzButton3, mzButton4);
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

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f6883a;
    }
}

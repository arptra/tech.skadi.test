package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;

public final class DialogAssistantUserGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6751a;
    public final MzButton b;
    public final TextView c;
    public final ScrollView d;
    public final TextView e;
    public final MzButton f;

    public DialogAssistantUserGuideBinding(LinearLayout linearLayout, MzButton mzButton, TextView textView, ScrollView scrollView, TextView textView2, MzButton mzButton2) {
        this.f6751a = linearLayout;
        this.b = mzButton;
        this.c = textView;
        this.d = scrollView;
        this.e = textView2;
        this.f = mzButton2;
    }

    public static DialogAssistantUserGuideBinding a(View view) {
        int i = R.id.exit;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i);
        if (mzButton != null) {
            i = R.id.permission_tips_content;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.permission_tips_scrollview;
                ScrollView scrollView = (ScrollView) ViewBindings.a(view, i);
                if (scrollView != null) {
                    i = R.id.permission_tips_title;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.sure;
                        MzButton mzButton2 = (MzButton) ViewBindings.a(view, i);
                        if (mzButton2 != null) {
                            return new DialogAssistantUserGuideBinding((LinearLayout) view, mzButton, textView, scrollView, textView2, mzButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogAssistantUserGuideBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogAssistantUserGuideBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_assistant_user_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6751a;
    }
}

package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class DialogCancelAgreementBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6752a;
    public final TextView b;
    public final CheckBox c;
    public final LinearLayout d;
    public final TextView e;
    public final ScrollView f;

    public DialogCancelAgreementBinding(LinearLayout linearLayout, TextView textView, CheckBox checkBox, LinearLayout linearLayout2, TextView textView2, ScrollView scrollView) {
        this.f6752a = linearLayout;
        this.b = textView;
        this.c = checkBox;
        this.d = linearLayout2;
        this.e = textView2;
        this.f = scrollView;
    }

    public static DialogCancelAgreementBinding a(View view) {
        int i = R.id.content;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.dont_notify_cb;
            CheckBox checkBox = (CheckBox) ViewBindings.a(view, i);
            if (checkBox != null) {
                i = R.id.dont_notify_main;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
                if (linearLayout != null) {
                    i = R.id.dont_notify_tv;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.lay_scroll_content;
                        ScrollView scrollView = (ScrollView) ViewBindings.a(view, i);
                        if (scrollView != null) {
                            return new DialogCancelAgreementBinding((LinearLayout) view, textView, checkBox, linearLayout, textView2, scrollView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogCancelAgreementBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogCancelAgreementBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_cancel_agreement, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6752a;
    }
}

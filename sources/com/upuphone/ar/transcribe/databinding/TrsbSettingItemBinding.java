package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.transcribe.R;

public final class TrsbSettingItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6057a;
    public final Switch b;
    public final TextView c;
    public final TextView d;

    public TrsbSettingItemBinding(ConstraintLayout constraintLayout, Switch switchR, TextView textView, TextView textView2) {
        this.f6057a = constraintLayout;
        this.b = switchR;
        this.c = textView;
        this.d = textView2;
    }

    public static TrsbSettingItemBinding a(View view) {
        int i = R.id.sw_setting;
        Switch switchR = (Switch) ViewBindings.a(view, i);
        if (switchR != null) {
            i = R.id.tv_content;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.tv_setting_title;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new TrsbSettingItemBinding((ConstraintLayout) view, switchR, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TrsbSettingItemBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trsb_setting_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6057a;
    }
}

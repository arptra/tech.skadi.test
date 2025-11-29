package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordFailTipLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f5593a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;

    public FastRecordFailTipLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.f5593a = linearLayout;
        this.b = linearLayout2;
        this.c = textView;
        this.d = textView2;
    }

    public static FastRecordFailTipLayoutBinding a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.tv_fail_tip_content;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.tv_fail_tip_number;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                return new FastRecordFailTipLayoutBinding(linearLayout, linearLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f5593a;
    }
}

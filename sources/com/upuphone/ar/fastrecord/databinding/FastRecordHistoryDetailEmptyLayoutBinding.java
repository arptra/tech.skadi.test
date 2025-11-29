package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordHistoryDetailEmptyLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f5596a;
    public final TextView b;
    public final TextView c;

    public FastRecordHistoryDetailEmptyLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f5596a = linearLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static FastRecordHistoryDetailEmptyLayoutBinding a(View view) {
        int i = R.id.re_asr_btn;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.tv_empty_tip;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                return new FastRecordHistoryDetailEmptyLayoutBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f5596a;
    }
}

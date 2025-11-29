package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordChooseTitleBarLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f5582a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;
    public final TextView e;

    public FastRecordChooseTitleBarLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f5582a = linearLayout;
        this.b = linearLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
    }

    public static FastRecordChooseTitleBarLayoutBinding a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.tv_choose_num;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.tv_title_cancel;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                i = R.id.tv_title_no_select;
                TextView textView3 = (TextView) ViewBindings.a(view, i);
                if (textView3 != null) {
                    return new FastRecordChooseTitleBarLayoutBinding(linearLayout, linearLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f5582a;
    }
}

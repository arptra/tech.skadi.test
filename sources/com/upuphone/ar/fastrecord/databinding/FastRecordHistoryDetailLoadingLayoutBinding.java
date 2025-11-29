package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordHistoryDetailLoadingLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f5599a;
    public final ProgressBar b;
    public final TextView c;
    public final TextView d;

    public FastRecordHistoryDetailLoadingLayoutBinding(LinearLayout linearLayout, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.f5599a = linearLayout;
        this.b = progressBar;
        this.c = textView;
        this.d = textView2;
    }

    public static FastRecordHistoryDetailLoadingLayoutBinding a(View view) {
        int i = R.id.loading_progress;
        ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, i);
        if (progressBar != null) {
            i = R.id.tv_asr_doing;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.tv_asr_doing_tip;
                TextView textView2 = (TextView) ViewBindings.a(view, i);
                if (textView2 != null) {
                    return new FastRecordHistoryDetailLoadingLayoutBinding((LinearLayout) view, progressBar, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f5599a;
    }
}

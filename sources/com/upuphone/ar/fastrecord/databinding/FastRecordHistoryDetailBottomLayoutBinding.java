package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordHistoryDetailBottomLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5595a;
    public final ImageView b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;

    public FastRecordHistoryDetailBottomLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.f5595a = constraintLayout;
        this.b = imageView;
        this.c = linearLayout;
        this.d = linearLayout2;
        this.e = textView;
        this.f = textView2;
    }

    public static FastRecordHistoryDetailBottomLayoutBinding a(View view) {
        int i = R.id.iv_play_or_pause;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.ll_copy;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i);
            if (linearLayout != null) {
                i = R.id.ll_spend;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i);
                if (linearLayout2 != null) {
                    i = R.id.tv_copy;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        i = R.id.tv_spend_num;
                        TextView textView2 = (TextView) ViewBindings.a(view, i);
                        if (textView2 != null) {
                            return new FastRecordHistoryDetailBottomLayoutBinding((ConstraintLayout) view, imageView, linearLayout, linearLayout2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5595a;
    }
}

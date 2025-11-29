package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordDuringDetailBottomLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5590a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;

    public FastRecordDuringDetailBottomLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.f5590a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = textView;
    }

    public static FastRecordDuringDetailBottomLayoutBinding a(View view) {
        int i = R.id.iv_finish;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.iv_start_rec;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
            if (imageView2 != null) {
                i = R.id.tv_record_resume;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    return new FastRecordDuringDetailBottomLayoutBinding((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5590a;
    }
}
